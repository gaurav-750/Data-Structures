package FileHandling;
import java.io.File; // import the File Class.
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) throws IOException {

        try {
            File myObj = new File("FirstFile.txt");// creating an object which will refer to our file
            if (myObj.createNewFile()) {
                // .createnewfile() creates new empty file.
                // The function returns true if the abstract file path does not exist and a "New file is CREATED".

                System.out.println("File Created: " + myObj.getName());
                System.out.println(myObj.getAbsolutePath());
            }else {
                System.out.println("File already exists!");
            }
//            System.out.println(myObj.delete());
        }catch (IOException e){
            System.out.println("Error!!");
            throw e;
        }


    }
}
