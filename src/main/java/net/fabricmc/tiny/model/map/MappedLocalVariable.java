package net.fabricmc.tiny.model.map;

public interface MappedLocalVariable extends MappedMethodElement {

//	int getLocalVariableIndex();

//	int getLocalVariableLength();

//	int getLocalVariableTableIndex();

	interface Factory {

		MappedLocalVariable create(MappedMethod owner, String name, int localVariableIndex, int localVariableStartOffset, int localVariableTableIndex);
	}
}
