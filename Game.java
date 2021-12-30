package game;
import java.util.Stack;
import java.util.Vector;
import java.util.Random;

public class Game {

    private static int[][] board;
    private static int score = 0;

    private static Stack<int[][]> undoStack = new Stack<int[][]>();
    private static Stack<int[][]> redoStack = new Stack<int[][]>();
    Game() {
        board = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = 0;
            }
        }
        add_random_tile();
        add_random_tile();
        print();

    }

    static boolean power_of_2(int x) {
        int flag = 0;
        for (int n = 1; n <= 11; n++) {
            if (x == Math.pow(2, n)) {
                flag = 1;
                return true;
            }
        }
        return false;
    }

    public static void print() {
        for (int[] x : board) {
            System.out.println(x[0] + " " + x[1] + " " + x[2] + " " + x[3]);
        }
        System.out.println("max"+boardmax());
    }

    public static int select_tile() {
        Random r = new Random();
        int rand = r.nextInt(100);
        if (rand <= 90) {
            return 2;
        }
        return 4;
    }

    public static void add_random_tile() {
        Random rand = new Random();
        int i = rand.nextInt(4);
        int j = rand.nextInt(4);
        if (board[i][j] == 0) {
            int temp = select_tile();
            board[i][j] = temp;
        }
    }

    static void down() {
        //table.push_back(board);
        undoStack.push(board);
        for (int j = 0; j <= 3; j++) {
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) {

                arr[i] = board[i][j];
            }
            pushZerosToBeginning(arr,4);
            for (int i = 0; i < 4; i++) {
                board[i][j] = arr[i];
            }
            for (int i = 3; i >0; i--) {
                if (power_of_2(board[i][j] + board[i - 1][j])) {
                    board[i][j] = board[i][j] + board[i - 1][j];
                    board[i-1][j] = 0;
                }
            }
        }

    }

    static void up() {
        undoStack.push(board);
//        boolean a[] = {false,false,false,false};
//        for (int j = 0; j <= 3; j++) {
//            for (int i = 3; i >0; i--) {
//                if (power_of_2(board[i][j] + board[i - 1][j])) {
//                    board[i-1][j] = board[i][j] + board[i - 1][j];
//                    board[i][j] = 0;
//                }
//            }
//        }
        for (int j = 0; j <= 3; j++) {
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) {

                arr[i] = board[i][j];
            }
            pushZerosToEnd(arr,4);
            for (int i = 0; i < 4; i++) {
                board[i][j] = arr[i];
            }
            for (int i = 0; i <3; i++) {
                if (power_of_2(board[i][j] + board[i + 1][j])) {
                    board[i][j] = board[i][j] + board[i + 1][j];
                    board[i+1][j] = 0;
                }
            }
        }
    }

    static void left() {
//        table.push_back(board);
        undoStack.push(board);
        for (int i = 0; i <= 3; i++) {
            int[] arr = new int[4];
            for (int j = 0; j < 4; j++) {

                arr[j] = board[i][j];
            }
            pushZerosToEnd(arr,4);
            for (int j = 0; j < 4; j++) {
                board[i][j] = arr[j];
            }
            for (int j = 0; j <3; j++) {
                if (power_of_2(board[i][j] + board[i][j+1])) {
                    board[i][j] = board[i][j] + board[i][j+1];
                    board[i][j+1] = 0;
                }
            }
        }
    }

    static void right() {
        undoStack.push(board);
        for (int i = 0; i <= 3; i++) {
            int[] arr = new int[4];
            for (int j = 0; j < 4; j++) {

                arr[j] = board[i][j];
            }
            pushZerosToBeginning(arr,4);
            for (int j = 0; j < 4; j++) {
                board[i][j] = arr[j];
            }
            for (int j = 3; j >0; j--) {
                if (power_of_2(board[i][j] + board[i][j-1])) {
                    board[i][j] = board[i][j] + board[i][j-1];
                    board[i][j-1] = 0;
                }
            }
        }
    }
    static int boardmax() {
        int max = board[0][0];
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (board[i][j] > max) {
                    max = board[i][j];
                }
            }
        }
        return max;
    }

    static int ifwin() {
        if (boardmax() == 2048) {
            return 1;
        }
        else {
            return 0;
        }
    }

    static int testup() {
        int flag = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (power_of_2(board[i][j]+board[i+1][j])&& board[i+1][j]!=0) {
                    flag = 1;
                }
            }
        }
        return flag;
    }
    static int testdown() {
        int flag=0;
        for(int j=0;j<=3;j++)
            for(int i=3;i>0;i--) {
                if(power_of_2(board[i][j]+board[i-1][j])&&board[i-1][j]!=0) {
                    flag=1;
                }
            }
        return flag;
    }
    static int testright() {
        int flag=0;
        for(int i=0;i<=3;i++)
            for(int j=3;j>0;j--){
                if(power_of_2(board[i][j]+board[i][j-1])&&(board[i][j-1]!=0)){
                    flag=1;
                }
            }
        return flag;
    }
    static int testleft(){
        int flag=0;
        for(int i=0;i<=3;i++)
            for(int j=0;j<3;j++){
                if(power_of_2(board[i][j] + board[i][j+1]) && (board[i][j+1] != 0)){
                    flag=1;
                }
            }
        return flag;
    }


    static void addnewnumber() {
        int newnumber = select_tile();
        score+= newnumber;
        Random r1 = new Random();
        int i = r1.nextInt(4);
        Random r2 = new Random();
        int j = r2.nextInt(4);
        if(board[i][j]==0) {
            board[i][j] = newnumber;
        }
    }


    public static int[][] getBoard() {
        return board;
    }

    public static void setBoard() {
        undoStack.pop();
        int arr[][] = undoStack.pop();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = arr[i][j];
            }
        }
    }



    public static int ifgameover() {
        int flag=0;
        if(testup()+ testdown() + testleft() + testright() == 0)
        {
            System.out.println("Game over!");
            flag=1;
        }
        return flag;
    }

    public static int getScore(){
        return score;
    }


    public static void undo(){
        if(undoStack.empty()){
            board = getBoard();
        }
        undoStack.pop();
        undoStack.pop();
//        redoStack.push(undoStack.pop());
        board = undoStack.peek();
    }
    public static int[][] redo() {
        redoStack.pop();
        redoStack.pop();
        return redoStack.peek();
//        undoStack.push(redoStack.);
    }
    public static Vector<int[][]> getUndoStack() {
        return undoStack;
    }

    public static void pushZerosToEnd(int arr[], int n)
    {
        int count = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i];
        while (count < n)
            arr[count++] = 0;
    }
    public static void pushZerosToBeginning(int arr[], int n){
        int current = 3;

        for (int i = 3; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[current] = arr[i];
                current--;
            }
        }

        while (current >= 0) {
            arr[current] = 0;
            current--;
        }
    }
}


