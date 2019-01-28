package com.prac.springInAction.chapter01;


import org.junit.Test;
import static org.mockito.Mockito.*;

import com.prac.springInAction.chapter01.bean.BraveKnight;
import com.prac.springInAction.chapter01.inter.Quest;

public class BraveKnightTest {
	@Test
	public void knightShouldEmbarkOnQuest() {
		Quest mockQuest=mock(Quest.class);
		BraveKnight knight=new BraveKnight(mockQuest);
		knight.embarkOnQuest();
		verify(mockQuest,times(1)).embark();
		
	}
}
