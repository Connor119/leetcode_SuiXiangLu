package boshen.com.Array;

/*探究java中数组是否是连续的*/
public class basicIdea {
    public static void main(String[] args) {
        int[] testArr = {1,2,3};
        for (int i : testArr) {
            System.out.println(testArr.hashCode());
        }
    }

}
