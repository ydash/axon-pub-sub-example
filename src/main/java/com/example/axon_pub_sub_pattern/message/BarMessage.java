package com.example.axon_pub_sub_pattern.message;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public record BarMessage(@TargetAggregateIdentifier UUID id, String message) implements MessageInterface {
}
