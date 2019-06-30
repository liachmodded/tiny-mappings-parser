package net.fabricmc.tiny.model.map;

public interface MappedParameter extends MappedMethodElement {

//	int getLocalVariableIndex();

	interface Factory {

		MappedParameter create(MappedMethod owner, String name, int localVariableIndex);
	}
}
