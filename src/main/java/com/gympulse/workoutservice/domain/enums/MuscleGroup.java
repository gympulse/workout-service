package com.gympulse.workoutservice.domain.enums;

import lombok.Getter;

@Getter
public enum MuscleGroup {
    ABDOMINAL("Abdômen"),
    ABDUCTORS("Abdutores"),
    ADDUCTORS("Adutores"),
    FOREARMS("Antebraços"),
    BICEPS("Bíceps"),
    CARDIO("Cardio"),
    FULL_BODY("Corpo Inteiro"),
    UPPER_BACK("Costas Superiores"),
    LATS("Dorsais"),
    GLUTES("Glúteos"),
    HAMSTRINGS("Isquiossurais"),
    LOWER_BACK("Lombar"),
    SHOULDERS("Ombros"),
    CALVES("Panturrilhas"),
    CHEST("Peito"),
    NECK("Pescoço"),
    QUADRICEPS("Quadríceps"),
    TRAPEZIUS("Trapézio"),
    TRICEPS("Tríceps"),
    OTHERS("Outros");

    private final String label;

    MuscleGroup(String label) {
        this.label = label;
    }

}
