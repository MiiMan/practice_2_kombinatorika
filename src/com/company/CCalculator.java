package com.company;

import java.util.Scanner;

public class CCalculator {

    CCalculator(){}

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выполнили: Альхеев Геннадий, Бондарь Георгий");
        System.out.println("#####################################");
        System.out.println("############ КАЛЬКУЛЯТОР ############");
        System.out.println("#####################################");
        System.out.println("");

        System.out.println("1)Сочетания\n2)Размещения\n3)Перестановка");
        System.out.print("Выберите операцию: ");
        int type = sc.nextInt();
        System.out.print("С повторениями? ");
        sc.nextLine();
        String is = sc.nextLine();
        boolean isWR = is.equals("Да");

        System.out.println("\nВведите коэффициенты.");
        int n, m;

        switch (type) {
            case 1:
                System.out.print("Введите m: ");
                m = sc.nextInt();
                System.out.print("Из различных n: ");
                n = sc.nextInt();

                if (isWR) {
                    System.out.print("\nОтвет: ");
                    System.out.print(CCalculator.CombinationsWR(m, n));
                } else {
                    System.out.print("\nОтвет: ");
                    System.out.print(CCalculator.Combinations(m, n));
                }
                break;
            case 2:
                System.out.print("Введите m: ");
                m = sc.nextInt();
                System.out.print("Из различных n: ");
                n = sc.nextInt();

                if (isWR) {
                    System.out.print("\nОтвет: ");
                    System.out.print(CCalculator.AllocationWR(m, n));
                } else {
                    System.out.print("\nОтвет: ");
                    System.out.print(CCalculator.Allocation(m, n));
                }
                break;
            case 3:
                System.out.print("Введите массив n по k: ");
                String str = sc.nextLine();

                String[] arr = str.split(" ");
                int[] k = new int[arr.length];
                int sum = 0;

                for (int i = 0; i < arr.length; i++) {
                    k[i] = Integer.parseInt(arr[i]);
                    sum += k[i];
                }

                if (!isWR) {
                    System.out.print("Ответ: ");
                    System.out.print(CCalculator.PermutationWR(sum));
                } else {
                    System.out.print("Ответ: ");
                    System.out.print(CCalculator.Permutation(k));
                }
                break;
        }
    }

    public static long CombinationsWR(int m, int n) {
        return SemiFactorial(n, n-m)/(Factorial(m));
    }

    public static long Combinations(int m, int n) {
        return Factorial(n+m-1)/(Factorial(m)*Factorial(n-1));
    }

    public static long AllocationWR(int m, int n) {
        return Factorial(n)/Factorial(n-m);
    }

    public static long Allocation(int m, int n) {
        return (long)Math.pow(n, m);
    }

    public static long PermutationWR(int n) {
        return Factorial(n);
    }

    public static long Permutation(int[] k) {
        long result = 1;
        int count = 0;

        for (int i = 0; i < k.length; i++) {
            result *= Factorial(k[i]);
            count += k[i];
        }

        return Factorial(count)/result;
    }

    public static long Factorial(int value) {
        long result = 1;
        for (int i = 1; i <= value; i++) {
            result *= i;
        }

        return result;
    }

    public static long SemiFactorial(int value, int from) {
        long result = 1;
        for (int i = from+1; i <= value; i++) {
            result *= i;
        }

        return result;
    }
}
