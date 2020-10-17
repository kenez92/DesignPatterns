package com.kenez92.company;

import com.kenez92.newhrsystem.Employee;
import com.kenez92.oldhrsystem.SalaryCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalaryAdapter extends SalaryAdaptee implements SalaryCalculator {
    @Override
    public double totalSalary(String[][] workers, double[] salaries) {
        List<Employee> employeeList = new ArrayList<>();
        for (int n = 0; n < salaries.length; n++) {
            employeeList.add(new Employee(
                    workers[n][0],
                    workers[n][1],
                    workers[n][2],
                    BigDecimal.valueOf(salaries[n])));
        }
        return calculateSalaries(employeeList).doubleValue();
    }
}
