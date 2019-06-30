package net.fabricmc.tiny.model;

import net.fabricmc.tiny.model.map.MappedLocalVariable;

public interface TinyLocalVariable extends Owned<TinyMethod>, Mappable<MappedLocalVariable> {

	int getLocalVariableIndex();

	int getLocalVariableStartOffset();

	int getLocalVariableTableIndex();

}
