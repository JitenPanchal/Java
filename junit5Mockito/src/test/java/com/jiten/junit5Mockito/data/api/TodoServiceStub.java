package com.jiten.junit5Mockito.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements ITodoService {

	public List<String> retrieveTodos(String user) {
		return Arrays.asList("JUnit","Mockito", "Spring 5");
	}

	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
