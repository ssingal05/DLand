package dLandGame;

public class RankedHighScore extends HighScore {
	
	private int myRank;
	
	public RankedHighScore(){
		super();
		myRank = 0;
	}
	
	public RankedHighScore(int r, HighScore hs){
		super(hs.getName(), hs.getScore());
		myRank = r;
	}
	
	public RankedHighScore(int r, String n, int s){
		super(n, s);
		myRank = r;
	}
	
	public int getRank(){
		return myRank;
	}
	
}
