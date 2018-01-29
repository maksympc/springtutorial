package com.springtutorial.idols.qualifiers;

import com.springtutorial.idols.Instrument;
import com.springtutorial.idols.Strummed;

@StringedInstrument
@Strummed
public class Guitar implements Instrument {
  public void play() {
    System.out.println("Strum strum strum");
  }
}
