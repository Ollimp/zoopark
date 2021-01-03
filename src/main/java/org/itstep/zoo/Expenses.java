package org.itstep.zoo;

import org.itstep.time.Date;

public class Expenses {
    private final double money;
    private final Date date;

    public Expenses(double money, Date date) {
        this.money = money;
        this.date = date;
    }

    public double getMoney() {
        return money;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Expenses for " + date + " is $" + money;
    }
}
