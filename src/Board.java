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

}
