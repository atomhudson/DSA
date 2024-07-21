public class _046_Defanging_an_IP_Address {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
    public static void main(String[] args) {
        _046_Defanging_an_IP_Address a = new _046_Defanging_an_IP_Address();
        String address = "1.1.1.1";
        System.out.println(a.defangIPaddr(address));
    }
}
