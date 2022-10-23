public class StepTracker {

    int defaultStepGoal = 10000;

    Converter converter = new Converter();

    Month[] month;

    public StepTracker() {
        month = new Month[12];
        for (int i = 0; i < month.length; i++) {
            month[i] = new Month();
        }
    }


    class Month {

        int[] stepsPerDays = new int[30];

    }

    void updateDailySteps(int month, int day, int steps) {

        this.month[month].stepsPerDays[day] = steps;

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
        for (int day = 0; day < this.month[month].stepsPerDays.length - 1; day++) {
            System.out.print(day + 1 + " день: " + this.month[month].stepsPerDays[day] + ", ");
        }
        System.out.println(this.month[month].stepsPerDays.length + " день: " + this.month[month].stepsPerDays[29]);
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
        for (int day = 0; day < this.month[month].stepsPerDays.length; day++) {
            if (this.month[month].stepsPerDays[day] > maxStepsValue) {
                maxStepsValue = this.month[month].stepsPerDays[day];
            }
        }

        System.out.println("Ваш рекорд шагов за выбранный месяц: " + maxStepsValue);
    }

    /**
     * Выводим среднее число шагов за месяц
     */
    void showAverageSteps (int month) {
        double averageSteps = (double) getTotalSteps(month) / this.month[month].stepsPerDays.length;
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
        for (int day = 0; day < this.month[month].stepsPerDays.length; day++) {
            stepsTotal = stepsTotal + this.month[month].stepsPerDays[day];
        }
        return stepsTotal;
    }

    /**
     * Показываем лучшую серию дней за месяц
     */
    void showBestStreak(int month) {
        int daysMaxStreak = 0;
        int maxLength = 0;
        for (int day = 0; day < this.month[month].stepsPerDays.length; day++) {
            if (this.month[month].stepsPerDays[day] >= defaultStepGoal) {
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
