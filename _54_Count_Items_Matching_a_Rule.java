import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _54_Count_Items_Matching_a_Rule {
//            ruleKey == "type" and ruleValue == typei.
//            ruleKey == "color" and ruleValue == colori.
//            ruleKey == "name" and ruleValue == namei.
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for(int i=0;i<items.size();i++){
            if(ruleKey.equals("type") && items.get(i).get(0).equals(ruleValue)){
                count++;
            }
            if(ruleKey.equals("color") && items.get(i).get(1).equals(ruleValue)){
                count++;
            }
            if(ruleKey.equals("name") && items.get(i).get(2).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("phone", "blue", "pixel"));
        items.add(Arrays.asList("computer", "silver", "lenovo"));
        items.add(Arrays.asList("phone", "gold", "iphone"));

        String ruleKey = "type", ruleValue = "phone";
        System.out.println(countMatches(items,ruleKey,ruleValue));
    }
}
