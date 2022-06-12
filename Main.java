import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static List<Turtle> turtleList = new ArrayList<>();


    public static void main(String[] args) throws ParseException {
//        Connect.connect();
        Scanner in = new Scanner(System.in);
        int choice;


        do {
            System.out.println("0.Exit");
            System.out.println("1.Insert");
            System.out.println("2.View");
            System.out.println("3.Search ");
            System.out.println("4.Delete");
            System.out.println("5.Update");
            System.out.println("6.Generate Report");

            System.out.print("Please Enter your choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:

                    System.out.println("Please Enter Turtle Species Option Number From the List Below: ");
                    System.out.println("1.Leatherback");
                    System.out.println("2.Loggerhead");
                    System.out.println("3.Green");
                    System.out.println("4.Flatback");
                    System.out.println("5.Hawksbill");
                    System.out.println("6.KempsRidley");
                    System.out.println("7.OliveRidley");

                    int speciesOption = in.nextInt();

                    System.out.print("Please Enter Turtle Weight: ");
                    float weight = in.nextFloat();

                    System.out.print("Please Enter Turtle Length: ");
                    float length = in.nextFloat();

                    System.out.print("Please Enter Turtle number Of Working Flippers: ");
                    int numberOfWorkingFlippers = in.nextInt();

                    System.out.print("Please Enter Turtle Sample Location: ");
                    String sampleLocation = in.next();

                    System.out.print("Please Enter Turtle Sample Date (dd/MM/yy): ");
                    Date sampleDate = null;
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String cinput = in.next();
                    if (null != cinput && cinput.trim().length() > 0) {
                        sampleDate = format.parse(cinput);
                    }
                    String species = "Flatback";

                    Turtle childObj = Factory.createObject(speciesOption, weight, length, numberOfWorkingFlippers, sampleDate, sampleLocation);
                    Connect.insert(childObj);
//                    Turtle.insertTurtle(childObj);
                    break;

                case 2:
                    System.out.println("-----------------");
                    Turtle.viewTurtle();
                    System.out.println("-----------------");
                    break;
                case 3:
                    System.out.println("Enter Turtle Species you want to search: ");
                    int searchId = in.nextInt();
                    break;
                case 4:
                    System.out.println("Enter Turtle Id you want to remove: ");
                    int turtleId = in.nextInt();
                    Connect.remove(turtleId);
                    break;
                case 5:
                    System.out.println("Enter Turtle Id you want to update: ");
                    turtleId = in.nextInt();

                    System.out.print("Please Enter Turtle Species Option Number From the List Below: ");
                    System.out.println("1.Leatherback");
                    System.out.println("2.Loggerhead");
                    System.out.println("3.Green");
                    System.out.println("4.Flatback");
                    System.out.println("5.Hawksbill");
                    System.out.println("6.KempsRidley");
                    System.out.println("7.OliveRidley");

                    speciesOption = in.nextInt();

                    System.out.print("Please Enter new Turtle Weight: ");
                    weight = in.nextFloat();

                    System.out.print("Please Enter new Turtle Length: ");
                    length = in.nextFloat();

                    System.out.print("Please Enter new Turtle number Of Working Flippers: ");
                    numberOfWorkingFlippers = in.nextInt();

                    System.out.print("Please Enter new Turtle Sample Location: ");
                    sampleLocation = in.next();

                    System.out.print("Please Enter new Turtle Sample Date (dd/MM/yy): ");
                    sampleDate = null;
                    format = new SimpleDateFormat("dd/MM/yyyy");
                    cinput = in.next();
                    if (null != cinput && cinput.trim().length() > 0) {
                        sampleDate = format.parse(cinput);
                    }

                    Turtle updatedChildObj = Factory.createObject(speciesOption, weight, length, numberOfWorkingFlippers, sampleDate, sampleLocation);
                    Connect.update(updatedChildObj);
//                    Turtle.updateTurtle(turtleId,updatedChildObj);
                    break;
                case 6:
                    System.out.print("Enter Location: ");
                    String location = in.next();

                    Date fromDate = null;
                    Date endDate = null;
                    format = new SimpleDateFormat("dd/MM/yy");
                    System.out.print("Enter From Date (dd/MM/yy): ");
                    String fromDateinput = in.next();
                    System.out.print("Enter End Date (dd/mm/yy): ");
                    String endDateinput = in.next();
                    if (null != fromDateinput && fromDateinput.trim().length() > 0) {
                        fromDate = format.parse(fromDateinput);
                    }
                    if (null != endDateinput && endDateinput.trim().length() > 0) {
                        endDate = format.parse(endDateinput);
                    }
                    List<Turtle> result = Turtle.generateReport(location, fromDate, endDate);
                    System.out.println("Summary Report");
                    System.out.println("**************");

                    System.out.println("Total Turtles: " + result.size());
                    System.out.println(result);
                    break;
            }
        } while (choice != 0);

    }
}