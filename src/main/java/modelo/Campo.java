package modelo;


public class Campo {
	
	private String name;
	private String unit;
	private float decPrecision;
	
	public Campo(String name, String unit, float decPrecision) {
		super();
		this.name = name;
		this.unit = unit;
		this.decPrecision = decPrecision;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getDecPrecision() {
		return decPrecision;
	}

	public void setDecPrecision(float decPrecision) {
		this.decPrecision = decPrecision;
	}
	

}
