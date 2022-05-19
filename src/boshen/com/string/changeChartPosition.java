package boshen.com.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class changeChartPosition {
    public void leetcode344(char[] s) {
        int leftIndex = 0;
        int rightIndex = s.length-1;
        while(leftIndex<rightIndex){
            swap(s,leftIndex,rightIndex);
            leftIndex++;
            rightIndex--;
        }
    }
    /*
    * 这里是通过字符数组交换位置的核心交换语句
    * */
    public void swap(char[] s,int index1,int index2){
        char cTemp = s[index1];
        s[index1] = s[index2];
        s[index2] = cTemp;

    }

    public String leetcode541(String s, int k) {
        char[] string = s.toCharArray();
        int start = 0;
        int rangeK = start+k;
        int range2k = rangeK+k;
        int len = string.length;
        while(len>=range2k){
            int left=start;
            int right = rangeK-1;
            while(left<right){
                swap(string,left,right);
                right--;
                left++;
            }
            start = range2k;
            rangeK =start+k;
            range2k =rangeK+k;
        }
        if(len<range2k && len>rangeK){
            int left=start;
            int right = rangeK-1;
            while(left<right){
                swap(string,left,right);
                right--;
                left++;
            }
        }
        if(len<=rangeK){
            int left=start;
            int right = len-1;
            while(left<right){
                swap(string,left,right);
                right--;
                left++;
            }
        }
        return new String(string);
    }

    public String leetcode345(String s) {
        Set<Character> recordChars = new HashSet<>();
        char[] chars = {'a','e','i','o','u','A','E','I','O','U'};
        for(int i=0;i<chars.length;i++){
            recordChars.add(chars[i]);
        }
        char[] string = s.toCharArray();
        List<Integer> indexList = new ArrayList<>();
        for(int i=0;i<string.length;i++){
            if(recordChars.contains(string[i])){
                indexList.add(i);
            }
        }
        int[] resWord = new int[indexList.size()];
        char[] resc = new char[indexList.size()];
        for(int i=resWord.length-1;i>=0;i--){
            resWord[i]=indexList.get((resWord.length-1)-i);
            resc[i]=string[resWord[i]];
        }
        int count =0;
        for(int i=0;i<string.length;i++){
            if(recordChars.contains(string[i])){
                string[i]= resc[count++];
            }
        }
        return new String(string);
    }


}
