package fitnessapp.example;

public class Calculator {
    private User user;

    public static double calculateIdealWeightBroca(int heightCm, int age, int bodyType) {
        double baseWeight;
        if (age < 40) {
            baseWeight = heightCm - 110;
        } else {
            baseWeight = heightCm - 100;
        }
        // Корректировка по типу телосложения:
        // астеник (тонкокостный) - минус 10%
        // гиперстеник (ширококостный) - плюс 10%
        if (bodyType == -1) {
            baseWeight *= 0.9;
        } else if (bodyType == 1) {
            baseWeight *= 1.1;
        }
        return baseWeight;
    }

}
