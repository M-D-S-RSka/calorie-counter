import java.util.Scanner;

public class StepTracker {
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int i = scanner.nextInt();
        if (i < 1 || i > 12) {
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно");
            return;
        }
        System.out.println("Введите номер дня");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Номер вводимого дня должен быть от 1 до 30 включительно");
            return;
        }
        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Количество шагов должно быть положительным числом");
        }
        MonthData monthData = monthToData[i - 1];
        monthData.days[day - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println("Введите новую цель шагов  в день");
        int newTarget = scanner.nextInt();
        if (newTarget > 0) {
            goalByStepsPerDay = newTarget;
        } else {
            System.out.println("Цель должна быть больше 0");
        }
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        int i = scanner.nextInt();
        if (i < 0 || i > 12) {
            System.out.println("введите число от 1 до 12");
            return;
        }
        MonthData monthData = monthToData[i - 1];
        int sumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        System.out.println("Среднее количество шагов: " + monthData.averageStepsInMonth());
        System.out.println("Пройденная дистанция (в км): " + converter.convertToKm(sumSteps));
        System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay) + "\n");
    }
}