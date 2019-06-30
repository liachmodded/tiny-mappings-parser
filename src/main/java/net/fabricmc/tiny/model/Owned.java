package net.fabricmc.tiny.model;

public interface Owned<T extends Mappable<?>> {

	T getOwner();
}
