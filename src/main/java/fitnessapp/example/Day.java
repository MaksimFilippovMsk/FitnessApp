package fitnessapp.example;

import java.time.LocalDate;
import java.util.List;

public class Day {
    private LocalDate localDate;
    private List<Training> trainings;

    public Day(LocalDate localDate, List<Training> trainings){
        this.localDate=localDate;
        this.trainings = trainings;
    }

    public void addTraining(Training training) {
        trainings.add(training);
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}
