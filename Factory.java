import java.util.Date;

public class Factory {

    public static Turtle createObject(int speciesOption, float weight, float length, int numberOfWorkingFlippers, Date sampleDate, String sampleLocation){

        switch (speciesOption){
            case 1:
                Leatherback leatherbackObj = new Leatherback("Leatherback",weight, length, numberOfWorkingFlippers, sampleDate, sampleLocation);
                return leatherbackObj;

            case 2:
                Loggerhead loggerheadObj = new Loggerhead("Loggerhead",weight, length, numberOfWorkingFlippers, sampleDate, sampleLocation);
                return loggerheadObj;

            case 3:
                Green greenObj = new Green("Green",weight, length, numberOfWorkingFlippers, sampleDate, sampleLocation);
                return greenObj;

            case 4:
                Flatback flatbackObj = new Flatback("Flatback",weight, length, numberOfWorkingFlippers, sampleDate, sampleLocation);
                return flatbackObj;

            case 5:
                Hawksbill hawksbillObj = new Hawksbill("Hawksbill",weight, length, numberOfWorkingFlippers, sampleDate, sampleLocation);
                return hawksbillObj;

            case 6:
                KempsRidley kempsRidleyObj = new KempsRidley("KempsRidley",weight, length, numberOfWorkingFlippers, sampleDate, sampleLocation);
                return kempsRidleyObj;

            case 7:
                OliveRidley oliveRidleyObj = new OliveRidley("OliveRidley",weight, length, numberOfWorkingFlippers, sampleDate, sampleLocation);
                return oliveRidleyObj;

            default:
                return null;
        }
    }
}
