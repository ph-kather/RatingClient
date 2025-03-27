package edu.ratingclient.controller;

import edu.ratingclient.dto.RatingRequestDTO;
import edu.ratingclient.dto.RatingResponseDTO;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    private final WebClient webClient;

    public RatingController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081/ratings").build();
    }

    @GetMapping("/latest")
    public Mono<RatingResponseDTO> getLatestRating() {
        return webClient
            .get()
            .uri("/latest")
            .retrieve()
            .bodyToMono(RatingResponseDTO.class);
    }

    @PostMapping
    public Mono<String> submitRating(@RequestParam int rating) {
        return webClient.post()
            .bodyValue(new RatingRequestDTO(rating))
            .retrieve()
            .bodyToMono(String.class)
            .onErrorResume(e -> Mono.just("Fehler beim Senden des Ratings: " + e.getMessage()));
    }

    @PostMapping("/originalRatings")
    public Flux<RatingResponseDTO> getOriginalRatings(@RequestBody List<UUID> ids) {
        // TODO: Aufgabe 1
        return null;
    }


    @GetMapping("/trends")
    public Mono<Double> getCurrentAverage() {
        // TODO: Aufgabe 2
        return null;
    }

    private double calculateAverage(List<Integer> ratings) {
        return ratings.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0.0);
    }
}
