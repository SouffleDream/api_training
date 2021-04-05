package fr.esiea.ex4A.client;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import fr.esiea.ex4A.client.MeekMockController.Matches;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class MeekMockControllerIT {

    private final MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;
    private MatchesRepository matchesRepository;

    public MeekMockControllerIT(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }


    @Test
    public void inscriptionAddUser() throws Exception {

        UserInfo userInfo = new UserInfo("test@test.fr", "test", "test", "FR", UserInfo.Sex.M, UserInfo.Sex.O);

        ArgumentCaptor<UserInfo> argumentCaptor = ArgumentCaptor.forClass(UserInfo.class);

        mockMvc
            .perform(MockMvcRequestBuilders
                .post("/api/inscription")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userEmail\": \"test@test.fr\", \"userName\": \"test\", \"userTweeter\": \"test\", \"userCountry\": \"FR\", \"userSex\": \"M\", \"userSexPref\": \"O\"}"))
            .andExpect(status().isOk());
        verify(userRepository).addUser(argumentCaptor.capture());
        Assertions.assertThat(argumentCaptor.getValue()).isEqualToIgnoringNullFields(userInfo);
    }

    @Test
    public void getMatchesTest() throws Exception {

        UserInfo userInfo = new UserInfo("test@test.fr", "test", "test", "FR", UserInfo.Sex.M, UserInfo.Sex.O);
        List<Matches> listmatches = List.of();
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches?userName=test&userCountry=FR")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

    }

    @Test
    public void matchesToStringTest() {
        String name = "test";
        String twitter = "FR";
        MeekMockController.Matches matches = new MeekMockController.Matches(name, twitter);
        String expectedString = "Matches{" +
            "name='" + name + '\'' +
            ", twitter='" + twitter +
            '}';
        assertEquals(expectedString, matches.toString());
    }
}
