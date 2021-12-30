package game;

public class Java2048 {
    public static void main(String[] args) {
     Game game = new Game();

        System.out.println();
     game.up();
     game.print();
     game.down();
     game.print();
     game.left();
     game.print();
     game.undo();
//        System.out.println(game.getVector().size());
//        int arr[][] = game.getVector().elementAt(game.getVector().size()-3);
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
}
