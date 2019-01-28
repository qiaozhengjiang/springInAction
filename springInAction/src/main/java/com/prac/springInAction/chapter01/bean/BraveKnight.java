package com.prac.springInAction.chapter01.bean;

import com.prac.springInAction.chapter01.inter.Knight;
import com.prac.springInAction.chapter01.inter.Quest;

public class BraveKnight implements Knight {
	private Quest quest;
	public BraveKnight(Quest quest) {
		this.quest=quest;
	}
	public void embarkOnQuest() {
		quest.embark();
	}
}
