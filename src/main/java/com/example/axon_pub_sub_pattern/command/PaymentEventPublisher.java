package com.example.axon_pub_sub_pattern.command;

import com.example.axon_pub_sub_pattern.event.PaymentAccepted;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.gateway.EventGateway;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public record PaymentEventPublisher(EventGateway eventGateway) {

    @CommandHandler
    public void on(Pay cmd) {
        var event = new PaymentAccepted(cmd.id(), cmd.amount());
        log.info("Publishing event: {}", event);
        eventGateway.publish(event);
    }
}
