import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int numOfConsecutive;
        int resultRow = 0;

        int[][] array = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        numOfConsecutive = scanner.nextInt();

        int currentFree = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == 0) {
                    currentFree++;
                    if (currentFree == numOfConsecutive) {
                        resultRow = i + 1;
                        break;
                    }
                } else {
                    currentFree = 0;
                }
            }
            if (resultRow != 0) {
                break;
            }
            currentFree = 0;
        }

        System.out.println(resultRow);
    }
}