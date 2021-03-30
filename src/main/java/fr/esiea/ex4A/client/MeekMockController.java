package fr.esiea.ex4A.client;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class MeekMockController {

    private final MatchesRepository matchesRepository;
    private final UserRepository userRepository;

    MeekMockController(MatchesRepository clientRepository, UserRepository userRepository) {
        this.matchesRepository = clientRepository;
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Matches> getMatches(@RequestParam(name = "userName") String name, @RequestParam(name = "userCountry") String country) {
        return List.of(
            matchesRepository.matchesClient(name, country),
            matchesRepository.matchesClient(name,country)
        );
    }

    @PostMapping(value = "/api/inscription", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void inscription(@RequestBody UserInfo userInfo) throws IOException {
        System.out.println(userInfo);
        userRepository.addUser(userInfo);
    }

    public static class Matches {
        public final String name;
        public final String twitter;

        public Matches(String name, String twitter) {
            this.name = name;
            this.twitter = twitter;
        }
        @Override
        public String toString() {
            return "Matches{" +
                "name='" + name + '\'' +
                ", twitter='" + twitter +
                '}';
        }
    }
}
