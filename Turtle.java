import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Turtle {
    protected static final AtomicInteger count = new AtomicInteger(0);
    protected String species;
    protected float weight, length;
    protected int numberOfWorkingFlippers;
    protected Date sampleDate;
    protected String sampleLocation;

    protected int turtleId;

    public Turtle() {

    }

    public Turtle(String species, float weight, float length, int numberOfWorkingFlippers, Date sampleDate, String sampleLocation) {
        this.species = species;
        this.weight = weight;
        this.length = length;
        this.numberOfWorkingFlippers = numberOfWorkingFlippers;
        this.sampleDate = sampleDate;
        this.sampleLocation = sampleLocation;
        this.turtleId = count.incrementAndGet();
    }

    public String getSpecies(){
        return this.species;
    }

    public float getWeight(){
        return this.weight;
    }

    public float getLength(){
        return this.length;
    }

    public int getNumberOfWorkingFlippers(){
        return this.numberOfWorkingFlippers;
    }

    public Date getSampleDate(){
        return this.sampleDate;
    }

    public String getSampleLocation(){
        return this.sampleLocation;
    }

    public int getTurtleId(){
        return this.turtleId;
    }

    public String toString()
    {
        return this.turtleId + " " + this.species + " " + this.weight + " " + this.length + " " + this.numberOfWorkingFlippers + " " + this.sampleDate + " " + this.sampleLocation;
    }

    public static void insertTurtle(Turtle turtleObj){
        Main.turtleList.add(turtleObj);
    }

    public static void viewTurtle(){
        Iterator<Turtle> i = Main.turtleList.iterator();
        while (i.hasNext()) {
            Turtle e = i.next();
            System.out.println(e);
        }
    }

    public static void updateTurtle(int turtleId, Turtle updatedObject){
        int index = searchTurtle(turtleId);
        if(index != -1)
        {
            Main.turtleList.set(index,updatedObject);
            System.out.println("Record is updated successfully");
        }
        else{
            System.out.println("Record Not Found");
        }
    }

    public static void removeTurtle(int turtleId){
        int index = searchTurtle(turtleId);

        if(index != -1)
        {
            Main.turtleList.remove(index);
            System.out.println("Record is removed successfully");
        }
        else{
            System.out.println("Record Not Found");
        }
    }

    public static int searchTurtle(int turtleId){
        int index = -1;
        boolean found = false;

        Iterator<Turtle> i = Main.turtleList.iterator();
        while (i.hasNext()) {
            Turtle e = i.next();
            if (e.getTurtleId() == turtleId) {
                System.out.println(e);
                found = true;
                index = Main.turtleList.indexOf(e);
            }
        }
        if (!found) {
            System.out.println("Record Not Found");
        }
        return index;
    }

    public static List<Turtle> generateReport(String location, Date fromDate, Date endDate){

        List<Turtle> filteredTurtleList = new ArrayList<>();
        Iterator <Turtle> i = Main.turtleList.iterator();
        while (i.hasNext()) {
            Turtle e = i.next();
            if ((e.getSampleDate().compareTo(fromDate) > 0 && e.getSampleDate().compareTo(endDate) < 0) || e.getSampleLocation().equals(location)) {
                filteredTurtleList.add(e);
            }
        }

        return filteredTurtleList;
    }

}
