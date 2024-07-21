public class _051_Permutation_Difference_Between_Two_Strings {
    public static int findPermutationDifference(String s, String t) {
        int indexofs;
        int indexoft;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    indexoft = t.indexOf(t.charAt(j));
                    indexofs = s.indexOf(s.charAt(i));
                    result = result + Math.abs(indexofs-indexoft);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "abcde";
        String t = "edbac";
        System.out.println(findPermutationDifference(s,t));
    }
}
