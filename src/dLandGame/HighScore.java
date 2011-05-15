package dLandGame;

public class HighScore {

	private String myName;
	private int myScore;
	
	public HighScore(){
		myName = null;
		myScore = 0;
	}
	
	public HighScore(String n, int s){
		myName = n;
		myScore = s;
	}
	
	public String getName(){
		return myName;
	}
	
	public int getScore(){
		return myScore;
	}
	
	public void setName(String n){
		myName = n;
	}
	
	public void setScore(int s){
		myScore = s;
	}
	
	public String toString(){
		return "NAME: " + getName() + "\t  SCORE: " + getScore();
	}
	
}
