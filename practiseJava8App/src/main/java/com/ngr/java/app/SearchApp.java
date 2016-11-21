package com.ngr.java.app;

import java.util.Arrays;
import java.util.List;

import com.ngr.java.entity.Client;



/**
 * #4 : Sample program to compare Java7 and Java8 syntax
 * 
 * Rechercher le client le plus âgé
 * 
 */
public class SearchApp {

	public static void main(String[] args) {

		List<Client> clients = Arrays.asList
				(new Client("Jackson", "Joe", 10), 
				new Client("Doe", "John", 20),
				new Client("Darcy", "Joanna", 22), 
				new Client("Kloug", "Billy", 30));

		System.out.println("Reduce Java 7 (with loop)");
		doJava7(clients);

		System.out.println("Reduce Java 8 (with stream + lambda)");
		doJava8(clients);
	}

	/**
	 * using Java7
	 * 
	 * @param clients
	 * @return
	 */
	private static void doJava7(final List<Client> clients) {

		Client older = null;
		
		for (Client client : clients) {
			if (older == null) {
				older = client;
			} else {
				if (client.getAge() > older.getAge()) {
					older = client;
				}
			}
		}
		System.out.println(older);
	}

	/**
	 * Reduce list (ie: compute a result from a list) using Java8
	 * 
	 * @param clients
	 * @return
	 */
	private static void doJava8(final List<Client> clients) {

		/**
		 * Une opération de réduction combine tous les éléments d’un stream en un unique résultat.
		 */
		/*
		 * reduce, ifPresent
		 */
		clients.stream()
			.reduce((c1,c2) -> c1.getAge()>c2.getAge() ? c1 : c2)
			.ifPresent(System.out::println);
		
	}

}
