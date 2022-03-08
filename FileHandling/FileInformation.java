package FileHandling;
import java.io.File;
import java.io.IOException;

public class FileInformation {
    public static void main(String[] args) throws IOException {

        File g = new File("Gaurav'sFile.txt");
        System.out.println(g.createNewFile()); // creating the file

        if (g.exists()){
            System.out.println("File Name: " + g.getName());
            System.out.println("File Path: " + g.getAbsolutePath());
            System.out.println("Writeable: " + g.canWrite());
            System.out.println("Readable: " + g.canRead());
            System.out.println("File size in bytes: " + g.length());
        }else {
            System.out.println("File does not exists!");
        }

    }
}
