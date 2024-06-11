package com.example.axon_pub_sub_pattern.event;

public sealed interface PaymentEvent permits PaymentAccepted {
    int id();
}
