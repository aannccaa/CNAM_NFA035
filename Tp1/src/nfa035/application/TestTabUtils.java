package nfa035.application;
import nfa035.utils.TableauUtils;

public class TestTabUtils {

	public static void main(String[] args) {
		int[] tab = TableauUtils.saisirTableauInt();
		TableauUtils.afficheTableauInt(tab);
	}

}
