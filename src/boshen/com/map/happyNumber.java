package boshen.com.map;

import java.util.HashSet;
import java.util.Set;

public class happyNumber {
    public boolean leetcode202(int n) {
        Set<Integer> recordSet = new HashSet<>();
        int sqreSum = 0;
        while(n>=1){
            int bit = n%10;
            n = n/10;
            sqreSum += bit*bit;
            if(n<1){
                if(recordSet.contains(sqreSum)){
                    return false;
                }
                recordSet.add(sqreSum);
                n = sqreSum;
                if(n==1){
                    break;
                }
                sqreSum=0;
            }
        }
        return true;
    }

}
