public class Move {

    private int y, x, player, score;

    public Move(){
        y = x = player = 0;
        score = Integer.MIN_VALUE;
    }

    public Move(int x, int y, boolean player){
        this.x = x;
        this.y = y;
        this.player = player ? 1 : -1;
        score = player ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }

    public int getPlayer() {
        return player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    @Override
    public String toString() {
        return "X: " + x + "Y: " + y + "SCORE: " + score + "PLAYER" + player;
    }
}
