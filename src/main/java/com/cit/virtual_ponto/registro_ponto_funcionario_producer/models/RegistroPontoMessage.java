package com.cit.virtual_ponto.registro_ponto_funcionario_producer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroPontoMessage implements Serializable {

    private String horaRegistro;
    private int idFuncionario;
}
