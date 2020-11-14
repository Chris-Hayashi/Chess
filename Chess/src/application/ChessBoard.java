public class ChessBoard {
	public static void startBoard(){
        int[][] board = new int[8][8];
        board[0][0] = 2; //white rook temp
        board[1][0] = 3; //white knight temp
        board[2][0] = 4; //white bishop temp
        board[3][0] = 5; //white queen temp
        board[4][0] = 6; //white king temp
        board[5][0] = 4; //white bishop temp
        board[6][0] = 3; //white knight temp
        board[7][0] = 2; //white rook temp

        board[0][7] = 2; //black rook temp
        board[1][7] = 3; //black knight temp
        board[2][7] = 4; //black bishop temp
        board[3][7] = 5; //black queen temp
        board[4][7] = 6; //black king temp
        board[5][7] = 4; //black bishop temp
        board[6][7] = 3; //black knight temp
        board[7][7] = 2; //black rook temp

        for(int x=0; x<8; x++){
            board[x][1] = 1; //white pawn temp
        }
        for(int x=0; x<8; x++){
            board[x][6] = 1; //white pawn temp
        }
        for(int y=2; y<5; y++){ //y coordinate
            for(int x=0; x<8; x++){ //x coordinate
                board[x][y] = 0; //empty space (should be set to null)
            }
        }

		for(int y=0; y<8; y++) { //for testing
            for (int x = 0; x < 8; x++) {
                System.out.print (board[x][y] + " ");
            }
            System.out.println ();
        }
}
