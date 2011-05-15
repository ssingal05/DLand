package dLandGame;

import java.applet.*;
import java.awt.Button;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;

public class Minigame extends Applet {

	int myGameScore;
	private String myGameID;
	private HighScore myPersonalHighScore;
	private String myGlobalHighScoreFile;
	private ArrayList<RankedHighScore> myGlobalHighScore = new ArrayList<RankedHighScore>();
	
	public Minigame(String gid, HighScore phs) throws IOException {
		myGameScore = 0;
		myGameID = gid;
		myPersonalHighScore = phs;
		myGlobalHighScoreFile = myGameID.toLowerCase() + ".ghs";
	    BufferedReader f = new BufferedReader(new FileReader(myGlobalHighScoreFile));
	    StringTokenizer st;
	    for(int i = 0; i < 10; i++){
	    	st = new StringTokenizer(f.readLine());
	    	String username = st.nextToken();
	    	st = new StringTokenizer(f.readLine());
	    	int score = Integer.parseInt(st.nextToken());
	    	myGlobalHighScore.add(new RankedHighScore(i+1, username, score));
	    }
	}
	
	public int getGameScore(){
		return myGameScore;
	}
	
	public void setGameScore(int score){
		myGameScore = score;
	}
	
	public String getGameID(){
		return myGameID;
	}
	
	public HighScore getPersonalHighScore(){
		return myPersonalHighScore;
	}
	
	public String updateGlobalHighScore(){
		int rank = 1;
		boolean unranked = true;
		while(rank <= 10 && unranked){
			if(getPersonalHighScore().getScore() < myGlobalHighScore.get(rank-1).getScore()){
				unranked = false;
				myGlobalHighScore.remove(9);
				if(rank==9)myGlobalHighScore.add(new RankedHighScore(rank, getPersonalHighScore()));
				else myGlobalHighScore.add(rank-1, new RankedHighScore(rank, getPersonalHighScore()));
			} else rank++;
		}
		if(unranked) return "Sorry! You did not make the highscore list. Please try again!";
		else return "WOW! You are rank number " + rank + " on the global leaderboards! Nice job!";
	}
	
	public RankedHighScore getGlobalHighScore(int index){
		return myGlobalHighScore.get(index);
	}
	
	public String updatePersonalHighScore(int score) {
		if(score > getPersonalHighScore().getScore()){ 
			myPersonalHighScore.setScore(score);
			return "You have beaten your previous record! Too good.";
		} else
			return "Aw you were only " + (getPersonalHighScore().getScore() - score + 1) + " points away from beating your record =(";
	}

	
}
