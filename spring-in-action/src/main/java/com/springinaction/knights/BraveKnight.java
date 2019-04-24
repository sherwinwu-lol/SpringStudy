package com.springinaction.knights;

import com.springinaction.quest.Quest;

public class BraveKnight implements Knight {
    private Quest quest;

    //构造器注入
    // ## 关键没有和任何特定的Quest实现发生耦合
    public BraveKnight(Quest quest) {
        this.quest = quest;
    }
    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
