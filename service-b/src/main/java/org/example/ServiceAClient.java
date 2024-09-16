package org.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-a")
public interface ServiceAClient {
    @GetMapping("/api/v1/service-a")
    String getServiceBMessage();
}
