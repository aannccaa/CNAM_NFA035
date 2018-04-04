package collections2.exercice2;

import java.util.Iterator;

public class NotRemovableIterator<T> implements Iterator<T> {

	private Iterator<T> originalIterator;

	public NotRemovableIterator(Iterable<T> originalIterable) {
		this.originalIterator = originalIterable.iterator();
	}

	public NotRemovableIterator(Iterator<T> originalIterator) {
		this.originalIterator = originalIterator;
	}

	@Override
	public boolean hasNext() {
		return this.originalIterator.hasNext();
	}

	@Override
	public T next() {
		return this.originalIterator.next();
	}

}
