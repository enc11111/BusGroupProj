package org.input;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomGenerator implements Input {
	Random rand;
	
	public RandomGenerator() {
		this.rand = new Random();
	}
	
	private String generateRouteNumber() {
		StringBuilder temp = new StringBuilder();
		char c = (char)rand.nextInt();
		if(c == 'E' || c == 'e' || c == 'M' || c == 'm' || c == 'C' || c == 'c' || c == 'T' || c == 't' || c == 'H')
			temp.append(c);
		int route = rand.nextInt(2500);
		temp.append(route);
		return temp.toString();
	}
	
	private String generateModel() {
		StringBuilder temp = new StringBuilder();
		int length = rand.nextInt(1, 5);
		for(int i = 0; i < length; i++) {
			char c = (char)rand.nextInt(65, 90);
			temp.append(c);
		}
		int modelNumber = rand.nextInt();
		temp.append(modelNumber);
		return temp.toString();
	}
	
	private float generateMileage() {
		return rand.nextInt() + rand.nextFloat();
	}
	
	@Override
	public Object createBus(String... info) {
		Object item = null;
		/*item.number = generateRouteNumber()
		  item.model = generateModel();
		  item.mileage = generateMileage()
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
