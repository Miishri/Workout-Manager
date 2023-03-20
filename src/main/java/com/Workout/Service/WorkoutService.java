package com.Workout.Service;

import com.Workout.Exception.WorkoutNotAcceptedException;
import com.Workout.Exception.WorkoutNotFoundException;
import com.Workout.Model.Workout;
import com.Workout.Repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkoutService implements WorkoutServiceProvider{

    private WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Workout checkWorkout(Workout workout) {

        Optional<Workout> userWorkout = Optional.of(new Workout(workout.getName(), workout.getReps()));

        check(userWorkout);

        workoutRepository.save(workout);

        return userWorkout.get();
    }

    private boolean exerciseCheck(String exercise) {
        if (
                exercise.equals("DL")
                || exercise.equals("BP")
                || exercise.equals("SQT")
                || exercise.equals("OHP")
        ) {
            return true;
        }

        return false;
    }

    private void check(Optional<Workout> userWorkout) {
        if (userWorkout.isEmpty()) {
            throw new WorkoutNotFoundException();
        }

        if (!exerciseCheck(userWorkout.get().getName())) {
            throw new WorkoutNotAcceptedException();
        }
    }
}
