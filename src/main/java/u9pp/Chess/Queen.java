package u9pp.Chess;

public class Queen extends ChessPiece{

    public Queen(ChessPiece[][] boardE, int rowE, int colE, boolean isWhiteE){
        super(boardE, rowE, colE, isWhiteE);
    }

    public boolean canMoveTo(int r, int c){

        if(super.canMoveTo(r, c)){
            if(this.onDiagonal(r, c)){
                if(this.noDiagonalBlocking(r, c)){
                    return true;
                }
            }else if(this.onHoriOrVerti(r, c)){
                if(this.noHVBlocking(r, c)){
                    return true;
                }

            }
        }
        return false;
    }

    public String toString()
    {
        String color = "q";
        if(this.isWhite){
            color = "Q";
        }
        return color;
    }
}