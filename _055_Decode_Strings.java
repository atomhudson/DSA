public class _055_Decode_Strings {
    public static String decodeMessage(String key, String message) {
        char actual[]=new char[128];
        actual[' ']=' ';
        char c='a';
        for(char ch:key.toCharArray()){
            if(actual[ch]==0){
                actual[ch]=c;
                c++;
            }
        }
        char decode[]=new char[message.length()];
        int i=0;
        for(char ch:message.toCharArray()){
            decode[i++]=actual[ch];
        }
        return new String(decode);
    }
    public static void main(String[] args) {
        String key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        System.out.println(decodeMessage(key,message));
    }
}
//