package org.itstep.zoo;

import org.itstep.time.Date;

import java.util.Arrays;

public abstract class Animal {
    private String name;
    private int age;
    private int weight;
    private int id; // Номер вольера
    private int time; // Время в годах
    private int animalType;
    private Expenses expenses[] = new Expenses[0]; // расходы на содержание животного

    public Animal(String name, int age, int weight, int id, int time, int animalType) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.id = id;
        this.time = time;
        this.animalType = animalType;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addExpenses(Expenses expenses) {
        this.expenses = Arrays.copyOf(this.expenses, this.expenses.length + 1);
        this.expenses[this.expenses.length - 1] = expenses;
    }

    public double getExpensesForDay(Date date) {
        double sum = 0;
        for (Expenses e: expenses){
            if (date.equals(e.getDate())) {
                sum += e.getMoney();
            }
        }
        return sum;
    }

public double getAllExpenses() {
    double sum = 0;
    for (Expenses e: expenses){
            sum += e.getMoney();
    }
    return sum;
}

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", id=" + id +
                ", time=" + time +
                ", animalType=" + animalType +
                ", expenses=" + Arrays.toString(expenses) +
                '}';
    }
}
