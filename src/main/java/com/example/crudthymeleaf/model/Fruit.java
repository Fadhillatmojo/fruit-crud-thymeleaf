package com.example.crudthymeleaf.model;

import java.time.LocalDateTime;

public class Fruit {

    private int id;
    private String name;
    private String type;
    private String color;
    private String taste;
    private String origin;
    private String harvestSeason;
    private LocalDateTime deletedAt;

    // Constructors
    public Fruit() {
    }

    public Fruit(int id, String name, String type, String color, String taste, String origin, String harvestSeason, LocalDateTime deletedAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.taste = taste;
        this.origin = origin;
        this.harvestSeason = harvestSeason;
        this.deletedAt = deletedAt;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getHarvestSeason() {
        return harvestSeason;
    }

    public void setHarvestSeason(String harvestSeason) {
        this.harvestSeason = harvestSeason;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}

