package com.kenez92.company;

import com.kenez92.newhrsystem.CompanySalaryProcessor;
import com.kenez92.newhrsystem.Employee;
import com.kenez92.newhrsystem.SalaryProcessor;

import java.math.BigDecimal;
import java.util.List;

public class SalaryAdaptee implements SalaryProcessor {
    @Override
    public BigDecimal calculateSalaries(List<Employee> employees) {
        CompanySalaryProcessor theProcessor = new CompanySalaryProcessor();
        return theProcessor.calculateSalaries(employees);
    }
}
