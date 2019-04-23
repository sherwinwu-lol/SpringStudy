package com.springinaction.knights;

import com.springinaction.quest.RescueDamseQuest;

public class DamselRescuingKnight implements Knight {
    private RescueDamseQuest quest;

    //与RescueDamseQuest紧耦合
    public DamselRescuingKnight() {
        this.quest = new RescueDamseQuest();
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
