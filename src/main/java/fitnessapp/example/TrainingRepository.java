package fitnessapp.example;

import java.util.ArrayList;
import java.util.List;

public class TrainingRepository {
    private List<Training> trainings;

    public TrainingRepository(List<Training> trainings) {
        this.trainings = trainings;
    }
    public void addTraining(Training training){
        trainings.add(training);
    }
    public List getAllTrainings(){
        return new ArrayList<>(trainings);
    }

}
