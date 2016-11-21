package com.ngr.java.app;

import java.util.Arrays;
import java.util.List;

import com.ngr.java.entity.Client;


/**
 * #1 : Sample filter program to compare Java7 and Java8 syntax
 * 
 * Trouver les noms commençant par D
 * 
 */
public class FilterApp {

	public static void main(String[] args) {
		
		List<Client> clients = Arrays.asList(new Client("Jackson", "Joe", 10), new Client("Doe", "John", 20),
				new Client("Darcy", "Joanna", 22), new Client("Kloug", "Billy", 30));

		System.out.println("Filter Java 7 (with loop)");
		filterJava7(clients);

		System.out.println("Filter Java 8 (with stream + lambda");
		filter(clients);
	}

	/**
	 * Filter on list using Java7
	 * 
	 * @param clients
	 */
	private static void filterJava7(final List<Client> clients) {

		for (Client client : clients) {
			if (client.getName().startsWith("D")) {
				System.out.println(client);
			}
		}
	}

	/**
	 * Filter on list using Java8
	 * 
	 * @param clients
	 */
	private static void filter(final List<Client> clients) {

		// 1 - get Stream<Client> from list
		// 2 - filter : use java.util.function.Predicate functional interface
		// - one method --> boolean test(T t)
		// 3 - forEach action on each filtered element : use
		// java.util.function.Consumer functional interface
		// - one method --> void accept(Client t)

		clients.stream().filter(c -> c.getName().startsWith("D"))
				.forEach(clie -> System.out.println(clie));

	}
}