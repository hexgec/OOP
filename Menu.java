public class Menu {
    //all output to the user are handled from this class

    private static final int REGISTER_EMPLOYEE =1;
    private static final int REMOVE_EMPLOYEE =2;
    private static final int RETRIEVE_EMPLOYEE =3;
    private static final int UPDATE_EMPLOYEE =4;
    private static final int GROSS_SALARIES =5;
    private static final int NET_SALARIES =6;
    private static final int TOTAL_EMPLOYEES =7;
    private static final int UPDATE_BENEFIT = 8;
    private static final int PROMOTION = 9;
    private static final int SORT = 10;
    private static final int DISPLAY = 11;
    private static final int QUIT = 12;

    private int option;
    Input input = new Input();
    ReusaxCorp company = new ReusaxCorp();

    private Menu(){

    }

    //the corresponding method to the chosen option is carried out
    public void run(){

        do{
            printMenuOptions();
            System.out.print(" Type the option number: ");
            option = input.readInt();

            System.out.println();

            switch (option){

                case REGISTER_EMPLOYEE:
                    createEmp();

                    break;

                case REMOVE_EMPLOYEE:
                    removeEmp();
                    break;

                case RETRIEVE_EMPLOYEE:
                    printEmp();
                    break;

                case UPDATE_EMPLOYEE:
                    updateEmp();
                    break;

                case GROSS_SALARIES:
                    grossSalaries();
                    break;

                case NET_SALARIES:
                    netSalaries();
                    break;

                case TOTAL_EMPLOYEES:
                    totalEmp();
                    break;

                case UPDATE_BENEFIT:
                    updateBenefit();
                    break;

                case PROMOTION:
                    promote();
                    break;

                case SORT:
                    sort();
                    break;

                case DISPLAY:
                    display();
                    break;

                case QUIT:
                    System.out.println("Goodbye!");
                    break;


                default:
                    System.out.println("Option "+option+" is not valid.");
                    System.out.println();
                    break;
            }




        }while(option != QUIT);


    }

    //the main menu is displayed to the user
    private void printMenuOptions(){

        System.out.println(" === Welcome to Reusax Corporate === ");
        System.out.println(" Choose an option below: ");
        System.out.println(" ");
        System.out.println(" 1. Register an employee. ");
        System.out.println(" 2. Remove an employee. ");
        System.out.println(" 3. Retrieve an employee's information. ");
        System.out.println(" 4. Update an employee's information ");
        System.out.println(" 5. Print total of gross salaries. ");
        System.out.println(" 6. Print total of net salaries. ");
        System.out.println(" 7. Retrieve total number of employees. ");
        System.out.println(" 8. Update benefit for directors. ");
        System.out.println(" 9. Promote employee. ");
        System.out.println(" 10. Sort the list of employees. ");
        System.out.println(" 11. Display all the employees. ");
        System.out.println(" 12. Quit program. ");
        System.out.println();

    }

    //requests and accepts the id of the employee from the user
    private String enterId(){
        System.out.println("Enter the ID of the Employee you wish to use: ");
        String id = input.readString();
        return id;
    }

    private int findAndcheckId(String id){

        //calls a method from ReusexCorp which returns the position in the array list where the employee with that specific id is found
        int i = company.findId(id);

        //if the method returned a value -1, this means that the id was not found and therefore no employee with the required id exists
        //the id is therefore requested from the user again until a valid id is entered
        while(i == -1){
            System.out.println("An employee of ID " + id + " is not registered in the system.");
            id = enterId();
            i = company.findId(id);
        }

        return i;
    }

    private void createEmp(){
        //split into parts

        System.out.println("Do you wish to register a: ");
        System.out.println(" 1. Regular employee. ");
        System.out.println(" 2. Manager. ");
        System.out.println(" 3. Director. ");
        System.out.println(" 4. Intern. ");
        int choice = input.readInt();

        switch(choice){
            //according to the users choice, the required method/s are called to retrieve all the necessary information from the user
            //the information is then passed to the corresponding method in the ReusexCorp class so as to create the new employee.
            case 1: { //Regular employee

                Object[] emp = regularEmp();
                company.regEmp((String)emp[0],(String)emp[1],(double)emp[2]);
                break;

            }case 2:{ //EmployeeTypes.Manager

                Object[] emp = regularEmp();
                String degree = manager();
                company.manager((String)emp[0],(String)emp[1],(double)emp[2],degree);
                break;

            }case 3:{ //EmployeeTypes.Director

                Object[] emp = regularEmp();
                String degree = manager();
                String department = director();
                company.director((String)emp[0],(String)emp[1],(double)emp[2],degree,department);
                break;

            }case 4:{ //EmployeeTypes.Intern

                Object[] emp = regularEmp();
                int gpa = intern();
                company.intern((String)emp[0],(String)emp[1],(double)emp[2],gpa);
                break;

            }default:{
                System.out.println("Invalid input.");
                break;
            }

        }

    }

    //asks for and retrieves all the information from the user to create a regular employee
    private Object[] regularEmp(){

        String empId;

        do {
            System.out.println("Enter employee's ID: ");
            empId = input.readString();

            //if any value besides -1 is returned from the method findId, this means that an employee with the entered Id already exists
            if(company.findId(empId) != -1){
                System.out.println("An employee with that ID already exists, re-enter.");
            }

        // the code is looped until the user enters a valid id
        }while (company.findId(empId) != -1);

        System.out.println("Enter employee's name: ");
        String empName = input.readString();

        System.out.println("Enter employee's gross salary: ");
        double grossSalary = input.readDouble();

        //the values are returned in an array of type object so that the variables of different data types can all be returned
        Object[] ans = {empId,empName,grossSalary};

        return ans;
    }

    private String manager(){

        String degree;

        //the degree is requested from the user until a valid input is entered
        do {

            System.out.println("Enter employee's degree('BSc.', 'MSc.', 'PhD'): ");
            degree = input.readString();

            //the degree is checked to be valid using a method in ReusexCorp
            if(!company.checkDegree(degree)){
                System.out.println("Invalid input.");
            }

        }while (!company.checkDegree(degree));

        return degree;

    }

    private String director(){

        String department;

        //the department is requested from the user until a valid input is entered
        do {

            System.out.println("Enter employee's department('Human Resources', 'Technical', 'Business'): ");
            department = input.readString();

            //the department is checked to be valid using a method in ReusexCorp
            if(!company.checkDepartment(department)){
                System.out.println("Invalid input.");
            }

        }while (!company.checkDepartment(department));

        return department;

    }

    private int intern(){

        int gpa;

        //the gpa is requested from the user until a valid input is entered
        do {

            System.out.println("Enter employee's gpa (between 0 and 10): ");
            gpa = input.readInt();

            //the gpa is checked to be valid using a method in ReusexCorp
            if(!company.checkGpa(gpa)){
                System.out.println("Invalid input.");
            }

        }while (!company.checkGpa(gpa));

        return gpa;

    }

    //the id of the desired employee is requested from the user
    //the position in the array list of that employee is found
    //the employee is removed from the array list
    private void removeEmp(){

        String empId = enterId();
        int no = findAndcheckId(empId);
        company.removeEmp(no);

    }

    //the id of the desired employee is requested from the user
    //the position in the array list of that employee is found
    //the employee displayed to the user
    private void printEmp(){

        String empId = enterId();
        int no = findAndcheckId(empId);
        System.out.println(company.printEmp(no));
    }

    private void updateEmp(){

        //the id of the desired employee is requested from the user
        //the position in the array list of that employee is found
        String empId = enterId();
        int no = findAndcheckId(empId);

        //the user is asked asked to choose an option and the corresponding methods are carried out accordingly
        System.out.println("Do you wish to change the employee's: ");
        System.out.println("1. Name. ");
        System.out.println("2. Salary. ");
        System.out.println("3. Both. ");
        int choice = input.readInt();

        switch (choice){

            case 1:
                updateName(no);
                break;

            case 2:
                updateSalary(no);
                break;

            case 3:
                updateName(no);
                updateSalary(no);
                break;

            default:
                System.out.println("Incorrect input.");
                break;
        }

    }

    //the user is asked for the new name from the user and the variable is passed into a method in ReusexCorp
    private void updateName(int no){

        System.out.println("Enter the employee's new name: ");
        String name = input.readString();
        company.updateName(no,name);

    }

    //the user is asked for the new salary from the user and the variable is passed into a method in ReusexCorp
    private void updateSalary(int no){

        System.out.println("Enter the employee's new salary: ");
        double salary = input.readDouble();
        company.updateSalary(no,salary);

    }

    //the total gross salary is calculated in a method in ReusexCorp and the value is displayed to the user
    private void grossSalaries(){

        double total = company.grossSalaries();

        System.out.println("Total expenses in by paying gross salaries is " + total);

    }

    //the total net salary is calculated in a method in ReusexCorp and the value is displayed to the user
    private void netSalaries(){

        double total = company.netSalaries();

        System.out.println("Total expenses in by paying net salaries is " + total);

    }

    //the total number of employees is calculated in a method in ReusexCorp and the value is displayed to the user
    private void totalEmp(){

        int numOfEmp = company.totalEmp();

        System.out.println("Total number of employees is " + numOfEmp);

    }

    //the user enters the desired new benefit which is then passed as a method in ReuseCorp
    private void updateBenefit(){
        System.out.println("Please type the new benefit: ");
        double benefit = input.readDouble();
        company.updateBenefit(benefit);

    }

    private void promote(){
        //the id of the desired employee is requested from the user
        //the position in the array list of that employee is found
        String empId = enterId();
        int no = findAndcheckId(empId);

        //the information needed to create a regular employee are obtained from the current employee
        // and are stored in emp using a method in ReusexCorp
        Object[] emp = company.baseEmp(no, empId);

        //the user is prompted to enter the position they would like to promote the employee to
        System.out.println("Enter the position you would you like to promote the employee to: ");
        System.out.println(" 1. Regular employee. ");
        System.out.println(" 2. Manager. ");
        System.out.println(" 3. Director. ");
        System.out.println(" 4. Intern. ");
        int choice = input.readInt();

        //according to the choice the necessary option is carried out
        switch(choice){
            case 1: { //Regular employee

                //the variables are passed to a method in ReusexCorp so as to change the employee to a regular employee
                company.promoteToRegEmp(no, emp);
                break;

            }case 2:{ //EmployeeTypes.Manager

                //checks whether the employee chosen is already a manager
                boolean same = company.checkManager(no);

                if(!same) {
                    //checks whether the employee is currently a director
                    boolean flag = company.checkDirector(no);

                    if (!flag) {
                        //if they are not then the user is requested for the extra information for manager
                        String degree = manager();
                        //the variables are passed to a method in ReusexCorp so as to change the employee to a manager (passing also the degree)
                        company.promoteToManager(no, emp, degree);
                    } else {
                        //the variables are passed to a method in ReusexCorp so as to change the employee to a manager
                        company.promoteToManager(no, emp);
                    }
                }else{
                    //if they are then nothing is done
                    System.out.println("That employee is already a manager.");
                }
                break;

            }case 3:{ //EmployeeTypes.Director

                //checks whether the employee chosen is already a director
                boolean same = company.checkDirector(no);

                if(!same) {
                    //the user is requested for the extra information for director
                    String department = director();
                    //checks whether the employee is currently a manager
                    boolean flag = company.checkManager(no);

                    if (!flag) {
                        //if they are not then the user is requested for the extra information for manager
                        String degree = manager();
                        //the variables are passed to a method in ReusexCorp so as to change the employee to a director (passing also the degree)
                        company.promoteToDirector(no, emp, degree, department);
                    } else {
                        //the variables are passed to a method in ReusexCorp so as to change the employee to a director
                        company.promoteToDirector(no, emp, department);
                    }
                }else{
                    //if they are then nothing is done
                    System.out.println("That employee is already a director.");
                }
                break;

            }case 4:{ //EmployeeTypes.Intern

                //checks whether the employee chosen is already an intern
                boolean same = company.checkIntern(no);

                if(!same) {
                    //the user is requested for the extra information for intern
                    int gpa = intern();
                    //the variables are passed to a method in ReusexCorp so as to change the employee to an intern
                    company.promoteToIntern(no, emp, gpa);
                }else{
                    //if they are then nothing is done
                    System.out.println("That employee is already an intern.");
                }
                break;

            }default:{
                System.out.println("Invalid input.");
                break;
            }

        }


    }

    public void sort(){

        //the user chooses how they wish to sort the employees
        System.out.println("Enter the type you wish to sort by: ");
        System.out.println(" Name ");
        System.out.println(" Net Salary ");
        System.out.print("Input: ");
        String type = input.readString();

        System.out.println("Enter the order you wish to sort by: ");
        System.out.println(" Ascending ");
        System.out.println(" Descending ");
        System.out.print("Input: ");
        String order = input.readString();

        //the information is passed as the parameters of a method in ReusexCorp so as to sort the list
        boolean result = company.sortBy(type,order);

        if(!result){
            //the method returns false if the user inputs incorrect information and so the list is not sorted
            System.out.println("Invalid input.");
        }

    }

    public void display(){

        //a method in ReusexCorp is called which returns a String containing all the employees information which is then displayed to the user
        System.out.println(company.display());

    }

    public static void main(String [] args) {

        Menu program = new Menu();

        program.run();


    }
}

