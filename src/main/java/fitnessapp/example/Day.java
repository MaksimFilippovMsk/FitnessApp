package fitnessapp.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Day{" +
                "Дата:" + localDate +
                "Название тренировки:" + trainings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return Objects.equals(getLocalDate(), day.getLocalDate()) && Objects.equals(trainings, day.trainings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocalDate(), trainings);
    }
}
