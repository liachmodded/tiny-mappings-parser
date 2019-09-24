/*
 * Copyright 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.mapping.util;

import net.fabricmc.mapping.tree.*;
import net.fabricmc.mapping.util.MethodData;
import org.objectweb.asm.commons.Remapper;

import net.fabricmc.mappings.*;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class AsmRemapperFactory {

	private static final class SimpleRemapper extends Remapper {
		private final Map<String, String> classNames = new HashMap<>();
		private final Map<EntryTriple, String> fieldNames = new HashMap<>();
		private final Map<EntryTriple, String> methodNames = new HashMap<>();

		SimpleRemapper(Collection<ClassDef> classes, String from, String to) {
			for (ClassDef clz : classes) {
				String className = clz.getName(from);
				classNames.put(className, clz.getName(to));
				for (FieldDef field : clz.getFields()) {
					fieldNames.put(new EntryTriple(className, field.getName(from), field.getSignature(from)), field.getName(to));
				}
				for (MethodDef method : clz.getMethods()) {
					methodNames.put(new EntryTriple(className, method.getName(from), method.getSignature(from)), method.getName(to));
				}
			}
		}

		@Override
		public String map(String typeName) {
			return classNames.getOrDefault(typeName, typeName);
		}

		@Override
		public String mapFieldName(final String owner, final String name, final String descriptor) {
			return fieldNames.getOrDefault(new EntryTriple(owner, name, descriptor), name);
		}

		@Override
		public String mapMethodName(final String owner, final String name, final String descriptor) {
			return methodNames.getOrDefault(new EntryTriple(owner, name, descriptor), name);
		}
	}

	private final Map<String, SoftReference<SimpleRemapper>> remapperCache = new HashMap<>();
	private final TinyMapping mapping;

	public AsmRemapperFactory(TinyMapping mapping) {
		this.mapping = mapping;
	}

	public Remapper getRemapper(String from, String to) {
		String key = from + ":" + to;
		SoftReference<SimpleRemapper> remapperRef = remapperCache.get(key);
		if (remapperRef != null && remapperRef.get() != null) {
			return remapperRef.get();
		} else {
			SimpleRemapper remapper = new SimpleRemapper(mapping.getClasses(), from, to);
			remapperCache.put(key, new SoftReference<>(remapper));
			return remapper;
		}
	}
}
