import javax.swing.*;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("The selected file: " + selectedFile.getAbsolutePath());

            try {
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                String line = "";
                int lineCount = 0;
                int wordCount = 0;
                int charCount = 0;

                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    String[] words = line.split("\\s+");
                    wordCount += words.length;
                    charCount += line.length();
                }
                reader.close();

                System.out.println("Summary of the Report");
                System.out.println("The name of the file: " + selectedFile.getName());
                System.out.println("The number of lines: " + lineCount);
                System.out.println("The number of words: " + wordCount);
                System.out.println("The number of characters: " + charCount);
            } catch (FileNotFoundException e)
            {
                System.out.println("The file was not found: " + e.getMessage());
            } catch (IOException e)
            {
                System.out.println("There was an error reading the file" + e.getMessage());
            }

        }

    }
}