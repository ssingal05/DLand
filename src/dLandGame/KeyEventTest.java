package dLandGame;

import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventTest extends Applet implements KeyListener {
	
	public void init(){
		addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()==KeyEvent.VK_ENTER) System.out.println("HELLO");
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
