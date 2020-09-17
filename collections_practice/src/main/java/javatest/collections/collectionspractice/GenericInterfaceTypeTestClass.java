package javatest.collections.collectionspractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

interface GenericInterfaceTypeTest<T extends BaseClass> {

	T run();
}

abstract class BaseClass {
	abstract String getName();
}

class DerivedClassA extends BaseClass {
	public String getName() {
		return "a";
	}
}

class DerivedClassB extends BaseClass {
	public String getName() {
		return "b";
	}
}

public class GenericInterfaceTypeTestClass {
	public static void main(String[] args) {
CopyOnWriteArrayList<String> p;

Collections.synchronizedCollection(Arrays.asList("1"));
	}

	
	static Supplier<String> incrementer(String start) {
		return () -> start + "rr";
	}

	boolean run = true;

	public void localVariableMultithreading() {

		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> {
			while (run) {
				// do operation
			}
		});

		run = false;
	}
}