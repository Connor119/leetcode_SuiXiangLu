package boshen.com.map;

import java.util.ArrayList;
import java.util.List;

public class UseArrayAsMap {
    public boolean leetcode242(String s, String t) {
        /*记录两个字符串是否包含相同的元素*/
        int[] arrRecordA = new int[256];
        int[] arrRecordB = new int[256];
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        for(char c:schar){
            arrRecordA[c]++;
        }
        for(char c:tchar){
            arrRecordB[c]++;
        }
        for(int i=0;i<256;i++){
            if(arrRecordA[i]!=arrRecordB[i]){
                return false;
            }
        }
        return true;
    }

    public List<Integer> leetcode438(String s, String p) {
        /*
        * 记录字符串1的每一个位置为起点是否有字符串3的异位词*/
        List<Integer> res = new ArrayList<>();
        int len = p.length();
        int[] recordP = new int[256];
        for(char c : p.toCharArray()){
            recordP[c]++;
        }
        int pointLeft = 0;
        int PointRight = pointLeft+len-1;
        char[] charS = s.toCharArray();
        boolean flag = false;
        while(PointRight<s.length()){
            int[] recordS = new int[256];
            for(int i=pointLeft;i<=PointRight;i++){
                recordS[charS[i]]++;
            }
            for(int j=0;j<256;j++){
                if(recordS[j]!=recordP[j]){
                    flag=true;
                    break;
                }
            }
            if(flag){
                recordS = new int[256];
                flag=false;
            }else{
                res.add(pointLeft);
            }
            pointLeft++;
            PointRight = pointLeft+len-1;
        }
        return res;
    }


}
