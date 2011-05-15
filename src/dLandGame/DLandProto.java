package dLandGame;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
public class DLandProto extends JApplet implements MouseMotionListener, KeyListener, Runnable, MouseListener {

	Graphics bufferGraphics;
	Image offscreen;
	Dimension dim;
	
	int xpos, ypos;
	int[] xco = new int[36], yco = new int[36], xlen = new int[36],
			ylen = new int[36], score = new int[36];
	boolean[] over = new boolean[36];
	boolean enter = false;
	TestMinigame tmg;
	JTextField username;
	JPanel mainPanel;
	
	
	public void init() {
		System.out.println("INITIALIZING");
		System.out.println("B");
		setLayout(null);
		try {
			tmg = new TestMinigame("TEST", new HighScore("JOE", 2));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setSize(600, 300);
		dim = getSize();
		for (int j = 0; j < 6; j++) {
			for (int k = 0; k < 6; k++) {
				if(j < 3 && k == 0) k++;
				int i = j * 6 + k;
				xco[i] = j * 100;
				yco[i] = k * 50;
				xlen[i] = 100;
				ylen[i] = 50;
			}
		}
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		username = new JTextField("Enter username here", 8);
		username.setBounds(30, 20, 250, 20);
		mainPanel.add(username);
		add(mainPanel);
		offscreen = createImage(dim.width, dim.height);
		bufferGraphics = offscreen.getGraphics();
		bufferGraphics.setColor(Color.BLACK);
		bufferGraphics.drawString("THE DLAND PROTOTYPE PROGRAM", 30, 10);
		bufferGraphics.drawString("" + tmg.getGameScore(), 270, 20);
		addMouseMotionListener(this);
		addKeyListener(this);
		addMouseListener(this);
		setFocusable(true);
	}

	private void unpaint() {
		bufferGraphics.clearRect(0, 0, getWidth(), getHeight());
		
	}

	public void update(Graphics g){
		System.out.println(username.getText());
		paint(g);
	}
	
	public void paint(Graphics g) {
		int mark = 1;
		for (int j = 0; j < 6; j++) {
			for (int k = 0; k < 6; k++) {
				int i = j * 6 + k;
				if (over[i])
					bufferGraphics.setColor(Color.RED);
				else
					bufferGraphics.setColor(Color.GREEN);
				bufferGraphics.fillRect(xco[i], yco[i], xlen[i], ylen[i]);
				bufferGraphics.setColor(Color.WHITE);
					bufferGraphics.drawString("" + mark, xco[i]+40, yco[i] + 40);
					mark++;
				//bufferGraphics.setColor(Color.blue);
				//bufferGraphics.drawString("(" + xpos + "," + ypos + ")", xpos, ypos);
			}
		}
		g.drawImage(offscreen,0,0,this);
	}

	public void mouseDragged(MouseEvent arg0) {
	}

	public void mouseMoved(MouseEvent me) {
		xpos = me.getX();
		ypos = me.getY();
		int a = xpos / 100;
		int b = ypos / 50;
		int i = a * 6 + b;
		for (int m = 0; m < 6; m++) {
			for (int n = 0; n < 6; n++) {
				if(m*6 + n==i){
					over[i] = true;
				} else {
					over[m*6+n] = false;
				}
			}
		}
		repaint();
	}

	public void mousePressed(MouseEvent me){
		System.out.println("HELLO");
		enter = true;
		for (int m = 0; m < 6; m++) {
			for (int n = 0; n < 6; n++) {
				int i = m*6 + n;
				if(over[i]){
					System.out.println("GOT IN HERE " + i);
					try {
						new TestMinigame("TEST", new HighScore("Sidd", 0));
						System.out.println("yup");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void mouseReleased(MouseEvent me){
		
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		if(ke.getKeyChar()== KeyEvent.VK_ENTER){
			System.out.println("HELLO");
			enter = true;
			for (int m = 0; m < 6; m++) {
				for (int n = 0; n < 6; n++) {
					int i = m*6 + n;
					if(over[i]){
						System.out.println("GOT IN HERE " + i);
						try {
							new TestMinigame("TEST", new HighScore("Sidd", 0));
							System.out.println("yup");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		if(ke.getKeyChar()== KeyEvent.VK_ENTER){
			//enter = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
