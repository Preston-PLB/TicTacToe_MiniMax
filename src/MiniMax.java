public class MiniMax {

    //thing

    /*
    * @param board: a 3x3 2d array with values -1, 0, 1. 1 being maximizer, 0 being empty, -1 being minimizer.
    *
    * @return return arbitrary integer. if positive then maximizer wins, if negative minimizer wins, if 0 either no one has won or stalemate.
    *
    * */
    public int evaluate(int[][] board){
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

}
