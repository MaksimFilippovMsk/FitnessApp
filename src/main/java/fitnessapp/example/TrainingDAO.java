package fitnessapp.example;

import jakarta.persistence.Access;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
public class TrainingDAO  {

    private static final Logger log = LoggerFactory.getLogger(TrainingDAO.class);
    @Autowired
    private SessionFactory sessionFactory;

    public TrainingDAO(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    public void createTraining(Training training){
        sessionFactory.openSession().persist(training);
    }

}

