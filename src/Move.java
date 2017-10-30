public class Move {

    private int y, x, player, score;

    public Move(){
        y = x = player = 0;
    }

    public Move(int x, int y, boolean player){
        this.x = x;
        this.y = y;
        this.player = player ? 1 : -1;
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


}
