package boshen.com.string;

public class KMPStrstr {
    public static int[] getNextArr(char[] str){
        if(str.length<2){
            return new int[] {-1};
        }
        int[] next = new int[str.length];
        next[0]=-1;
        next[1]=0;
        int point=2;
        int pointof = 0;
        while(point<str.length){
            if(str[point-1]==str[pointof]){
                next[point++] = ++pointof;
            }else if(pointof>0){
                pointof=next[pointof];
            }else{
                next[point++] = 0;
            }
        }
        return next;
    }

    public static int getIndexOf(String s,String m){
//        做条件过滤
        if(s==null||m==null||m.length()<1||s.length()<m.length()){
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
//        两个指针从头开始指
        int i1 = 0;
        int i2 = 0;
//        拿到str2的next数组
        int[] next = getNextArr(str2);
//        边界条件就是不可以越界（两个字符串都不可以）
        while(i1<str1.length && i2<str2.length){
//            当i1指的为止和i2指的为止相等的时候,同时向后移动比较之后的
            if(str1[i1]==str2[i2]){
                i1++;
                i2++;
            }else if(next[i2]==-1){
//                当str2已经到头了,那就i1自己一个人加就行了,其中if判断中的语句是因为在存储next数组的时候就规定了，第一个字符的next是-1。
                i1++;
            }else{
//                i2作为str2指针，next数组中存的就是当对不上的时候指针去哪里的问题
                i2=next[i2];
            }
        }
        //        如果i2跑到了str2的最后就返回i1-i2（返回匹配的头）否则就没有返回-1
        return i2 == str2.length?i1-i2:-1;
    }

}
