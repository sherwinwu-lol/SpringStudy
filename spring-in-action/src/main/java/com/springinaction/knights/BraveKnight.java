package com.springinaction.knights;

import com.springinaction.quest.Quest;

public class BraveKnight implements Knight {
    private Quest quest;

    //构造器注入
    public BraveKnight(Quest quest) {
        this.quest = quest;
    }
    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
