import java.util.Collections;
import java.util.LinkedList;

public class MiniMax {

    public static Move bestMove(Board board, boolean maximizer){
        LinkedList<Move> moves = new LinkedList<>();

        for(int y = 0; y<3; y++){
            for(int x = 0; x<3; x++){
                Move m = new Move(x, y, maximizer);
                if(board.canMove(m)){
                    m.setScore(minimax(board, 2, maximizer));
                    moves.add(m);
                }
            }
        }

        Move best = new Move(0, 0, maximizer);

        for(Move m: moves){
            if(maximizer) {
                if (m.getScore() > best.getScore()) {
                    best = m;
                }
            }else{
                if (m.getScore() < best.getScore()) {
                    best = m;
                }
            }
            System.out.println(m);
        }

        return best;
    }

    public static int minimax(Board board, int depth, boolean maximizer){
        if(depth == 0 || board.isFull()){
            return evaluate(board);
        }
        for(int y = 0; y<3; y++){
            for(int x = 0; x<3; x++){
                Move m = new Move(x, y, maximizer);
                if(board.canMove(m)){
                    board.move(m);
                    return minimax(board, depth-1, !maximizer);
                }
            }
        }
        return 0;
    }

    /**
    * @param board a 3x3 2d array with values -1, 0, 1. 1 being maximizer, 0 being empty, -1 being minimizer.
    *
    * @return return arbitrary integer. if positive then maximizer wins, if negative minimizer wins, if 0 either no one has won or stalemate.
    *
    * */
    private static int evaluate(Board board){
        int[][] b = board.getBoard();

        //check for wins

        //check rows
        for(int y = 0; y<3; y++){
            int sum = b[y][0]+b[y][1]+b[y][2];
            if(sum == 3 || sum == -3){
                return 100*sum;
            }
        }
        //check columns
        for(int x = 0; x<3; x++){
            int sum = b[0][x]+b[1][x]+b[2][x];
            if(sum == 3 || sum == -3){
                return 100*sum;
            }
        }
        //if the above seems backwards, trust me it's not. Step through this code line by line and you'll see

        //check diags
        int leftRightDiag = b[0][0]+b[1][1]+b[2][2];
        if(leftRightDiag == 3 || leftRightDiag == -3){
            return 100*leftRightDiag;
        }

        int RightLeftDiag = b[0][2]+b[1][1]+b[2][0];
        if(RightLeftDiag == 3 || RightLeftDiag == -3){
            return 100*RightLeftDiag;
        }

        //check for blocks
        for(int y = 0; y<3; y++){
            int sum = b[y][0]+b[y][1]+b[y][2];
            if(sum == 2 || sum == -2 && !board.rowEmpty(y)){
                return 20*-sum;
            }
        }
        for(int x = 0; x<3; x++){
            int sum = b[0][x]+b[1][x]+b[2][x];
            if(sum == 2 || sum == -2 && !board.colEmpty(x)){
                return 20*-sum;
            }
        }

        //check for partials

        //check rows
        for(int y = 0; y<3; y++){
            int sum = b[y][0]+b[y][1];
            if(sum == 2 || sum == -2){
                return 10*sum;
            }
            sum = b[y][1]+b[y][2];
            if(sum == 2 || sum == -2){
                return 10*sum;
            }
        }

        for(int x = 0; x<3; x++){
            int sum = b[0][x]+b[1][x];
            if(sum == 2 || sum == -2){
                return 10*sum;
            }
            sum = b[1][x]+b[2][x];
            if(sum == 2 || sum == -2){
                return 10*sum;
            }
        }

        //check diag partials
        int sum = b[0][0]+b[1][1];
        if(sum == 2 || sum == -2){
            return 10*sum;
        }
        sum = b[1][1]+b[2][2];
        if(sum == 2 || sum == -2){
            return 10*sum;
        }
        sum = b[0][2]+b[1][1];
        if(sum == 2 || sum == -2){
            return 10*sum;
        }
        sum = b[1][1]+b[2][0];
        if(sum == 2 || sum == -2){
            return 10*sum;
        }

        return 0;
    }

}
