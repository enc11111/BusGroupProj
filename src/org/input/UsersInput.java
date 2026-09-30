package org.input;

import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsersInput implements Input {
	private Scanner scanner;
	public UsersInput() {
		scanner = new Scanner(System.in);
	}
	
	private String inputNumber() {
		String number = scanner.next();
		//validate data...
		return number;
	}
	
	private String inputModel() {
		String model = scanner.next();
		//validate data...
		return model;
		
	}
	private float inputMileage() {
		float mileage = scanner.nextFloat();
		//validate data...
		return mileage;
	}
	
	@Override
	public Object createBus(String... info) {
		Object item = null;
		/*item.number = inputNumber()
		  item.model = inputModel();
		  item.mileage = inputMileage()
		 */
		return item;
	}
	
	@Override
	public Collection<?> fillCollection(int length) {
		Collection<Object> buses = Stream
				.generate(()->createBus(null))
				.limit(length)
				.collect(Collectors.toList());
		return buses;
	}

}
