package demos;

public class AdressePostale /* implements Comparable<AdressePostale> */ {
	private int numero;
	private String rue;
	private String ville;
	private String code;

	public AdressePostale(int n, String r, String v) {
		numero = n;
		rue = r;
		ville = v;
	}

	public String getCode() {
		return this.code;
	}

	public String toString() {
		return ("" + ville + "-" + rue + "," + numero);
	}
	/*
	 * public boolean equals(Object o){ try { AdressePostale a = (AdressePostale) o;
	 * String autre = a.toString().toLowerCase(); String ici =
	 * this.toString().toLowerCase(); return ici.equals(autre); } catch (Exception
	 * e) { // Traite les cas o==null et // o n'est pas de type AdressePostale
	 * return false; } }
	 * 
	 * public int hashCode() { String s = this.toString().toLowerCase(); return
	 * s.hashCode(); }
	 * 
	 * public int compareTo(AdressePostale o){ String autre =
	 * o.toString().toLowerCase(); String ici = this.toString().toLowerCase();
	 * return ici.compareTo(autre); }
	 */
}
