package Compare;
import EmployeeTypes.*;

import java.util.Comparator;

public class CompareSalary implements Comparator<Employee> {

    //allows for the list to be sorted according to the net salary of the employee
    @Override
    public int compare(Employee o1, Employee o2) {

        return Double.compare(o1.getNetSalary(),o2.getNetSalary());

    }

}
