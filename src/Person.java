import java.time.Year;

/**
 * @author shachin shachin777@gmail.com
 *
 *
 */


public class Person
{

    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;
    static private int IDSeed = 1;

    public static void setIDSeed(int IDSeed) {Person.IDSeed = IDSeed;}
    public  static int getIDSeed(){return IDSeed;}

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }
    /**
     * Method to get the full name from the person object
     *
     * @return the first and last name as a full name string
     */
    public String getFullName()
    {
        return firstName + " " + lastName;

    }
    /**
     * method to get the formal name
     * @return get the title, first and last name, arranged as a fromal naems string
     */
    public String getFormalName()
    {
        return title + "." + firstName + " " + lastName;

    }

    /**
     * Get the age as an int assuming it is for the current year
     *
     *
     * @return the current age
     */
    public int getAge()
    {
       return Integer.parseInt(Year.now().toString()) - YOB;

    }

    /**
     *
     * @param year the year that you want to use at that time
     * @return
     */
    public int getAge(int year)
    {
        return year - YOB;
    }

    /**
     *
     * @return object data in csv format
     */

    public String toCSVDataRecord()
    {
        return ID +", " + firstName +", " + lastName+", " + title +", " + YOB;

    }



}
