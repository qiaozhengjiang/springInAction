package com.prac.springInAction.chapter02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prac.springInAction.chapter02.bean.CDPlayer;
import com.prac.springInAction.chapter02.bean.SgtPeppers;
import com.prac.springInAction.chapter02.inter.CompactDisc;

@Configuration
//@ComponentScan(basePackages= {"com.prac.springInAction.chapter02","com.prac.springInAction.chapter01"})
public class CDPlayerConfig {
	@Bean
	public CompactDisc sgtPeppers() {
		return new SgtPeppers();
	}
	@Bean
	public CDPlayer cdPlayer() {
		return new CDPlayer(sgtPeppers());
	}
}
