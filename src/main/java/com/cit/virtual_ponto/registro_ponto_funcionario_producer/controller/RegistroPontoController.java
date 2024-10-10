package com.cit.virtual_ponto.registro_ponto_funcionario_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cit.virtual_ponto.registro_ponto_funcionario_producer.models.RegistroPontoMessage;
import com.cit.virtual_ponto.registro_ponto_funcionario_producer.services.producer.RegistroPontoProducerService;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/")
public class RegistroPontoController {

    @Autowired
    private RegistroPontoProducerService produtorService;

    @GetMapping("/registrar-entrada/{idFuncionario}")
    public CompletableFuture<String> registrarEntrada(@PathVariable Integer idFuncionario) {

        // Criar e popular o objeto RegistroPontoMessage
        RegistroPontoMessage registroPontoMessage = new RegistroPontoMessage();
        
        // Definindo o formato desejado para data/hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        // Obtendo a data e hora atual em São Paulo
        ZonedDateTime horaAtual = ZonedDateTime.now(java.time.ZoneId.of("America/Sao_Paulo"));
        String horaRegistroFormatada = horaAtual.format(formatter); // Formata a data e hora
        registroPontoMessage.setHoraRegistro(horaRegistroFormatada); // Define a hora de registro formatada


        registroPontoMessage.setIdFuncionario(idFuncionario);
        return produtorService.enviarRegistroPonto(registroPontoMessage);
    }
}
