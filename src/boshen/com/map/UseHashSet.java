package boshen.com.map;

import java.util.HashSet;
import java.util.Set;

public class UseHashSet {
    public int[] leetcode345(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for(int i:nums1){
            set1.add(i);
        }
        for(int i:nums2){
            if(set1.contains(i)){
                resSet.add(i);
            }
        }
        int[] resArr = new int[resSet.size()];
        int index = 0;

        for (int i : resSet) {
            resArr[index++] = i;
        }
        return resArr;

    }
}
