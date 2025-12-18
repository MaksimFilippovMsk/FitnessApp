package fitnessapp.example;

//public class Training {
//    private String name;
//    private String
//
//    public Training(String name, String type, Integer duration, String s) {
//    this.name=name;
//    }
//}

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trainings")
public class Training {
    @Id
    @Column (name = "name")
    String name;
    @Column(name = "type")
    String type;
    @Column(name ="duration")
    Integer duration;

    public Training(String name, String type, Integer duration) {
        this.name = name;
        this.type = type;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}