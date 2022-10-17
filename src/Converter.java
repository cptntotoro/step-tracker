public class Converter {

    int cmPerStep = 75;
    int calsPerStep = 50;

    public double convertCmToKm(int stepsTotal) {
        int cmTravelled = stepsTotal * cmPerStep;
        return ((double) cmTravelled / 100000);
    }

    public double convertCCalToCal(int stepsTotal) {
        int ccalBurned = stepsTotal * calsPerStep;
        return ((double) ccalBurned / 1000);
    }


}
