package com.kenez92.company;

import com.kenez92.oldhrsystem.Workers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SalaryAdapterTestSuite {

    @Test
    public void testTotalSalary() {
        //Given
        Workers workers = new Workers();
        SalaryAdapter salaryAdapter = new SalaryAdapter();
        //When
        double totalSalary = salaryAdapter.totalSalary((workers.getWorkers()), workers.getSalaries());
        //Then
        assertEquals(27750, totalSalary, 0);
    }

}