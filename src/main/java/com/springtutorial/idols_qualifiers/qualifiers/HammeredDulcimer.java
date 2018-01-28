package com.springtutorial.idols_qualifiers.qualifiers;


import com.springtutorial.idols_qualifiers.Instrument;

@StringedInstrument
public class HammeredDulcimer implements Instrument {
  public void play() {
    System.out.println("Ting ting ting");
  }
}
