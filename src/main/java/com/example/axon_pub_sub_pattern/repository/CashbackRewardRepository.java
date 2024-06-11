package com.example.axon_pub_sub_pattern.repository;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public record CashbackRewardRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {

    public void save(CashbackReward cashbackReward) {
        var sql = """
                  INSERT INTO CASHBACK_REWARD(id, amount) VALUES(:id, :amount)
                  """;
        namedParameterJdbcTemplate.update(
                sql,
                new BeanPropertySqlParameterSource(cashbackReward)
        );
    }
}
