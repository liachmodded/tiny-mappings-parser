package net.fabricmc.tiny.builtin;

import net.fabricmc.tiny.model.TinyMethod;
import net.fabricmc.tiny.model.map.MappedClass;
import net.fabricmc.tiny.model.map.MappedMethod;

public class TinyMethodImpl extends TinyClassMemberImpl<MappedMethod> implements TinyMethod {

	private final MappedMethod.Factory factory;

	public TinyMethodImpl(MappedMethod.Factory factory, TinyClassImpl owner, String[] names, String defaultDesc) {
		super(owner, names, defaultDesc);
		this.factory = factory;
	}

	@Override
	MappedMethod create(MappedClass owner, String name, String desc) {
		return factory.create(owner, name, desc);
	}
}
