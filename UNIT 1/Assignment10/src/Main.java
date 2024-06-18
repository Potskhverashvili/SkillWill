import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // File path and content to be written
        String fileLocation = "C:\\Users\\Public\\MyFile2.txt";
        String fileContent1 = "Soft skills are personal attributes that enable someone to interact effectively.";
        String fileContent2 = "Hard skills are specific abilities, capabilities and skill sets that an individual can possess and demonstrate in a measured way.";


        // Manage the file (create, write, read) with the initial content
        fileManager(fileLocation, fileContent1);

        // Update the file with new content and read it again
        updateFileContent(fileLocation, fileContent2);

        // Uncomment the line below if you want to delete the file after reading
        //deleteFile(fileLocation);
    }

    // --------------------------------------------------- FUNCTIONS ---------------------------------------------------

    // Manages the file operations (create, write, read)
    static void fileManager(String fileLocation, String fileContent) {
        System.out.println("------------- File Manager ------------");
        createNewFile(fileLocation);
        writeToFile(fileLocation, fileContent);
        readFromFile(fileLocation);
    }

    // Updates the content of the file and reads it again
    static void updateFileContent(String fileLocation, String fileContent) {
        System.out.println("\n--------- Update File Content ---------");
        writeToFile(fileLocation, fileContent);
        readFromFile(fileLocation);
    }

    // Creates a new file if it doesn't exist
    static void createNewFile(String fileLocation) {
        File myFile = new File(fileLocation);
        try {
            if (myFile.createNewFile()) {
                System.out.println("-- Create File -- > File Successfully Created");
            } else {
                System.out.println("-- Create File -- > File already exist");
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }

    // Writes text to the file (overwrites existing content)
    static void writeToFile(String fileLocation, String txt) {
        try {
            FileWriter writer = new FileWriter(fileLocation);
            writer.write(txt);
            writer.close();
            System.out.println("-- Write Text -- > Text written successfully");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    /// Reads content from the file
    static void readFromFile(String fileLocation) {
        File file = new File(fileLocation);
        try {
            Scanner scanner = new Scanner(file);
            System.out.print("-- File Contents -- > ");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
    }

    // Delete Function
    static void deleteFile(String fileLocation) {
        File file = new File(fileLocation);
        if (file.delete()) {
            System.out.println("File Deleted!");
        } else {
            System.out.println("Failed to delete this file");
        }
    }
}