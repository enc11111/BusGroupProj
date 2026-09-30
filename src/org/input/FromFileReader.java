package org.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;

public class FromFileReader implements Input {
	private String filename;

	public FromFileReader(String filename) {
		this.filename = filename;
	}

	@Override
	public Object createBus(String... info) {
		Object item = null;
		String[] parameters = info[0].split(";");
		/*item.number = parameters[0];
		  item.model = parameters[1];
		  item.mileage = parameters[2];
		 */
		return item;
	}

	@Override
	public Collection<Object> fillCollection(int length) {
		Collection<Object> buses = null;
		try {
			buses = Files.readAllLines(Paths.get(filename)).stream()
										.map(line -> {return createBus(line);})
										.limit(length)
										.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buses;
	}

}
