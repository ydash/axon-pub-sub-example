package com.example.axon_pub_sub_pattern;

import com.example.axon_pub_sub_pattern.command.Pay;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@AllArgsConstructor
public class PaymentController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @PutMapping("/pay")
    public ResponseEntity<PayResponseBody> pay(@RequestBody PayRequestBody requestBody) {
        var command = new Pay(requestBody.id(), requestBody.amount());
        log.info("Sending command: {}", command);
        commandGateway.send(command);
        return ResponseEntity.ok(new PayResponseBody(requestBody.id(), requestBody.amount()));
    }
}

