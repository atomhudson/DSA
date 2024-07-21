public class _047_1528_Shuffle_String {
    public String restoreString(String s, int[] indices) {
//        char[] arr = s.toCharArray();
//        HashMap<Integer, Character> map = new HashMap<>();
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < indices.length; i++) {
//            map.put(indices[i], arr[i]);
//        }
//        for (Map.Entry<Integer,Character> maps : map.entrySet()){
//            result.append(maps.getValue());
//        }
//        return result.toString();
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[indices[i]] = s.charAt(i);
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        _047_1528_Shuffle_String newa = new _047_1528_Shuffle_String();
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
//        HashMap<Integer, Character> map = newa.restoreString(s, indices);
//        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
        System.out.println(newa.restoreString(s,indices));
    }
}
