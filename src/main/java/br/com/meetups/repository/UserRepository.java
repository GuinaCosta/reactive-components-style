package br.com.meetups.repository;

import br.com.meetups.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
public class UserRepository {
    private final WebClient webClient = WebClient.create("http://www.mocky.io/v2");

    private static final String ID_PATH = "/{id}";

    public Mono<User> findUser() {
        return webClient.get()
                .uri(ID_PATH, "5e93d1c83000001f5a156c48")
                .retrieve()
                .bodyToMono(User.class);
    }

    public Flux<User> findAllUsers() {
        return webClient.get()
                .uri(ID_PATH, "5e93d52a3000007400156c56")
                .retrieve()
                .bodyToFlux(User.class);
    }

    public Flux<User> findManyUsers() {
        return webClient.get()
                .uri(ID_PATH, "5e93df2a3000007400156c8b")
                .retrieve()
                .bodyToFlux(User.class);
    }
}
