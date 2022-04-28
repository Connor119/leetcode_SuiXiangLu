package boshen.com.Array;

import java.util.HashMap;

public class SlidingWindow {
//    最小滑动窗口
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
//    最大滑动窗口
    public static int leetcode904(int[] fruits){
        // int typeCount = 0;
        int leftPoint = 0;
        int returnSum = 0;
        // int returnSumtemp = 0;
        HashMap<Integer,Integer> recording = new HashMap<>();
        for(int rightPoint = 0; rightPoint<fruits.length ;rightPoint++){
            if(!recording.containsKey(fruits[rightPoint])&&recording.size()<2){
                recording.put(fruits[rightPoint],0);
            }
            if(recording.containsKey(fruits[rightPoint])){
                int recordNum = recording.get(fruits[rightPoint]);
                recording.put(fruits[rightPoint],recordNum+1);
            }
            if(!recording.containsKey(fruits[rightPoint])&&recording.size()==2){
                returnSum = Math.max(returnSum,rightPoint-leftPoint);
                while(recording.get(fruits[leftPoint])!=0){
                    int recordNumRem = recording.get(fruits[leftPoint]);
                    recording.replace(fruits[leftPoint],--recordNumRem);
                    if(recording.get(fruits[leftPoint])==0){
                        recording.remove(fruits[leftPoint]);
                        leftPoint++;
                        rightPoint--;
                        break;
                    }
                    leftPoint++;
                }
            }
            returnSum = Math.max(returnSum,rightPoint-leftPoint+1);
        }

        return returnSum;
    }

}
