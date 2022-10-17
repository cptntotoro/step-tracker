public class StepTracker {

    int defaultStepGoal = 10000;
    int[][] stepsPerDate = new int[12][30];

    Converter converter = new Converter();

    StepTracker() {
        // Заполняем массив нулевыми значениями
        for (int month = 0; month < stepsPerDate.length; month++ ) {
            for (int day = 0; day < stepsPerDate[0].length; day++) {
                stepsPerDate[month][day] = 0;
            }
        }
    }

    /**
     * Обновляем число шагов за нужную дату на значение, введенное пользователем
     * @param
     */
    void updateDailySteps(int month, int day, int steps) {

        stepsPerDate[month][day] = steps;

    }

    /**
     * Выводим различную статистику шагов
     * @param
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
     * @param
     */
    void showStepsPerDay(int month) {
        for (int day = 0; day < stepsPerDate[0].length; day++) {
            System.out.println(day + " день: " + stepsPerDate[month][day] + ", ");
        }
    }

    /**
     * Выводим общее число шагов за месяц
     * @param
     */
    void showTotalSteps (int totalSteps) {
        System.out.println("Сумма шагов за выбранный месяц: " + totalSteps);
    }

    /**
     * Выводим максимальное пройденное количество шагов за месяц
     * @param
     */
    void showMaxStepsValue(int month) {
        int maxStepsValue = 0;
        for (int day = 0; day < stepsPerDate[0].length; day++) {
            if (stepsPerDate[month][day] > maxStepsValue) {
                maxStepsValue = stepsPerDate[month][day];
            }
        }

        System.out.println("Ваш рекорд шагов за выбранный месяц: " + maxStepsValue);
    }

    /**
     * Выводим среднее число шагов за месяц
     * @param
     */
    void showAverageSteps (int month) {
        double averageSteps = (double) getTotalSteps(month) / stepsPerDate[0].length;
        System.out.printf("Ваше среднее число шагов за месяц: %f%n", averageSteps);
    }

    /**
     * Выводим пройденную дистанцию за месяц
     * @param
     */
    void showTravelledDistance (int totalSteps) {
        System.out.printf("Пройдено километров за месяц: %f%n", converter.convertCmToKm(totalSteps));
    }

    /**
     * Выводим число сожжённых калорий за месяц
     * @param totalSteps
     */
    void showCcalBurned(int totalSteps) {
        System.out.println("Сожгли килокалорий за месяц: " + converter.convertCCalToCal(totalSteps));
    }

    /**
     * Получаем общее число шагов за месяц
     * @param month
     * @return
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
     * @param month
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
     * @param
     */
    public void changeStepsGoal(int newStepsGoal) {

        this.defaultStepGoal = newStepsGoal;

    }

}
