import java.util.Scanner;

public class maxNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            String num = scanner.next(); // Input number as a string
            int n = num.length();

            // Check if the number is already divisible by 3
            if (isDivisible(num)) {
                System.out.println(num);
                continue;
            }

            // Find the largest possible number by changing a single digit
            char[] arr = num.toCharArray();
            boolean found = false;
            for (int i = 0; i < n; i++) {
                for (char ch = '9'; ch > arr[i]; ch--) {
                    if (ch == '0') continue; // Skip leading zero
                    char original = arr[i];
                    arr[i] = ch;
                    String newNum = new String(arr);
                    if (isDivisible(newNum)) {
                        System.out.println(newNum);
                        found = true;
                        break;
                    }
                    arr[i] = original; // Revert the change
                }
                if (found) break;
            }
            if (!found) {
                System.out.println("-1");
            }
        }
    }

    // Function to check if a number is divisible by 3
    public static boolean isDivisible(String num) {
        int sum = 0;
        for (char ch : num.toCharArray()) {
            sum += ch - '0';
        }
        return sum % 3 == 0;
    }
}

