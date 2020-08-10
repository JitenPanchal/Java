package com.jiten.junit5Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;

import com.jiten.junit5Mockito.data.api.ITodoService;
import com.jiten.junit5Mockito.data.api.TodoServiceImpl;

public class TodoBusinessImplMocikitoTests {

	@Test
	void test() {
		ITodoService todoServiceMock = mock(ITodoService.class);

		when(todoServiceMock.retrieveTodos("dummy"))
				.thenReturn(Arrays.asList("JUnit", "Mockito", "Spring 5", "EasyMock"));

		TodoServiceImpl todoServiceImpl = new TodoServiceImpl(todoServiceMock);

		List<String> todos = todoServiceImpl.retrieveTodosRelatedToSpring("dummy");

		verify(todoServiceMock).retrieveTodos(anyString());

		assertEquals(1, todos.size());
	}

	@Test
	void ListTest() {
		List listMock = mock(List.class);

		when(listMock.size()).thenReturn(2);

		assertEquals(2, listMock.size());
	}

	@Test
	void ListTest2() {
		List listMock = mock(List.class);

		when(listMock.size()).thenReturn(2).thenReturn(3);

		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(3, listMock.size());
	}

	@Test
	void ListTest3() {
		List listMock = mock(List.class);

		when(listMock.get(anyInt())).thenReturn("Jiten");

		assertEquals("Jiten", listMock.get(0));
	}

	@Test
	void ListTest4() {
		List listMock = mock(List.class);

		assertEquals(null, listMock.get(0));
	}

	@Test
	void ListTest5() {
		final List listMock = mock(List.class);

		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something failed"));

		assertThrows(RuntimeException.class, () -> listMock.get(0));
	}
}