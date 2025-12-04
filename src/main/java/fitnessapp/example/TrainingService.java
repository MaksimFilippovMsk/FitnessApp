package fitnessapp.example;

import java.util.ArrayList;
import java.util.List;

public class TrainingService {

    private TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public void addTraining(Training training){
        trainingRepository.addTraining(training);
    }
    public List<Training> getAllTrainings(){
        return trainingRepository.getAllTrainings();
    }

    //todo

}

