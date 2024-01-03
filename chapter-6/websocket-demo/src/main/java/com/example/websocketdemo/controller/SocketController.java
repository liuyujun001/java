package com.example.websocketdemo.controller;


import com.example.websocketdemo.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SocketController {

    @Autowired
    private WebSocketServer webSocketServer;

    @GetMapping("/webSocket")
    public ModelAndView socket() {
        ModelAndView modelAndView = new ModelAndView("/webSocket");
        return modelAndView;
    }

}