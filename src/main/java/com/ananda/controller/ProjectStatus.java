/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ananda.controller;

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
public class ProjectStatus {

   @RequestMapping(value = "/webhook", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public Object currentStatus() throws Exception {
        return "ok";
    }

//    @RequestMapping(value = "/server/ok", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
//    @ResponseStatus(HttpStatus.OK)
//    public Object currentServer() throws Exception {
//        return " is ok http://local";
//    }
//    http://localhost:8080/callback/api/v1/project/your/ok
}
