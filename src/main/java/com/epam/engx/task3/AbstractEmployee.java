package com.epam.engx.task3;

public abstract class AbstractEmployee implements Employee {
    protected double hourly;

    public AbstractEmployee(double hourly) {
        this.hourly = hourly;
    }
    
}