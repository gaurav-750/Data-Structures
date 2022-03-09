package FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDemo {

    public static String appendExistingContent(String str) throws FileNotFoundException {
        File obj = new File("Employee.txt");
        Scanner myReader = new Scanner(obj);

        while (myReader.hasNextLine()){
            str = str + myReader.nextLine() + "\n";
        }
        myReader.close();

        return str;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        System.out.println("1. INSERT");
        System.out.println("2. DISPLAY");
        System.out.println("3. EXIT");

        ArrayList<Employee> list = new ArrayList<>();

        //Creating an obj that will point towards my File:
        File myObj = new File("Employee.txt");
        if (myObj.createNewFile()) {
            // .createnewfile() creates new empty file.
            // The function returns true if the abstract file path does not exist and a "New file is CREATED".

            System.out.println("File Created: " + myObj.getName());
            System.out.println(myObj.getAbsolutePath());
        }


        do {
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice){
                //Inserting the Data:
                case 1:
                    //asking User how many employees he want:
                    System.out.print("Enter how many employees you want: ");
                    int n = sc.nextInt();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter employee id: ");
                        int empId = sc.nextInt();
                        System.out.print("Enter employee name: ");
                        String empName = sc.next();
                        System.out.print("Enter employee salary: ");
                        int empSalary = sc.nextInt();

                        Employee e = new Employee(empId, empName, empSalary);
                        //adding the employee into list:
                        list.add(e);
                    }

                    //appending the existing content into String str:
                    String str = "";
                    str = appendExistingContent(str);

                    //append the new Employees into str:
                    for (Employee emp: list){
                        str = str + (emp.emp_id + " " + emp.name + " " + emp.salary + "\n");
                    }

                    //writing into File:
                    try {
                        FileWriter writer = new FileWriter("Employee.txt");
                        writer.write(str);
                        writer.close();
                    }catch (IOException e){
                        System.out.println("Error occurred!!");
                        e.printStackTrace();
                    }

                    break;
                 //Display:
                case 2:
                    //Reading from File:
                    try {
                        File obj2 = new File("Employee.txt");
                        Scanner myReader2 = new Scanner(obj2);

                        while (myReader2.hasNextLine()){
                            System.out.println(myReader2.nextLine());
                        }
                        myReader2.close();
                    }catch (IOException e){
                        System.out.println("Error " + e.getMessage());
                    }

                    break;
            }
        }while (choice != 3);

    }
}
