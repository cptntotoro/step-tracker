import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StepTracker stepTracker = new StepTracker();

        while (true) {

            int month;
            int day;
            int steps;

            printMenu();

            int menuCommand = scanner.nextInt();

            if (menuCommand == 1) {

                month = getDataFromUser(scanner, 0, 11, "Введите номер месяца: ") - 1;

                day = getDataFromUser(scanner, 0, 29, "Введите день: ") - 1;

                steps = getDataFromUser(scanner, 0, 100000, "Введите число шагов: ");

                stepTracker.updateDailySteps(month, day, steps);

            } else if (menuCommand == 2) {

                month = getDataFromUser(scanner, 0, 11, "Введите номер месяца: ") - 1;

                stepTracker.showMonthlyStats(month);

            } else if (menuCommand == 3) {

                steps = getDataFromUser(scanner, 0, 100000, "Введите новую ежедневную цель по шагам: ");

                stepTracker.changeStepsGoal(steps);
                System.out.println("Установлена новая ежедневная цель - " + steps + " шагов.");


            } else if (menuCommand == 4) {

                break;

            } else {

                System.out.println("Неверная команда");

            }

        }

        System.out.println("Программа завершена");

    }

    public static void printMenu() {

        System.out.println("Что вы хотите сделать? Напишите номер команды.");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("4. Выйти из приложения");

    }

    /**
     * Получаем и проверяем данные, введённые пользователем
     * @param scanner
     * @param minValue
     * @param maxValue
     * @param message
     * @return
     */
    static int getDataFromUser(Scanner scanner, int minValue, int maxValue, String message) {
        int data;
        while (true) {
            System.out.print(message);
            data = scanner.nextInt();
            if (data >= minValue && data <= maxValue) {
                return data;
            } else {
                System.out.println("Вы ввели некорректные данные. Попробуйте снова. ");
            }
        }
    }
}