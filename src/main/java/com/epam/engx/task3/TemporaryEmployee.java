package com.epam.engx.task3;

public class TemporaryEmployee extends AbstractEmployee {
    public TemporaryEmployee(double hourly) {
        super(hourly);
    }

    @Override
    public String say() {
        return "Temporary employee with an hourly rate of " + hourly;
    }
}