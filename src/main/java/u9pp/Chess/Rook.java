package u9pp.Chess;

public class Rook extends ChessPiece{

    public Rook(ChessPiece[][] boardE, int rowE, int colE, boolean isWhiteE){
        super(boardE, rowE, colE, isWhiteE);
    }

    public boolean canMoveTo(int r, int c){

        if(super.canMoveTo(r, c)){   
            if(this.onHoriOrVerti(r, c)){
                if(this.noHVBlocking(r, c)){
                    return true;
                }
            }
        }
        return false;
    }

    public String toString()
    {
        String color = "r";
        if(this.isWhite){
            color = "R";
        }
        return color;
    }
}