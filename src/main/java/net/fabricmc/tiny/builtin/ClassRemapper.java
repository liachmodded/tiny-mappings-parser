package net.fabricmc.tiny.builtin;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

// not thread safe!
public final class ClassRemapper {

	private final Map<String, String[]> mappings;
	final int namespaceCount;
	final ToIntFunction<String> indexer;
	boolean ready;

	ClassRemapper(int namespaceCount, ToIntFunction<String> indexer) {
		this.mappings = new HashMap<>();
		this.indexer = indexer;
		this.namespaceCount = namespaceCount;
		this.ready = false;
	}

	void markReady() {
		this.ready = true;
	}

	void register(String[] names) {
		register(names, 0);
	}

	private void register(String[] names, int index) {
		if (ready)
			throw new IllegalStateException("Already initialized");
		mappings.put(names[index], names);
	}

	String remap(String old, String namespace) {
		return remap(old, indexer.applyAsInt(namespace));
	}

	String remap(String old, int index) {
		if (!ready)
			throw new IllegalStateException("Not yet initialized");
		String[] arr = mappings.get(old);
		return arr == null ? old : arr[index];
	}

	String remapDesc(String oldDesc, String namespace) {
		return remapDesc(oldDesc, indexer.applyAsInt(namespace));
	}

	String remapDesc(String oldDesc, int index) {
		final int len = oldDesc.length();
		final StringBuilder ret = new StringBuilder((int) (len * 1.2)); // guess a cap?
		int lastL = -1;
		for (int i = 0; i < len; i++) {
			final char c = oldDesc.charAt(i);
			if (lastL == -1) {
				if (c == 'L') {
					lastL = i;
				}
				ret.append(c);
			} else {
				if (c == ';') {
					// remap
					ret.append(remap(oldDesc.substring(lastL + 1, i), index));
					ret.append(';');
					lastL = -1;
				}
				// skip
			}
		}

		return ret.toString();
	}
}
