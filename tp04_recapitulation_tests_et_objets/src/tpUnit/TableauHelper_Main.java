package tpUnit;

public class TableauHelper_Main {

	public static void main(String[] args) {
		char[] orig = { 'a', '1', 'R' };
		TableauHelper.afficherTableau(orig);
		char[] expected = { 'R', '1', 'a' };
		TableauHelper.afficherTableau(expected);
		char[] inverse = TableauHelper.inverser(orig);

		
		TableauHelper.afficherTableau(inverse);
		
		int indiceDebut;
		int indiceFin;
		char[] t1 = {  '0', '1', '2', '3', '4', '5', '6', '7' };
		indiceDebut = 0;
		indiceFin = 3;
		char[] subtab1 = TableauHelper.sousTableau(t1, indiceDebut, indiceFin);
		TableauHelper.afficherTableau(subtab1);
		
		
		char[] t2 = {  '1', '2', '3', '4', '5', '6', '7' };
		indiceDebut = 2;
		indiceFin = 4;
		char[] subtab2 = TableauHelper.sousTableau(t2, indiceDebut, indiceFin);
		TableauHelper.afficherTableau(subtab2);
	}

}
