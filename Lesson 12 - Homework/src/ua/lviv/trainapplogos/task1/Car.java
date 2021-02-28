package ua.lviv.trainapplogos.task1;

public class Car {
	private int hoursePower;
	private int yearOfManufacture;
	
	public Car() {
		this.hoursePower = 100;
		this.yearOfManufacture = 2020;
	}

	public Car(int hoursePower, int yearOfManufacture) {
		this.hoursePower = hoursePower;
		this.yearOfManufacture = yearOfManufacture;
	}

	public int getHoursePower() {
		return hoursePower;
	}

	public void setHoursePower(int hoursePower) {
		this.hoursePower = hoursePower;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	
	@Override
	public String toString() {
		return "\nCar [hoursePower=" + hoursePower + ", yearOfManufacture=" + yearOfManufacture + "]";
	}

	
	
}
