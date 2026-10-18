import java.util.Scanner;

public class InputHelper {
    private String helperName;

    public InputHelper() {
        this.helperName = "Стандартный валидатор ввода";
    }

    public InputHelper(String helperName) {
        this.helperName = helperName;
    }

    public String getHelperName() { return helperName; }
    public void setHelperName(String helperName) { this.helperName = helperName;}

    @Override
    public String toString() {
        return "InputHelper{name='" + helperName + "'}";
    }

    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: ожидается целое число. Попробуйте снова.");
            }
        }
    }

    public static int readIntInRange(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Ошибка: число должно быть от " + min + " до " + max + ". Попробуйте снова.");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: ожидается целое число. Попробуйте снова.");
            }
        }
    }

    public static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                // Заменяем запятую на точку для удобства пользователя
                String input = scanner.nextLine().replace(",", ".");
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: ожидается число. Попробуйте снова.");
            }
        }
    }

    public static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
