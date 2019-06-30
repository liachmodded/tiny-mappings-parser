package net.fabricmc.tiny.model.map;

public interface MappedMethodElement extends MappedClassElement {

	String getOwnerMethodName();

	String getOwnerMethodDescriptor();
}
