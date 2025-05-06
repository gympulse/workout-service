package com.gympulse.workoutservice.api.dto;

import java.util.List;
import java.util.UUID;

public record WorkoutRequest(String title, List<UUID> exercises) {
}
