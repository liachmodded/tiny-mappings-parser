package net.fabricmc.tiny.builtin;

import net.fabricmc.tiny.model.TinyLocalVariable;
import net.fabricmc.tiny.model.TinyMethod;
import net.fabricmc.tiny.model.map.MappedLocalVariable;

public class TinyLocalVariableImpl extends TinyMethodMemberImpl<MappedLocalVariable> implements TinyLocalVariable {

	private final MappedLocalVariable.Factory factory;
	private final int localVariableStartOffset;
	private final int localVariableTableIndex;

	public TinyLocalVariableImpl(MappedLocalVariable.Factory factory, TinyMethodImpl owner, String[] names, int localVariableIndex, int localVariableStartOffset) {
		this(factory, owner, names, localVariableIndex, localVariableStartOffset, -1);
	}

	public TinyLocalVariableImpl(MappedLocalVariable.Factory factory, TinyMethodImpl owner, String[] names, int localVariableIndex, int localVariableStartOffset, int localVariableTableIndex) {
		super(owner, names, localVariableIndex);
		this.factory = factory;
		this.localVariableStartOffset = localVariableStartOffset;
		this.localVariableTableIndex = localVariableTableIndex;
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
	public int getLocalVariableStartOffset() {
		return localVariableStartOffset;
	}

	@Override
	public int getLocalVariableTableIndex() {
		return localVariableTableIndex;
	}

	@Override
	MappedLocalVariable create(int index) {
		return factory.create(owner.map(index), names[index], localVariableIndex, localVariableStartOffset, localVariableTableIndex);
	}
}
