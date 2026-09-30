package org.input;

import java.util.Collection;

public interface Input {
	Object createBus(String... info);
	Collection<?> fillCollection(int length);	
}
