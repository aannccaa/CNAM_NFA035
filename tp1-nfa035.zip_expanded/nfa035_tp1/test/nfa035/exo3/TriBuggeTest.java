package nfa035.exo3;
/*
Reprenez l’exercice TriBugge de la semaine dernie`re. e ́crivez des tests pour les 
diverses me ́thodes (remplacez private par “rien” pour pouvoir tester) et corrigez 
les proble`mes.
 */
import org.junit.Assert;
import org.junit.Test;

public class TriBuggeTest {

	@Test(timeout=1000)
	public void testTrier() {
		int[] tabCurrent = {3, 2, 4, 1};
		TriBugge.trier(tabCurrent);
		int[] tabExpected = {1, 2, 3, 4};
		Assert.assertArrayEquals(tabExpected, tabCurrent);
	}
	
	@Test(timeout=1000)
	public void TestEchanger() {
		int[] tabCurrent = {3, 2, 4, 1};
		int i = 1;
		int pos = 0;
		TriBugge.echanger(tabCurrent, i, pos);
		int[] tabExpected = {2, 3, 4, 1};
		Assert.assertArrayEquals(tabExpected, tabCurrent);
	}
	
	@Test(timeout=1000)
	public void TestPosPlusPetit() {
		int[] tabCurrent = {3, 2, 4, 1};
		int i=1;
		int posPlusPetit = TriBugge.posPlusPetit(tabCurrent, i);
		Assert.assertEquals(3, posPlusPetit );
	}
	

}
