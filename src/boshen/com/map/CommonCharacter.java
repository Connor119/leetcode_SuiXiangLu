package boshen.com.map;

import java.util.ArrayList;
import java.util.List;

public class CommonCharacter {
    public List<String> leetcode1002(String[] words) {
        int[] recordArr = new int[26];
        int[] recordArr2 = new int[26];
        int len = words.length;
        List<String> res = new ArrayList<>();
        int numOfStr = 1;
        for(char c : words[0].toCharArray()){
            recordArr[c-'a']++;
        }
        for(int i=1;i<len;i++){
            for(char c:words[i].toCharArray()){
                recordArr2[c-'a']++;
            }
            for(int j=0;j<26;j++){
                if(recordArr[j]>recordArr2[j]){
                    recordArr[j]=recordArr2[j];
                }
            }
            recordArr2= new int[26];
        }
        for(int j=0;j<26;j++){
            while(recordArr[j]>0){
                res.add(Character.toString((char)(j+'a')));
                recordArr[j]--;
            }
        }
        return res;
    }
}
