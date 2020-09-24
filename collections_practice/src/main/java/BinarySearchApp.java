import java.util.Arrays;

public class BinarySearchApp {

	public static void main(String[] args) {

		Person[] people = new Person[] { new Person(10, "Vristi"), new Person(2, "Krishni"), new Person(40, "Jiten"),
				new Person(36, "Prexa") };

		Arrays.sort(people);

		System.out.println(Arrays.toString(people));

		int i = Arrays.binarySearch(people, new Person(36, "Prexa"));

		System.out.println(i);
		
		if (!(null instanceof Integer)) {
			System.out.println("not");
		}

	}
}

class Person implements Comparable<Person> {
	private int age;
	private String name;
	private static final Integer x;
	private final int p;
	private final Integer MAX_VALUE;
	
	{
	}

	static {
		x = new Integer("5");
	}
	public Person(int age) {
		super();
		this.age = age;
		this.name = "";
		p = 6;
		MAX_VALUE=5;
	}
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
		p = 6;
		MAX_VALUE=null;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]" + "-" + x;
	}

	@Override
	public int compareTo(Person o) {
		return this.age - o.age;
	}

}

/*
 * 
 * Company has 23K client all over the world Also it's providing services to 22
 * global banks so client base is strong
 * 
 * As the company is planning to add more than 150 developers to UK team that
 * means company has plans to add more products & features that means lot more
 * challenges
 * 
 * looking for Long term change
 * 
 * 
 * Ask Salary for this position
 * 
 * 
 * 
 * 
 */