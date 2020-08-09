package com.jiten.junit5Mockito.data.api;

import java.util.List;

public interface ITodoService {
	public List<String> retrieveTodos(String user);

	void deleteTodo(String todo);
}
