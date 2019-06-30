package net.fabricmc.tiny.builtin;

import net.fabricmc.tiny.model.Mappable;
import net.fabricmc.tiny.model.Owned;
import net.fabricmc.tiny.model.TinyClass;
import net.fabricmc.tiny.model.map.MappedClass;
import net.fabricmc.tiny.model.map.MappedClassElement;

import java.util.function.ToIntFunction;

abstract class TinyClassMemberImpl<T extends MappedClassElement> implements Mappable<T>, Owned<TinyClass> {

	// passed on properties
	private final TinyClassImpl owner;
	private final ClassRemapper remapper;
	final ToIntFunction<String> indexer;

	// inherent properties
	private final String[] names;
	private final String defaultDesc;

	// mapping
	private final T[] created;

	@SuppressWarnings("unchecked")
	TinyClassMemberImpl(TinyClassImpl owner, String[] names, String defaultDesc) {
		this.names = names;
		this.defaultDesc = defaultDesc;
		this.owner = owner;
		this.indexer = owner.indexer;
		this.remapper = owner.remapper;
		this.created = (T[]) new MappedClassElement[names.length];
	}

	@Override
	public TinyClass getOwner() {
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
		return created[index] = create(owner.map(index), names[index], remapper.remapDesc(defaultDesc, index));
	}

	abstract T create(MappedClass owner, String name, String desc);
}
