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

@Entity
public record Training {
    @Id
    @Column (name = "name")
    String name;
    @Column(name = "type")
    String type;
    @Column(name ="duration")
    Integer duration;

    @Override
    public String toString() {
        return name;
    }
}