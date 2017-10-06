package by.tc.task01.entity;

public class Speakers extends Appliance{
    private int powerConsumption;
    private int numberOfSpekears;
    private String frequencyRange;
    private double cordLength;

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpekears() {
        return numberOfSpekears;
    }

    public void setNumberOfSpekears(int numberOfSpekears) {
        this.numberOfSpekears = numberOfSpekears;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public double getCordLength() {
        return cordLength;
    }

    public void setCordLength(double cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speakers speakers = (Speakers) o;

        if (powerConsumption != speakers.powerConsumption) return false;
        if (numberOfSpekears != speakers.numberOfSpekears) return false;
        if (Double.compare(speakers.cordLength, cordLength) != 0) return false;
        return frequencyRange != null ? frequencyRange.equals(speakers.frequencyRange) : speakers.frequencyRange == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = powerConsumption;
        result = 31 * result + numberOfSpekears;
        result = 31 * result + (frequencyRange != null ? frequencyRange.hashCode() : 0);
        temp = Double.doubleToLongBits(cordLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
