package com.example.axon_pub_sub_pattern.event;

import com.example.axon_pub_sub_pattern.repository.CashbackReward;
import com.example.axon_pub_sub_pattern.repository.CashbackRewardRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public record CashbackRewardProjection(CashbackRewardRepository repository) {

    @EventHandler
    public void on(PaymentAccepted event) {
        int cashbackAmount = (int) (event.amount() * 0.1);
        CashbackReward cashbackReward = new CashbackReward(event.id(), cashbackAmount);
        log.info("Saving cashback reward: {}", cashbackReward);
        repository.save(cashbackReward);
    }
}
