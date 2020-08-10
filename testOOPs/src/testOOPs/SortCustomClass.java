package testOOPs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCustomClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Person> list = new ArrayList<>();

		list.add(new Person("Jiten", 40));
		list.add(new Person("Prexa", 22));

		Collections.sort(list);
		
		System.out.println(list);

	}

	static class Person implements Comparable<Person> {
		String name;
		int age;

		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		@Override
		public int compareTo(Person o) {
			return o.age - this.age;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (age != other.age)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}

	}
}
