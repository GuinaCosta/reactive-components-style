package br.com.meetups.resource;

import br.com.meetups.model.User;
import br.com.meetups.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UsersResource {

    private final UserRepository userRepository;

    @GetMapping
    public Flux<User> getAllUsers() {
        return Flux.from(userRepository.findAllUsers());
    }

    @GetMapping("/{id}")
    public Mono<User> getAllUsers(String id) {
        return Mono.from(userRepository.findUser());
    }

    @GetMapping("/singleflux")
    public Mono<User> getSingleUserFromFlux() {
        return Mono.from(userRepository.findAllUsers());
    }

    @GetMapping("/singlemanyflux")
    public Mono<User> getSingleUserFromManyFlux() {
        return Mono.from(userRepository.findManyUsers());
    }

    @GetMapping("/manyflux")
    public Flux<User> getAllUsersFromManyFlux() {
        return Flux.from(userRepository.findManyUsers());
    }
}
