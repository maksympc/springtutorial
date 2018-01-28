package com.springtutorial.idols_qualifiers;

import static org.junit.Assert.*;

import com.springtutorial.idols_qualifiers.qualifiers.StringedInstrument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/resources/spring-idol-qualifier.xml"})
public class AnnotationConfigTest {
  @Autowired
  @Qualifier("eddie")
  private Instrumentalist eddie;

  @Autowired
  @StringedInstrument
  @Strummed
  private Instrument guitar;

  @Test
  public void shouldWireWithAutowire() {
    assertNotNull(eddie.getInstrument());
    assertEquals(guitar, eddie.getInstrument());
  }
}