package hash;

import utils.Log;

/**
 * 有效的数独
 */
public class Chapter43 {

    public static void main(String[] args){
        Chapter43 chapter43 = new Chapter43();
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        chapter43.isValidSudoku(board);
    }

    /**
     * i是行标，j是列标。行标决定一组block的起始位置（因为block为3行，所以除3取整得到组号，又因为每组block为3个，所以需要乘3），列标再细分出是哪个block（因为block是3列，所以除3取整）
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];

        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (rows[i][num] || columns[j][num] || blocks[blockIndex][num]){
                        return false;
                    }
                    rows[i][num] = true;
                    columns[j][num] = true;
                    blocks[blockIndex][num] = true;
                }
            }
        }
        return true;
    }
}
