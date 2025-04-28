package com.ejsjose.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class AppController {

    @RequestMapping( value = "info", method=RequestMethod.GET)
    public String info( ) {
        return "The application is up ...";
    }

}
