package com.springtutorial.idols_qualifiers.qualifiers;

import com.springtutorial.idols_qualifiers.Instrument;
import com.springtutorial.idols_qualifiers.Strummed;

@StringedInstrument
@Strummed
public class Guitar implements Instrument {
  public void play() {
    System.out.println("Strum strum strum");
  }
}
