package u9pp.Chess;

public class ChessPiece{
    //instance
    public int row;
    public int col;
    public boolean isWhite;
    public ChessPiece[][] board;

    //constructor
    public ChessPiece(ChessPiece[][] boardE, int rowE, int colE, boolean isWhiteE){
        row = rowE;
        col = colE;
        isWhite = isWhiteE;
        board = boardE;
    }

    //methods
    public boolean canMoveTo(int rowE, int colE){
        if(boundaryCheck(rowE, colE)){
            if(this.notOwnColor(rowE, colE)){
                if(this.notCurrentGrid(rowE, colE)){
                    return true;
                }
            }
        }
        return false;
    }

    public void doMove(int rowTo, int colTo){
        board[rowTo][colTo] = board[row][col];
        board[row][col] = null;
    }

    public boolean isWhite(){
        return isWhite;
    }

    //own method
    public boolean boundaryCheck(int rowE, int colE){
        if((rowE < board.length && rowE >= 0) && (colE < board[rowE].length && colE >= 0)){
            return true;
        }
        return false;
    }

    public boolean notOwnColor(int rowE, int colE){
        if(board[rowE][colE] == null || board[rowE][colE].isWhite() != this.isWhite()){
            return true;
        }
        else return false;
    }
    
    public boolean notCurrentGrid(int rowE, int colE){
        if(rowE == this.row && colE == this.col){
            return false;
        }
        return true;
    }

    public boolean onDiagonal(int r, int c){
        int distRow = Math.abs(this.row - r);
        int distCol = Math.abs(this.col - c);
        if(distCol == distRow){
            return true;
        }
        
        return false;
    }

    public boolean onHoriOrVerti(int r, int c){
        int distRow = this.row - r;
        int distCol = this.col - c;
        if(distRow == 0 || distCol == 0){
            return true;
        }
        return false;
    }

    public boolean noDiagonalBlocking(int rT, int cT){
        int rDirection = 1;
        int cDirection = 1;

        //drection set
        if(this.row - rT > 0){rDirection = -1;}
        if(this.col - cT > 0){cDirection = -1;}

        //loop
        for(int currRow = this.row + rDirection; currRow != rT; currRow += rDirection){
            for(int currCol = this.col + cDirection; currCol != cT; currCol += cDirection){
                if(this.onDiagonal(currRow, currCol) && board[currRow][currCol] != null){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean noHVBlocking(int rT, int cT){
        
        System.out.println("reaches noHVBlicking");
        int distRow = this.row - rT;
        int distCol = this.col - cT;

        //for vertical check
        int rDirection = 1;
        if(this.row - rT > 0){rDirection = -1;}

        if(distRow != 0){
            System.out.println("distRow != 0");
            for(int currRow = this.row + rDirection ; currRow != rT; currRow += rDirection){
                if(board[currRow][cT] != null){
                    System.out.println("false on test vertically");

                    return false;
                }
            }
        }

        //for horizontal check
        int cDirection = 1;
        if(this.col - cT > 0){cDirection = -1;}

        if(distCol != 0){
            for(int currCol = this.col + cDirection ; currCol != cT; currCol += cDirection){
                if(board[rT][currCol] != null){
                    System.out.println("false on test horizontally");

                    return false;
                }
            }
        }
        return true;
        
    }
}