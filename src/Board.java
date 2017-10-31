public class Board {

    private int[][] board;

    public Board(){
        board = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
    }

    public Board(int[][] board){
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public void move(Move move){
        int y = move.getY();
        int x = move.getX();
        int player = move.getPlayer();

        board[y][x] = player;
    }

    public boolean canMove(Move move){
        int y = move.getY();
        int x = move.getX();

        return board[y][x] == 0;
    }

    public boolean isFull(){
        for(int y = 0; y<3; y++){
            for(int x = 0; x<3; x++){
                //yes this is syntactically valid
                if(board[y][x] == 0) return false;
            }
        }
        return true;
    }

    public boolean rowEmpty(int row){
        for(int i = 0; i<3; i++){
            if(board[row][i] != 0){
                return false;
            }
        }
        return true;
    }

    public boolean colEmpty(int col){
        for(int i = 0; i<3; i++){
            if(board[i][col] != 0){
                return false;
            }
        }
        return true;
    }

}
