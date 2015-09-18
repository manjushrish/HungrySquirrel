public class Maze {

    public static final int MAX_ROW = 20;
    public static final int MAX_COL = 50;
    public static char[][] maze = new char[MAX_ROW][MAX_COL];

    static void create() throws Exception {
        InputStream in = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("maze.txt"));
            String line;

            for (int i = 0; i < MAX_ROW; i++) {
                line = br.readLine();

                for (int j = 0; j < MAX_COL; j++) {

                    maze[i][j] = line.charAt(j);
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("File does not exist " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("IO Error " + e.getMessage());
            return;
        } finally {
            if (in != null) {
                in.close();
            }

        }

    }

    static void display() {
        System.out.println();
        System.out.println();
        for (int i = 0; i < MAX_ROW; i++) {

            for (int j = 0; j < MAX_COL; j++) {
                System.out.print(maze[i][j]);

            }

            System.out.print("\n");

        }

        System.out.println();
    }

    public static boolean available(int row, int col) {
        if (maze[row][col] == ' ') {
            return true;
        } else {
            return false;
        }

    }
}
