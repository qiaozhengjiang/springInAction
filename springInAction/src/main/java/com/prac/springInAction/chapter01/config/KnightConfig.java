package com.prac.springInAction.chapter01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prac.springInAction.chapter01.bean.BraveKnight;
import com.prac.springInAction.chapter01.bean.SlayDragonQuest;
import com.prac.springInAction.chapter01.inter.Knight;
import com.prac.springInAction.chapter01.inter.Quest;

@Configuration
public class KnightConfig {
	@Bean
	public Knight knight() {
		return new BraveKnight(quest());
	}
	@Bean
	public Quest quest() {
		return new SlayDragonQuest(System.out);
	}
}
