package com.example.axon_pub_sub_pattern.message;

import java.util.UUID;

public sealed interface MessageInterface permits BarMessage, BazMessage, FooMessage {
    UUID id();
    String message();
}
