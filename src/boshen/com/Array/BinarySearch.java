package boshen.com.Array;

/*
* 数组的二分查找
* */
public class BinarySearch {
    public static void main(String[] args) {
        
    }
/*
* leetcode 704
* */
    public static int binarySearch1(int[] nums, int target){
        int left=0;
//        这是第1种写法，将右指针永远打到查询集合的右面一个位置
        int right=nums.length;
//        这时候不能有等于判断
        while(right>left){
            int mid = (left+right)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
//                保持右节点永远在右1位置上
                right=mid;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static int binarySearch2(int[] nums, int target){
        int left=0;
//        这是第1种写法，将右指针永远打到查询集合中最后一个元素
        int right=nums.length-1;
//        这时候需要等于判断(这种写法的终止条件将让右节点在左节点后面一个)
        while(right>=left){
            int mid = (left+right)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
//                右节点保持在待搜寻范围的前一个
                right=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
