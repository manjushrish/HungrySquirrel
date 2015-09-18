public abstract class Entity {

    public static char Sym;

    public void create() {

    }

    public static char put(int newX, int newY) {
          
        if (Maze.maze[newX][newY] == ' ') {
            Maze.maze[newX][newY] = '@';
            return ' ';

        } else if (Maze.maze[newX][newY] == 'A') {
            Maze.maze[newX][newY] = '@';
            return 'A';

        } else if (Maze.maze[newX][newY] == 'P') {
            Maze.maze[newX][newY] = '@';
            return 'P';

        } 
        else if (Maze.maze[newX][newY] == 'X') {
            Maze.maze[newX][newY] = '@';
            return 'X';
        }
        else if (Maze.maze[newX][newY] == '#') {
            Maze.maze[newX][newY] = '@';
            return '#';
        }
        
        else {
            return '*';
        }
        
       

    }
    
    
}
