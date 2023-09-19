public class Converter {
    final double step_size = 0.00075;
    final double calories_to_k_calories = 1000;
    final double calories_to_step = 50;

    double convertToKm(double steps) {
        steps = steps * step_size;
        return steps;
    }

    double convertStepsToKilocalories(double steps) {
        steps = steps * calories_to_step / calories_to_k_calories;
        return steps;
    }
}