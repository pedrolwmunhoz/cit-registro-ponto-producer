// package com.cit.virtual_ponto.registro_ponto_funcionario.services;

// import com.cit.virtual_ponto.registro_ponto_funcionario.models.RegistroPontoEntity;
// import com.cit.virtual_ponto.registro_ponto_funcionario.repositories.CadastroHistoricoRegistrosDiarioRepository;
// import jakarta.persistence.EntityManager;
// import jakarta.persistence.TypedQuery;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.time.format.DateTimeFormatter;
// import java.util.ArrayList;
// import java.util.Collections;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.ArgumentMatchers.*;
// import static org.mockito.Mockito.*;

// public class RegistroPontoServiceTest {

//     @Mock
//     private CadastroHistoricoRegistrosDiarioRepository repository;

//     @Mock
//     private EntityManager entityManager;

//     @InjectMocks
//     private RegistroPontoService service;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     void testRegistrarEntradaSemRegistrosAnteriores() {
//         Long funcionarioId = 1L;
//         LocalDate hoje = LocalDate.now();
//         LocalTime agora = LocalTime.now();

//         TypedQuery<RegistroPontoEntity> queryMock = mock(TypedQuery.class);
         
//         // Simular que não há registros anteriores para o funcionário no dia
//         when(entityManager.createQuery(anyString(), eq(RegistroPontoEntity.class)))
//                 .thenReturn(queryMock);
//         when(queryMock.setParameter("funcionarioId", funcionarioId))
//                 .thenReturn(queryMock);
//         when(queryMock.setParameter("data", hoje))
//                 .thenReturn(queryMock);
//         when(queryMock.setMaxResults(1))
//                 .thenReturn(queryMock);
//         when(queryMock.getResultList())
//                 .thenReturn(Collections.emptyList());

//         String resultado = service.registrarEntrada(funcionarioId);

//         assertEquals("Entrada registrada " + agora.format(DateTimeFormatter.ofPattern("HH:mm:ss")), resultado);

//         // Verificar se o método save do repository foi chamado uma vez
//         verify(repository, times(1)).save(any(RegistroPontoEntity.class));
//     }

//     @Test
//     void testRegistrarSaidaComRegistroDeEntradaAberto() {
//         Long funcionarioId = 1L;
//         LocalDate hoje = LocalDate.now();
//         LocalTime agora = LocalTime.now();

//         // Simular que há um registro de entrada aberto para o funcionário no dia
//         RegistroPontoEntity registroEntrada = new RegistroPontoEntity();
//         registroEntrada.setId(1L);
//         registroEntrada.setFuncionarioId(funcionarioId);
//         registroEntrada.setData(hoje);
//         registroEntrada.setListaHoraEntrada(new ArrayList<>(Collections.singletonList(agora.minusHours(1)))); // Simulando uma entrada 1 hora atrás

//         TypedQuery<RegistroPontoEntity> queryMock = mock(TypedQuery.class);
//         when(entityManager.createQuery(anyString(), eq(RegistroPontoEntity.class)))
//                 .thenReturn(queryMock);
//         when(queryMock.setParameter("funcionarioId", funcionarioId))
//                 .thenReturn(queryMock);
//         when(queryMock.setParameter("data", hoje))
//                 .thenReturn(queryMock);
//         when(queryMock.setMaxResults(1))
//                 .thenReturn(queryMock);
//         when(queryMock.getResultList())
//                 .thenReturn(Collections.singletonList(registroEntrada));

//         String resultado = service.registrarEntrada(funcionarioId);

//         assertEquals("Saída registrada " + agora.format(DateTimeFormatter.ofPattern("HH:mm:ss")), resultado);

//         // Verificar se o método merge do entityManager foi chamado uma vez
//         verify(entityManager, times(1)).merge(any(RegistroPontoEntity.class));
//     }

//     @Test
//     void testAtualizarRegistroDeEntradaParaIncluirSaida() {
//         Long funcionarioId = 1L;
//         LocalDate hoje = LocalDate.now();
//         LocalTime agora = LocalTime.now();

//         // Simular que há um registro de entrada aberto para o funcionário no dia
//         RegistroPontoEntity registroEntrada = new RegistroPontoEntity();
//         registroEntrada.setId(1L);
//         registroEntrada.setFuncionarioId(funcionarioId);
//         registroEntrada.setData(hoje);
//         registroEntrada.setListaHoraEntrada(new ArrayList<>(Collections.singletonList(agora.minusHours(1)))); // Simulando uma entrada 1 hora atrás
//         registroEntrada.setListaHoraSaida(new ArrayList<>());

//         TypedQuery<RegistroPontoEntity> queryMock = mock(TypedQuery.class);
//         when(entityManager.createQuery(anyString(), eq(RegistroPontoEntity.class)))
//                 .thenReturn(queryMock);
//         when(queryMock.setParameter("funcionarioId", funcionarioId))
//                 .thenReturn(queryMock);
//         when(queryMock.setParameter("data", hoje))
//                 .thenReturn(queryMock);
//         when(queryMock.setMaxResults(1))
//                 .thenReturn(queryMock);
//         when(queryMock.getResultList())
//                 .thenReturn(Collections.singletonList(registroEntrada));

//         String resultado = service.registrarEntrada(funcionarioId);

//         assertEquals("Saída registrada " + agora.format(DateTimeFormatter.ofPattern("HH:mm:ss")), resultado);

//         // Verificar se o método merge do entityManager foi chamado uma vez
//         verify(entityManager, times(1)).merge(any(RegistroPontoEntity.class));
//     }
// }
