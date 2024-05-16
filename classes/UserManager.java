package classes;
import java.io.*;

public class UserManager {

    public void changePassword(String username, String newPassword) {
        // Path to the user file
        String filePath = "data/user.txt";

        // Temp file path for storing modified data
        String tempFilePath = "data/temp_user.txt";

        File file = new File(filePath);
        File tempFile = new File(tempFilePath);

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length >= 3 && parts[0].equals(username)) {
                    // Change the password
                    parts[1] = newPassword;
                    line = String.join("\t", parts);
                }
                writer.write(line + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (writer != null)
                    writer.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        // Delete the original file
        if (!file.delete()) {
            System.out.println("Failed to delete the original file.");
            return;
        }

        // Rename the temp file to original file name
        if (!tempFile.renameTo(file)) {
            System.out.println("Failed to rename the temp file.");
        }
    }

}
