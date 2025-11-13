package fitnessapp.example;

public enum Gender {
    MALE(100),
    FEMALE(110);

    private int coefBroca;

    Gender(int coefBroca) {
        this.coefBroca= coefBroca;
    }

    public int getCoefBroca() {
        return coefBroca;
    }

}
