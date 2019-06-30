package net.fabricmc.tiny.builtin;

import net.fabricmc.tiny.model.TinyMethod;
import net.fabricmc.tiny.model.TinyParameter;
import net.fabricmc.tiny.model.map.MappedParameter;

public class TinyParameterImpl extends TinyMethodMemberImpl<MappedParameter> implements TinyParameter {

	private final MappedParameter.Factory factory;

	public TinyParameterImpl(MappedParameter.Factory factory, TinyMethodImpl owner, String[] names, int localVariableIndex) {
		super(owner, names, localVariableIndex);
		this.factory = factory;
	}

	@Override
	public TinyMethod getOwner() {
		return owner;
	}

	@Override
	public int getLocalVariableIndex() {
		return localVariableIndex;
	}

	@Override
	MappedParameter create(int index) {
		return factory.create(owner.map(index), names[index], localVariableIndex);
	}
}
