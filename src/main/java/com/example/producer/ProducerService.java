package com.example.producer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@EnableBinding( ProducerChannel.class )
@Service
public class ProducerService {

    protected final ProducerChannel producerChannel;

    public ProducerService(ProducerChannel producerChannel) {
        this.producerChannel = producerChannel;
    }

    public String produce(String input){
        Message< String > message = MessageBuilder.withPayload( input )
                .build();

        if( producerChannel.producer()
                .send( message ) )
        {

            return "success";
        }
        else
        {
            return "fail";
        }

    }
}
