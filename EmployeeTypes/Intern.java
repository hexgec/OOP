package EmployeeTypes;

public class Intern extends Employee {

    private int gpa;
    private double salary;

    //constructor of class EmployeeTypes.Intern
    public Intern(String employeeID, String employeeName, double grossSalary, int gpa){
        //creating an object from superclass EmployeeTypes.Employee
        super(employeeID, employeeName, grossSalary);
        //setting gpa with value passed in parameter
        setGpa(gpa);
    }


    //setters and getters

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setGrossSalary(double grossSalary) {
        super.setGrossSalary(grossSalary);
        //the necessary values are updated accordingly
        setSalary();
    }

    public void setGpa(int gpa) {
        //the gpa can only be between 0 and 10
        if((gpa>=0) && (gpa<=10)) {
            this.gpa = gpa;
            //the salary is calculated according to the gpa
            setSalary();
            //setting the net salary according to the new salary
            super.setNetSalary(this.salary);
        }else{
            //allows for incorrect input to be checked in main method
            this.gpa = -1;
        }
    }

    //the salary is calculated according to the gpa of the intern
    private void setSalary(){
        if(this.gpa<=5){
            this.salary = 0;
        }else if(this.gpa<8){
            this.salary = super.getGrossSalary();
        }else{
            this.salary = super.getGrossSalary() + 1000;
        }
    }

    @Override
    public String toString(){
        return (super.getEmployeeName() + "'s gross salary is of " + this.getSalary() + " SEK per month.");
    }
}
