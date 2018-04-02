package exo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

public class SetTest {

	@Test
	public void testDoublon() {
		Set<String> mySet = new HashSet<>();
		String s = "S1";
		mySet.add(s);
		mySet.add(s);
		Assert.assertEquals(1, mySet.size());
	}

	@Test
	public void testForEach() {
		Set<String> mySet = new TreeSet<>();

		mySet.add("A");
		mySet.add("D");
		mySet.add("2");
		mySet.add("d");
		mySet.add("C");
		mySet.add("B");
		ArrayList<String> elements = new ArrayList<>();
		for (String s : mySet) {
			elements.add(s);
		}
		Object[] actuals = elements.toArray();
		Object[] expecteds = { "2", "A", "B", "C", "D", "d" };
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testIterator() {
		Set<String> mySet = new TreeSet<>();

		mySet.add("A");
		mySet.add("D");
		mySet.add("2");
		mySet.add("d");
		mySet.add("C");
		mySet.add("B");
		ArrayList<String> elements = new ArrayList<>();

		Iterator<String> it = mySet.iterator();
		while (it.hasNext()) {
			String element = it.next();
			elements.add(element);
		}
		Object[] actuals = elements.toArray();
		Object[] expecteds = { "2", "A", "B", "C", "D", "d" };
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testIteratorRemove() {
		Set<String> mySet = new TreeSet<>();

		mySet.add("A");
		mySet.add("D");
		mySet.add("C");
		mySet.add("B");

		Iterator<String> it = mySet.iterator();
		it.next();
		it.remove();

		ArrayList<String> elements = new ArrayList<>();
		for (String s : mySet) {
			elements.add(s);
		}

		List<String> expecteds = Arrays.asList("B", "C", "D");
		Assert.assertEquals(expecteds, elements);
	}
}
