package fitnessapp.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    private TrainingDAO trainingDAO;

    public TrainingService(TrainingDAO trainingDAO) {
        this.trainingDAO = trainingDAO;
    }

    public void addTraining(Training training){
        trainingDAO.createTraining(training);
    }
//    public List<Training> getAllTrainings(){
//        return trainingDAO.findAll();
//    }

    //todo

}

