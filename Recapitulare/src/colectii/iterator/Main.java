package colectii.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Element {
	int data;
}

public class Main {

	public static void main(String[] args) {

		unExemplu();
		doiExemplu();

		Iterable<String> monIterable = new Cuvinte("Anca  are mere  ");

		for (String s : monIterable) {
			System.out.println(s);
		}

		Iterator<String> cuvinte = monIterable.iterator();
		while (cuvinte.hasNext()) {
			String s = cuvinte.next();
			System.out.println(s);
		}

		List<String> listaCuvinte = new ArrayList<>();
		listaCuvinte.add("Anca");
		listaCuvinte.add("are");
		listaCuvinte.add("mere");
		cuvinte = listaCuvinte.iterator();
		while (cuvinte.hasNext()) {
			String s = cuvinte.next();
			if (s.equals("are")) {
				cuvinte.remove();
			}
			System.out.println(s);
		}
		System.out.println(listaCuvinte);
	}

	private static void doiExemplu() {
		int i = 5;
		increment(i);
		System.out.println(i);
		Element e1 = new Element();
		e1.data = 1;
		increment(e1);
		System.out.println(e1.data);
	}

	private static void increment(Element e) {
		e.data = e.data +1;
	}

	private static int increment(int x) {
		x = x + 1;
		return x;
	}

	private static void unExemplu() {

		List<Element> listaElemente = new ArrayList<>();
		Element e1 = new Element();
		Element e2 = new Element();
		listaElemente.add(e1);
		listaElemente.add(e2);
		for (Element e : listaElemente) {
			e.data = 5;
		}
		for (Element e : listaElemente) {
			System.out.println(e.data);
		}

	}

}
