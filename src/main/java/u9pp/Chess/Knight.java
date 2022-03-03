package u9pp.Chess;

public class Knight extends ChessPiece{

    //constructor
    public Knight(ChessPiece[][] boardE, int rowE, int colE, boolean isWhiteE){
        super(boardE, rowE, colE, isWhiteE);
    }

    //methods
    public boolean canMoveTo(int r, int c){
        if(super.canMoveTo(r, c)){
            if(isIt2by1(r, c)){
                return true;
            }
        }
        return false;
    }

    public boolean isIt2by1(int r, int c){
        int diffR = Math.abs(this.row - r);
        int diffC = Math.abs(this.col - c);

        if ((diffR == 2 && diffC == 1) || (diffR == 1 && diffC == 2)){
            return true;
        }
        return false;
    }

    public String toString()
    {
        String color = "n";
        if(this.isWhite){
            color = "N";
        }
        return color;
    }
}
