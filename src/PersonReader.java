import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

import static java.lang.System.out;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import static java.nio.file.StandardOpenOption.*;
import javax.swing.JFileChooser;



public class PersonReader {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Person> person0data = new ArrayList<>();


        final int FIELDS_LENGTH = 5;

        String id, firstName, lastName, title;
        int yob;

        try
        {

            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));


                int line = 0;

                while(reader.ready())
                {
                    rec = reader.readLine();
                    lines.add(rec);
                    line++;
                }
                reader.close();

                String[] fields;
                for(String l:lines)
                {
                    fields = l.split(",");

                    if(fields.length == FIELDS_LENGTH)
                    {
                        id        = fields[0].trim();
                        firstName = fields[1].trim();
                        lastName  = fields[2].trim();
                        title     = fields[3].trim();
                        yob       = Integer.parseInt(fields[4].trim());

                        person0data.add(new Person(id, firstName, lastName,title, yob));

                    }
                    else
                    {
                        System.out.println("Found a record that may be corrupt: ");
                        System.out.println(l);
                    }
                }

            }
            else
            {
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again!");
                System.exit(0);
            }
        }


        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println();

        for (Person p:person0data)
        {
            System.out.println(p.toCSVDataRecord());
        }
        out.println();

        for(Person p:person0data)
        {
           System.out.println(p.toXMLRecord());
        }
        out.println( );

        for(Person p: person0data)
        {
            out.println(p.toJSONRecord());
        }

    }


}




