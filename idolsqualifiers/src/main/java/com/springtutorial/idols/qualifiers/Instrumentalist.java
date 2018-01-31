package com.springtutorial.idols.qualifiers;


import com.springtutorial.idols.Instrument;
import com.springtutorial.idols.PerformanceException;
import com.springtutorial.idols.Performer;
import com.springtutorial.idols.Strummed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("eddie")
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