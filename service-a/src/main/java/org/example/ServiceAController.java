package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAController {

    @Autowired
    private Environment env;

    @GetMapping("/api/v1/service-a")
    public String getServiceBMessage() {
        String serverPort = env.getProperty("server.port");
        return "I'm Service-A." + " Running on Port is: "+ serverPort;
    }
}
