import java.util.Arrays;

import java.util.Arrays;

public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int[] bubbleSort(double[] nums) {
        int swaps = 0;
        int steps = 0;
        boolean swapped;


        for (int i = 0; i < nums.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                steps++;
                if (nums[j] > nums[j + 1]) {
                    double temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swaps += 3;


                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return new int[]{swaps, steps};
    }


    public static int[] selectionSort(double[] nums) {
        int swaps = 0;
        int steps = 0;


        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                steps++;
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                    swaps++;
                }
            }
            double temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
            swaps += 3;
        }
        return new int[]{swaps, steps};
    }


    public static int[] insertionSort(double[] nums) {
        int swaps = 0;
        int steps = 0;


        for (int i = 1; i < nums.length; i++) {
            double key = nums[i];
            swaps++;
            int j = i - 1;
            // boolean comparisonMadeInLoop = false;


            while (j >= 0 && nums[j] > key) {
                steps++;
                // comparisonMadeInLoop = true;
                nums[j + 1] = nums[j];
                swaps++;
                j--;
            }


            nums[j + 1] = key;
            swaps++;
        }
        return new int[]{swaps, steps};
    }


    public static String leastSwaps(double[] nums) {
        double[] bubbleNums = Arrays.copyOf(nums, nums.length);
        double[] selectionNums = Arrays.copyOf(nums, nums.length);
        double[] insertionNums = Arrays.copyOf(nums, nums.length);


        int[] bubbleResults = bubbleSort(bubbleNums);
        int[] selectionResults = selectionSort(selectionNums);
        int[] insertionResults = insertionSort(insertionNums);


        int bubbleSwaps = bubbleResults[0];
        int selectionSwaps = selectionResults[0];
        int insertionSwaps = insertionResults[0];


        String bestSort = "Bubble";


        int minSwaps = bubbleSwaps;


        if (insertionSwaps < minSwaps) {
            minSwaps = insertionSwaps;
            bestSort = "Insertion";
        }


        if (selectionSwaps < minSwaps) {
            bestSort = "Selection";
        }


        //pick
        if (bubbleSwaps <= insertionSwaps && bubbleSwaps <= selectionSwaps) {
            return "Bubble";
        }


        else if (insertionSwaps <= selectionSwaps) {
            return "Insertion";
        }


        else {
            return "Selection";
        }
    }


    public static String leastIterations(double[] nums) {
        double[] bubbleNums = Arrays.copyOf(nums, nums.length);
        double[] selectionNums = Arrays.copyOf(nums, nums.length);
        double[] insertionNums = Arrays.copyOf(nums, nums.length);


        int[] bubbleResults = bubbleSort(bubbleNums);
        int[] selectionResults = selectionSort(selectionNums);
        int[] insertionResults = insertionSort(insertionNums);


        int bubbleSteps = bubbleResults[1];
        int selectionSteps = selectionResults[1];
        int insertionSteps = insertionResults[1];


        String bestSort = "Bubble";
        int minSteps = bubbleSteps;


        if (insertionSteps < minSteps) {
            minSteps = insertionSteps;
            bestSort = "Insertion";
        }


        if (selectionSteps < minSteps) {
            bestSort = "Selection";
        }


        if (bubbleSteps <= insertionSteps && bubbleSteps <= selectionSteps) {
            return "Bubble";
        }


        else if (insertionSteps <= selectionSteps) {
            return "Insertion";
        }


        else {
            return "Selection";
        }
    }


}