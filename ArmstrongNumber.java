import java.util.*;

public class ArmstrongNumber {

    public static boolean checkArmstrong(int num) {
        int count = 0;
        int temp = num;

        if (num == 0) return true;

        while (temp != 0) {
            count++;
            temp /= 10;
        }

        temp = num;
        double sum = 0;

        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, count);
            temp /= 10;
        }

        return sum == num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (checkArmstrong(num)) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }
    }
}



// public class ArmstrongNumber {

//     public static boolean checkArmstrong(int num) {
//         int count = 0;
//         int temp = num;

//         // Count number of digits
//         while (temp != 0) {
//             count++;
//             temp = temp / 10;
//         }

//         temp = num;
//         double sum = 0;

//         // Calculate sum of powers
//         while (temp != 0) {
//             int digit = temp % 10;
//             sum = sum + Math.pow(digit, count);
//             temp = temp / 10;
//         }

//         return sum == num;
//     }

//     public static void main(String args[]) {
//         int num = 158;
//         boolean result = checkArmstrong(num);

//         if (result) {
//             System.out.println("Armstrong Number");
//         } else {
//             System.out.println("Not an Armstrong Number");
//         }
//     }
//}
