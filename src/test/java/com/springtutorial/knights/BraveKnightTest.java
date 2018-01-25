package com.springtutorial.knights;

import static org.mockito.Mockito.*;

import com.springtutorial.knights.BraveKnight;
import com.springtutorial.knights.Quest;
import com.springtutorial.knights.QuestException;
import org.junit.Test;

public class BraveKnightTest {
    @Test
    public void knightShouldEmbarkOnQuest() throws QuestException {
        Quest mockQuest = mock(Quest.class);     //<co id="co_createMockQuest"/>

        BraveKnight knight = new BraveKnight(mockQuest); //<co id="co_injectMockQuest"/>
        knight.embarkOnQuest();

        verify(mockQuest, times(1)).embark();
    }
}
