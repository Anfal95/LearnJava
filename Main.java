import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static List<Turtle> turtleList = new ArrayList<>();

    public static void main(String[] args) throws ParseException {

        Scanner in = new Scanner(System.in);
        int choice;

        do {
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

                    System.out.print("Please Enter Turtle Type: ");
                    String type = in.next();

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

                    turtleList.add(new Turtle(type, weight, length, numberOfWorkingFlippers, sampleDate, sampleLocation));
                    break;

                case 2:
                    System.out.println("-----------------");
                    Iterator<Turtle> i = turtleList.iterator();
                    while (i.hasNext()) {
                        Turtle e = i.next();
                        System.out.println(e);
                    }
                    System.out.println("-----------------");
                    break;
                case 3:
                    boolean found = false;
                    System.out.println("Enter Turtle Type you want to search: ");
                    String turtleType = in.next();
                    i = turtleList.iterator();
                    while (i.hasNext()) {
                        Turtle e = i.next();
                        if (e.getType().equals(turtleType)) {
                            System.out.println(e);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    }
                    System.out.println("-----------------");
                    break;
                case 4:
                    found = false;
                    System.out.println("Enter Turtle Id you want to remove: ");
                    int turtleId = in.nextInt();
                    i = turtleList.iterator();
                    while (i.hasNext()) {
                        Turtle e = i.next();
                        if (e.getTurtleId() == turtleId) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    } else {
                        System.out.println("Record is deleted successfully");
                    }
                    System.out.println("-----------------");
                    break;
                case 5:
                    found = false;
                    System.out.println("Enter Turtle Id you want to remove: ");
                    turtleId = in.nextInt();
                    ListIterator<Turtle> li = turtleList.listIterator();
                    while (li.hasNext()) {
                        Turtle e = li.next();
                        if (e.getTurtleId() == turtleId) {
                            System.out.print("Please Enter new Turtle Type: ");
                            type = in.next();

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
                            li.set(new Turtle(type, weight, length, numberOfWorkingFlippers, sampleDate, sampleLocation));
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    } else {
                        System.out.println("Record is Updated successfully");
                    }
                    System.out.println("-----------------");
                    break;
                case 6:
                    List<Turtle> filteredTurtleList = new ArrayList<>();
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
                    System.out.println("Summary Report");
                    System.out.println("**************");


                    i = turtleList.iterator();
                    while (i.hasNext()) {
                        Turtle e = i.next();
                        if ((e.getSampleDate().compareTo(fromDate) > 0 && e.getSampleDate().compareTo(endDate) < 0) || e.getSampleLocation().equals(location)) {
                            filteredTurtleList.add(e);
                        }
                    }

                    System.out.println("Total Turtles: " + filteredTurtleList.size());
                    System.out.println(filteredTurtleList);
                    System.out.println("-----------------");
                    break;
            }
        } while (choice != 0);

    }
}