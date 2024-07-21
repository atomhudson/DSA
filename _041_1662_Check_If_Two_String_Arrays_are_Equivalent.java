public class _041_1662_Check_If_Two_String_Arrays_are_Equivalent {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String newWord1 = "";
        String newWord2 = "";
        for (String word: word1){
            newWord1 = newWord1.concat(word);
        }
        for (String word: word2){
            newWord2 = newWord2.concat(word);
        }
        return newWord1.equals(newWord2) ? true : false;
    }
    public static boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        StringBuilder newWord1 = new StringBuilder();
        StringBuilder newWord2 = new StringBuilder();
        for (String word : word1){
            newWord1.append(word);
        }
        for (String word : word2){
            newWord2.append(word);
        }
        return newWord1.toString().equals(newWord2.toString());

    }
    public static void main(String[] args) {
        String[] word1 = {"abc", "d", "defg"}, word2 = {"abcddefg"};
        System.out.println(arrayStringsAreEqual(word1,word2));
        System.out.println(arrayStringsAreEqual1(word1,word2));
    }
}
