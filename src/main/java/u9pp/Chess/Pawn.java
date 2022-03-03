package u9pp.Chess;

public class Pawn extends ChessPiece{

    //instance
    private boolean firstTurn;
    private int direction = 1;
    //constructor
    public Pawn(ChessPiece[][] boardE, int rowE, int colE, boolean isWhiteE){
        super(boardE, rowE, colE, isWhiteE);
        firstTurn = true;
    }

    public boolean canMoveTo(int r, int c){

        //direction set
        if(this.isWhite){
            direction = -1;
        }


        if(super.canMoveTo(r, c)){



            //when entered row is just 1 in the direction
            if(r == this.row + direction){
                if(c == this.col){
                    if(board[r][c] == null){
                        return true;
                    }
                    
                }
                //diagnal 
                else if(c == this.col + 1 || c == this.col - 1){
                    if(board[r][c] != null && board[r][c].isWhite() != this.isWhite()){
                        return true;
                    }
                }
                
            }
            //when entered row is more than 1 grid 
            if((r == this.row + 2 * direction) && firstTurn && c == this.col ){
                if(board[r][c] == null && board[r - direction][c] == null){
                    return true;
                }
            }



            
        }
        return false;
    }
    
    public void doMove(int rowTo, int colTo)
    {
        super.doMove(rowTo, colTo);
        firstTurn = false;
    }

    public String toString()
    {
        String color = "p";
        if(this.isWhite){
            color = "P";
        }
        return color;
    }
}