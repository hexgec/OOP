package EmployeeTypes;

public class Employee{

    private String employeeID;
    private String employeeName;
    private double grossSalary;
    private double netSalary;

    public Employee(){}

    //constructor for EmployeeTypes.Employee
    public Employee(String employeeID, String employeeName, double grossSalary){
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        setGrossSalary(grossSalary);
    }

    //setters and getters

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
        calculateNetSalary(this.grossSalary);
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public double getSalary(){
        return this.grossSalary;
    }

    public String toString(){
        return (employeeName + "'s gross salary is of " + getSalary() + " SEK per month.");
    }

    public void calculateNetSalary(double grossSalary) {
        this.netSalary = grossSalary - (grossSalary*0.1);
    }

    //checking if two employees are equals if their ID is the same
    public boolean areEquals(String otherID){

        if(otherID.equals(this.employeeID)){
            return true;
        }else return false;

    }

}

