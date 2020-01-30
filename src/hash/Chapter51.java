package hash;

/**
 * 宝石与石头
 */
public class Chapter51 {

    public static void main(String[] args){

    }

    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++){
            if (J.indexOf(S.charAt(i)) != -1){
                count++;
            }
        }
        return count;
    }
}
