import java.time.Year;
import java.util.Objects;

/**
 * @author shachin shachin777@gmail.com
 *
 *
 */


public class Person
{

    private String firstName;
    private String lastName;
    private String IDNum;
    private String title;
    private int YOB;
    static private int IDSeed = 1;

    public static void setIDSeed(int IDSeed) {Person.IDSeed = IDSeed;}
    public  static int getIDSeed(){return IDSeed;}

    public Person(String IDNum,String firstName, String lastName, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.IDNum = IDNum;
        this.title = title;
        this.YOB = YOB;
    }

    public Person(String firstName, String lastName, int YOB) {
        this.IDNum = this.getIDNum();
        this.firstName = firstName;
        this.lastName = lastName;
        this.YOB = YOB;
    }

    public String getIDNum(){return IDNum;}
    private  String genIDNum()
    {
        String newID = " " + IDSeed;
        while(newID.length() < 8)
        {
            newID = "0" + newID;
        }
        IDSeed ++;
        return newID;
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

    public void setIDNum(String IDNum)
    {
        this.IDNum = IDNum;
    }

    public String getID() {
        return IDNum;
    }

    public void setID(String ID) {
        this.IDNum = ID;
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
                ", ID='" + IDNum + '\'' +
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
        return IDNum +", " + firstName +", " + lastName+", " + title +", " + YOB;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(IDNum, person.IDNum) && Objects.equals(title, person.title);
    }
    public String toJSONRecord()
    {
        String retString = "";
        char DQ = '\u0022';  // Assign the double quote char to a variable
        retString =  "{" + DQ + "IDNum" + DQ + ":" + DQ + this.IDNum + DQ + ",";
        retString += DQ + "firstName" + DQ + ":" + DQ + this.firstName + DQ + ",";
        retString += " " + DQ + "lastName"  + DQ + ":" + DQ + this.lastName + DQ + ",";
        retString += " " + DQ + "title"  + DQ + ":" + DQ + this.title + DQ + ",";
        retString += " " + DQ + "YOB"  + DQ + ":" + this.YOB + "}";

        return retString;
    }
    public String toXMLRecord()
    {
        String retString = "";

        retString = "<Person>" + "<IDNum>" + this.IDNum + "</IDNum>";
        retString += "<firstName>" + this.firstName + "</firstName>";
        retString += "<lastName>" + this.lastName + "</lastName>";
        retString += "<title>" + this.title + "</title>";
        retString += "<YOB>" + this.YOB + "</YOB></Person>";

        return retString;
    }

    /**
     * XML DATA FOR PERSON
     *<Person>
     *     <IDNum>IDNum</IDNum>
     *     <firstName>firstName</firstName>
     *     <lastName>lastName</lastName>
     *     <yob>yob</yob>
     *     <title>title</title>
     *</Person>
     */





}




