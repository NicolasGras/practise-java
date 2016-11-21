package com.ngr.java.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ngr.java.entity.Client;


/**
 * #5 : Sample program to compare Java7 and Java8 syntax
 * 
 * Créer une sous liste des noms des clients
 * 
 */
public class CollectApp {

	public static void main(String[] args) {

		List<com.ngr.java.entity.Client> clients = Arrays.asList
				(new Client("Jackson", "Joe", 10), 
				new Client("Doe", "John", 20),
				new Client("Darcy", "Joanna", 22), 
				new Client("Kloug", "Billy", 30));

		System.out.println(" Java 7 (with loop)");
		doJava7(clients);

		System.out.println(" Java 8 (with collect)");
		doJava8(clients);
	}

	/**
	 * using Java7
	 * 
	 * @param clients
	 * @return
	 */
	private static void doJava7(final List<Client> clients) {

		List<String> noms = new ArrayList<>();
		for (Client client : clients) {
			noms.add(client.getName());
		}
		
		System.out.println(noms);
		
	}

	/**
	 *  using Java8
	 * 
	 * @param clients
	 * @return
	 */
	private static void doJava8(final List<Client> clients) {

		/**
		 * Collecte est une réduction immutable. 
		 * Elle cumule les éléments d’un stream dans un container.
			Collectors propose des implémentations prêtes à l’emploi: toList, toSet, toCollection, toMap..
		 */
		/*
		 * map, collect
		 */
		List<String> noms = clients.stream()
				.map(Client::getName)
				.collect(Collectors.toList());
		
		System.out.println(noms);

	}

}
