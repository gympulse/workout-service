package com.gympulse.workoutservice.api;

import com.gympulse.workoutservice.api.dto.WorkoutRequest;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/workout")
public class WorkoutController {

    @PostMapping
    @Transactional
    ResponseEntity<Void> create(@RequestBody WorkoutRequest data) {


        return ResponseEntity.created(URI.create("/api/workout/1")).build();
    }
}
