package net.fabricmc.tiny.model;

import net.fabricmc.tiny.model.map.MappedMethod;

public interface TinyMethod extends Owned<TinyClass>, Mappable<MappedMethod> {
	// No mapping agnostic attributes exposed
}
