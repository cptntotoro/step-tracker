public class StepTracker {

    int defaultStepGoal = 10000;
    int[][] stepsPerDate = new int[12][30];

    Converter converter = new Converter();

    void updateDailySteps(int month, int day, int steps) {

        stepsPerDate[month][day] = steps;

    }

    /**
     * Выводим различную статистику шагов
     */
    void showMonthlyStats(int month) {

        // Так как статистика содержит несколько операций, я разбила их на методы
        showStepsPerDay(month);
        int totalSteps = getTotalSteps(month);
        showTotalSteps(totalSteps);
        showMaxStepsValue(month);
        showAverageSteps(month);
        showTravelledDistance(totalSteps);
        showCcalBurned(totalSteps);
        showBestStreak(month);
    }

    /**
     * Выводим статистику шагов по дням за месяц
     */
    void showStepsPerDay(int month) {
        for (int day = 0; day < stepsPerDate[month].length - 1; day++) {
            System.out.print(day + 1 + " день: " + stepsPerDate[month][day] + ", ");
        }
        System.out.println(stepsPerDate[month].length + " день: " + stepsPerDate[month][29]);
    }

    /**
     * Выводим общее число шагов за месяц
     */
    void showTotalSteps (int totalSteps) {
        System.out.println("Сумма шагов за выбранный месяц: " + totalSteps);
    }

    /**
     * Выводим максимальное пройденное количество шагов за месяц
     */
    void showMaxStepsValue(int month) {
        int maxStepsValue = 0;
        for (int day = 0; day < stepsPerDate[month].length; day++) {
            if (stepsPerDate[month][day] > maxStepsValue) {
                maxStepsValue = stepsPerDate[month][day];
            }
        }

        System.out.println("Ваш рекорд шагов за выбранный месяц: " + maxStepsValue);
    }

    /**
     * Выводим среднее число шагов за месяц
     */
    void showAverageSteps (int month) {
        double averageSteps = (double) getTotalSteps(month) / stepsPerDate[month].length;
        System.out.printf("Ваше среднее число шагов за месяц: %.1f%n", averageSteps);
    }

    /**
     * Выводим пройденную дистанцию за месяц
     */
    void showTravelledDistance (int totalSteps) {
        System.out.printf("Пройдено километров за месяц: %.1f%n", converter.convertCmToKm(totalSteps));
    }

    /**
     * Выводим число сожжённых калорий за месяц
     */
    void showCcalBurned(int totalSteps) {
        System.out.println("Сожгли килокалорий за месяц: " + converter.convertCCalToCal(totalSteps));
    }

    /**
     * Получаем общее число шагов за месяц
     */
    int getTotalSteps(int month) {
        int stepsTotal = 0;
        for (int day = 0; day < stepsPerDate[month].length; day++) {
            stepsTotal = stepsTotal + stepsPerDate[month][day];
        }
        return stepsTotal;
    }

    /**
     * Показываем лучшую серию дней за месяц
     */
    void showBestStreak(int month) {
        int daysMaxStreak = 0;
        int maxLength = 0;
        for (int day = 0; day < stepsPerDate[month].length; day++) {
            if (stepsPerDate[month][day] >= defaultStepGoal) {
                maxLength++;
                if (maxLength > daysMaxStreak) {
                    daysMaxStreak = maxLength;
                }
            } else {
                maxLength = 0;
            }
        }
        System.out.println("Лучшая серия: " + daysMaxStreak + " дней");
    }

    /**
     * Изменяем целевое число шагов на значение, введенное пользователем
     */
    public void changeStepsGoal(int newStepsGoal) {

        defaultStepGoal = newStepsGoal;

    }

}
