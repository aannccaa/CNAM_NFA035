package exo1.question1;
/*
Exercice 1

Question 1

On considere un langage de programmation utilisé pour gérer une calculatrice. Il comporte les 
instructions suivantes: 
• ADD valeur : ajoute une valeur, qui est a priori un entier ;
• MULT valeur : multiplie par une une valeur, qui est a priori un entier ;
• CLEAR efface le calcul courant (remet le re ́sultat a` 0);
• PRINT affiche le re ́sultat du calcul.
Les instructions operent sur le résultat actuel du calcul, qui commence à 0.
Ainsi, la séquence :
CLEAR ADD 3 ADD 5
MULT 2 PRINT
va afficher le résultat 16.
Ecrire une methode java qui prendra comme argument un Reader et qui sera capable d’exécuter 
un programme écrit dans ce petit langage.
La structure de l’algorithme de lecture sera la suivante:
tant que tok.hasNextToken() :
        si c’est une instruction ADD:
			tok.next() 
			// on saute le ADD
			// on lit le nombre (ou on l`eve une erreur) 
 			// on termine en avançant
        sinon si c’est une instruction MULT :
                l’analyser et la traiter
                 ... 
        sinon
        			lever une exception pour signaler un token
				inattendu.
		fin si


Question 2

On ajoute une nouvelle commandes au langage:
• SET VAR : donne à la variable VAR la valeur actuelle du calcul ;
Ensuite, les commandes ADD et MULT sont modifiees: elles peuvent prendre comme argument un nombre, 
mais aussi un nom de variable (auquel cas, la valeur ajoutée ou multipliée sera celle de la variable).
Pour stocker les valeurs des variables, on suggere une HashMap.
 */

public class CalcFromFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
