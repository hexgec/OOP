import Compare.*;
import EmployeeTypes.*;

import java.util.ArrayList;

public class ReusaxCorp {
    //employees list is only handled by this class

    private ArrayList<Employee> employees;

    //constructor for reuse corp
    public ReusaxCorp(){

        employees = new ArrayList<>();
        //the benefit of the director is initially set to 100 when an instance of the class ReusexCorp is created
        new Director(100);

    }


    //REGISTER_EMPLOYEE
    //checking if the passed id value is already stored
    public int findId(String id){
        for(int i = 0; i<employees.size(); i++){
            if(employees.get(i).getEmployeeID().equals(id)){
                return i;
            }
        }
        //no ID matches the passed id
        return -1;
    }

    //checking if the degree is one of the specified types
    public boolean checkDegree(String degree) {
        if (degree.equals("BSc.") || degree.equals("MSc.") || degree.equals("PhD") ){
            return true;
        }else
            return false;
    }

    //checking if the department is one of the specified types
    public boolean checkDepartment(String department) {
        if(department.equals("Human Resources") || department.equals("Technical") || department.equals("Business")){
            return true;
        }else
            return false;
    }

    //the gpa can only be between 0 and 10
    public boolean checkGpa(int gpa) {
        if((gpa>=0) && (gpa<=10)) {
            return true;
        }else{
            return false;
        }
    }

    //register an employee
    public void regEmp(String empId, String empName, double grossSalary){
        employees.add(new Employee(empId, empName, grossSalary));
    }

    //register an intern
    public void intern(String empId, String empName, double grossSalary, int gpa){
        employees.add(new Intern(empId, empName, grossSalary, gpa));
    }

    //register a manager
    public void manager(String empId, String empName, double grossSalary, String degree){
        employees.add(new Manager(empId, empName, grossSalary, degree));
    }

    //register a director
    public void director(String empId, String empName, double grossSalary, String degree, String department){
        employees.add(new Director(empId, empName, grossSalary, degree, department));
    }



    //REMOVE_EMPLOYEE
    public void removeEmp(int no){
        employees.remove(no);
    }

    //RETRIEVE_EMPLOYEE
    public Employee printEmp(int no){
        return employees.get(no);
    }

    // UPDATE_EMPLOYEE
    public void updateName(int no, String name){
        employees.get(no).setEmployeeName(name);
    }

    public void updateSalary(int no, double salary){
        employees.get(no).setGrossSalary(salary);
    }

    //GROSS_SALARIES
    public double grossSalaries(){
        double total = 0;

        //each employee is traversed and each gross salary is added to the total
        for(Employee e: employees){
            total += e.getSalary();
        }

        return total;
    }

    //NET_SALARIES
    public double netSalaries(){
        double total = 0;

        //each employee is traversed and each net salary is added to the total
        for(Employee e: employees){
            total += e.getNetSalary();
        }

        return total;
    }


    //TOTAL_EMPLOYEES
    public int totalEmp(){
        return employees.size();
    }

    //UPDATE_BENEFIT
    public void updateBenefit(double benefit){
        //the benefit is updated by passing the value as the parameter of the constructor of the class
        new Director(benefit);
    }


    //PROMOTION
    public Object[] baseEmp(int no, String tempId){
        //all the required information from the passed employee is saved in the necessary variables
        String id = tempId;
        String name = employees.get(no).getEmployeeName();
        double salary = employees.get(no).getGrossSalary();

        //the values are stored as an array of objects so as to account for the the different data types
        Object[] ans = {id,name,salary};

        return ans;
    }


    //Checking different types of employees
    //using instanceof the types of the objects are are compared

    public boolean checkManager(int no){
        if(employees.get(no) instanceof Manager){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkDirector(int no){
        if(employees.get(no) instanceof Director){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkIntern(int no){
        if(employees.get(no) instanceof Intern){
            return true;
        }else{
            return false;
        }
    }

    //the required method is called passing the necessary variables to create the new employee of the required type
    // and stores it in the employees list and after the old employee in the list is removed

    //promoting to a regular employee
    public void promoteToRegEmp(int no, Object[] emp){
        regEmp((String)emp[0],(String)emp[1],(double)emp[2]);
        removeEmp(no);
    }

    //promoting to a EmployeeTypes.Manager from any employee apart from EmployeeTypes.Director
    public void promoteToManager(int no, Object[] emp){
        manager((String)emp[0],(String)emp[1],(double)emp[2],((Director) employees.get(no)).getDegree());
        removeEmp(no);
    }

    //promoting to a EmployeeTypes.Manager from a EmployeeTypes.Director
    public void promoteToManager(int no, Object[] emp, String degree){
        manager((String)emp[0],(String)emp[1],(double)emp[2],degree);
        removeEmp(no);
    }

    //promoting to a EmployeeTypes.Director from any employee apart from EmployeeTypes.Manager
    public void promoteToDirector(int no, Object[] emp, String degree, String department){
        director((String)emp[0],(String)emp[1],(double)emp[2],degree,department);
        removeEmp(no);
    }

    //promoting to a EmployeeTypes.Director from a EmployeeTypes.Manager
    public void promoteToDirector(int no, Object[] emp, String department){
        director((String)emp[0],(String)emp[1],(double)emp[2],((Manager)employees.get(no)).getDegree(),department);
        removeEmp(no);
    }

    //promoting to an EmployeeTypes.Intern
    public void promoteToIntern(int no, Object[] emp, int gpa){
        intern((String)emp[0],(String)emp[1],(double)emp[2], gpa);
        removeEmp(no);
    }


    public boolean sortBy(String type, String order){

        switch (type){
            case "Name":

                //an instance of the Compare.CompareName class is created to be used to sort the list by name
                CompareName compareName = new CompareName();

                switch (order){
                    case "Ascending":
                        employees.sort(compareName);
                        break;

                    case "Descending":
                        //.reversed() allows for sorting in descending order
                        employees.sort(compareName.reversed());
                        break;

                    default:
                        //if an invalid input, false returned
                        return false;

                }
                break;

            case "Net Salary":

                //an instance of the Compare.CompareSalary class is created to be used to sort the list by net salary
                CompareSalary compareSalary = new CompareSalary();

                switch (order){
                    case "Ascending":
                        employees.sort(compareSalary);
                        break;

                    case "Descending":
                        //.reversed() allows for sorting in descending order
                        employees.sort(compareSalary.reversed());
                        break;

                    default:
                        //if an invalid input, false returned
                        return false;

                }
                break;

            default:
                //if an invalid input, false returned
                return false;
        }
        return true;

    }

    public String display(){

        String result = "";

        //stores all the information of the employees in a single String
        for (Employee e : employees
                ) {
            result = result + e + "\n" ;
        }

        return result;
    }
}