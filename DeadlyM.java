public class DeadlyM extends Entity{
    public static int DeadlyFlag = 0;
    
    DeadlyM()
    {
        Sym = '#';
    }
    @Override
    public void create() {

        int counter = 0;
        int ROW;
        int COLUMN;

        while (counter == 0) {
            ROW = (int) (Math.random() * 19) + 1;
            COLUMN = (int) (Math.random() * 49) + 1;

            if (Maze.available(ROW, COLUMN)) {

                Maze.maze[ROW][COLUMN] = Sym;

                counter++;
            }
        }

    }
    static int isDm(char Sym) {
        if (Sym == (char) DeadlyM.Sym) {
            DeadlyFlag = 1;
            return DeadlyFlag;
        } else return 0;
    }
}
