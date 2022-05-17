package boshen.com.map;

import java.util.*;

public class AddSomeNumber {
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
}
