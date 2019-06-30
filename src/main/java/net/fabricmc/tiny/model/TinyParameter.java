package net.fabricmc.tiny.model;

import net.fabricmc.tiny.model.map.MappedParameter;

public interface TinyParameter extends Owned<TinyMethod>, Mappable<MappedParameter> {

	int getLocalVariableIndex();
}
