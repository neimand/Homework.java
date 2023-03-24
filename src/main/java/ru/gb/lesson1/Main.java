package ru.gb.lesson1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        arrayDemo();
//        int x = getInteger();
//        System.out.println(x);

//        int[] array = {1, 1, 0, 1, 1, 1};
//        System.out.println(calculateMaxCount(array, 1)); // 3
//
//        int[] array2 = {1, 1, 0, 0, 0, 1};
//        System.out.println(calculateMaxCount(array2, 0)); // 3

//        int[] array = {3, 2, 2, 3};
//        shift(array, 3);
//        System.out.println(Arrays.toString(array)); // [2, 2, 3, 3]
//
//        int[] array2 = {1, 2, 1, 1, 2, 1, 1};
//        shift(array2, 2);
//        System.out.println(Arrays.toString(array2)); // [2, 1, 2, 1, 3, 3, 3]

        System.out.println(getCommonPrefix(new String[]{"aaab", "aacc", "aacd"})); // aa
        System.out.println(getCommonPrefix(new String[]{"abc", "abd", "cde"})); // ""
        System.out.println(getCommonPrefix(new String[]{"aaaaa", "aaaaa", "aaaaacde"})); // "aaaaa"

        String s = "abcde";
        char[] chars = s.toCharArray();

        int[][] array = {{1, 2, 3}, {4, 5}, {4, 5, 6}};
        System.out.println(array[1][1]);
//
//        int length = s.length();
//        for (int i = 0; i < length; i++) {
//            char c = s.charAt(i);
//        }
    }

    /**
     * Напишите метод, который находит самую длинную строку общего префикса среди массива строк.
     * Если общего префикса нет, вернуть пустую строку "".
     * ["aaab", "aacc", "aacd"] -> "aa"
     * ["abc", "abd", "cde"] -> ""
     * ["aaaaa", "aaaaa", "aaaaacde"] -> "aaaaa"
     */
    static String getCommonPrefix(String[] array) {
        String commonPrefix = array[0];
        for (int i = 1; i < array.length; i++) {
            String second = array[i];
            int minLength = Math.min(commonPrefix.length(), second.length());
            for (int j = 0; j < minLength; j++) {
                if (commonPrefix.charAt(j) != second.charAt(j)) {
                    commonPrefix = commonPrefix.substring(0, j);
                    break;
                }
            }
        }
        return commonPrefix;
    }

    /**
     * Дан массив nums = [3,2,2,3] и число val = 3.
     * Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
     * Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
     * [3, 2, 2, 1], val = 3 -> [1, 2, 2, 3]
     * [3, 2, 2, 3], val = 3 -> [2, 2, 3, 3]
     * [3, 2, 1, 3, 2, 1, 3], val = 3 -> [2, 1, 2, 1, 3, 3, 3]
     */
    static void shift(int[] array, int val) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != val) {
                array[count] = array[i];
                count++;
            }
        }

        for (int i = count; i < array.length; i++) {
            array[i] = val;
        }


//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == val) {
//                for (int j = array.length - 1; j > i; j--) {
//                    if (array[j] != val) {
//                        int tmp = array[i];
//                        array[i] = array[j];
//                        array[j] = tmp;
//                        break;
//                    }
//                }
//            }
//        }
    }


    /**
     * Дан массив двоичных чисел, например [1,1,0,1,1,1],
     * вывести максимальное количество подряд идущих 1.
     */
    static int calculateMaxCount(int[] array, int number) {
        int count = 0;
        int maxCount = 0;
        for (int a : array) {
            if (a == number) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 0;
            }
        }
        if (count > maxCount) {
            maxCount = count;
        }

        return maxCount;
    }

    static int getInteger() {
        return 5;
    }

    private static void arrayDemo() {
        //        int x = 5;
//        int[] x = {1, 2, 3, 4, 5};
        int[] x = new int[5]; // [0, 0, 0, 0, 0]
        int third = x[3];
        System.out.println(third);

        x[2] = -1;
        System.out.println(Arrays.toString(x));
        System.out.println(x.length);
    }

}