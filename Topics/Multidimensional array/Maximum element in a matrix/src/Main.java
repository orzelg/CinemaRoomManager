import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] array = new int[rows][cols];

        int maxVal = Integer.MIN_VALUE;
        int maxValRow = 0;
        int maxValCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = scanner.nextInt();
                if (array[i][j] > maxVal) {
                    maxVal = array[i][j];
                    maxValRow = i;
                    maxValCol = j;
                }
            }
        }

        System.out.printf("%d %d", maxValRow, maxValCol);

    }
}