package fr.esiea.ex4A.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class MeekMockControllerIT {

    private final MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeekMockControllerIT)) return false;
        MeekMockControllerIT that = (MeekMockControllerIT) o;
        return userRepository.equals(that.userRepository);
    }

    public MeekMockControllerIT(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }


    @Test
    public void inscriptionAddUser() throws Exception {

        UserInfo userInfo = new UserInfo("test@test.fr", "test", "test", "FR", UserInfo.Sex.M, UserInfo.Sex.O);

        ArgumentCaptor<UserInfo> argumentCaptor = ArgumentCaptor.forClass(UserInfo.class);
        mockMvc
                .perform(MockMvcRequestBuilders.post("/api/inscription")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"userEmail\": \"test@test.fr\", \"userName\": \"test\", \"userTweeter\": \"test\", \"userCountry\": \"FR\", \"userSex\": \"M\", \"userSexPref\": \"O\"}"))
                .andExpect(status().isOk());
        verify(userRepository).addUser(argumentCaptor.capture());
        Assertions.assertEquals(userInfo, argumentCaptor.getValue());
        /*mockMvc
            .perform(MockMvcRequestBuilders
                .post("/api/inscription")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userEmail\": \"test@test.fr\", \"userName\": \"test\", \"userTweeter\": \"test\", \"userCountry\": \"FR\", \"userSex\": \"M\", \"userSexPref\": \"O\"}"))
            .andExpect(status().isOk());
        verify(userRepository).addUser(userInfo);*/
    }
}
