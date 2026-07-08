import java.util.*;
public class L36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //if in one row a number appears more than once return false so make a hashmap per row which stores the numebr and it's appearance and if the value exceeds one return false
        for(int row = 0; row < board.length; row++){
            Set<Character> set = new HashSet<>();
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col] == '.'){
                    continue;
                }
                if(set.contains(board[row][col])){
                    return false;
                }
                set.add(board[row][col]);
            }
        }

        for(int col = 0; col < board[0].length; col++){
            Set<Character> set = new HashSet<>();
            for(int row = 0; row < board.length; row++){
                if(board[row][col] == '.'){
                    continue;
                }
                if(set.contains(board[row][col])){
                    return false;
                }
                set.add(board[row][col]);
            }
        }

        for(int square = 0; square < board.length; square++){
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }

        return true;
    }

    public void main(String[] args){
        char[][] board = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        L36ValidSudoku s = new L36ValidSudoku();
        System.out.println(s.isValidSudoku(board));

    }
}
