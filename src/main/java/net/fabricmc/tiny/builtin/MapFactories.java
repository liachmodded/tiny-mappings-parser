package net.fabricmc.tiny.builtin;

import net.fabricmc.tiny.MapModel;
import net.fabricmc.tiny.TinyMapping;
import net.fabricmc.tiny.model.map.MappedClass;
import net.fabricmc.tiny.model.map.MappedField;
import net.fabricmc.tiny.model.map.MappedLocalVariable;
import net.fabricmc.tiny.model.map.MappedMethod;
import net.fabricmc.tiny.model.map.MappedParameter;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Utility factories.
 */
public final class MapFactories {

	public static final MappedClass.Factory CLASS = MappedClassImpl::new;
	public static final MappedField.Factory FIELD = MappedClassElementImpl::new;
	public static final MappedMethod.Factory METHOD = MappedClassElementImpl::new;
	public static final MappedParameter.Factory PARAMETER = (owner, name, localVariableIndex) -> new MappedVariableImpl(owner, name);
	public static final MappedLocalVariable.Factory LOCAL_VARIABLE = (owner, name, localVariableIndex, localVariableStartOffset, localVariableTableIndex) -> new MappedVariableImpl(owner, name);

	public static final MapModel DEFAULT_MODEL = MapModel.builder().build();

	/**
	 * Read the mappings.
	 *
	 * <p>Warning: The reader needs to be closed by the user!</p>
	 *
	 * @param reader the reader
	 * @param model the model
	 * @return
	 */
	public static TinyMapping createMapping(BufferedReader reader, MapModel model) throws IOException {
		String firstLine = reader.readLine();
		if (firstLine == null)
			throw new IllegalArgumentException("invalid reader!");

		if (firstLine.startsWith("tinyv1\t")) {

		}

		if
	}

	private MapFactories() {
	}
}
