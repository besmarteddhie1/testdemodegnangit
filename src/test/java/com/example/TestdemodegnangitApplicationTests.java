package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestdemodegnangitApplicationTests {

	@Test
	public void contextLoads() {
		Random random = new Random();

		System.out.println(random);


	}

}
