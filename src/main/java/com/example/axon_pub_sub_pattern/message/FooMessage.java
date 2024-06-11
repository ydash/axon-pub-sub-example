package com.example.axon_pub_sub_pattern.message;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public record FooMessage(@TargetAggregateIdentifier UUID id, String message) implements MessageInterface {
}
