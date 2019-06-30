package net.fabricmc.tiny.model.map;

public interface MappedMethod extends MappedClassElement {

	String getName();

	String getOwnerClass();

	String getDescriptor();

	interface Factory {

		MappedMethod create(MappedClass owner, String name, String descriptor);
	}
}
