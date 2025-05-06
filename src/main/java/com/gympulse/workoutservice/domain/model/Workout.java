package com.gympulse.workoutservice.domain.model;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Workout {
    private UUID id;
    private String title;
    private List<UUID> exercises;

    public Workout(String title, List<UUID> exercises) {
        this.title = title;
        this.exercises = exercises;
    }

    public UUID generateUUID() {
        this.id = UUID.randomUUID();
        return this.id;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
