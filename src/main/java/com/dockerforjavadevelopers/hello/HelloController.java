package com.dockerforjavadevelopers.hello;


import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Server is Healthy";
    }

    @RequestMapping("/users")
    public Map<String, String> ping() {
        HashMap<String, String> map = new HashMap<>();
        map.put("test", "test@gmail.com");
        map.put("bermtec", "bermtec@gmail.com");
        map.put("cistec", "cistec@gmail.com");
        return map;
    }
    
}
