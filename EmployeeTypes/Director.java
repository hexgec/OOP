package EmployeeTypes;

public class Director extends Manager {

    private String department;
    private static double benefit;
    private double salary;

    //constructor for the director
    public Director(String employeeID, String employeeName, double grossSalary, String degree, String department) {
        //creating an object from the superclass EmployeeTypes.Manager
        super(employeeID, employeeName, grossSalary, degree);

        //using setters to set the degree to one of the specified strings
        setDepartment(department);
        this.salary = changeSalary();
        newNetSalary();
    }

    //constructor for changing the benefit
    public Director(double benefit){
        this.benefit = benefit;
    }

    //setters and getters

    //setter for the department of the EmployeeTypes.Director
    public void setDepartment(String department) {
        //setting the department to one of the specified types
        if(department.equals("Human Resources") || department.equals("Technical") || department.equals("Business")){
            //setting the value for the department
            this.department = department;
        }else
            //allows for the incorrect input to be checked in the main method
            this.department = "Invalid";
    }

    @Override
    public String getDegree() {
        return super.getDegree();
    }

    @Override
    public double getSalary() {
        this.salary = changeSalary();
        return this.salary;
    }

    @Override
    public double getNetSalary() {
        newNetSalary();
        return super.getNetSalary();
    }

    @Override
    public void setGrossSalary(double grossSalary) {
        super.setGrossSalary(grossSalary);
        //the necessary values are updated accordingly
        this.salary = this.changeSalary();
        newNetSalary();
    }


    public double changeSalary(){
        //adding the benefit to the initial gross salary
        double directorGrossSal = super.getSalary();
        salary = directorGrossSal + benefit;
        return salary;
    }


    public void newNetSalary(){
        //calculating the net salary based on the current gross salary
        if(this.salary < 30000){

            super.calculateNetSalary(this.salary);

        }else

        if(this.salary>30000 && this.salary<50000){

            super.setNetSalary(this.salary - 0.2*this.salary);

        }else

        if(this.salary>50000){

            super.setNetSalary(salary-(this.salary - 30000)*0.4 - 30000*0.2);

        }

    }

    @Override
    public String toString(){
        return (super.getEmployeeName() + "'s gross salary is of " + this.getSalary() + " SEK per month.");
    }

}


