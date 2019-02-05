package br.com.projeto.interfaces;

import java.util.List;

public interface AppBO<T> {

	default void save(T t) {
	}

	default List<T> all() {
		return null;
	}

	default void remove(T t) {
	}

	default List<T> selected(String value) {
		return null;
	}

	default T get(Long id) {
		return null;
	}

}
