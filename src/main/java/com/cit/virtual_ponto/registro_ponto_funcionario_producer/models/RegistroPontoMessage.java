package com.cit.virtual_ponto.registro_ponto_funcionario_producer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

import com.cit.virtual_ponto.registro_ponto_funcionario_producer.models.banco_horas.BancoHorasEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroPontoMessage {
    private BancoHorasEntity bancoHoras;
    private LocalTime horaRegistro;
    private int idFuncionario;
}
