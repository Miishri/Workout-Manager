package com.Workout.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(WorkoutNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public WorkoutNotFound Handler (WorkoutNotFoundException workoutException) {

        WorkoutNotFound workoutNotFound = new WorkoutNotFound();
        workoutNotFound.setMessage("Your workout does not exist!");

        return workoutNotFound;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(WorkoutNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public WorkoutNotFound Handler (WorkoutNotAcceptedException workoutException) {

        WorkoutNotFound workoutNotFound = new WorkoutNotFound();
        workoutNotFound.setMessage("Your workout is not acceptable!");

        return workoutNotFound;
    }
}
