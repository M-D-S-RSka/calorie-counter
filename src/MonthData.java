class MonthData {
    int[] days = new int[30];
    void printDaysAndStepsFromMonth() {
        System.out.println("Общая статистика по дням: ");//int daysAndSteps = 0;
        for (int i = 0; i < days.length; i++) {
            //daysAndSteps = daysAndSteps + days[i];
            System.out.println((i + 1) + " день: " + days[i]);
        }
        //return daysAndSteps;
    }
    int sumStepsFromMonth() { //подсчет суммы шагов за месяц
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }
    int maxSteps() { //максимальное количество шагов за месяц
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (maxSteps < days[i])// поиск максимального элемента
                maxSteps = days[i];
        }
        return maxSteps;
    }
    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                if (++finalSeries > currentSeries) {
                    currentSeries = finalSeries;
                }
            }
        }
        return currentSeries;
    }
    int averageStepsInMonth() {
        int sumSteps = sumStepsFromMonth();
        int average = sumSteps / days.length;
        return average;
    }
}