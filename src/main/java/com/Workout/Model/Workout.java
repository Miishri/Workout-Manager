package com.Workout.Model;

import jakarta.persistence.*;

@Entity
@Table()
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column()
    private String name;

    @Column()
    private String reps;

    @Column()
    private Integer weight;

    @Column()
    private String date = new java.util.Date().toString();

    public Workout(){}

    public Workout(Long id, String name, String reps, Integer weight) {
        this.id = id;
        this.name = name;
        this.reps = reps;
        this.weight = weight;
    }

    public Workout(String name, String reps, Integer weight) {
        this.name = name;
        this.reps = reps;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public String getDate() {
        return date;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.name + " " + this.reps + " " + this.weight + " " + this.date;
    }
}
