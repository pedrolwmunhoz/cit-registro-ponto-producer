package com.cit.virtual_ponto.registro_ponto_funcionario_producer.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.cit.virtual_ponto.registro_ponto_funcionario_producer.models.RegistroPontoMessage;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, RegistroPontoMessage> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092"); // Endereço do seu broker Kafka
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // Usando JsonSerializer do Spring Kafka

        // Configurações adicionais (opcionais)
        config.put(ProducerConfig.ACKS_CONFIG, "all"); // Garantir que todas as réplicas confirmem o recebimento
        config.put(ProducerConfig.RETRIES_CONFIG, 3); // Tentar reenviar mensagens em caso de falha
        config.put(ProducerConfig.LINGER_MS_CONFIG, 10); // Atraso para otimização de batching
        config.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384); // Tamanho máximo do lote

        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, RegistroPontoMessage> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
