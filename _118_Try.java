public class _118_Try {
    public static void main(String[] args) {
        System.out.println(ConvertToBinary("2080-02-29"));
    }
    static String ConvertToBinary(String date){
        String[] dateArr = date.split("-");
        StringBuilder an = new StringBuilder();
        for (int i = 0; i < dateArr.length; i++) {
            String binaryPart = datatoBinary(dateArr[i]);
            an.append(binaryPart);
            if (i < dateArr.length - 1) {
                an.append("-");
            }
        }

        return an.toString();

    }
    public static String datatoBinary(String date){
        int da = Integer.parseInt(date);
        return Integer.toBinaryString(da);
    }


}
