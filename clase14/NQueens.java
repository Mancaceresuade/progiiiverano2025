package clase14;

public class NQueens {

    // Tamaño del tablero
    private static final int N = 30;

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        solve(board, 0);
        printBoard(board);
    }

    // Método de backtracking para resolver el problema
    public static boolean solve(int[][] board, int row) {
        if (row == N) { // Si todas las reinas están colocadas
            return true;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;  // Coloca la reina

                if (solve(board, row + 1)) {  // Recurre para colocar el resto
                    return true;
                }

                board[row][col] = 0;  // Si falla, descoloca la reina (backtracking)
            }
        }

        return false;  // No hay solución posible
    }

    // Verifica si es seguro colocar una reina en board[row][col]
    public static boolean isSafe(int[][] board, int row, int col) {
        // Verificar columna
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Verificar diagonal superior izquierda
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Verificar diagonal superior derecha
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Método para imprimir el tablero
    public static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
