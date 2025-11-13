package fitnessapp.example;

import java.util.Objects;

public class User {
    private String name;
    private int weight;
    private int age;
    private int height;
    public Gender gender;

    public User(String name,int age,int weight,int height,Gender gender) {

            validateName(name);
            validateAge(age);
            validateWeight(weight);
            validateHeight(height);

        this.name=name;
        this.age=age;
        this.weight=weight;
        this.gender = gender;
        this.height=height;
    }
    public void validateName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException();//todo WrongCredentialsException()
        }if(name.length()<2||name.length()>50){
            throw new IllegalArgumentException();
        }if(!name.matches("[a-zA-Zа-яА-ЯёЁ\\s-]+")){
            throw new IllegalArgumentException();
        }
    }
    public void validateAge(int age){
        if(age <= 0 || age >= 110 ){
            throw new IllegalArgumentException();
        }
    }
    public void validateWeight(int weight){
        if(weight <= 40 || weight >= 200){
            throw new IllegalArgumentException();
        }
    }
    public void validateHeight(int height){
        if(height<= 100 || height >= 230){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return weight == user.weight && age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, age);
    }
}
