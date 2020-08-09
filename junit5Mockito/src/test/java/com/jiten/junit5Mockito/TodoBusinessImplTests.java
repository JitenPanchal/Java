package com.jiten.junit5Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.jiten.junit5Mockito.data.api.ITodoService;
import com.jiten.junit5Mockito.data.api.TodoServiceImpl;
import com.jiten.junit5Mockito.data.api.TodoServiceStub;


public class TodoBusinessImplTests {

	@Test
	void test() {
		ITodoService todoServiceStub = new TodoServiceStub();
		TodoServiceImpl todoServiceImpl = new TodoServiceImpl(todoServiceStub);

		List<String> todos = todoServiceImpl.retrieveTodosRelatedToSpring("dummy");

		assertEquals(1, todos.size());
	}
}