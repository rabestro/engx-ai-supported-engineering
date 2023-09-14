package com.epam.engx.task3;

public class FullTimeEmployee extends AbstractEmployee {
    public FullTimeEmployee(double hourly) {
        super(hourly);
    }

    @Override
    public String say() {
        return "Full-time employee with an hourly rate of " + hourly;
    }
}