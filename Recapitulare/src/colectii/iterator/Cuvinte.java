package colectii.iterator;

import java.util.Iterator;

public class Cuvinte implements Iterable<String> {

	private String text;

	public Cuvinte(String text) {
		this.text = text;
	}

	@Override
	public Iterator<String> iterator() {
		return new CuvinteIterator(this.text);
	}

}
