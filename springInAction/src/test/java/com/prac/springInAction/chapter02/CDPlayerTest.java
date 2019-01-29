package com.prac.springInAction.chapter02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prac.springInAction.chapter02.config.CDPlayerConfig;
import com.prac.springInAction.chapter02.inter.CompactDisc;
import com.prac.springInAction.chapter02.inter.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {
	@Rule
	public final StandardOutputStreamLog log=new StandardOutputStreamLog();
	@Autowired
	private CompactDisc cd;
	@Autowired
	private MediaPlayer player;
	@Test
	public void cdShouldNotBeBull() {
		cd.play();
		assertNotNull(cd);
	}
	@Test
	public void play() {
		player.play();
		assertEquals("Playing sgt. pepper's lonely hearts club band by The Beatles\n",log.getLog());
	}
}
