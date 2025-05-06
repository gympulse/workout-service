package com.gympulse.workoutservice.domain.model;

import com.google.gson.Gson;
import com.gympulse.workoutservice.domain.enums.Equipment;
import com.gympulse.workoutservice.domain.enums.MuscleGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exercise {
    private UUID id;
    private String name;
    private MuscleGroup mainMuscleGroup;
    private List<MuscleGroup> correlatedMuscles;
    private Equipment equipment;
    private String executionVideoURL;
    private Map<Integer, String> instructions;

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
