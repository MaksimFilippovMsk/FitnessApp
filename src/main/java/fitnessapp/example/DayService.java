package fitnessapp.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DayService {
    private DayRepository dayRepository;

    public Day getDayFromLocalDate(LocalDate localDate){
        Day day = dayRepository.getDay(localDate);
        return day;
    }

    public void createEmptyDay(LocalDate localDate){
        Day day = new Day(localDate, new ArrayList<Training>());
        dayRepository.addDay(day);
    }
}
