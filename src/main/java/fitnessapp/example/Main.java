package fitnessapp.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
//            try {
//                // create user with null name
//
//            } catch (WrongCredentialsException e) {
//                // sout to front that credentials are bad
//            }

//        SpringApplication.run(Main.class);
        new FitnessFrame();
        }
    }
