package net.fabricmc.tiny.builtin;

import net.fabricmc.tiny.model.TinyClass;
import net.fabricmc.tiny.model.map.MappedClass;

import java.util.function.ToIntFunction;

public class TinyClassImpl implements TinyClass {

	// passed on references
	final ClassRemapper remapper;
	final ToIntFunction<String> indexer;

	// inherent properties
	private final String oldName;

	// mapping
	private final MappedClass.Factory factory;
	private final MappedClass[] created;

	public TinyClassImpl(MappedClass.Factory factory, String oldName, ClassRemapper remapper) {
		this.factory = factory;
		this.oldName = oldName;
		this.remapper = remapper;
		this.indexer = remapper.indexer;
		this.created = new MappedClass[remapper.namespaceCount];
	}

	@Override
	public MappedClass map(String namespace) throws IllegalArgumentException {
		return map(indexer.applyAsInt(namespace));
	}

	MappedClass map(int index) {
		MappedClass mapped = created[index];
		if (mapped != null)
			return mapped;
		return created[index] = factory.create(remapper.remap(oldName, index));
	}
}
