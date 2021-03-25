package EmployeeTypes;

public class Manager extends Employee {
    private String degree;
    private double bonus;
    private double salary;

    public Manager(){}

    //constructor for the EmployeeTypes.Manager
    public Manager(String employeeID, String employeeName, double grossSalary,String degree){
        //creating an object from the superclass EmployeeTypes.Employee
        super(employeeID, employeeName, grossSalary);

        //using setters to set the degree to one of the specified strings
        setDegree(degree);
        this.salary = this.changeSalary();

    }

    //setters and getters

    @Override
    public void setGrossSalary(double grossSalary) {
        super.setGrossSalary(grossSalary);
        //the necessary values are updated accordingly
        this.salary = this.changeSalary();
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    public String getDegree() {
        return degree;
    }

    //setter for the academic qualification of the EmployeeTypes.Manager
    public void setDegree(String degree) {
        //checking if the degree is BSc., MSc. or PhD
        if (degree.equals("BSc.") || degree.equals("MSc.") || degree.equals("PhD") ){
            //setting the value for the degree
            this.degree = degree;
            //bonus is set according to the passed degree
            setBonus();
        }else
            //allows for the incorrect input to be checked in the main method
            this.degree ="Invalid";
    }


    //the bonus is calculated according to the degree of the EmployeeTypes.Manager
    private void setBonus() {
        double grossSalary = super.getGrossSalary();
        if(this.degree.equals("Bsc.")){
            this.bonus = grossSalary*0.1;
        }else
        if(degree.equals("MSc.")){
            this.bonus = grossSalary*0.2;
        }else
        if(degree.equals("PhD")){
            this.bonus = grossSalary*0.35;
        }

        this.salary = this.changeSalary();
    }

    //adding the bonus to the initial gross salary
    private double changeSalary(){
        double tempGross = super.getGrossSalary()+this.bonus;
        super.calculateNetSalary(tempGross);
        return tempGross;
    }

    @Override
    public String toString(){
        return (super.getEmployeeName() + "'s gross salary is of " + this.getSalary() + " SEK per month.");
    }

}

