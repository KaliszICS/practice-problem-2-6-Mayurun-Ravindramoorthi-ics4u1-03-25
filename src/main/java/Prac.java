import java.util.Arrays;

public class PracticeP {

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
                    swaps += 3; // Full swap counts as 3
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return new int[]{swaps, steps};
    }

    public static int[] selectionSort(double[] nums) {
        int swaps = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                steps++;
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                double temp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = temp;
                swaps += 3;
            }
        }
        return new int[]{swaps, steps};
    }

    public static int[] insertionSort(double[] nums) {
        int swaps = 0;
        int steps = 0;

        for (int i = 1; i < nums.length; i++) {
            double key = nums[i];
            swaps++; // key assignment
            int j = i - 1;

            while (j >= 0) {
                steps++; // comparison
                if (nums[j] > key) {
                    nums[j + 1] = nums[j];
                    swaps++; // shifting counts as 1
                    j--;
                } else {
                    break;
                }
            }

            nums[j + 1] = key;
            swaps++; // inserting key
        }

        return new int[]{swaps, steps};
    }

    public static String leastSwaps(double[] nums) {
        int[] bubble = bubbleSort(Arrays.copyOf(nums, nums.length));
        int[] selection = selectionSort(Arrays.copyOf(nums, nums.length));
        int[] insertion = insertionSort(Arrays.copyOf(nums, nums.length));

        int min = Math.min(bubble[0], Math.min(selection[0], insertion[0]));

        // Alphabetical tie-breaker
        if (min == bubble[0] && min == insertion[0] && min == selection[0]) return "Bubble";
        if (min == bubble[0] && min == insertion[0]) return "Bubble";
        if (min == bubble[0] && min == selection[0]) return "Bubble";
        if (min == insertion[0] && min == selection[0]) return "Insertion";
        if (min == bubble[0]) return "Bubble";
        if (min == insertion[0]) return "Insertion";
        return "Selection";
    }

    public static String leastIterations(double[] nums) {
        int[] bubble = bubbleSort(Arrays.copyOf(nums, nums.length));
        int[] selection = selectionSort(Arrays.copyOf(nums, nums.length));
        int[] insertion = insertionSort(Arrays.copyOf(nums, nums.length));

        int min = Math.min(bubble[1], Math.min(selection[1], insertion[1]));

        // Alphabetical tie-breaker
        if (min == bubble[1] && min == insertion[1] && min == selection[1]) return "Bubble";
        if (min == bubble[1] && min == insertion[1]) return "Bubble";
        if (min == bubble[1] && min == selection[1]) return "Bubble";
        if (min == insertion[1] && min == selection[1]) return "Insertion";
        if (min == bubble[1]) return "Bubble";
        if (min == insertion[1]) return "Insertion";
        return "Selection";
    }

    public static void main(String[] args) {
        double[] nums = {5, 2, 9, 1, 5, 6};

        System.out.println("Least Swaps: " + leastSwaps(nums));
        System.out.println("Least Iterations: " + leastIterations(nums));

        // Optional: print detailed counts
        int[] bubble = bubbleSort(Arrays.copyOf(nums, nums.length));
        int[] selection = selectionSort(Arrays.copyOf(nums, nums.length));
        int[] insertion = insertionSort(Arrays.copyOf(nums, nums.length));

        System.out.println("Bubble Sort => Swaps: " + bubble[0] + ", Steps: " + bubble[1]);
        System.out.println("Selection Sort => Swaps: " + selection[0] + ", Steps: " + selection[1]);
        System.out.println("Insertion Sort => Swaps: " + insertion[0] + ", Steps: " + insertion[1]);
    }
}