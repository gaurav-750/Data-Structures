package FileHandling;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFromFile {
    public static void main(String[] args) throws FileNotFoundException {

        try {
            File myObj = new File("Gaurav'sFile.txt"); // making myObj point towards the desired file
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                System.out.println(myReader.nextLine());
            }
            myReader.close();
        }catch (IOException e){
            System.out.println("Error!! \n IOException: " + e.getMessage());
//            e.printStackTrace();
        }

    }
}
