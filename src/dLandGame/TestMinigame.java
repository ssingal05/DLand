package dLandGame;

import java.awt.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.Applet;

public class TestMinigame extends Minigame implements Runnable {

	
	Thread t;
	
	public TestMinigame() throws IOException {
		super("TEST", new HighScore("Joe", 23));
	}

	public TestMinigame(String gid, HighScore phs) throws IOException {
		super(gid, phs);
		t = new Thread(this, "Thread");
		t.start();

	}

	public void init() {
		Button button = new Button("OK");
		add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setGameScore(10000);
			}
		});
	}
	
	public void run() {
		init();
	}
}
