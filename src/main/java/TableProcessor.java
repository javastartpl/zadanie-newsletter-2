import java.util.*;

public class TableProcessor {

    public String processTable(int[] nums) throws TooSmallArrayException {

        throwExceptionsIfNeeded(nums);

        Integer[] smallestPair = new Integer[]{nums[0], nums[1]};
        int sumSmallest = nums[0] + nums[1];

        Integer[] biggestPair = new Integer[]{nums[0], nums[1]};
        int sumBiggest = nums[0] + nums[1];

        if (nums.length > 2) {
            for (int i = 2; i < nums.length; i++) {

                if (sumSmallest > nums[i - 1] + nums[i]) {
                    smallestPair = new Integer[]{nums[i - 1], nums[i]};
                    sumSmallest = nums[i - 1] + nums[i];
                }

                if (sumBiggest < nums[i - 1] + nums[i]) {
                    biggestPair = new Integer[]{nums[i - 1], nums[i]};

                    sumBiggest = nums[i - 1] + nums[i];
                }
            }
        }

        Set<Integer[]> smallestPairsSet = new HashSet<>();
        smallestPairsSet.add(smallestPair);
        Set<Integer[]> biggestPairsSet = new HashSet<>();
        biggestPairsSet.add(biggestPair);

        creatingSetsOfBiggestAndSmallestPairs(nums, smallestPair, sumSmallest, biggestPair, sumBiggest, smallestPairsSet, biggestPairsSet);

        return ResultCreator.finalStringResult(smallestPairsSet, biggestPairsSet);
    }


    private void creatingSetsOfBiggestAndSmallestPairs(int[] nums, Integer[] smallestPair, int sumSmallest, Integer[] biggestPair, int sumBiggest, Set<Integer[]> smallestPairsSet, Set<Integer[]> biggestPairsSet) {
        for (int i = 2; i < nums.length; i++) {
            int sum = nums[i - 1] + nums[i];
            Integer[] testAr = new Integer[]{nums[i - 1], nums[i]};
            if (sum == sumSmallest && !(Arrays.hashCode(testAr) == Arrays.hashCode(smallestPair))) {
                smallestPairsSet.add(testAr);
            }
            if (sum == sumBiggest && !(Arrays.hashCode(testAr) == Arrays.hashCode(biggestPair))) {
                biggestPairsSet.add(testAr);
            }
        }
    }

    public void throwExceptionsIfNeeded(int[] nums) throws TooSmallArrayException {
        if (nums.length == 0) {
            throw new NoSuchElementException("No elements found");
        }
        if (nums.length < 2) {
            throw new TooSmallArrayException("Not enough elements to form a pair");
        }

    }

    public void printTable(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i : nums) {
            sb.append(i);
            sb.append(", ");
        }
        System.out.println(sb.toString().substring(0, sb.toString().length() - 2));
    }
}
