import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] array = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < cols; i++) {
            for (int j = rows - 1; j >= 0; j--) {
                System.out.printf("%d ", array[j][i]);
            }
            System.out.println();
        }

    }
}