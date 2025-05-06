package com.gympulse.workoutservice.api;

import com.gympulse.workoutservice.api.dto.WorkoutRequest;
import com.gympulse.workoutservice.mediator.Mediator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/workout")
public class WorkoutController {

    final
    Mediator mediator;

    public WorkoutController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    @Transactional
    ResponseEntity<Void> create(@RequestBody WorkoutRequest data) {
        return ResponseEntity.created(URI.create("/api/workout/1")).build();
    }
}
