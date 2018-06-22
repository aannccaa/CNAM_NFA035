package actionDemo;

/**
 * Classe Personne du modèle.
 * <p>Dans notre exemple, les objets Personnes sont des "objets valeurs".
 * <p>Modifier une personne ne fait rien tant qu'on n'a pas appelé la méthode "update" de PersonnesFacade.
 * <p>Noter que ce n'est pas obligatoire. On pourrait avoir un objet "personne" "vivant".
 * @author rosmord
 *
 */
public class Personne {
	private int id;
	private String nom, prenom;
	
	public Personne(int id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
	
}
