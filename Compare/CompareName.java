package Compare;
import EmployeeTypes.*;

import java.util.Comparator;

public class CompareName implements Comparator<Employee> {

    //allows for the list to be sorted according to the name of the employee
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getEmployeeName().compareTo(o2.getEmployeeName()) == 0){
            //if the two names are equal, the employees are then sorted according to gross salary
            return Double.compare(o1.getGrossSalary(),o2.getGrossSalary());
        }

        else return o1.getEmployeeName().compareTo(o2.getEmployeeName());
    }
}
