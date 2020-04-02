package com.example.producer.controller;

import com.example.producer.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController( "prodController" )
@RequestMapping( "/produce")
public class ProdController {

    @Autowired
    ProducerService service;

    @RequestMapping(value = "/receive/{input}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String produce(@PathVariable String input)
          throws JsonProcessingException
    {
        System.out.println("input "+input);
        String result = service.produce(input);
        return result;
    }
}
