package fitnessapp.example;

import java.time.LocalDate;

public class Day {
    private LocalDate localDate;
    private List<Training> trainings;

    public Day(LocalDate localDate, List<Training> trainings){
        this.localDate=localDate;
        this.trainings = trainings
    }
}
