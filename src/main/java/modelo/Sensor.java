package modelo;

import java.util.ArrayList;
import java.util.List;


public class Sensor {
	
	private String type;
	private String num;
	private List <Campo> fields;
	

	public Sensor(String type, String num) {
		super();
		this.type = type;
		this.num = num;
		this.fields = fields;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public List<Campo> getMisC() {
		return fields;
	}

	public void setMisC(List<Campo> misC) {
		this.fields = misC;
	}

	
	public boolean eliminarCampo(String campoName) {
        Campo campo = buscarCampo(campoName);
        if (campo != null) {
            fields.remove(campo);
            return true;
        }
        return false;
    }
	
	
	public boolean addCampo(Campo c) {
        if (c != null && buscarCampo(c.getName()) == null) {
            fields.add(c);
            return true;
        }
        return false;
    }
	
	public Campo buscarCampo(String name) {
		for (Campo c:fields) {
			if(name.equals(c.getName())) {
				return c;
			}
		}
		return null;
	}
	
	public Campo[] todosCampos() {
		if (fields.size()==0) return null;
		Campo[] listaC = new Campo[fields.size()]; 
		return fields.toArray(listaC);
	}
	
	/*public boolean actualizaCampo(String name, String unit, float decPrecision) {
		Campo c = this.buscarCampo(name);
		if (c != null) {
			c.setValor(campo, atrActualizar);
			return true;
		}
		return false;
	}*/
		


}
