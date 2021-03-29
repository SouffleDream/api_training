package fr.esiea.ex4A.client;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeekMockController {
    
    private final MatchesRepository clientRepository;

    MeekMockController(MatchesRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Matches> getMatches(@RequestParam(name = "userName") String name, @RequestParam(name = "userCountry") String country) {
        return List.of(
            clientRepository.matchesClient(),
            clientRepository.matchesClient()
        );
    }

    @PostMapping(value = "/api/inscription", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void inscription(@RequestBody User client){
        System.out.println(client);
    }

    public static class Matches {
        public final String name;
        public final String twitter;

        public Matches(String name, String twitter) {
            this.name = name;
            this.twitter = twitter;
        }
    }
}
