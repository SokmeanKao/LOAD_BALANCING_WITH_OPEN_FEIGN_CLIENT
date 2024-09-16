package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {
    @Autowired
    private ServiceAClient serviceAClient;

    @GetMapping("/api/v1/service-b")
    public String callServiceA() {
        return "Service B Called A. "+serviceAClient.getServiceBMessage();
    }
}
