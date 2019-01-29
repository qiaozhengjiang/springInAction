package com.prac.springInAction.chapter02.bean;

import org.springframework.stereotype.Component;

import com.prac.springInAction.chapter02.inter.CompactDisc;
@Component
public class SgtPeppers implements CompactDisc{
	private String title="sgt. pepper's lonely hearts club band";
	private String artist="The Beatles";
	public void play() {
		System.out.println("Playing "+title+" by "+artist);
	}
}
