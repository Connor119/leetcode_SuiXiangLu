package boshen.com.map;

import java.util.*;

public class numsSum {
    public int[] leetcode1(int[] nums, int target) {
        // 哈希表记录当前数据于target差多少，值为这个数据的下标
        Map<Integer,Integer> record = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0 ;i<nums.length;i++){
            if(record.keySet().contains(nums[i])){
                res[0] = record.get(nums[i]);
                res[1] = i;
                break;
            }
            record.put(target-nums[i],i);
        }
        return res;
    }

    public List<List<Integer>> leetcode15(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int leftIndex = i+1;
            int rightIndex = nums.length-1;
            while(leftIndex<rightIndex){
                if((nums[i]+nums[leftIndex]+nums[rightIndex])==0){
                    List<Integer> childRes = new ArrayList<>();
                    childRes.add(nums[i]);
                    childRes.add(nums[leftIndex]);
                    childRes.add(nums[rightIndex]);
                    res.add(childRes);
                    while (rightIndex > leftIndex && nums[rightIndex] == nums[rightIndex - 1]) rightIndex--;
                    while (rightIndex > leftIndex && nums[leftIndex] == nums[leftIndex + 1]) leftIndex++;
                    rightIndex--;
                    leftIndex++;
                }else if((nums[i]+nums[leftIndex]+nums[rightIndex])>0){
                    rightIndex--;
                }else{
                    leftIndex++;
                }
            }
        }
        return res;
    }

    public int leetcode16(int[] nums, int target) {
        int gap = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                // gap = Math.min(gap,Math.abs(sum));
                int newGap = target<sum?Math.abs(sum-target):Math.abs(target-sum);
                // 找寻最小差距更新返回值
                if(gap>=newGap){
                    gap = newGap;
                    res = sum;
                }
                // 找寻下一个组合是否为最小的差距
                if(sum==target){
                    return res;
                }
                if(sum<target){
                    // while(left<right&&nums[left]==nums[left+1]){
                    //     left++;
                    // }
                    left++;
                }
                if(sum>target){
                    // while(left<right&&nums[right]==nums[right-1]){
                    //     right--;
                    // }
                    right--;
                }
            }
        }
        return res;
    }




}
