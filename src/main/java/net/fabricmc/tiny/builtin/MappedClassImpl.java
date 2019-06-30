package net.fabricmc.tiny.builtin;

import net.fabricmc.tiny.model.map.MappedClass;

final class MappedClassImpl implements MappedClass {

	private final String name;

	MappedClassImpl(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}
