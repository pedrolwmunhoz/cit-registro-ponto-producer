package com.cit.virtual_ponto.registro_ponto_funcionario_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cit.virtual_ponto.registro_ponto_funcionario_producer.models.RegistroPontoMessage;
import com.cit.virtual_ponto.registro_ponto_funcionario_producer.models.banco_horas.BancoHorasEntity;
import com.cit.virtual_ponto.registro_ponto_funcionario_producer.models.banco_horas.JornadaTrabalhoEntity;
import com.cit.virtual_ponto.registro_ponto_funcionario_producer.models.banco_horas.SaldoHorasEntity;
import com.cit.virtual_ponto.registro_ponto_funcionario_producer.services.producer.RegistroPontoProducerService;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/")
public class RegistroPontoController {

    @Autowired
    private RegistroPontoProducerService produtorService;

    @GetMapping("/registrar-entrada/")
    public CompletableFuture<String> registrarEntrada(@RequestBody BancoHorasEntity bancoHoras) {
        // Criar e popular um objeto SaldoHorasEntity
        SaldoHorasEntity saldoHoras = new SaldoHorasEntity();
        saldoHoras.setIdSaldoHoras(1); // Exemplo de ID
        saldoHoras.setSaldoHorasTrabalhadas("40:00:00"); // Exemplo de saldo de horas trabalhadas
        saldoHoras.setSaldoHorasExtras("05:00:00"); // Exemplo de saldo de horas extras

        // Criar e popular um objeto JornadaTrabalhoEntity
        JornadaTrabalhoEntity jornadaTrabalho = new JornadaTrabalhoEntity();
        jornadaTrabalho.setIdJornadaTrabalho(1); // Exemplo de ID
        jornadaTrabalho.setGeolocalizacaoPermitida("São Paulo"); // Exemplo de geolocalização permitida
        jornadaTrabalho.setJornadaTrabalhoHoras(LocalTime.of(8, 0)); // Exemplo de jornada de 8 horas
        jornadaTrabalho.setHorarioEntrada(LocalTime.of(9, 0)); // Exemplo de horário de entrada
        jornadaTrabalho.setHorarioSaida(LocalTime.of(17, 0)); // Exemplo de horário de saída
        jornadaTrabalho.setIntervaloDescanso(LocalTime.of(1, 0)); // Exemplo de intervalo de 1 hora

        // Criar e popular o objeto BancoHorasEntity
        bancoHoras = new BancoHorasEntity();
        bancoHoras.setIdBancoHoras(1); // Defina um ID (geralmente gerado automaticamente)
        bancoHoras.setSaldoHoras(saldoHoras); // Associar o objeto SaldoHorasEntity
        bancoHoras.setJornadaTrabalho(jornadaTrabalho); // Associar o objeto JornadaTrabalhoEntity
        bancoHoras.setDataInicioApuracao(java.sql.Date.valueOf("2024-01-01"));

        // Criar e popular o objeto RegistroPontoMessage
        RegistroPontoMessage registroPontoMessage = new RegistroPontoMessage();
        registroPontoMessage.setBancoHoras(bancoHoras);
        registroPontoMessage.setHoraRegistro(LocalTime.now()); // Define a hora atual como hora de registro
        registroPontoMessage.setIdFuncionario(bancoHoras.getIdBancoHoras()); // Exemplo de ID do funcionário

        return produtorService.enviarRegistroPonto(registroPontoMessage);
    }
}
