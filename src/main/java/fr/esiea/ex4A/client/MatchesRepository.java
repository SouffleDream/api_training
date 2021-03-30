package fr.esiea.ex4A.client;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Random;
import fr.esiea.ex4A.client.MeekMockController.Matches;

@Repository
public
class MatchesRepository {
    final List<String> names = List.of(
        "Pierre",
        "Paul",
        "Jack",
        "Arthur",
        "Skeileen",
        "Isabelle",
        "Emile"
    );
    final List<String> twitter = List.of(
        "Jaguabyss",
        "Coyolax",
        "Gazena",
        "Chickig",
        "Gladiabat",
        "Bella95",
        "ForteNight2000"
    );

    final Random random = new Random();
    public Matches matchesClient(String userName, String country) {
        return new Matches(names.get(random.nextInt(names.size())), twitter.get(random.nextInt(twitter.size())));
    }
}
