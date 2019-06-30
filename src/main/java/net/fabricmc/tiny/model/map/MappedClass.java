package net.fabricmc.tiny.model.map;

public interface MappedClass extends MappedElement {

	/**
	 * Obtains the qualified name with dots replaced by slashes.
	 *
	 * E.g. {@code java/lang/Object} is for {@link Object}.
	 * @return
	 */
	@Override
	String getName();

	interface Factory {

		MappedClass create(String name);
	}
}
