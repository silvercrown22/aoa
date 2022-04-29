import java.util.*;
public class Nqueen{

    static boolean isSafe(int[][] board, int row, int col){
        // for upper-vertical
//        for(int i=row;i>=0;i--){
//            if(board[i][col]==1) {
//                return false;
//            }
//        }
//
//        // for upper-left diagonal
//        int j=col;
//        for(int i=row;i>=0 && j>=0;i--,j--){
//            if(board[i][j]==1) {
//                return false;
//            }
//        }
//
//        // for upper-right diagonal
//
//        j=col;
//        for(int i=row;i>=0 && j<board.length;i--,j++){
//            if(board[i][j]==1)
//                return false;
//        }


        for(int i=row; i>=0 ; i--){
            if (board[i][col] == 1) return false;
        }

        int j= col;
        for (int i=row;i>=0&&j>=0;i--,j--){
            if(board[i][j]==1) return false;
        }

        j =col;
        for (int i=row; i>=0 && j<board.length; i--,j++){
            if(board[i][j]==1) return false;
        }
        
        return true;
    }

    static boolean solveQueen(int[][] board,int row){
        if(row==board.length) return true;

        for(int col=0;col<board[0].length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = 1;
                if(solveQueen(board,row+1)){
                    return true;
                }
                board[row][col] = 0;

            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] board = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };

        solveQueen(board,0);

        System.out.println(Arrays.deepToString(board));
    }

}
