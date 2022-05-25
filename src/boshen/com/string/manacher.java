package boshen.com.string;

public class manacher {
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length()*2+1];
        int index = 0;
        for(int i=0;i!=res.length;i++){
//            某一个数&1就是判断是不是基数
            res[i] = (i&1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }
    public static int maxLcpsLength(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int C=-1;
        int R=-1;
        int max =Integer.MIN_VALUE;
        for (int i = 0; i < str.length; i++) {
            pArr[i] = R>i?Math.min(pArr[2*C-i],R-i):1;
//            以i位置出发，左边不能越界，右边不能越界
            while(i+pArr[i]<str.length &&i-pArr[i]>-1){
                if(str[i+pArr[i]]==str[i-pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i+pArr[i]>R){
                R = i+pArr[i];
                C=i;
            }
            max = Math.max(max,pArr[i]);
        }
        return max-1;
    }
}
