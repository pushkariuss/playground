/**
 * Created by pushkariuss on 10.04.2017.
 */
public class ArraysCompare {
    public static void main (String[] args){
        int[] ar1={1,2,3,0,0,0,9,1};
        int[] ar2={3,2,1,1};
        for (int i = 0; i < ar1.length; i++ )
        {
         for (int j = 0; j < ar2.length; j++)
         {if (ar1[i]==ar2[j]) System.out.println("("+ar1[i]+";"+ar2[j]+")");}
        }
    }
}
