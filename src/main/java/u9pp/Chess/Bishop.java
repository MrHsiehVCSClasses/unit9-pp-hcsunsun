package u9pp.Chess;


public class Bishop extends ChessPiece{

    public Bishop(ChessPiece[][] boardE, int rowE, int colE, boolean isWhiteE){
        super(boardE, rowE, colE, isWhiteE);
    }

    public boolean canMoveTo(int r, int c){

        if(super.canMoveTo(r, c)){
            if(this.onDiagonal(r, c)){
                if(this.noDiagonalBlocking(r, c)){
                    return true;
                }
            }
        }
        return false;
    }

    public String toString()
    {
        String color = "b";
        if(this.isWhite){
            color = "B";
        }
        return color;
    }
}