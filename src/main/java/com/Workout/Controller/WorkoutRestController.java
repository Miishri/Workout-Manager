package com.Workout.Controller;

import com.Workout.Exception.WorkoutNotFoundException;
import com.Workout.Model.Workout;
import com.Workout.Service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/workout")
public class WorkoutRestController {

    private WorkoutService workoutService;

    @Autowired
    public WorkoutRestController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping("/post")
    public String submitWorkout(@RequestBody Workout workout) {
        Workout userWorkout = workoutService.checkWorkout(workout);

        return userWorkout + " :  has been added!";
    }

    @GetMapping("/average")
    public String averageWorkout() {

    }

}
