package com.hcl.interviews;

import static com.hcl.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.junit.Test;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing
 * stories. You will notice the TimeConverter has no implementation ... (hint)
 */
public class RomanNumberConverterFixture {

	int number = 400;
	RomanNumberConverter romanNumberConverter=new RomanNumberConverter();

	@Test
	public void numberToRomanAcceptanceTests() throws Exception {
		aBehaviouralTestRunner().usingStepsFrom(this).withStory("roman-number-converter.story").run();
	}

	@When("input number is $number")
	public void whenLimitIs(int number) {
		this.number=number;
	}

	@Then("corresponding roman representation is $romanValue")
	public void thenCorrespondingRomanRepresentationIs(String romanValue) {
		String result=romanNumberConverter.convertNumberToRoman(number);
		Assert.assertEquals(romanValue, result);
	}

}
