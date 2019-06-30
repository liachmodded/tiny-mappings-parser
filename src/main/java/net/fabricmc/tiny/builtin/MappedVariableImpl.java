package net.fabricmc.tiny.builtin;

import net.fabricmc.tiny.model.map.MappedLocalVariable;
import net.fabricmc.tiny.model.map.MappedMethod;
import net.fabricmc.tiny.model.map.MappedParameter;

final class MappedVariableImpl implements MappedParameter, MappedLocalVariable {

	private final MappedMethod owner;
	private final String name;

	MappedVariableImpl(MappedMethod owner, String name) {
		this.owner = owner;
		this.name = name;
	}

	@Override
	public String getOwnerMethodName() {
		return owner.getName();
	}

	@Override
	public String getOwnerMethodDescriptor() {
		return owner.getDescriptor();
	}

	@Override
	public String getOwnerClass() {
		return owner.getOwnerClass();
	}

	@Override
	public String getName() {
		return name;
	}
}
