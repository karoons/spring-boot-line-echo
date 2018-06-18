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
@RequestMapping("/api/v1/project")
public class ProjectStatus {

    @Value("${custom.application.name}")
    private String appName;

    @RequestMapping(value = "/your/ok", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public Object currentStatus() throws Exception {
        return appName + " is ok ^^ การุณย์ " + URLDecoder.decode("การุณย์", "UTF-8");
    }

    @RequestMapping(value = "/server/ok", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public Object currentServer() throws Exception {
        return appName + " is ok http://local";
    }
    
}
