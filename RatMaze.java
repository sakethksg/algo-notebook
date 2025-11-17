public class RatMaze {

    int N;

    void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

    boolean isSafe(int maze[][], int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[y][x] == 1);
    }

    boolean solveMaze(int maze[][]) {

        N = maze.length;

        int sol[][] = new int[N][N];

        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.println("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {

        if (x == N - 1 && y == N - 1) {
            sol[y][x] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {

            sol[y][x] = 1;

            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

            sol[y][x] = 0;
            return false;
        }

        return false;
    }

    public static void main(String args[]) {

        RatMaze rat = new RatMaze();

        int maze1[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        rat.solveMaze(maze1);

        System.out.println("\nFor 5x5 Maze:\n");

        int maze2[][] = {
            {1, 1, 1, 1, 1},
            {0, 0, 1, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
        };

        rat.solveMaze(maze2);
    }
}
