package com.example.axon_pub_sub_pattern;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class FooBazBarController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @PutMapping("/foo")
    public void foo() {
        commandGateway.send();
        log.info("foo called");
    }
}
