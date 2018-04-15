package exercice1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test du comparateur de notes... 
 * Il faut voir tous les cas...
 * @author rosmord
 *
 */
public class NoteComparatorTest {

	Recette r1, r2, r3, r4, r5;
	NoteComparator comparator= new NoteComparator();
	
	@Before
	public void prepare() {
		// initialisation une fois pour toutes des recettes.
		r1= new Recette("a");
		r1.ajouterNote(3);
		r2= new Recette("b");
		r2.ajouterNote(2);
		r3= new Recette("c");
		r3.ajouterNote(3);
		r4= new Recette("a");
		r4.ajouterNote(3);
		r5= new Recette("a");
		r5.ajouterNote(5);
	}
	
	@Test
	public void test1() {
		assertTrue(comparator.compare(r1, r2) > 0);
	}
	
	@Test
	public void test2() {
		assertTrue(comparator.compare(r2, r1) < 0);
	}

	@Test
	public void test3() {
		assertTrue(comparator.compare(r1, r3) < 0);
	}
	
	@Test
	public void test4() {
		assertTrue(comparator.compare(r3, r1) > 0);
	}

	@Test
	public void test5() {
		assertTrue(comparator.compare(r1, r4) ==0);
	}
	
	@Test
	public void test6() {
		assertTrue(comparator.compare(r1, r5) < 0);
	}
}
