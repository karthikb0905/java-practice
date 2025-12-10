public class strings {
    public static String reverse(String str){
        String reversed =" ";
        for (int i =str.length()-1;i>=0;i--){
            reversed = reversed + str.charAt(i);
        }
        return reversed ;
    }
    public static boolean
    public static void main(String[] args) {
        String reversed = reverse("Hello");

        System.out.println(reversed);
    }
}

