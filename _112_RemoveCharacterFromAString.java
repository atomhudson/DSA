public class _112_RemoveCharacterFromAString {
    public static void main(String[] args) {
        String str = "baccadhaah";
        char ch = 'a';
        removeCharacter(str,ch);
        System.out.println(removingCharacter(str,ch));
        System.out.println(removeSubString("baccapplesbananafruit","apples"));

    }
    static void removeCharacter(String str, char ch){
        helperRemoveCharacter(str, "", ch);

    }
    private static void helperRemoveCharacter(String str, String result, char target){
        if (str.isEmpty()){
            System.out.println(result);
            return;
        }
        char character = str.charAt(0);
        if (character == target){
            helperRemoveCharacter(str.substring(1), result,target);
        }else{
            helperRemoveCharacter(str.substring(1), result + character,target);
        }
    }

    static String removingCharacter(String str, char target){
        return helperRemovingCharacter(str, target);
    }
    private static String helperRemovingCharacter(String str, char target){
        if (str.isEmpty()){
            return "";
        }
        char character = str.charAt(0);
        if (character == target){
            return helperRemovingCharacter(str.substring(1),target);
        }else {
            return character + helperRemovingCharacter(str.substring(1),target);
        }
    }

    static String removeSubString(String str, String target){
        if (str.isEmpty()){
            return "";
        }
        if (str.startsWith(target)){
            return removeSubString(str.substring(target.length()),target);
        }else{
            return str.charAt(0) + removeSubString(str.substring(1),target);
        }
    }


}
