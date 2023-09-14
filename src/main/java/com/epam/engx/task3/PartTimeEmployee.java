package com.epam.engx.task3;

public class PartTimeEmployee extends AbstractEmployee {
    public PartTimeEmployee(double hourly) {
        super(hourly);
    }

    @Override
    public String say() {
        return "Part-time employee with an hourly rate of " + hourly;
    }
}