package IA_TRABALHO_QUESTAO_2;

/**
    * @author Mateus Junges
    <contato@mateusjunges.com>
 */
public final class Position{
    private final int nz = 11;
    int t = 1;
    int p = 4;
    private final int nc = 8;
    public int x,  y;
    private final int[][] plan;
    private static Board lab;
    public Position(Board l) {
        lab = l;
        x = 8;
        y = 3;
        plan = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };
        plan[x][y] = 2;
        plan[t][p] = 3;
        lab.setPlan(getPlan());
    }
    public Position(int px, int py, int[][] p){
        plan = new int[nz][nc];
        for (int i = 0; i < nz; i++) {
            System.arraycopy(p[i], 0, plan[i], 0, nc);
        }
        x = px;
        y = py;
    }
    public int[][] getPlan() {
        return (plan);
    }
    public int getX() {
        return (x);
    }
    public int getY() {
        return (y);
    }
    boolean canGoLeft(){
        return ((x > 0) && (plan[x - 1][y] != 1));
    }
    void _left(){
        if(canGoLeft()) {
            x = x - 1;
        }
    }
    boolean canGoUp(){
        return ((y > 0) && (plan[x][y - 1] != 1));
    }
    void _up(){
        if (canGoUp()) {
            y = y - 1;
        }
    }
    boolean canGoDown(){
        return ((y < nc - 1) && (plan[x][y + 1] != 1));
    }
    void _down() {
        if (canGoDown()) {
            y = y + 1;
        }
    }
    boolean canGoRight() {
        return ((x < nc - 1) && (plan[x + 1][y] != 1));
    }
    void direita() {
        if (canGoRight()) {
            x = x + 1;
       }
    }
    public int euclidean() {
        double distance;
        distance = Math.sqrt(Math.pow(t - x, 2) + Math.pow(p - y, 2));
        return ((int) distance);
    }
    public boolean isGoalState() {
        return ((x == t) && (y == p));
    }
}