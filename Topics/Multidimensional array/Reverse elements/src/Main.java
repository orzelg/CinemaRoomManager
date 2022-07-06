import java.util.Arrays;
import java.util.Collections;

class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {

        int[][] oldArray = twoDimArray;

        for (int i = 0; i < oldArray.length; i++) {
            Collections.reverse(Arrays.asList(oldArray[i]));
        }

        twoDimArray = oldArray;
    }
}