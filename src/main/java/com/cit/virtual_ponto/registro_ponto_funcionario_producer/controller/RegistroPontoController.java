package com.cit.virtual_ponto.registro_ponto_funcionario_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cit.virtual_ponto.registro_ponto_funcionario_producer.models.RegistroPontoMessage;
import com.cit.virtual_ponto.registro_ponto_funcionario_producer.services.producer.RegistroPontoProducerService;

import java.time.LocalTime;
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
        registroPontoMessage.setHoraRegistro(LocalTime.now().toString()); // Define a hora atual como hora de registro
        registroPontoMessage.setIdFuncionario(idFuncionario); // Exemplo de ID do funcionário

        return produtorService.enviarRegistroPonto(registroPontoMessage);
    }
}
