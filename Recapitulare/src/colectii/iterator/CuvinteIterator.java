package colectii.iterator;

import java.util.Iterator;

public class CuvinteIterator implements Iterator<String> {

	private final String text;
	private int currentPosition = 0;

	public CuvinteIterator(String text) {
		this.text = text == null ? "" : text.trim();
	}

	@Override
	public boolean hasNext() {
		return this.currentPosition < this.text.length();
	}

	@Override
	public String next() {
		String result = "";
		while(this.currentPosition < this.text.length()) {
			char current = this.text.charAt(this.currentPosition);
			this.currentPosition++;
			if(current > ' ') {
				result = result + current;
			} else {
				while(this.currentPosition < this.text.length() && 
						this.text.charAt(this.currentPosition) <= ' ' ) {
					this.currentPosition++;
				}
				break;
			}
		}
		return result;
	}
}
