package com.example.realtime.web;

import com.example.realtime.model.SensorReading;
import com.example.realtime.repo.SensorReadingRepository;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.ChangeStreamEvent;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Instant;

@RestController
public class StreamController {
    private final ReactiveMongoTemplate template;
    private final SensorReadingRepository repository;

    public StreamController(ReactiveMongoTemplate template,
                            SensorReadingRepository repository) {
        this.template = template;
        this.repository = repository;
    }

    @GetMapping(value = "/stream/readings",
                produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<SensorReading> streamReadings() {
        return template.changeStream(
                "sensor_readings",
                ChangeStreamOptions.empty(),
                SensorReading.class)
            .map(ChangeStreamEvent::getBody)
            .filter(reading -> reading != null);
    }

    @PostMapping("/api/readings")
    public Mono<SensorReading> addReading(@RequestParam double value) {
        return repository.save(new SensorReading(Instant.now(), value));
    }
}