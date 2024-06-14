package modelo;

import java.util.List;


public class Artefacto {
	private int productID;
	private String architecture;
	private String artifact;
	private List<Sensor> sensors;
	
	public Artefacto(int productID, String architecture, String artifacto) {
		super();
		productID = productID;
		this.architecture = architecture;
		this.artifact = artifact;
		this.sensors = sensors;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		productID = productID;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public String getArtifact() {
		return artifact;
	}

	public void setArtifact(String artifact) {
		this.artifact = artifact;
	}

	public List<Sensor> getMisS() {
		return sensors;
	}

	public void setMisS(List<Sensor> misS) {
		this.sensors = misS;
	}

	public void setSensor(Sensor sensor) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public boolean eliminarSensor(String num) {
        Sensor miSensor = buscarSensor(num);
        if (miSensor != null) {
            sensors.remove(miSensor);
            return true;
        }
        return false;
    }
	
	public Sensor buscarSensor(String num) {
		for (Sensor s:sensors) {
			if(num.compareTo(s.getNum())==0) {
				return s;
			}
		}
		return null;
	}

	public boolean añadirSensores(Sensor s) {
        if (!sensoresta(s)) {
            sensors.add(s);
            return true;
        }
        return false;
    }

    private boolean sensoresta(Sensor s) {
        for (Sensor sensor : sensors) {
            if (sensor.getNum().equals(s.getNum())) {
                return true;
            }
        }
        return false;
    }

	public Sensor getSensor(int numSens) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
