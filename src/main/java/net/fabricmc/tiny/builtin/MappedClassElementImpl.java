package net.fabricmc.tiny.builtin;

import net.fabricmc.tiny.model.map.MappedClass;
import net.fabricmc.tiny.model.map.MappedField;
import net.fabricmc.tiny.model.map.MappedMethod;

final class MappedClassElementImpl implements MappedMethod, MappedField {

	private final String ownerName;
	private final String name;
	private final String descriptor;

	MappedClassElementImpl(MappedClass owner, String name, String descriptor) {
		this.ownerName = owner.getName();
		this.name = name;
		this.descriptor = descriptor;
	}

	@Override
	public String getOwnerClass() {
		return ownerName;
	}

	public String getDescriptor() {
		return descriptor;
	}

	@Override
	public String getName() {
		return name;
	}
}
