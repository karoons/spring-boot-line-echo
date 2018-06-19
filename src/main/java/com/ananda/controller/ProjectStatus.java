/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ananda.controller;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
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

   @RequestMapping(value = "/webhook", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
   @EventMapping
    public Object currentStatus(MessageEvent<TextMessageContent> event) throws Exception {
       System.out.println("EVENT--- -"+event);
        return "ok";
    }


    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) throws Exception {
        System.out.println("--------------------------event: " + event);
        return new TextMessage(event.getMessage().getText());
    }

//    @RequestMapping(value = "/server/ok", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
//    @ResponseStatus(HttpStatus.OK)
//    public Object currentServer() throws Exception {
//        return " is ok http://local";
//    }
//    http://localhost:8080/callback/api/v1/project/your/ok
}
