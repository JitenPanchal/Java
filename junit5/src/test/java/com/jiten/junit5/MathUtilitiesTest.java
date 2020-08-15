package com.jiten.junit5;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Running maths tests")
class MathUtilitiesTest {

	MathUtilities mathUtilities;
	private TestInfo testInfo;
	private TestReporter testReporter;

	@BeforeEach
	void beforeEach(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		System.out.println("beforeEach");
		mathUtilities = new MathUtilities();
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
	}

	@BeforeAll
	public static void beforeAll() {
		System.out.println("beforeAll");
	}

	@AfterEach
	void afterEach() {
		System.out.println("afterEach");
	}

	@BeforeAll
	public static void afterAll() {
		System.out.println("afterAll");
	}

	@Nested
	class TestAddMethod {
		@Test
		@DisplayName("testing add with 1,1")
		void testAdd() {
			boolean assumption = true;
			assumeTrue(assumption);
			assertEquals(21, mathUtilities.add(1, 1), () -> "this should add 2 numbers with assumtion true");
			System.out.println(this);
		}
	}

	@RepeatedTest(3)
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtilities.divide(1, 0));
		System.out.println(this);
	}

	@Test
	void testMultiply() {
		assertAll(() -> assertEquals(1, mathUtilities.multiply(1, 1)),
				() -> assertEquals(4, mathUtilities.multiply(2, 2)),
				() -> assertEquals(9, mathUtilities.multiply(3, 3)),
				() -> assertEquals(18, mathUtilities.multiply(6, 3)));
	}

	@RepeatedTest(3)
	@DisplayName("testMultiplyWithRepeated")
	void testMultiplyWithRepeated(RepetitionInfo repetitionInfo) {

		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());

		assertEquals(repetitionInfo.getCurrentRepetition() * repetitionInfo.getCurrentRepetition(),
				mathUtilities.multiply(repetitionInfo.getCurrentRepetition(), repetitionInfo.getCurrentRepetition()));

	}

	@Test
	@Disabled
	@DisplayName("testDivide")
	void testDivideDisabled() {
		fail("Mathod is disabled should not run");
	}

	@Test
	@EnabledOnOs(OS.LINUX)
	void computeCircleArea() {
		assertEquals(314.1592653589793, mathUtilities.computeCircleArea(10), "should return circle area");
		System.out.println(this);
	}
}