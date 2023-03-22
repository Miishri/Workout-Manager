package com.Workout.Repository;

import com.Workout.Model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    List<Workout> findWorkoutByName(String name);

}
