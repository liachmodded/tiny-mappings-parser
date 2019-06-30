package net.fabricmc.tiny.model;

public interface TinyVisitor {

	void visitClass(TinyClass tinyClass);

	void visitClassComment(TinyClass tinyClass, String comment);

	void visitField(TinyField tinyField);

	void visitFieldComment(TinyField tinyField, String comment);

	void visitMethod(TinyMethod tinyMethod);

	void visitMethodComment(TinyMethod tinyMethod, String comment);

	void visitParameter(TinyParameter tinyParameter);

	void visitParameterComment(TinyParameter tinyParameter, String comment);

	void visitLocalVariable(TinyLocalVariable tinyLocalVariable);
}
