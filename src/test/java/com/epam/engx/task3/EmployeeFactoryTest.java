package com.epam.engx.task3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EmployeeFactoryTest {

  private final EmployeeFactory employeeFactory = new EmployeeFactory();

  @DisplayName("Valid employee types:")
  @ParameterizedTest(name = "[{index}] Type: {0}, Expected Class: {1}")
  @CsvSource(delimiter = '|', textBlock = """
              fulltime    | FullTimeEmployee
              parttime    | PartTimeEmployee
              temporary   | TemporaryEmployee
              contractor  | ContractorEmployee
      """)
  void createEmployee_validTypes(String type, String expectedClassName) {
    var hourlyRate = 25.0;
    var employee = employeeFactory.createEmployee(type, hourlyRate);

    assertThat(employee)
        .as("Employee should not be null")
        .isNotNull();

    assertThat(employee.getClass().getSimpleName())
        .as("Expected employee subclass")
        .isEqualTo(expectedClassName);

    assertThat(employee.say())
        .as("Expected employee hourly rate")
        .contains(Double.toString(hourlyRate));
  }

  @DisplayName("Invalid employee type:")
  @Test
  void createEmployee_invalidType() {
    var invalidType = "nonexistent";
    var hourlyRate = 30.0;

    assertThatThrownBy(() -> employeeFactory.createEmployee(invalidType, hourlyRate))
        .as("Invalid employee type should throw an exception")
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Invalid employee type");
  }
}