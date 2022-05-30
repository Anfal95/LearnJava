import java.util.Date;

public class KempsRidley extends Turtle{
    public KempsRidley(String species, float weight, float length, int numberOfWorkingFlippers, Date sampleDate, String sampleLocation) {
        this.species = species;
        this.weight = weight;
        this.length = length;
        this.numberOfWorkingFlippers = numberOfWorkingFlippers;
        this.sampleDate = sampleDate;
        this.sampleLocation = sampleLocation;
        this.turtleId = count.incrementAndGet();
    }

}
