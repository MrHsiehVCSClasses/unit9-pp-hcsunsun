package u9pp.Chess;

public class King extends ChessPiece{

    //instance

    //constructor
    public King(ChessPiece[][] boardE, int rowE, int colE, boolean isWhiteE){
        super(boardE, rowE, colE, isWhiteE);

    }

    //methods
    public boolean canMoveTo(int rowE, int colE){
        if(super.canMoveTo(rowE, colE)){
            if(noKing(rowE, colE)){
                if((rowE + 1 == this.row || rowE == this.row || rowE - 1 == this.row) && (colE + 1 == this.col || colE == this.col || colE - 1 == this.col)){
                        return true;
                }
            }
        }
        return false;
    }

    public String toString()
    {
        String color = "k";
        if(this.isWhite){
            color = "K";
        }
        return color;
    }

    public boolean noKing(int rowE, int colE){

        for(int r = rowE - 1; r < rowE + 2; r++){
            for(int c = colE - 1; c < colE + 2; c++){
                if(boundaryCheck(r, c)){
                    if(board[r][c] != null && board[r][c] instanceof King && board[r][c] != this){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}