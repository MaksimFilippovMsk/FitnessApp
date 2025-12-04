package fitnessapp.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DayRepository {

    private List<Day> days = new ArrayList<>();     // todo set?

    public void addDay(Day day){
        days.add(day);
    }
    public List<Day> getAllDays() {
        return new ArrayList<>(days);
    }

    public Day getDayFromDate(LocalDate date){
        Day resultDay = days.stream().filter(day -> day.getLocalDate().isEqual(date))
                                    .findFirst()
                                    .get();
        return resultDay;
    }
}