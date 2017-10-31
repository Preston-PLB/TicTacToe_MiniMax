public class Main {

    public static void main(String[] args){
        int[][] ints = {{0,0,1},
                        {0,0,0},
                        {-1,0,1}};
        Board b = new Board(ints);
        Move m = MiniMax.bestMove(b, true);
        System.out.printf("%d %d %d", m.getX(), m.getY(), m.getScore());
    }

}
