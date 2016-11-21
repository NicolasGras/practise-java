package com.ngr.java.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ngr.java.entity.Client;


/**
 * #6 : Sample program to compare Java7 and Java8 syntax
 * 
 * Créer un Comparator qui va trier la liste par noms puis par prénoms
 * 
 */
public class CompareApp {

	public static void main(String[] args) {

		List<Client> clients = Arrays.asList
				(new Client("Jackson", "Joe", 10), 
				new Client("Doe", "John", 20),
				new Client("Doe", "Joanna", 22), 
				new Client("Bob", "Billy", 30));

		System.out.println(" Java 7 with Comparator compare");
		compareJava7(clients);

		System.out.println(" Java 8 with comparing");
		compareJava8(clients);
	}

	/**
	 * using Java7
	 * 
	 * @param clients
	 * @return
	 */
	private static void compareJava7(final List<Client> clients) {

		Collections.sort(clients, new Comparator<Client>() {
			@Override
			public int compare(Client p1, Client p2) {
				int nameCompare = p1.getName().compareTo(p2.getName());
				if (nameCompare == 0) {
					return p1.getFirstName().compareTo(p2.getFirstName());
				} else {
					return nameCompare;
				}
			}
		});
		
		System.out.println( clients );
		
	}

	/**
	 *  using Java8
	 * 
	 * @param clients
	 * @return
	 */
	private static void compareJava8(final List<Client> clients) {

		/**
		 * Par défaut, les méthodes comparing et thenComparing extraient le champ à comparer 
		 * et utilisent la méthode compareTo de la classe du champ extrait pour faire la comparaison.
		 * 
		 */
		Collections.sort(clients, 
				Comparator.comparing(Client::getName).thenComparing(Client::getFirstName));

	}

}
