package com.example.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.http.MediaType;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;


@Service
public class ProducerService {

    private ConnectionFactory connectionFactory;

    private ObjectMapper objectMapper;



    public ProducerService(ConnectionFactory connectionFactory, ObjectMapper objectMapper) {
        this.connectionFactory = connectionFactory;
        this.objectMapper = objectMapper;
    }

    public String produce(String input)
          throws JsonProcessingException
    {
        RabbitAdmin rabbitConf = new RabbitAdmin( connectionFactory );
        Queue queue = new Queue( "local-evoucher-listener" );
        rabbitConf.declareQueue( queue );

        TopicExchange exchange = new TopicExchange( "local-evoucher-listener" );
        rabbitConf.declareExchange( exchange );

        rabbitConf.declareBinding( BindingBuilder.bind( queue )
                                                 .to( exchange )
                                                 .with( "evoucher-listener" ) );
        final CustomMessage message = new CustomMessage( input,
                                                         "1234",
                                                         "CERT",
                                                         "QPS194",
                                                         "10",
                                                         null );
        Message jsonMessage = MessageBuilder.withBody( objectMapper.writeValueAsBytes( message ) )
                                                          .andProperties( MessagePropertiesBuilder.newInstance()
                                                                                                  .setContentType( MediaType.APPLICATION_JSON.toString() )
                                                                                                  .build() )
                                                          .build();

        try
        {
            rabbitConf.getRabbitTemplate().convertAndSend( "local-evoucher-listener",
                                                               "local-evoucher-listener",
                                                               jsonMessage);
        }
        catch( AmqpException e )
        {
            return "FAIL";
        }
        return "SUCCESS";

    }
}
