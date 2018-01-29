package com.springtutorial.idols.qualifiers;

import com.springtutorial.idols.Instrument;

@StringedInstrument
public class HammeredDulcimer implements Instrument {
  public void play() {
    System.out.println("Ting ting ting");
  }
}
