package com.gympulse.workoutservice.domain.enums;

import lombok.Getter;

@Getter
public enum Equipment {
    NONE("Nenhum"),
    RESISTANCE_BAND("Banda de Resistência"),
    SUSPENSION_BAND("Banda de Suspensão"),
    BARBELL("Barra"),
    PLATE("Anilha"),
    DUMBBELL("Haltere"),
    KETTLEBELL("Kettlebell"),
    MACHINE("Máquina"),
    OTHER("Outro");

    private final String label;

    Equipment(String label) {
        this.label = label;
    }
}