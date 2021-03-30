package fr.esiea.ex4A.client;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import fr.esiea.ex4A.client.MeekMockController.Matches;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MatchesTest {

    @Test
    public void matchesToStringTest() {
        String name = "test";
        String twitter = "FR";
        Matches matches = new Matches(name, twitter);
        String expectedString = "Matches{" +
            "name='" + name + '\'' +
            ", twitter='" + twitter +
            '}';
        assertEquals(expectedString, matches.toString());
    }
}
