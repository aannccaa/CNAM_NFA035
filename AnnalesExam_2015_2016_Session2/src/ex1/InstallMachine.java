package ex1;

/*
Question 1.1 (1 point)
Dans la classe InstallMachine on vous demande de comple ́ter le code de la me ́thode estInstalle(Logiciel l). 
Cette me ́thode doit tester non seulement le nom du logiciel mais aussi son nume ́ro de version. 
Par exemple, si JDK 6 est installe ́, un appel qui teste si JDK 8 est installe ́ doit renvoyer false.

Question 1.2 (2 points)
Dans InstallMachine, ajoutez la me ́thode depNonInstallees(Logiciel p) qui retourne un 
Set<Logiciel> correspondant aux logiciels se trouvant dans la liste de de ́pendances de p et qui par 
ailleurs ne sont pas installe ́s sur la machine. Supposons que k soit dans les de ́pendances de p : 
s’il est de ́ja` installe ́ (avec la version qui convient), k ne doit pas figurer dans le re ́sultat. 
Si k n’est pas installe ́, ou si k est installe ́ mais dans une autre version, il doit figurer au re ́sultat.

Question 1.3 (1.5 points)
Dans la classe InstallMachine comple ́tez la me ́thode installer(Logiciel l). 
Note : un logiciel pourra eˆtre installe ́ uniquement si ce logiciel (meˆme nom, meˆme nume ́ro de version) 
n’est pas de ́ja` installe ́, et si toutes ses de ́pendances sont de ́ja` installe ́es. Dans les autres cas, 
le logiciel ne sera pas ajoute ́ aux logiciels installe ́s de la machine et la me ́thode renverra false.
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class InstallMachine {

	// NOMS + LOGIELS INSTALLES SUR LA MACHINE
	private HashMap<String, Logiciel> installes = new HashMap<String, Logiciel>();

	/**
	 * Dit si le logiciel nomme ́ nl est installe ́
	 * 
	 * @param nl
	 *            un nom de logiciel
	 * @return true si et seulement si une version de nl est installe ́e .
	 */
	public boolean estInstalle(String nl) {
		return installes.containsKey(nl);
	}

	// Q1
	public boolean estInstalle(Logiciel l) {
		// A COMPLETER
		Logiciel trouve = installes.get(l.getNom());
		return (trouve != null && l.getVersion() == trouve.getVersion());
	}

	// Q1
	public boolean estInstalle_variante1(Logiciel l) {
		// A COMPLETER
		Logiciel trouve = installes.get(l.getNom());
		if (trouve == null) {
			return false;
		} else {
			return l.getVersion() == trouve.getVersion();
		}
	}
	

	// Q2
	public Set<Logiciel> depNonInstallees(Logiciel p) {
		Set<Logiciel> result = new HashSet<Logiciel>();
		Set<Logiciel> dependances = p.getDependances();
		for (Logiciel d : dependances) {
			if (!estInstalle(d)) {
				result.add(d);
			}
		}
		return result;
	}

	/**
	 * Enregistre un logiciel comme installe ́ , si c’est possible . un logiciel
	 * peut etre installe ́ s’il ne l’est pas déjà , et si ses de ́pendances sont
	 * installe ́es , avec les bonnes versions . post−condition: si le logiciel peut
	 * eˆtre installe ́ , il est enregistre ́ dans la map.
	 * 
	 * @return true si le logiciel a pu eˆtre installe ́ .
	 */
	public boolean installer(Logiciel l) {
		if (estInstalle(l)) {
			return false;
		}
		// COMPLETER
		Set<Logiciel> depNonInstallee = this.depNonInstallees(l);
		if (depNonInstallee.size() > 0) {
			return false;
		}
		this.installes.put(l.getNom(), l);
		return true;
	}
}
