public class _174_FindTheKthCharacterInStringGAmeI {
    public static void main(String[] args) {
        _174_FindTheKthCharacterInStringGAmeI outer = new _174_FindTheKthCharacterInStringGAmeI();
        Solution inner = outer.new Solution();
        System.out.println(inner.kthCharacter(10));
    }
    class Solution {
        public char kthCharacter(int k) {
            String word = "a";
            while (word.length() < k){
                String generated  = generateString(word);
                word+=generated;
            }
            return word.charAt(k-1);
        }
        String generateString(String word){
            String result = "";
            for (char ch: word.toCharArray()){
                char character = ch;
                character += 1;
                result += character;
            }
            return result;
        }

    }

}
