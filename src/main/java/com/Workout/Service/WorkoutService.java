
package com.Workout.Service;

import com.Workout.Exception.WorkoutNotAcceptedException;
import com.Workout.Exception.WorkoutNotFound;
import com.Workout.Exception.WorkoutNotFoundException;
import com.Workout.Model.Workout;
import com.Workout.Repository.WorkoutRepository;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

        Optional<Workout> userWorkout = Optional.of(new Workout(workout.getName(), workout.getReps(), workout.getWeight()));

        check(userWorkout);

        workoutRepository.save(userWorkout.get());

        return userWorkout.get();
    }

    @Override
    public Integer workoutAverage(String workoutToBeFound) {
        return findWorkoutBy(workoutToBeFound).stream().map(e -> e.getWeight()).reduce(0, (a, b) -> a+b, Integer::sum);
    }

    @Override
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    @Override
    public List<Workout> getWorkoutByName(String name) {
        exerciseCheck(name);
        return workoutRepository.findWorkoutByName(name);
    }

    @Override
    public String deleteWorkoutById(Long id) {
        Optional<Workout> found = workoutRepository.findById(id);

        if (found.isEmpty()) {
            throw new WorkoutNotFoundException();
        }

        workoutRepository.delete(found.get());

        return found.get().getName() + " has been deleted with id : " + found.get().getId();
    }
    public List<Workout> findWorkoutBy(String workout) {
        return workoutRepository.findWorkoutByName(workout);
    }

    @Override
    public Workout updateWorkoutById(Workout workout) {
        Optional<Workout> found = workoutRepository.findById(workout.getId());

        if (found.isEmpty()) throw  new WorkoutNotFoundException();

        Workout foundWorkout = found.get();
        foundWorkout.setName(workout.getName());
        foundWorkout.setReps(workout.getReps());
        foundWorkout.setWeight(workout.getWeight());

        return workoutRepository.save(foundWorkout);
    }

    private boolean exerciseCheck(String exercise) throws WorkoutNotFoundException{
        if (
                exercise.equals("DL")
                || exercise.equals("BP")
                || exercise.equals("SQT")
                || exercise.equals("OHP")
        ) {
            return true;
        }

        throw new WorkoutNotFoundException();
    }

    private void check(Optional<Workout> userWorkout) throws WorkoutNotAcceptedException, WorkoutNotFoundException{
        if (userWorkout.isEmpty()) {
            throw new WorkoutNotFoundException();
        }

        if (!exerciseCheck(userWorkout.get().getName())) {
            throw new WorkoutNotAcceptedException();
        }
    }
}
