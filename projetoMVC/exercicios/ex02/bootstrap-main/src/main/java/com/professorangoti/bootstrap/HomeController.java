package com.professorangoti.bootstrap;

public class HomeController {
    @Controller
    @getMapping("/home.html"){
        
        return "home";
    }
}
