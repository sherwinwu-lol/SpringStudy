package com.springinaction.knights;

import com.springinaction.quest.Quest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.mockito.Mockito.*;


public class BraveKnightTest {
    @Resource
    private Quest quest;
    @Test
    public void embarkOnQuest() throws Exception {
        Quest mockQuest = mock(Quest.class);
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }

    @Test
    public void test() {
        quest.embark();
    }

}