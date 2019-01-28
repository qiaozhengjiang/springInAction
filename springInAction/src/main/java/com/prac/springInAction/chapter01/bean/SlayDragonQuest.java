package com.prac.springInAction.chapter01.bean;

import java.io.PrintStream;

import com.prac.springInAction.chapter01.inter.Quest;

public class SlayDragonQuest implements Quest {
	private PrintStream stream;
	public SlayDragonQuest(PrintStream stream) {
		this.stream=stream;
	}
	public void embark() {
		stream.println("Embarking on quest to slay the dragon");

	}

}
