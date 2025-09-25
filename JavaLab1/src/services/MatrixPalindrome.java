package services;

public class MatrixPalindrome{
    public static boolean isPalindrome(int number){
        String numStr = Integer.toString(number);
        int left=0;
        int right=numStr.length()-1;
        while(left<right){
            if(numStr.charAt(left)!=numStr.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isSimple(int number){
        if (number <=1) return false;
        for(int i=2;i<Math.sqrt(number); ++i){
            if (number%i==0) return false;
        }
        return true;
    }

    
    public static int findMinPalindromeInColumn(int[][] matrix, int columnIndex) {
        int minPalindrome = Integer.MAX_VALUE;
        boolean foundPalindrome = false;

        for (int i = 0; i < matrix.length; i++) {
            int element = matrix[i][columnIndex];
            if (isPalindrome(element)) {
                foundPalindrome = true;
                if (element < minPalindrome) {
                    minPalindrome = element;
                }
            }
        }

        return foundPalindrome ? minPalindrome : -1; 
    }

    public static int findMaxSimpleInColumn(int[][] matrix, int columnIndex) {
        int maxSimple = Integer.MIN_VALUE;
        boolean foundSimple = false;
        for (int i = 0; i < matrix.length; i++) {
            int element = matrix[i][columnIndex];
            if (isSimple(element)) {
                foundSimple = true;
                if (element > maxSimple) {
                    maxSimple = element;
                }
            }
        }
        return foundSimple ? maxSimple : -1;
    }
    
    public static int[] processMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int numColumns = matrix[0].length;
        int[] resultVector = new int[numColumns];

        for (int j = 0; j < numColumns; j++) {
            resultVector[j] = findMaxSimpleInColumn(matrix, j);
        }

        return resultVector;
    }
}