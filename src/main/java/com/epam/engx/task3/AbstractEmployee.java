package com.epam.engx.task3;

public abstract class AbstractEmployee {
    protected double hourly;

    public AbstractEmployee(double hourly) {
        this.hourly = hourly;
    }
    
    public abstract String say();
}