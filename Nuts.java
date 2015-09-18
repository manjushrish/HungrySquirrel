public class Nuts extends Entity {

    public static int totalNuts = 5;

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

    static int isNuts(char Symb) {
        if (Symb == 'A') {
            
            return Almonds.nutritionPoints;

        } else if (Symb == 'P') {
            
            return PeaNuts.nutritionPoints;
        }
        return 0;
    }

}
