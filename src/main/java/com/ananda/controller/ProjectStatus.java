/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ananda.controller;

import com.ananda.ExampleFlexMessageSupplier;
import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;

/**
 *
 * @author Karoons
 */
@RestController
@RequestMapping()
@LineMessageHandler
public class ProjectStatus {

    @Autowired
    private LineMessagingClient lineMessagingClient;

    @RequestMapping(value = "/", produces = "application/json;charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    @EventMapping
    public Object currentStatus2(MessageEvent<TextMessageContent> event) throws Exception {
       System.out.println("EVENT 1--- -"+event);
        return "ok2";
    }

   @RequestMapping(value = "/webhook", produces = "application/json;charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
   @EventMapping
    public Object currentStatus(MessageEvent<TextMessageContent> event) throws Exception {
       System.out.println("EVENT 2--- -"+event);
        return "ok";
    }

        @EventMapping
    public Message handleTextMessageEvent(MessageEvent<TextMessageContent> event) {

        System.out.println("----------------------event: " + event);
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
        System.out.println("----------------------event:: " + event);
    }

//    @RequestMapping(value = "/server/ok", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
//    @ResponseStatus(HttpStatus.OK)
//    public Object currentServer() throws Exception {
//        return " is ok http://local";
//    }
//    http://localhost:8080/callback/api/v1/project/your/ok
}
