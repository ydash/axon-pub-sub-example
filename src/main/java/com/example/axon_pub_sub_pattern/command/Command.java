package com.example.axon_pub_sub_pattern.command;

sealed interface Command permits Pay {
    int id();
}
