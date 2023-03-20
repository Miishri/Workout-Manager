package com.Workout.Repository;

import com.Workout.Model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Long, Workout> {

}
