package fitnessapp.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingDAO extends JpaRepository<Training,Long> {

}
