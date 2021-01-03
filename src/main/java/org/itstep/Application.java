package org.itstep;

import org.itstep.time.Date;
import org.itstep.ui.ZooUi;
import org.itstep.zoo.Expenses;

public class Application {
    public static void main(String[] args) {
      // Date date = new Date(27,11,2020);
       //Expenses expenses = new Expenses(100,date);
       // System.out.println(expenses);
       // System.out.println(date.equals(new Date(27,11,2020)));
         ZooUi zooUi = new ZooUi();
      zooUi.start();
    }
}
