package etudiant;

public class Etudiant {
	Long numero;
	String nom;
	int anneeNaissance;

	public Etudiant(Long numero, String nom, int anneeNaissance) {
		this.numero = numero;
		this.nom = nom;
		this.anneeNaissance = anneeNaissance;
	}

	public Long getNumero() {
		return this.numero;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getDateNaissance() {
		return this.anneeNaissance;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Etudiant [numero=" + this.numero + ", nom=" + this.nom + ", anneeNaissance=" + this.anneeNaissance + "]");
		buffer.append("\n");
		return buffer.toString();
		
	}
	
	
	
	
}
