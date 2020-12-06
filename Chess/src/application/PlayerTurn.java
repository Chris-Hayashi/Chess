package application;

public class PlayerTurn {
	private boolean whiteTurn;
	
	public PlayerTurn() {
		this.whiteTurn = true;
	}
	
	public Boolean getWhiteTurn() {
		return this.whiteTurn;
	}
	
	public void setWhiteTurn(boolean whiteTurn) {
		this.whiteTurn = whiteTurn;
	}
}
