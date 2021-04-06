package edu.ucsb.cs156.spring.backenddemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ApplicationTests {
  @Test
  public void applicationStarts() {
    Application.main(new String[] {});
  }
}