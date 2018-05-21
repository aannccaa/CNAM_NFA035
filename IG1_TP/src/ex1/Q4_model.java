package ex1;

public class Q4_model {
	private String texte;
	
	public String getTexte() {
		return this.texte;
	}
	
	public void setTexte(String value) {
		this.texte = value;
	}
	
	public void doUpperCase() {
		this.doChangeCase(true);
	}
	
	public void doLowerCase() {
		this.doChangeCase(false);
	}
	
	public void effacer() {
		this.setTexte(null);
	}
	
	private void doChangeCase(boolean upperCase) {
		if (this.texte != null) {
			String newValue = upperCase? this.texte.toUpperCase(): this.texte.toLowerCase();
			this.setTexte(newValue);
		}
	}
}
