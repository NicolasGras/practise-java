package com.ngr.java.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ngr.java.entity.Client;


/**
 * Class to compare way of joining elements from a list
 * in Java7 with loops and in Java8 with streams
 */
public class CollectorJoining {

	/**
	 * Expected result : "Joe Jackson, John Doe, Joanna Doe, Billy Bob"
	 */
	public static void main(String[] args) {
		
		final List<Client> clients = Arrays.asList
				(new Client("Jackson", "Joe", 10), 
				new Client("Doe", "John", 20),
				new Client("Doe", "Joanna", 22), 
				new Client("Bob", "Billy", 30));

		System.out.println(" Java 7 - joining elements from Collection with loop");
		joiningJava7(clients);
		
		System.out.println(" Java 8 - joining elements from Collection with stream");
		joiningJava8(clients);
	}

	/**
	 * Joining elements from Collection with loop
	 * @param clients
	 */
	private static void joiningJava7(final List<Client> clients) {
		
		final StringBuilder sBuilder = new StringBuilder();
		for(Client client : clients) {
			sBuilder.append(client.getFirstName() + " " + client.getName() + ", ");
		}
		
		String result = sBuilder.toString();
		result = result.replaceAll(", $", "");
		
		System.out.println(result);
	}
	
	/**
	 * Joining elements from Collection with stream
	 * @param clients
	 */
	private static void joiningJava8(final List<Client> clients) {
		
		/*
		 * - Create a Stream<Client> from List<Client> in method arg
		 * - Get a Stream<String> from previous Stream<Client> by using java.util.stream.Stream.map(Function<Client, String> method
		 * - Reduce Stream<String> in a String by using java.util.stream.Stream.collect(Collector<>) method
		 * 
		 * When you use collect method, to get a Collector instance, you should use  java.util.stream.Collectors.joining(CharSequence delimiter)
		 */
		
		final String result = clients.stream()
									.map(tmpClient -> tmpClient.getFirstName() + " " + tmpClient.getName())
									.collect(Collectors.joining(", "));
		
		System.out.println(result);
		
	}

}
