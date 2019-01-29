package com.prac.springInAction.chapter02.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prac.springInAction.chapter02.inter.CompactDisc;
import com.prac.springInAction.chapter02.inter.MediaPlayer;
@Component
public class CDPlayer implements MediaPlayer {
	private CompactDisc cd;
	//@Autowired
	public CDPlayer(CompactDisc cd) {
		this.cd=cd;
	}
	public void play() {
		cd.play();
	}

}
