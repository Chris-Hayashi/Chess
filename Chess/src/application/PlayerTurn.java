package application;

public class PlayerTurn {
	private Boolean whiteTurn;
	
	public PlayerTurn() {
		this.whiteTurn = true;
	}
	
	public Boolean getWhiteTurn() {
		return this.whiteTurn;
	}
	
	public void setWhiteTurn(Boolean whiteTurn) {
		this.whiteTurn = whiteTurn;
	}
}
