public class PoisonousMushrooms extends Entity{
    public static int TotalPM = 2;
    public static int nutritionPoints = -15;
    //public static int killerMushroom =1;
    PoisonousMushrooms() {
        Sym = 'X';

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
    
    static int isPm(char Symb) {
        if (Symb == 'X') {
            
            return nutritionPoints;
        }

        else
        return 0;
    }
}
