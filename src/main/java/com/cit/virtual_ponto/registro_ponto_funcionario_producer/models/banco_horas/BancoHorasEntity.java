package com.cit.virtual_ponto.registro_ponto_funcionario_producer.models.banco_horas;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "banco_horas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BancoHorasEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_banco_horas")
    private Integer idBancoHoras;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_saldo_horas", unique = true)
    private SaldoHorasEntity saldoHoras;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_jornada_trabalho", unique = true)
    private JornadaTrabalhoEntity jornadaTrabalho;

    @Column(name = "data_inicio_apuracao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicioApuracao;

}
