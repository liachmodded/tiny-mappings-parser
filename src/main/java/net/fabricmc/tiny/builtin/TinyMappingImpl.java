package net.fabricmc.tiny.builtin;

import net.fabricmc.tiny.MapModel;
import net.fabricmc.tiny.TinyMapping;
import net.fabricmc.tiny.model.TinyClass;
import net.fabricmc.tiny.model.TinyField;
import net.fabricmc.tiny.model.TinyLocalVariable;
import net.fabricmc.tiny.model.TinyMethod;
import net.fabricmc.tiny.model.TinyParameter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TinyMappingImpl implements TinyMapping {

	private final MapModel model;
	private final List<String> namespaces;
	private final Collection<TinyClass> classes = new ArrayList<>();
	private final Collection<TinyField> fields = new ArrayList<>();
	private final Collection<TinyMethod> methods = new ArrayList<>();
	private final Collection<TinyParameter> parameters = new ArrayList<>();
	private final Collection<TinyLocalVariable> localVariables = new ArrayList<>();

	TinyMappingImpl(MapModel model, List<String> namespaces) {
		this.model = model;
		this.namespaces = namespaces;
	}

	@Override
	public MapModel getModel() {
		return model;
	}

	@Override
	public List<String> getNamespaces() {
		return namespaces;
	}

	@Override
	public Collection<TinyClass> getClasses() {
		return classes;
	}

	@Override
	public Collection<TinyField> getFields() {
		return fields;
	}

	@Override
	public Collection<TinyMethod> getMethods() {
		return methods;
	}

	@Override
	public Collection<TinyParameter> getParameters() {
		return parameters;
	}

	@Override
	public Collection<TinyLocalVariable> getLocalVariables() {
		return localVariables;
	}
}
