public class Converter {
        double convertToKm(double steps) {
            steps = steps * 0.00075;
            return steps;
        }
        int convertStepsToKilocalories(int steps){
            steps = steps * 50 / 1000;
            return steps;
        }
}