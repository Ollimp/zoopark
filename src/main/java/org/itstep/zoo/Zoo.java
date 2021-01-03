package org.itstep.zoo;

import org.itstep.time.Date;

import java.util.Arrays;

public class Zoo {
    private Animal[] animals = new Animal[0];

    public void add(Animal animal) {
        animals = Arrays.copyOf(animals, animals.length + 1);
        animals[animals.length - 1] = animal;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void deleteByName(String name) {
        if (name == null) return;
        int deleteIndex = -1;
        for (int i = 0; i < animals.length; i++) {

            if (name.equals(animals[i].getName())) {
                deleteIndex = i;
                 break;
            }
        }
        //        2
        // [0, 1, 2, 3, 4, 5,]
        if (deleteIndex >=0) {
            for (int i = deleteIndex + 1; i < animals.length; i++) {
                animals[i - 1] = animals[i];
            }
            animals = Arrays.copyOf(animals, animals.length -1);
        }
    }

    /**
     * Добавление расходов на животное по кличке
     * @param name - кличка животного
     * @param expense - расходы
     */
    public void addExpenses(String name, Expenses expense) {
        if (name == null) return;
        for (Animal animal: animals) {
            if (name.equals(animal.getName())) {
                animal.addExpenses(expense);
            }
        }
    }

    /**
     * Добавление расходов на животное по номеру вольера
     * @param id - номер вольера
     * @param expense - расходы
     */
    public void addExpenses(int id, Expenses expense) {
        for (Animal animal: animals) {
            if (id == animal.getId()) {
                animal.addExpenses(expense);
            }
        }
    }


    public double  getExpensesForDay(Date date) {
        double sum = 0;
        for (Animal animal: animals) {
            sum += animal.getExpensesForDay(date);
        }
        return sum;
    }

    public double getAllExpenses() {
        double sum = 0;
        for (Animal animal: animals) {
            sum += animal.getAllExpenses();
        }
        return sum;
    }
}
