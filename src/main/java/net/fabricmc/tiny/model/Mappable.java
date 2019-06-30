package net.fabricmc.tiny.model;

import net.fabricmc.tiny.model.map.MappedElement;

public interface Mappable<T extends MappedElement> {

	/**
	 * Map the tiny element in order to retrieve some mapping-aware features of the element.
	 *
	 * @param namespace The namespace target
	 * @return The mapped data
	 * @throws IllegalArgumentException If the namespace does not exist
	 */
	// lazily evaluate stuff for each namespace, i guess
	T map(String namespace) throws IllegalArgumentException;
}
