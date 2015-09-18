public class Squirrel extends Entity {

    public static int pointsEarned = 0;
    private int nutsCollected = 0;
    private int posX;
    private int posY;
    public static final char Sym = '@';
    
    @Override
    public void create() {
        Scanner in = new Scanner(System.in);
        int flag = 0;

        while (flag == 0) {
            System.out.println("Enter the Squirrel position (x position,y position): ");
            System.out.println("x position range 0 to 19 ,y position range 0 to 49): ");
            String position = in.next();
            String[] positionS = position.split(",", 2);
            if (positionS.length != 2) {
                System.out.println("ERROR: Incorrect entries. Try again! ");
                continue;
            }
            // 2 points on the maze is derived from the user input.
            int newX = Integer.valueOf(positionS[0]);
            int newY = Integer.valueOf(positionS[1]);

            if ((newX < 0 || newX >= Maze.MAX_ROW) || (newY < 0 || newY >=Maze.MAX_COL)) {
                System.out.println("ERROR: Position is out of range");
                continue;
            }
            //'@' is placed on the maze if the positon is available
            if (Maze.available(newX, newY)) {
                Maze.maze[newX][newY] = Sym;
                posX = newX;
                posY = newY;
                flag = 1;
            } else {
                System.out.println("ERROR: Position not available. Try again! ");
            }
        }
    }

    void moveLeft() {

        handleMove("left");

    }

    void moveRight() {

        handleMove("right");

    }

    void moveUp() {

        handleMove("up");

    }

    void moveDown() {
        handleMove("down");

    }

    void handleMove(String moveType) {
        char done;
        int checkPosX = 0;
        int checkPosY = 0;

        switch (moveType) {
            case "up":
                checkPosX = posX - 1;
                checkPosY = posY;
                break;
            case "down":
                checkPosX = posX + 1;
                checkPosY = posY;
                break;
            case "left":
                checkPosX = posX;
                checkPosY = posY - 1;
                break;
            case "right":
                checkPosX = posX;
                checkPosY = posY + 1;
                break;
        }
        
//if the position is not '*'(wall) then below is performed
        //the squirre is moved and the replaced character will be checked 
        //if its a nut then points will be added to the current score 
        //if its a poisonous mushroom then points will be deducted
        
        if (Maze.maze[checkPosX][checkPosY] != '*') {

            Maze.maze[posX][posY] = ' ';
            posX = checkPosX;
            posY = checkPosY;
            done = Squirrel.put(posX, posY);
            if (Nuts.isNuts(done) > 0) {
                nutsCollected++;
                Nuts.totalNuts--;
            }
            pointsEarned = pointsEarned + Nuts.isNuts(done) + PoisonousMushrooms.isPm(done);

        } else {
            System.out.println("ERROR: Move not allowed, try again");
        }
    }

    //Squirrel dies if it eats a deadly mushroom
    public void CheckMove() {
        if (DeadlyM.DeadlyFlag == 1) {
            System.out.println("You ate a Deadly Mushroom!! Game Over");
            System.exit(0);

        }
        // game over if the current score is negative
        if (pointsEarned < 0) {
            System.out.println("Game Over");
            System.out.println("Total points : " + pointsEarned);
            System.exit(0);
        }
        System.out.println("Total points : " + pointsEarned);

    }

}
