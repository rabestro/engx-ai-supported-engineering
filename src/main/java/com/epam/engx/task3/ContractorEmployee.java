package com.epam.engx.task3;

public class ContractorEmployee extends AbstractEmployee {
    public ContractorEmployee(double hourly) {
        super(hourly);
    }

    @Override
    public String say() {
        return "Contractor employee with an hourly rate of " + hourly;
    }
}