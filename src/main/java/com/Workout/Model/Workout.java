package com.Workout.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "workout_name")
    private String name;

    @Column(name = "workout_reps")
    private int reps;

    @Column(name = "workout_date")
    private String date = new java.util.Date().toString();

    public Workout(){}
    public Workout(long id, String name, int reps) {
        this.id = id;
        this.name = name;
        this.reps = reps;
    }
    public Workout(String name, int reps) {
        this.name = name;
        this.reps = reps;
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
    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return this.name + " " + this.reps + " " + this.date;
    }
}
