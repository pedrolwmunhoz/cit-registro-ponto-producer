// package com.cit.virtual_ponto.registro_ponto_funcionario.models.registro_ponto;

// import org.junit.jupiter.api.Test;

// import com.cit.virtual_ponto.registro_ponto_funcionario.models.RegistroPontoEntity;

// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.util.Arrays;

// import static org.junit.jupiter.api.Assertions.*;

// public class RegistroPontoEntityTest {

//     @Test
//     void testGetterSetter() {
//         // Criando uma instância de RegistroPontoEntity usando Lombok
//         RegistroPontoEntity entity = new RegistroPontoEntity();

//         // Definindo valores
//         entity.setId(1L);
//         entity.setFuncionarioId(100L);
//         entity.setData(LocalDate.of(2023, 6, 20));
//         entity.setListaHoraEntrada(Arrays.asList(LocalTime.of(9, 0)));
//         entity.setListaHoraSaida(Arrays.asList(LocalTime.of(18, 0)));
//         entity.setObservacao("Teste de observação");

//         // Verificando os valores obtidos pelos getters
//         assertEquals(1L, entity.getId());
//         assertEquals(100L, entity.getFuncionarioId());
//         assertEquals(LocalDate.of(2023, 6, 20), entity.getData());
//         assertEquals(Arrays.asList(LocalTime.of(9, 0)), entity.getListaHoraEntrada());
//         assertEquals(Arrays.asList(LocalTime.of(18, 0)), entity.getListaHoraSaida());
//         assertEquals("Teste de observação", entity.getObservacao());
//     }

//     @Test
//     void testEqualsAndHashCode() {
//         // Criando duas instâncias iguais
//         RegistroPontoEntity entity1 = new RegistroPontoEntity();
//         entity1.setId(1L);

//         RegistroPontoEntity entity2 = new RegistroPontoEntity();
//         entity2.setId(1L);

//         // Verificando equals
//         assertEquals(entity1, entity2);

//         // Verificando hashCode
//         assertEquals(entity1.hashCode(), entity2.hashCode());

//         // Modificando um campo e verificando equals
//         entity2.setId(2L);
//         assertNotEquals(entity1, entity2);
//     }

//     @Test
//     void testToString() {
//         // Criando uma instância
//         RegistroPontoEntity entity = new RegistroPontoEntity();
//         entity.setId(1L);
//         entity.setFuncionarioId(100L);
//         entity.setData(LocalDate.of(2023, 6, 20));
//         entity.setListaHoraEntrada(Arrays.asList(LocalTime.of(9, 0)));
//         entity.setListaHoraSaida(Arrays.asList(LocalTime.of(18, 0)));
//         entity.setObservacao("Teste de observação");

//         // Verificando toString
//         String expectedToString = "RegistroPontoEntity(id=1, funcionarioId=100, data=2023-06-20, listaHoraEntrada=[09:00], listaHoraSaida=[18:00], observacao=Teste de observação)";
//         assertEquals(expectedToString, entity.toString());
//     }
// }
