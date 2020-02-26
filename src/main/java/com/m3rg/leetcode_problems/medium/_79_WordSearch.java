package com.m3rg.leetcode_problems.medium;

public class _79_WordSearch {

    public static void main(String[] args) {
        _79_WordSearch obj = new _79_WordSearch();
        char[][] board = new char[][] {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' }
        };
        boolean result = obj.exist(board, "ABCCED");
        System.out.println(result);
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if(exist(board, y, x, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) {
            return true;
        }
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) {
            return false;
        }
        if (board[y][x] != word[i])
            return false;
        //char tmp = board[y][x];
        //board[y][x] = '#';
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x + 1, word, i + 1)
            || exist(board, y, x - 1, word, i + 1)
            || exist(board, y + 1, x, word, i + 1)
            || exist(board, y - 1, x, word, i + 1);
        board[y][x] ^= 256;
        //board[y][x] = tmp;
        return exist;
    }
}
