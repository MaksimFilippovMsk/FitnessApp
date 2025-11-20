package fitnessapp.example;

import java.util.ArrayList;
import java.util.List;

public class DayRepository {
    private Day day;
    private List<Day> days = new ArrayList<>();

    public void addDay(Day day){
        days.add(day);
    }

}
