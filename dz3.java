// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. 
//И вывести Доску. 0x00000 0000x00 00x0000

public class dz3 {
    static int N = 8;
    static int[] queenPos = {-1, -1, -1, -1, -1, -1, -1, -1};
 
    private static boolean isSafe(int i, int j) {
        for (int k = 0; k < i; k++) {
            if (queenPos[k] == j) {
                return false;
            }
        }
 
        for (int k=i-1, m=j-1; k>=0 && m>=0; k--, m--) {
            if (queenPos[k] == m) {
                return false;
            }
        }
 
        for (int k=i-1, m=j+1; k>=0 && m<N; k--, m++) {
            if (queenPos[k] == m) {
                return false;
            }
        }
        return true;
    }

    public static void printBoard() {
        System.out.println("Комбинация: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (queenPos[i] == j) {
                    System.out.print(" X " + " ");
                } else {
                    System.out.print(" 0 " + " ");
                }
            }
            System.out.println();
        }
    }
 
    public static void placeQueens(int i) {
        for (int j = 0; j < N; j++) {
            if (isSafe(i, j)) {
                queenPos[i] = j;
                if (i == N - 1) {
                    printBoard();
                } else {
                    placeQueens(i + 1);
                }
            }
        }
    }
 
    public static void main(String[] args) {
        placeQueens(0);
    }
}