package Algorithm_and_Practice;

public class _048_Goal_Parser_Interpretation {
    public static String newString(String command){
        command = command.replace("()","o");
        command = command.replace("(al)","al");
        return command;
    }

    public static void main(String[] args) {
        String command = "Algorithm_and_Practice.G()(al)";
        System.out.println(newString(command));
    }
}
