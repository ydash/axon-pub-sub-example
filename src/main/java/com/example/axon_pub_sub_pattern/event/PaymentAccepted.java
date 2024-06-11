package com.example.axon_pub_sub_pattern.event;

public record PaymentAccepted(int id, int amount) implements PaymentEvent {
}
