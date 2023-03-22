package com.Workout.Controller;

import com.Workout.Exception.WorkoutNotFoundException;
import com.Workout.Model.Workout;
import com.Workout.Service.WorkoutService;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workout")
public class WorkoutRestController {

    private WorkoutService workoutService;

    @Autowired
    public WorkoutRestController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping("/submit")
    public String submitWorkout(@RequestBody Workout workout) {
        Workout userWorkout = workoutService.checkWorkout(workout);

        return userWorkout + " :  has been added!";
    }

    @GetMapping("/average")
    public Integer averageWorkout(@RequestBody String workout) {
        return workoutService.workoutAverage(workout);
    }

    @GetMapping("/all")
    public List<Workout> allWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/workout")
    public List<Workout> findWorkout(@RequestBody String name) {
        return workoutService.findWorkoutBy(name);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteWorkout(@PathVariable Long id) {
        return workoutService.deleteWorkoutById(id);
    }

    @PostMapping("/update")
    public Workout updateWorkout(@RequestBody Workout workout) {
        return workoutService.updateWorkoutById(workout);
    }

}
