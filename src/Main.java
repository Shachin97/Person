public class Main {
    public static void main(String[] args)

    {
        Person Shachin = new Person("Shachin" , "Dhungel", "000001",
                "Mr", 2002  );

        System.out.println(Shachin);

        System.out.println(Shachin.getFullName());

        System.out.println(Shachin.getFormalName());

        System.out.println("You are " + Shachin.getAge() + " years old");
        System.out.println( "Age at 2010 I was " + Shachin.getAge(2010));
    }
}