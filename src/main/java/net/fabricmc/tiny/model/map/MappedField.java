package net.fabricmc.tiny.model.map;

public interface MappedField extends MappedClassElement {

	String getName();

	String getOwnerClass();

	String getDescriptor();

	interface Factory {

		MappedField create(MappedClass owner, String name, String descriptor);
	}
}
