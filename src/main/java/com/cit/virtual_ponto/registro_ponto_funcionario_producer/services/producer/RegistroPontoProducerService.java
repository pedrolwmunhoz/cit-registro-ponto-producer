package com.cit.virtual_ponto.registro_ponto_funcionario_producer.services.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.cit.virtual_ponto.registro_ponto_funcionario_producer.models.RegistroPontoMessage;

import java.util.concurrent.CompletableFuture;

@Service
public class RegistroPontoProducerService {

    private static final String TOPIC = "registro-ponto-topic"; // Nome do seu tópico Kafka

    @Autowired
    private KafkaTemplate<String, RegistroPontoMessage> kafkaTemplate;

    public CompletableFuture<String> enviarRegistroPonto(RegistroPontoMessage registroPontoMessage) {
        return kafkaTemplate.send(TOPIC, registroPontoMessage)
            .thenApply(SendResult::getProducerRecord)
            .thenApply(record -> {
                System.out.println("Mensagem enviada com sucesso: " + record.value());
                return "Mensagem enviada ao tópico com sucesso! " + record.value();
            })
            .exceptionally(ex -> {
                System.err.println("Erro ao enviar mensagem: " + ex.getMessage());
                return "Erro ao enviar mensagem: " + ex.getMessage();
            });
    }
}
