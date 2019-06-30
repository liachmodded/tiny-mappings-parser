package net.fabricmc.tiny.builtin;

import net.fabricmc.tiny.model.map.MappedClass;
import net.fabricmc.tiny.model.map.MappedField;

public class TinyFieldImpl extends TinyClassMemberImpl<MappedField> {

	private final MappedField.Factory factory;

	public TinyFieldImpl(MappedField.Factory factory, TinyClassImpl owner, String[] names, String defaultDesc) {
		super(owner, names, defaultDesc);
		this.factory = factory;
	}

	@Override
	MappedField create(MappedClass owner, String name, String desc) {
		return factory.create(owner, name, desc);
	}
}
