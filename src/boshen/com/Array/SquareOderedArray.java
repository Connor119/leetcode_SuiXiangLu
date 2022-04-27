package boshen.com.Array;

/*
* 这道题同归并排序的merge过程，先用指针找到正数和负数的分界处，创建一个新的数组让两个指针分别进行merge
* */
public class SquareOderedArray {
    public static int[] LeetCode977(int[] nums) {
        int[] res = new int[nums.length];
        int positiveNumIndex = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]<0){
                positiveNumIndex++;
            }else{
                break;
            }
        }
        int negNumIndex = positiveNumIndex-1;
        for(int i =0;i<res.length;i++){
            if(positiveNumIndex<nums.length&&negNumIndex>=0){
                if(nums[positiveNumIndex]<=-nums[negNumIndex]){
                    res[i]=nums[positiveNumIndex]*nums[positiveNumIndex];
                    positiveNumIndex++;
                }else{
                    res[i]=nums[negNumIndex]*nums[negNumIndex];
                    negNumIndex--;
                }
            }else{
                if(positiveNumIndex<nums.length){
                    res[i]=nums[positiveNumIndex]*nums[positiveNumIndex];
                    positiveNumIndex++;
                }
                if(negNumIndex>=0){
                    res[i]=nums[negNumIndex]*nums[negNumIndex];
                    negNumIndex--;
                }
            }
        }
        return res;
    }
}
