package boshen.com.Array;

/*对应leetcode27，884*/
public class RemoveElementFastSlowPoint {
    public static int leetcode27(int[] nums, int val){
//        返回的右边界
        int fast = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
//                当前的东西和右边界交换(把要的东西放到下一个阔进来的位置)
                swep(nums,fast,i);
//                将范围右扩
                fast++;
            }
        }
        return fast;
    }

    public static boolean leetcode844(String s, String t){
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        int indexS1=0;
        int indexS2=0;
        indexS2=stringChange(s2,indexS2);
        indexS1=stringChange(s1,indexS1);

        if(indexS1==indexS2){
            for(int i=0;i<indexS1;i++){
                if(s1[i]!=s2[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static int stringChange(char[] s1,int indexS1){
//        设置向后扩的右边界，当是非删除字符的时候就往后扩，当是删除祝福的时候就往前缩，当缩不了就不动
        for(int i=0;i<s1.length;i++){
            if(s1[i]=='#'&&indexS1!=0){
                indexS1--;
            }else if(s1[i]=='#'&&indexS1==0){
//                这里为了防止进入else循环中去
                continue;
            }else{
                swep(s1,indexS1,i);
                indexS1++;
            }
        }
        return indexS1;
    }

    public static void swep(char[] nums,int index1,int index2){
        char temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

    }
    public static void swep(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

    }

}
