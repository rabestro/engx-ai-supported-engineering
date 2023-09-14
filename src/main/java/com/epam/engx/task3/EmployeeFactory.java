package com.epam.engx.task3;

import java.util.Locale;

public class EmployeeFactory {
    public AbstractEmployee createEmployee(String type, double hourly) {
        return switch (type.toLowerCase(Locale.ROOT)) {
            case "fulltime" -> new FullTimeEmployee(hourly);
            case "parttime" -> new PartTimeEmployee(hourly);
            case "temporary" -> new TemporaryEmployee(hourly);
            case "contractor" -> new ContractorEmployee(hourly);
            default -> throw new IllegalArgumentException("Invalid employee type: " + type);
        };
    }
}