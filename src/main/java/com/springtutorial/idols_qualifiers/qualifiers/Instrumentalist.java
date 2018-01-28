package com.springtutorial.idols_qualifiers.qualifiers;

import com.springtutorial.idols_qualifiers.Instrument;
import com.springtutorial.idols_qualifiers.PerformanceException;
import com.springtutorial.idols_qualifiers.Performer;

import com.springtutorial.idols_qualifiers.Strummed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Instrumentalist implements Performer {
    public void perform() throws PerformanceException {
        getInstrument().play();
    }

    public Instrument getInstrument() {
        return instrument;
    }

    //<start id="autowire_property" />
    @Autowired
    @StringedInstrument
    @Strummed
    private Instrument instrument;
    //<end id="autowire_property" />

}