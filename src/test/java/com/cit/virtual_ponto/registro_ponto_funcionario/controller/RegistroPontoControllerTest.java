// package com.cit.virtual_ponto.registro_ponto_funcionario.controller;

// import com.cit.virtual_ponto.registro_ponto_funcionario.services.RegistroPontoService;
// import com.cit.virtual_ponto.registro_ponto_funcionario.models.RegistroPontoEntity;
// import com.cit.virtual_ponto.registro_ponto_funcionario.repositories.CadastroHistoricoRegistrosDiarioRepository;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// import java.util.Collections;
// import java.util.List;

// import static org.mockito.ArgumentMatchers.anyLong;
// import static org.mockito.Mockito.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// public class RegistroPontoControllerTest {

//     private MockMvc mockMvc;

//     @Mock
//     private CadastroHistoricoRegistrosDiarioRepository repository;

//     @Mock
//     private RegistroPontoService service;

//     @InjectMocks
//     private RegistroPontoController controller;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//         mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//     }

//     @Test
//     void testGetAll() throws Exception {
//         // Mockando o retorno do repository
//         List<RegistroPontoEntity> registros = Collections.singletonList(createRegistroPontoEntity());
//         when(repository.findAll()).thenReturn(registros);

//         // Executando o teste de requisição GET para "/"
//         mockMvc.perform(get("/")
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(jsonPath("$[0].id").value(1));  // Verifica se o ID é 1 (ajuste conforme sua entidade)

//         // Verificando se o método repository.findAll() foi chamado uma vez
//         verify(repository, times(1)).findAll();
//     }
//     @Test
//     void testRegistrarEntrada() throws Exception {
//         Long funcionarioId = 1L;
//         String mensagemRetorno = "Entrada registrada 08:00:00";

//         // Mockando o retorno do service
//         when(service.registrarEntrada(anyLong())).thenReturn(mensagemRetorno);

//         // Executando o teste de requisição GET para "/registrar-entrada/{funcionarioId}"
//         mockMvc.perform(get("/registrar-entrada/{funcionarioId}", funcionarioId)
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
//                 .andExpect(content().string(mensagemRetorno));

//         // Verificando se o método service.registrarEntrada() foi chamado com o funcionarioId correto
//         verify(service, times(1)).registrarEntrada(funcionarioId);
//     }

//     // Método utilitário para criar uma entidade de teste RegistroPontoEntity
//     private RegistroPontoEntity createRegistroPontoEntity() {
//         RegistroPontoEntity entity = new RegistroPontoEntity();
//         entity.setId(1L);
//         // Preencha os demais campos conforme necessário para o teste
//         return entity;
//     }
// }
