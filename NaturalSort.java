import java.util.*;

 class NaturalSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> values = new ArrayList<>();
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            values.add(scanner.next());
        }
        values.sort(Comparator.naturalOrder());
        System.out.println("Sorted list: " + values);
        scanner.close();
    }
}