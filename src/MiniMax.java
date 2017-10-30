public class MiniMax {

    public static int minimax(int[][] board, boolean maximizer){
        if(isFull(board)){
            return evaluate(new Board(board));
        }

        if(maximizer) {
            int bestScore = Integer.MIN_VALUE;
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (board[y][x] == 0) {
                        int[][] temp = board;
                        temp[y][x] = 1;
                        int score = minimax(temp, !maximizer);
                        if(score > bestScore){
                            bestScore = score;
                        }
                        return bestScore;
                    }
                }
            }
        }else{
            int bestScore = Integer.MAX_VALUE;
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (board[y][x] == 0) {
                        int[][] temp = board;
                        temp[y][x] = -1;
                        int score = minimax(temp, !maximizer);

                        if(score < bestScore){
                            bestScore = score;
                        }
                        return bestScore;
                    }
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

    /**
     * @param board a 3x3 2d array with values -1, 0, 1
     *
     * @return true if the board is full of 1's or/and -1's. False if there are 0's (there are empty spots).
     */
    private static boolean isFull(int[][] board){
        for(int y = 0; y<3; y++){
           for(int x = 0; x<3; x++){
               //yes this is syntactically valid
               if(board[y][x] == 0) return false;
           }
        }
        return true;
    }

}
