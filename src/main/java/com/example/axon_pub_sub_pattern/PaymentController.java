package com.example.axon_pub_sub_pattern;

import com.example.axon_pub_sub_pattern.event.PaymentAccepted;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.gateway.EventGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public record PaymentController(EventGateway eventGateway) {

    @PutMapping("/pay")
    public ResponseEntity<PayResponseBody> pay(@RequestBody PayRequestBody requestBody) {
        var event = new PaymentAccepted(requestBody.id(), requestBody.amount());
        log.info("Publishing event: {}", event);
        eventGateway.publish(event);
        return ResponseEntity.ok(new PayResponseBody(requestBody.id(), requestBody.amount()));
    }
}

