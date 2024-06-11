package com.example.axon_pub_sub_pattern.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public record Pay(@TargetAggregateIdentifier int id, int amount) implements Command {
}
