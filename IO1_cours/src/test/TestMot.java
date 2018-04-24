package test;
import myIO.Mot;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestMot {

	@Test
	public void test_getMots() {
		String s = "je sais: tu n'est pas là bas";
		StringReader sr = new StringReader(s);
		List<String> mots = null;
		try {
			mots = Mot.getMots(sr);
		} catch (IOException e) {
			Assert.fail("exception");
		}
		String actual = mots.toString();
		String expected = "[je, sais, tu, n, est, pas, là, bas]";
		Assert.assertEquals(expected, actual);
	}

}
