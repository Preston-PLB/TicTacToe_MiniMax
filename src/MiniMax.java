public class MiniMax {

    public int minimax(int[][] board, boolean maximizer){
        if(isFull(board)){
            return evaluate(board);
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
    private int evaluate(int[][] board){
        //check rows
        for(int y = 0; y<3; y++){
            int sum = board[y][0]+board[y][1]+board[y][2];
            if(sum == 3){
                return 10;
            }else if(sum == -3){
                return -10;
            }
        }
        //check columns
        for(int x = 0; x<3; x++){
            int sum = board[0][x]+board[1][x]+board[2][x];
            if(sum == 3){
                return 10;
            }else if(sum == -3){
                return -10;
            }
        }
        //if the above seems backwards, trust me it's not. Step through this code line by line and you'll see

        //check diags
        int leftRightDiag = board[0][0]+board[1][1]+board[2][2];
        if(leftRightDiag == 3){
            return 10;
        }else if(leftRightDiag == -3){
            return -10;
        }

        int RightLeftDiag = board[0][2]+board[1][1]+board[2][0];
        if(RightLeftDiag == 3){
            return 10;
        }else if(RightLeftDiag == -3){
            return -10;
        }


        return 0;
    }

    /**
     * @param board a 3x3 2d array with values -1, 0, 1
     *
     * @return true if the board is full of 1's or/and -1's. False if there are 0's (there are empty spots).
     */
    private boolean isFull(int[][] board){
        for(int y = 0; y<3; y++){
           for(int x = 0; x<3; x++){
               //yes this is syntactically valid
               if(board[y][x] == 0) return false;
           }
        }
        return true;
    }

}
