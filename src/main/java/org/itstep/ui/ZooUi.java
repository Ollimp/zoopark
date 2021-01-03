package org.itstep.ui;

import org.itstep.time.Date;
import org.itstep.zoo.*;

import java.util.Scanner;

import static org.itstep.ui.MenuItems.*;

public class ZooUi {
   private  final Scanner scanner = new Scanner(System.in);
   private final Zoo zoo = new Zoo();
   
    public ZooUi() {}

    public void start() {
        int menu = 0;
do {
menu = menu();
switch (menu) {
    case ADD:

        addAnimals();
        break;
    case SHOW:
        showAnimals();
        break;
    case DELETE:
        deleteAnimal();
        break;
    case ADD_EXPENSIVE:
        addExpensive();

        break;
    case CALC_TODAY:
        calcExpensesToday();
        break;
    case CALC_ALL:
        calcAllExpenses();
        break;
}
} while (menu != 7);
        System.out.println("Работа программы завершена");
    }

    private void deleteAnimal() {
        System.out.println("Удаление животного по кличке");
        System.out.println("Введите кличку животного: ");
        String name = scanner.nextLine();
        zoo.deleteByName(name);
    }

    private void showAnimals() {
    }

    private void addAnimals() {
    }

    private void calcAllExpenses() {
        System.out.println("Расходы за весь период: $" + zoo.getAllExpenses() );
    }

    private void calcExpensesToday() {
        Date date = getDate();
        System.out.println("Расходы на текущий день: " + zoo.getExpensesForDay(date));
    }

    private Date getDate() {
        System.out.println("Ведите день: ");
        int day = getIntInRange(1, 31);
        System.out.println("Ведите месяц: ");
        int month = getIntInRange(1, 12);
        System.out.println("Ведите год: ");
        int year = getIntInRange(1980, 2100);
        return  new Date(day, month, year);
    }

    private void addExpensive() {
        System.out.println("Добавление расходов на день");
        System.out.println("Введите кличку животного: ");
        String name = scanner.nextLine();
        System.out.println("Введите сумму расходов: ");
        double money  = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите дату: ");
        Date date  = getDate();
        zoo.addExpenses(name, new Expenses(money, date));
    }



     {
        System.out.println("Добавление нового животного");

         String name;
         int age;
         int weight;
         int id; // Номер вольера
         int time; // Время в годах
         int animalType = 0;

        System.out.println("Введите кличку: ");
        name = scanner.nextLine();
        System.out.println("Введите возраст: ");
        age = getIntInRange(0 , 100);
        System.out.println("Введите вес животного: ");
        weight = getIntInRange(0, 150);
        System.out.println("Введите номер вольера: ");
        id = getIntInRange(1, 100);
        System.out.println("Введите время в годах пребывания в зоопарке: ");
        time = getIntInRange(0, 30);

Animal animal = null ;
        System.out.println("Укажите вид животного");
        System.out.println(SNAKES + ". Змеи\n" +
               CATS  +". Кошки\n" +
               DOGS  +". Собаки");
        int choice = getIntInRange(SNAKES, DOGS);

        switch (choice) {
            case SNAKES:
                System.out.println("1. Питон\n +" +
                        "2. Удав\n +" +
                        "3. Гадюка");
                choice = getIntInRange(1, 3);
                switch (choice) {
                    case 1:
                        animalType = AnimalTypes.PYTHON;
                        break;
                    case 2:
                        animalType = AnimalTypes.BOA;
                        break;
                    case 3:
                        animalType = AnimalTypes.VIPER;
                        break;
                }
                animal = new Snake(name, age, weight, id, time, animalType);
                break;
            case  CATS:
                System.out.println("1. Лев\n +" +
                        "2. Пантера");
                choice = getIntInRange(1, 2);
                switch (choice) {
                    case 1:
                        animalType = AnimalTypes.LION;
                        break;
                    case 2:
                        animalType = AnimalTypes.PANTHER;
                        break;

                }
                animal = new Cat(name, age, weight, id, time, animalType);
                break;
            case DOGS:
                System.out.println("1. Волк\n +" +
                        "2. Собака динго");
                
                choice = getIntInRange(1, 2);
                switch (choice) {
                    case 1:
                        animalType = AnimalTypes.WOLF;
                        break;
                    case 2:
                        animalType = AnimalTypes.DINGO;
                        break;

                }

                zoo.add(animal);
        }


    }

    private int menu() {
        System.out.println(
                ADD  +". Добавление нового животного в зоопарк\n" +
               SHOW + ". Отображение всех животных\n" +
                DELETE +". Удаление животного по кличке\n" +
                ADD_EXPENSIVE +". Добавление расходов на еду за текущий день для отдельного животного\n" +
                CALC_TODAY +". Подсчет расходов на питание для всех животных за текущий день...\n" +
                CALC_ALL +". Расходы  за весь период учета\n" +
                EXIT +". Выйти из программы");
        return getIntInRange(ADD,EXIT);
    }

    private int getIntInRange(int from, int to) {
        int menu = 0;
        do {
            System.out.print(">>> ");
            String input = scanner.nextLine();
            try {
menu = Integer.parseInt(input);
            } catch (Throwable ex) {
                System.out.println("Необходимо ввести число от "+from+" до "+to);
            }
        }while ( menu < from|| menu > to);
        return menu;
    }
}
