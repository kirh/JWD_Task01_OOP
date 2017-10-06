package by.tc.task01.entity;

public class Refrigerator extends Appliance{
	private int powerConsumption;
	private double weight;
	private double freezerCapacity;
	private double overalCapacity;
	private double height;
	private double width;

	public int getPowerConsumption() {
		return powerConsumption;
	}

	public void setPowerConsumption(int powerConsumption) {
		this.powerConsumption = powerConsumption;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getFreezerCapacity() {
		return freezerCapacity;
	}

	public void setFreezerCapacity(double freezerCapacity) {
		this.freezerCapacity = freezerCapacity;
	}

	public double getOveralCapacity() {
		return overalCapacity;
	}

	public void setOveralCapacity(double overalCapacity) {
		this.overalCapacity = overalCapacity;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Refrigerator that = (Refrigerator) o;

		if (powerConsumption != that.powerConsumption) return false;
		if (Double.compare(that.weight, weight) != 0) return false;
		if (Double.compare(that.freezerCapacity, freezerCapacity) != 0) return false;
		if (Double.compare(that.overalCapacity, overalCapacity) != 0) return false;
		if (Double.compare(that.height, height) != 0) return false;
		return Double.compare(that.width, width) == 0;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = powerConsumption;
		temp = Double.doubleToLongBits(weight);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(freezerCapacity);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(overalCapacity);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(height);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
