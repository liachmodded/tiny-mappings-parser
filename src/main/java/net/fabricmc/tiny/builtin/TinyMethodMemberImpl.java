package net.fabricmc.tiny.builtin;

import net.fabricmc.tiny.model.Mappable;
import net.fabricmc.tiny.model.Owned;
import net.fabricmc.tiny.model.TinyMethod;
import net.fabricmc.tiny.model.map.MappedMethodElement;

import java.util.function.ToIntFunction;

abstract class TinyMethodMemberImpl<T extends MappedMethodElement> implements Mappable<T>, Owned<TinyMethod> {

	// passed on properties
	final TinyMethodImpl owner;
	private final ToIntFunction<String> indexer;

	// inherent properties
	final String[] names;
	final int localVariableIndex;

	// mapping
	private final T[] created;

	@SuppressWarnings("unchecked")
	TinyMethodMemberImpl(TinyMethodImpl owner, String[] names, int localVariableIndex) {
		this.names = names;
		this.localVariableIndex = localVariableIndex;
		this.owner = owner;
		this.indexer = owner.indexer;
		this.created = (T[]) new MappedMethodElement[names.length];
	}

	@Override
	public TinyMethod getOwner() {
		return owner;
	}

	@Override
	public T map(String namespace) throws IllegalArgumentException {
		return map(indexer.applyAsInt(namespace));
	}

	T map(int index) {
		T mapped = created[index];
		if (mapped != null)
			return mapped;
		return created[index] = create(index);
	}

	abstract T create(int index);
}
