class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;

                int box = (r / 3) * 3 + (c / 3);

                if (!rows[r].add(ch)) return false;
                if (!cols[c].add(ch)) return false;
                if (!boxes[box].add(ch)) return false;
            }
        }
        return true;
    }
}

//O(9*9)=O(1) time complexity
