package fr.esiea.ex4A.meekmock;

import fr.esiea.ex4A.client.MatchesRepository;
import fr.esiea.ex4A.client.MeekMockController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RestController
class MeekMockControllerIT {

    /*private final MockMvc mockMvc;

    @MockBean
    private MatchesRepository repository = new MatchesRepository();

    MeekMockControllerIT(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void hello_delegates_to_random_when_name_param_is_absent() throws Exception {
        when(repository.matchesClient()).thenReturn(new MeekMockController.Matches("randomtest", "testyTweet"));

        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            //.andExpect(MeekMockController.Matches);

        verify(repository).matchesClient();
    }*/
}
