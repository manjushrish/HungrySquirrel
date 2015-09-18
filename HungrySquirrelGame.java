public class HungrySquirrelGame {

    public static void main(String[] args) throws Exception {
        
        //new maze is created
        Maze.create();
        Maze.display();
        //new syirrel is created
        Squirrel S = new Squirrel();
        S.create();
        // nuts array (of 5 nuts) created
        Nuts[] nuts = new Nuts[Nuts.totalNuts];
        for (int i = 0; i < Nuts.totalNuts; i++) {

            if (Math.random() < 0.5) {

                nuts[i] = new PeaNuts();
                nuts[i].create();
            } else {
                nuts[i] = new Almonds();
                nuts[i].create();
            }

        }
        
        // array of 2 poisonous mushrooms cretaed.
        PoisonousMushrooms[] PM = new PoisonousMushrooms[2];
        for (int j = 0; j < PoisonousMushrooms.TotalPM; j++) {
            PM[j] = new PoisonousMushrooms();
            PM[j].create();

        }
        
        //one deadly mushroom, which can end the game is created.
        DeadlyM DM = new DeadlyM();
        DM.create();

        Maze.display();

        System.out.println("Peanuts(p): +10,    Almonds(A): +5"
                + "\n poisonous mushroom(x): -10 "
                + "\n And BEWARE deadly mushroom(#) kills the squirrel!!"
                + " Squirrel with NEGATIVE points means you lose");
        System.out.println("Commands ");
        System.out.println("l or L to move left ");
        System.out.println("r or R to move right ");
        System.out.println("u or U to move up ");
        System.out.println("d or D to move down ");
        System.out.println("Press ENTER to accept command");

        Scanner in = new Scanner(System.in);
        char command;
        while (Nuts.totalNuts != 0) {
            //'command' is command entered by the user
            command = in.next().charAt(0);
            command = Character.toLowerCase(command);
            switch (command) {
                case 'u':
                    S.moveUp();
                    Maze.display();
                    //check move is used to display current status like, points and if the squirrel is dead
                    S.CheckMove();
                    break;
                case 'd':
                    S.moveDown();
                    Maze.display();
                    S.CheckMove();
                    break;
                case 'l':
                    S.moveLeft();
                    Maze.display();
                    S.CheckMove();

                    break;
                case 'r':

                    S.moveRight();
                    Maze.display();
                    S.CheckMove();
                    break;
                default:
                    break;

            }

        }
        System.out.println("You WON!");

    }
}
