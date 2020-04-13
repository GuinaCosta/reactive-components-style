package br.com.meetups.resource;

import br.com.meetups.model.User;
import br.com.meetups.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("userstransformation")
public class UsersSyncTransformationResource {

    private final UserRepository userRepository;

    @GetMapping
    public Flux<ResponseEntity<User>> getAllUsers() {
        return userRepository.findAllUsers().map(ResponseEntity::ok);
    }

    @GetMapping("/singleflux")
    public Flux<ResponseEntity<User>> getSingleUserFromFlux() {
        return userRepository.findAllUsers()
                .doOnComplete(() -> log.info("completado!"))
                .map(user -> ResponseEntity.status(HttpStatus.CREATED.value()).body(user));
    }
}
