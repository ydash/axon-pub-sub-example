package com.example.axon_pub_sub_pattern;

import org.axonframework.common.jdbc.ConnectionProvider;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.eventhandling.tokenstore.jdbc.GenericTokenTableFactory;
import org.axonframework.eventhandling.tokenstore.jdbc.JdbcTokenStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.jdbc.JdbcEventStorageEngine;
import org.axonframework.eventsourcing.eventstore.jdbc.MySqlEventTableFactory;
import org.axonframework.serialization.Serializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

   @Bean
    public EventStorageEngine storageEngine(Serializer serializer,
                                            ConnectionProvider connectionProvider,
                                            @Qualifier("eventSerializer") Serializer eventSerializer,
                                            TransactionManager transactionManager) {
        JdbcEventStorageEngine storageEngine = JdbcEventStorageEngine.builder()
                .snapshotSerializer(serializer)
                .connectionProvider(connectionProvider)
                .eventSerializer(eventSerializer)
                .transactionManager(transactionManager)
                .build();
        storageEngine.createSchema(MySqlEventTableFactory.INSTANCE);
        return storageEngine;
    }


    @Bean
    public JdbcTokenStore stealingTokenStore(ConnectionProvider connectionProvider, Serializer serializer) {
        var tokenStore = JdbcTokenStore.builder()
                .connectionProvider(connectionProvider)
                .serializer(serializer)
                .build();
        tokenStore.createSchema(GenericTokenTableFactory.INSTANCE);
        return tokenStore;
    }
}
