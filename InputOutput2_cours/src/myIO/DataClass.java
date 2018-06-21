package myIO;

import java.io.Serializable;

public class DataClass implements Serializable {
	static final long serialVersionUID=606606100;
	public int id;
	public String code;
	public String libelle;
	public String toString() {
		return String.format("%d %s %s", id, code, libelle);
	}
}