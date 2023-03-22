package com.Workout.Service;

import com.Workout.Model.Workout;
import org.hibernate.jdbc.Work;

import java.util.List;

public interface WorkoutServiceProvider {

    Workout checkWorkout(Workout workout);

    Integer workoutAverage(String workoutName);

    List<Workout> getAllWorkouts();

    List<Workout> getWorkoutByName(String name);

    String deleteWorkoutById(Long id);

    Workout updateWorkoutById(Workout workout);
}
