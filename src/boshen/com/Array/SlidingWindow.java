package boshen.com.Array;

public class SlidingWindow {
    public static int leetcode209(int target, int[] nums) {
        int subArrLength=Integer.MAX_VALUE;
        int leftIndex = 0;
        int rightIndex = 0;
        int subArrSum = 0;
        while(rightIndex<nums.length){
            subArrSum += nums[rightIndex++];
            while(subArrSum>=target){
                subArrLength =  Math.min(subArrLength,rightIndex-leftIndex);
                subArrSum-=nums[leftIndex++];
            }
        }
        return subArrLength==Integer.MAX_VALUE?0:subArrLength;
    }
}
