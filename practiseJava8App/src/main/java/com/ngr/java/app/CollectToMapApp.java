package com.ngr.java.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ngr.java.entity.Client;


/**
 * Class build a Map from a Collection
 */
public class CollectToMapApp {

	/**
	 * Expected result : Map<Integer, String> with following elements
	 * - <10, "Joe Jackson">
	 * - <20, "John Doe">
	 * - <30, "Billy Bob">
	 * 
	 * You don't get Client whose age is in range [21;25]
	 * 
	 * When you print this map you should get that : "{20=John Doe, 10=Joe Jackson, 30=Billy Bob}"
	 *  
	 * Nb: with java.util.Map, unless you use a TreeMap, elements are not ordered
	 */
	public static void main(String[] args) {
		
		final List<Client> clients = Arrays.asList
				(new Client("Jackson", "Joe", 10), 
				new Client("Doe", "John", 20),
				new Client("Doe", "Joanna", 22), 
				new Client("Bob", "Billy", 30));

		System.out.println(" Java 7 - build a Map<Integer, String> from Collection<Client> with loop");
		buildMapJava7(clients);
		
		System.out.println(" Java 8 - build a Map<Integer, String> from Collection<Client> with stream");
		buildMapJava8(clients);

	}

	/**
	 * Java 7 - build a Map<Integer, String> from Collection<Client> with loop
	 */
	private static void buildMapJava7(final List<Client> clients) {
		
		Map<Integer, String> map = new HashMap<>();
		for(Client client : clients) {
			
			if(client.getAge() < 21 || client.getAge() > 25) {
			
				map.put(client.getAge(), client.getFirstName() + " " + client.getName());
			}
		}
		
		System.out.println(map);
	}
	
	/**
	 * Java 8 - build a Map<Integer, String> from Collection<Client> with stream
	 * @param clients
	 */
	private static void buildMapJava8(final List<Client> clients) {
		
		/*
		 * - Create a Stream<Client> from List<Client> in method arg
		 * - Filter this Stream<Client> by removing Clients whose age is in range [21;25]
		 * - Reduce Stream<String> in a String by using java.util.stream.Stream.collect(Collector<>) method
		 * 
		 * Collector to pass as argument of collect method must be gotten with the following method
		 * - java.util.stream.Collectors.toMap(Function1<Client, Integer> keyMapper, Function2<Client, String> valueMapper)
		 * --- keyMapper must return age of client
		 * --- value must return concatenation of firstName + " " + name
		 */
		
		Map<Integer, String> map = clients.stream()
										.filter(tmpClient -> tmpClient.getAge() < 21 || tmpClient.getAge() > 25)
										.collect(Collectors.toMap(Client::getAge, tmpClient -> tmpClient.getFirstName() + " " + tmpClient.getName()));
		
		System.out.println(map);
	}

}
