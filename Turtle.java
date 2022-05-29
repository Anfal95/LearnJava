import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Turtle {
    private static final AtomicInteger count = new AtomicInteger(0);
    private String type;
    private float weight, length;
    private int numberOfWorkingFlippers;
    private Date sampleDate;
    private String sampleLocation;

    private int turtleId;

    public Turtle() {

    }

    public Turtle(String type, float weight, float length, int numberOfWorkingFlippers, Date sampleDate, String sampleLocation) {
        this.type = type;
        this.weight = weight;
        this.length = length;
        this.numberOfWorkingFlippers = numberOfWorkingFlippers;
        this.sampleDate = sampleDate;
        this.sampleLocation = sampleLocation;
        this.turtleId = count.incrementAndGet();
    }

    public String getType(){
        return this.type;
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
        return this.turtleId + " " + this.type + " " + this.weight + " " + this.length + " " + this.numberOfWorkingFlippers + " " + this.sampleDate + " " + this.sampleLocation;
    }

}
