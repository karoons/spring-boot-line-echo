/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ananda;

import com.linecorp.bot.model.message.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Karoons
 */
@SpringBootApplication
@LineMessageHandler
//@RestController
public class Application {

//    @RequestMapping("/webhook")
//    String home() {
//        return "ok";
//    }

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @EventMapping
    public Message handleTextMessageEvent(MessageEvent<TextMessageContent> event) {

        System.out.println("event: " + event);
        final String originalMessageText = event.getMessage().getText();

        switch (originalMessageText.toUpperCase()) {
            case "FLEX":
                return new ExampleFlexMessageSupplier().get();
            default:
                return new TextMessage(originalMessageText);
        }
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }
}
