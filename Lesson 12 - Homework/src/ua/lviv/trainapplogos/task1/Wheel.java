package ua.lviv.trainapplogos.task1;

public class Wheel extends Car{
	private int wheelDiameter;
	private WheelMaterial wheelMaterial;
	
	public Wheel(int wheelDiameter, WheelMaterial wheelMaterial) {
		super();
		this.wheelDiameter = wheelDiameter;
		this.wheelMaterial = wheelMaterial;
	}

	public int getWheelDiameter() {
		return wheelDiameter;
	}

	public void setWheelDiameter(int wheelDiameter) {
		this.wheelDiameter = wheelDiameter;
	}

	public WheelMaterial getWheelMaterial() {
		return wheelMaterial;
	}

	public void setWheelMaterial(WheelMaterial wheelMaterial) {
		this.wheelMaterial = wheelMaterial;
	}

	/*
	@Override
	public String toString() {
		return "Wheel [wheelDiameter=" + wheelDiameter + ", wheelMaterial=" + wheelMaterial + "]";
	}
	*/
	
	
}
