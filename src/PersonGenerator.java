import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;


public class PersonGenerator {
    public static void main(String[] args)
    {
        ArrayList<Person> person0data = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title= "";
        int dateOfBirth = 0;
        String CSV = "";

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");
        boolean done = false;
        do
        {
           ID = SafeInput.getNonZeroLenString(in, "Enter the ID Number");
           firstName = SafeInput.getNonZeroLenString(in, "Enter the first Name");
           lastName = SafeInput.getNonZeroLenString(in, "Enter the last name");
           title = SafeInput.getNonZeroLenString(in, "Enter the title ");
           dateOfBirth = SafeInput.getRangedInt(in, "Enter the Date of Birth", 1000, 9999);



           person0data.add(new Person(ID, firstName, lastName, title, dateOfBirth));


           done = SafeInput.getYNConfirm(in, "Are you done entering");


        }
        while(!done);
        for(Person p:person0data)
            System.out.println(p.toCSVDataRecord());

        try
        {

            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));



            for(Person rec : person0data)
            {
                writer.write(rec.toCSVDataRecord());

                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}
