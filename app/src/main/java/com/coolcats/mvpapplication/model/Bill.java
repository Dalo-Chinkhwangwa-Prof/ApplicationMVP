package com.coolcats.mvpapplication.model;

public class Bill {

    private String name;
    private double total;
    private String dueDate;

    public Bill(String name, double total, String dueDate) {
        this.name = name;
        this.total = total;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return name + " with a total of " + total + " is due " + dueDate;
    }
}
