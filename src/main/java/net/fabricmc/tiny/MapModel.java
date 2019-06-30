package net.fabricmc.tiny;

import net.fabricmc.tiny.builtin.MapFactories;
import net.fabricmc.tiny.model.map.MappedClass;
import net.fabricmc.tiny.model.map.MappedField;
import net.fabricmc.tiny.model.map.MappedLocalVariable;
import net.fabricmc.tiny.model.map.MappedMethod;
import net.fabricmc.tiny.model.map.MappedParameter;

public final class MapModel {

	private final MappedClass.Factory classFactory;
	private final MappedMethod.Factory methodFactory;
	private final MappedField.Factory fieldFactory;
	private final MappedLocalVariable.Factory localVariableFactory;
	private final MappedParameter.Factory parameterFactory;

	public static Builder builder() {
		return new Builder();
	}

	public MapModel(MappedClass.Factory classFactory, MappedMethod.Factory methodFactory, MappedField.Factory fieldFactory, MappedLocalVariable.Factory localVariableFactory, MappedParameter.Factory parameterFactory) {
		this.classFactory = classFactory;
		this.methodFactory = methodFactory;
		this.fieldFactory = fieldFactory;
		this.localVariableFactory = localVariableFactory;
		this.parameterFactory = parameterFactory;
	}

	public MappedClass.Factory getClassFactory() {
		return classFactory;
	}

	public MappedMethod.Factory getMethodFactory() {
		return methodFactory;
	}

	public MappedField.Factory getFieldFactory() {
		return fieldFactory;
	}

	public MappedLocalVariable.Factory getLocalVariableFactory() {
		return localVariableFactory;
	}

	public MappedParameter.Factory getParameterFactory() {
		return parameterFactory;
	}

	public static final class Builder {
		private MappedClass.Factory classFactory = MapFactories.CLASS;
		private MappedMethod.Factory methodFactory = MapFactories.METHOD;
		private MappedField.Factory fieldFactory = MapFactories.FIELD;
		private MappedLocalVariable.Factory localVariableFactory = MapFactories.LOCAL_VARIABLE;
		private MappedParameter.Factory parameterFactory = MapFactories.PARAMETER;

		Builder() {}

		public Builder classFactory(MappedClass.Factory factory) {
			classFactory = factory;
			return this;
		}

		public Builder methodFactory(MappedMethod.Factory factory) {
			methodFactory = factory;
			return this;
		}

		public Builder fieldFactory(MappedField.Factory factory) {
			fieldFactory = factory;
			return this;
		}

		public Builder localVariableFactory(MappedLocalVariable.Factory factory) {
			localVariableFactory = factory;
			return this;
		}

		public Builder parameterFactory(MappedParameter.Factory factory) {
			parameterFactory = factory;
			return this;
		}

		public MapModel build() {
			return new MapModel(classFactory, methodFactory, fieldFactory, localVariableFactory, parameterFactory);
		}
	}
}
