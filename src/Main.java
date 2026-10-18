import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- Главное меню ---");
            System.out.println("1. Задача 1.1: Точка на плоскости");
            System.out.println("2. Задача 1.3: Имена");
            System.out.println("3. Задача 2.1: Прямая");
            System.out.println("4. Задача 3.3: Города");
            System.out.println("5. Задача 4.8: Создаем Города");
            System.out.println("6. Задача 5.5: Дроби");
            System.out.println("0. Выход из программы");

            int choice = InputHelper.readInt(scanner, "Выберите номер пункта: ");

            switch (choice) {
                case 1:
                    runTask1(scanner);
                    break;
                case 2:
                    runTask2(scanner);
                    break;
                case 3:
                    runTask3(scanner);
                    break;
                case 4:
                    runTask4(scanner);
                    break;
                case 5:
                    runTask5(scanner);
                    break;
                case 6:
                    runTask6(scanner);
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("\nСпасибо за работу! До свидания.");
                    break;
                default:
                    System.out.println("\nНет такого пункта меню. Введите число от 0 до 2.");
            }
        }
        scanner.close();
    }

    private static void runTask1(Scanner scanner) {
        System.out.println("  Задача 1: Точка на плоскости");
        System.out.println("Необходимо создать 3 точки и вывести их координаты.\n");

        Point[] points = new Point[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите координаты для Точки №" + (i + 1) + ":");
            double x = InputHelper.readDouble(scanner, "  Координата X = ");
            double y = InputHelper.readDouble(scanner, "  Координата Y = ");

            points[i] = new Point(x, y);
        }

        System.out.println("\n Результат (текстовое представление точек):");
        for (int i = 0; i < 3; i++) {
            System.out.println("Точка №" + (i + 1) + ": " + points[i].toString());
        }
    }

    private static void runTask2(Scanner scanner) {
        System.out.println("  Задача 2: Имена");
        System.out.println("Необходимо создать 3 имени. Если параметр не задан, просто нажмите Enter.\n");
        System.out.println("Подсказка (какие данные ожидается получить):");
        System.out.println("  1. Только имя: Клеопатра");
        System.out.println("  2. Полное имя: Пушкин Александр Сергеевич");
        System.out.println("  3. Фамилия и имя: Маяковский Владимир\n");

        Name[] names = new Name[3];
        String[] hints = {"Клеопатра", "Пушкин А. С.", "Маяковский В."};

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите данные для человека №" + (i + 1) + " (ориентир: " + hints[i] + "):");

            String lastName = InputHelper.readString(scanner, "  Фамилия (или Enter, если нет): ");
            String firstName = InputHelper.readString(scanner, "  Личное имя: ");
            String patronymic = InputHelper.readString(scanner, "  Отчество (или Enter, если нет): ");

            names[i] = new Name(
                    lastName.isEmpty() ? null : lastName,
                    firstName.isEmpty() ? null : firstName,
                    patronymic.isEmpty() ? null : patronymic
            );
        }

        System.out.println("\nРезультат (приведение к строковому виду):");
        for (int i = 0; i < 3; i++) {
            System.out.println("Человек №" + (i + 1) + ": " + names[i].toString());
        }
    }

    private static void runTask3(Scanner scanner) {
        System.out.println("  Задача 3: Прямая");

        System.out.println("\n1): Создание Линии 1");
        System.out.println("По условию: начало {1;3}, конец {23;8}");
        System.out.println("Введите координаты начала Линии 1:");
        double x1 = InputHelper.readDouble(scanner, "  X начала: ");
        double y1 = InputHelper.readDouble(scanner, "  Y начала: ");
        System.out.println("Введите координаты конца Линии 1:");
        double x2 = InputHelper.readDouble(scanner, "  X конца: ");
        double y2 = InputHelper.readDouble(scanner, "  Y конца: ");

        Line line1 = new Line(x1, y1, x2, y2);
        System.out.println("Создана: " + line1.toString());

        System.out.println("\n2): Создание Линии 2 (горизонтальная, высота 10, от 5 до 25)");
        System.out.println("Введите координаты:");
        double x3 = InputHelper.readDouble(scanner, "  X начала: ");
        double y3 = InputHelper.readDouble(scanner, "  Y начала (высота): ");
        double x4 = InputHelper.readDouble(scanner, "  X конца: ");
        double y4 = InputHelper.readDouble(scanner, "  Y конца (высота): ");

        Line line2 = new Line(x3, y3, x4, y4);
        System.out.println("Создана: " + line2.toString());

        // Пункт 3: Создание Линии 3 (использует те же объекты Point!)
        System.out.println("\n3): Создание Линии 3");
        System.out.println("Начало = начало Линии 1, Конец = конец Линии 2");

        Line line3 = new Line(line1.getStartPoint(), line2.getEndPoint());
        System.out.println("Создана: " + line3.toString());

        System.out.println("\n4): Изменение координат Линии 1 (начало) и Линии 2 (конец)");

        System.out.println("Введите новые координаты НАЧАЛА Линии 1:");
        double newX1 = InputHelper.readDouble(scanner, "  Новый X начала: ");
        double newY1 = InputHelper.readDouble(scanner, "  Новый Y начала: ");
        line1.getStartPoint().setX(newX1);
        line1.getStartPoint().setY(newY1);

        System.out.println("Введите новые координаты КОНЦА Линии 2:");
        double newX4 = InputHelper.readDouble(scanner, "  Новый X конца: ");
        double newY4 = InputHelper.readDouble(scanner, "  Новый Y конца: ");
        line2.getEndPoint().setX(newX4);
        line2.getEndPoint().setY(newY4);

        System.out.println("\nРезультат после изменений (пункт 4):");
        System.out.println("  Линия 1: " + line1.toString());
        System.out.println("  Линия 2: " + line2.toString());
        System.out.println("  Линия 3: " + line3.toString() + " <- изменилась автоматически!");

        System.out.println("\n5): Изменение Линии 1 так, чтобы Линия 3 не изменилась");
        System.out.println("Меняем только КОНЕЦ Линии 1");

        System.out.println("Введите новые координаты КОНЦА Линии 1:");
        double newX2 = InputHelper.readDouble(scanner, "  Новый X конца: ");
        double newY2 = InputHelper.readDouble(scanner, "  Новый Y конца: ");
        line1.getEndPoint().setX(newX2);
        line1.getEndPoint().setY(newY2);

        System.out.println("\nФинальный результат (пункт 5):");
        System.out.println("  Линия 1: " + line1.toString() + " <- изменился только конец");
        System.out.println("  Линия 2: " + line2.toString());
        System.out.println("  Линия 3: " + line3.toString() + " <- НЕ изменилась!");
    }

    private static void runTask4(Scanner scanner) {
        System.out.println("  Задача 4: Города");
        System.out.println("Создание схемы городов и путей между ними.\n");

        int cityCount = InputHelper.readIntInRange(scanner, "Введите количество городов (минимум 2): ", 2, 100);

        City[] cities = new City[cityCount];

        System.out.println("\nВведите названия городов:");
        for (int i = 0; i < cityCount; i++) {
            String name;
            do {
                name = InputHelper.readString(scanner, "  Город №" + (i + 1) + ": ");
                if (name.isEmpty()) {
                    System.out.println("Название не может быть пустым. Попробуйте снова.");
                }
            } while (name.isEmpty());
            cities[i] = new City(name);
        }

        int routeCount = InputHelper.readIntInRange(scanner, "\nВведите количество путей (минимум 0): ", 0, 1000);

        System.out.println("\nВведите данные для каждого пути:");
        for (int i = 0; i < routeCount; i++) {
            System.out.println("\n--- Путь №" + (i + 1) + " ---");

            System.out.println("  Доступные города:");
            for (int j = 0; j < cityCount; j++) {
                System.out.println("    " + (j + 1) + ". " + cities[j].getName());
            }

            int fromIndex = InputHelper.readIntInRange(scanner, "  Откуда (номер города): ", 1, cityCount) - 1;
            int toIndex = InputHelper.readIntInRange(scanner, "  Куда (номер города): ", 1, cityCount) - 1;

            if (fromIndex == toIndex) {
                System.out.println("Путь из города в самого себя не добавлен.");
                i--; // повторяем итерацию
                continue;
            }

            double cost = InputHelper.readDouble(scanner, "  Стоимость поездки: ");

            cities[fromIndex].addRoute(cities[toIndex], cost);
            System.out.println("Путь добавлен: " + cities[fromIndex].getName()
                    + " -> " + cities[toIndex].getName() + " (стоимость: " + (int) cost + ")");
        }

        System.out.println("\nИтоговая схема городов и путей:");
        for (City city : cities) {
            System.out.println("  " + city.toString());
        }
    }

    private static void runTask5(Scanner scanner) {
        System.out.println("  Задача 5: Создаем Города (V2)");
        System.out.println("Демонстрация двух способов создания города.\n");

        int baseCityCount = InputHelper.readIntInRange(scanner, "Введите количество базовых городов (минимум 2): ", 2, 50);
        CityV2[] baseCities = new CityV2[baseCityCount];

        System.out.println("\nСоздаем базовые города (используется конструктор с одним параметром):");
        for (int i = 0; i < baseCityCount; i++) {
            String name = InputHelper.readString(scanner, "  Название города №" + (i + 1) + ": ");
            while (name.isEmpty()) {
                System.out.println("Название не может быть пустым.");
                name = InputHelper.readString(scanner, "  Название города №" + (i + 1) + ": ");
            }
            baseCities[i] = new CityV2(name);
        }

        System.out.println("\nТеперь создадим 'продвинутый' город, указав сразу все пути к базовым городам.");
        String advancedName = InputHelper.readString(scanner, "Введите название продвинутого города: ");
        while (advancedName.isEmpty()) {
            System.out.println("Название не может быть пустым.");
            advancedName = InputHelper.readString(scanner, "Введите название продвинутого города: ");
        }

        RouteCollection routes = new RouteCollection();
        System.out.println("\nДобавим пути из '" + advancedName + "' к базовым городам:");

        for (int i = 0; i < baseCityCount; i++) {
            int addRoute = InputHelper.readIntInRange(scanner,
                    "  Добавить путь в '" + baseCities[i].getName() + "'? (1 - да, 0 - нет): ", 0, 1);

            if (addRoute == 1) {
                double cost = InputHelper.readDouble(scanner, "    Стоимость поездки: ");
                routes.addRoute(new RouteV2(baseCities[i], cost));
            }
        }

        CityV2 advancedCity = new CityV2(advancedName, routes);

        System.out.println("\nИтоговая схема (вызов toString() для всех объектов):");
        System.out.println("  Базовые города (без исходящих путей):");
        for (CityV2 city : baseCities) {
            System.out.println("    " + city.toString());
        }
        System.out.println("  Продвинутый город (с заданными путями):");
        System.out.println("    " + advancedCity.toString());
    }

    private static void runTask6(Scanner scanner) {
        System.out.println("  Задача 6: Дроби");
        System.out.println("Введите данные для трех дробей (f1, f2, f3) и целого числа.\n");

        System.out.println("Введите дробь f1:");
        Fraction f1 = readFraction(scanner, "f1");

        System.out.println("\nВведите дробь f2:");
        Fraction f2 = readFraction(scanner, "f2");

        System.out.println("\nВведите дробь f3:");
        Fraction f3 = readFraction(scanner, "f3");

        int intVal = InputHelper.readInt(scanner, "\nВведите целое число для операций: ");

        System.out.println("  Результаты вычислений");

        System.out.println("\nАрифметические операции с дробями:");
        System.out.println("  Сложение:       " + f1 + " + " + f2 + " = " + f1.sum(f2));
        System.out.println("  Вычитание:      " + f1 + " - " + f2 + " = " + f1.minus(f2));
        System.out.println("  Умножение:      " + f1 + " * " + f2 + " = " + f1.mul(f2));
        System.out.println("  Деление:        " + f1 + " / " + f2 + " = " + f1.div(f2));

        System.out.println("\nАрифметические операции с целым числом (" + intVal + "):");
        System.out.println("  Сложение:       " + f1 + " + " + intVal + " = " + f1.sum(intVal));
        System.out.println("  Вычитание:      " + f1 + " - " + intVal + " = " + f1.minus(intVal));
        System.out.println("  Умножение:      " + f1 + " * " + intVal + " = " + f1.mul(intVal));
        System.out.println("  Деление:        " + f1 + " / " + intVal + " = " + f1.div(intVal));

        System.out.println("\n Сложное выражение: f1.sum(f2).div(f3).minus(5)");
        Fraction complexResult = f1.sum(f2).div(f3).minus(5);
        System.out.println("  Результат: " + f1 + ".sum(" + f2 + ").div(" + f3 + ").minus(5) = " + complexResult);
    }

    private static Fraction readFraction(Scanner scanner, String name) {
        while (true) {
            int num = InputHelper.readInt(scanner, "  Числитель (" + name + "): ");
            int den = InputHelper.readInt(scanner, "  Знаменатель (" + name + "): ");

            try {
                return new Fraction(num, den);
            } catch (IllegalArgumentException e) {
                System.out.println("\nОшибка: " + e.getMessage() + ". Попробуйте ввести дробь снова.");
            }
        }
    }
}
