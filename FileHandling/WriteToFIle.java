package FileHandling;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFIle {
    public static void main(String[] args) throws IOException {

        try {
            FileWriter myWriter = new FileWriter("Gaurav'sFile.txt");
            myWriter.write("Hi! Gaurav Here! \n Java is a very prominent Language!");
            myWriter.close();

            System.out.println("Successfully wrote to the file!");
        }catch (IOException e){
            System.out.println("An error Occurred!");
            e.printStackTrace();
        }


    }
}
