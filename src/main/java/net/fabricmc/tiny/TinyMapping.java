package net.fabricmc.tiny;

import net.fabricmc.tiny.model.TinyClass;
import net.fabricmc.tiny.model.TinyField;
import net.fabricmc.tiny.model.TinyLocalVariable;
import net.fabricmc.tiny.model.TinyMethod;
import net.fabricmc.tiny.model.TinyParameter;

import java.util.Collection;
import java.util.List;

public interface TinyMapping {

	MapModel getModel();

	List<String> getNamespaces();

	Collection<TinyClass> getClasses();

	Collection<TinyField> getFields();

	Collection<TinyMethod> getMethods();

	Collection<TinyParameter> getParameters();

	Collection<TinyLocalVariable> getLocalVariables();

}
