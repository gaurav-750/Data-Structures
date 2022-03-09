package FileHandling;

public class Employee {
    //data members:
    int emp_id;
    String name;
    int salary;

    public Employee(int emp_id, String name, int salary){
        this.emp_id = emp_id;
        this.name = name;
        this.salary = salary;
    }

    public String getInfo(){
        return emp_id + " " + name + " " + salary;
    }

}
