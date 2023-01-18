package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DemoApplicationTests
{
	@Test
    public void contextLoads()
    {
		System.out.println("Great, context loaded.");
    }
	
	@Test
	public void testAddNumbers()
	{
		int res = DemoApplication.addNumbers(2, 5);
		assertThat(res).isEqualTo(2+5);
	}
}
