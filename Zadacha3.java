import java.io.*;
import java.util.*;

public class Zadacha3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("C:\\Users\\Acer\\IdeaProjects\\first\\src\\1111.txt"));
        List<Integer> list = new ArrayList<>();

        // 1. Считываем все числа из файла в список
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        sc.close();

        // 2. Находим минимальное кратное 37 и максимальное кратное 73
        int min37 = Integer.MAX_VALUE;
        int max73 = Integer.MIN_VALUE;

        for (int num : list) {
            if (num % 37 == 0) {
                min37 = Math.min(min37, num);
            }
            if (num % 73 == 0) {
                max73 = Math.max(max73, num);
            }
        }

        // Границы интервала: left — меньшее из двух, right — большее
        int left = Math.min(min37, max73);
        int right = Math.max(min37, max73);

        int count = 0;
        int minSum = Integer.MAX_VALUE;

        // 3. Перебираем все пары соседних элементов
        for (int i = 0; i < list.size() - 1; i++) {
            int a = list.get(i);
            int b = list.get(i + 1);

            // Проверяем, лежит ли каждый элемент строго между left и right
            boolean aBetween = (a > left && a < right);
            boolean bBetween = (b > left && b < right);

            // XOR: ровно один элемент пары находится внутри интервала
            if (aBetween ^ bBetween) {
                count++;
                minSum = Math.min(minSum, a + b);
            }
        }

        System.out.println(count + " " + minSum);
    }
}