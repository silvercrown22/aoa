import java.util.*;
public class LCS{
    static int[][] getLcs(String x, String y){
        int[][] lcs = new int[x.length()+1][y.length()+1];
        for(int i=0;i<=x.length();i++){
            for(int j=0;j<=y.length();j++){
                if(i==0 || j==0) lcs[i][j]=0;
                else if(x.charAt(i-1)==y.charAt(j-1)) lcs[i][j] = 1 + lcs[i-1][j-1];
                else lcs[i][j]  = Math.max(lcs[i-1][j],lcs[i][j-1]);
            }

        }
        return lcs;
    }


    static String getSequence(int[][] lcs,String str1, String str2){

        int i = str1.length();
        int j = str2.length();
        String seq ="";
        while(i>0){
            int curr = lcs[i][j];
            if(curr == lcs[i-1][j]) i--;
            else if(curr == lcs[i][j-1]) j--;
            else {
                i--;
                j--;
                seq = str1.charAt(i) + seq;
            }
        }

        return seq;

    }

    public static void main(String[] args){
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        int[][] lcs = getLcs(str1,str2);
        String seq = getSequence(lcs,str1,str2);
        System.out.println("Longest Sub Sequence length: " + seq.length());
        System.out.println("Longest Sub Sequence: " + seq);        
    }
}
