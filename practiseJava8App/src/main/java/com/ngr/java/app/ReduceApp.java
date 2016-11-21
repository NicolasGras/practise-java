package com.ngr.java.app;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import com.ngr.java.entity.Client;



/**
 * #2 : Sample reduce program to compare Java7 and Java8 syntax
 * (compute a result from a list)
 * 
 * Calculer l’âge moyen des clients de plus de 20 ans
 * 
 */
public class ReduceApp {

	public static void main(String[] args) {
		
		List<Client> clients = Arrays.asList(
				new Client("Jackson", "Joe", 10),
				new Client("Doe", "John", 20),
				new Client("Darcy", "Joanna", 22),
				new Client("Kloug", "Billy", 30));
		
		System.out.println("Reduce Java 7 (with loop)");
		System.out.println(reduceJava7(clients));
		
		System.out.println("Reduce Java 8 (with stream + lambda");
		System.out.println(reduce(clients));
	}
	
	/**
	 * Reduce list (ie: compute a result from a list) using Java7 
	 * @param clients
	 * @return
	 */
	private static double reduceJava7(final List<Client> clients) {
		
		int nbClient = 0;
		int sumAge = 0;
		
		for(Client client : clients) {
			if(client.getAge() > 20) {
				nbClient++;
				sumAge += client.getAge();
			}
		}
		
		return (double)(sumAge/nbClient);
	}
	
	/**
	 * Reduce list (ie: compute a result from a list) using Java8
	 * @param clients
	 * @return
	 */
	private static Double reduce(final List<Client> clients) {
		
		// 1 - get Stream<Client> from list
		// 2 - filter : use java.util.function.Predicate functional interface
		//   - one method --> boolean test(T t)
		//		==> get Stream<Client>
		// 3 - mapToInt map each Client to int : use java.util.function.ToIntFunction functional interface
		//   - one method --> int applyAsInt(T t)
		//		==> get IntStream
		// 4 - use average() method on IntStream

		OptionalDouble optional = clients.stream()
				.filter(c -> c.getAge()> 20)
				.mapToInt(Client::getAge)	// <=> c -> c.getAge()
				.average();
		
		if(optional.isPresent()) {
			return optional.getAsDouble();
		} else {
			return null;	
		}
	}

}
