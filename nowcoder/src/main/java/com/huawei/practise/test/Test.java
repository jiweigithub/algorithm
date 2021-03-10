package com.huawei.practise.test;

public class Test {

    public static void main(String[] args) {
        boolean prime = isPrime(9);
        System.out.println(prime);
    }

    /**
     * 判断x是否为素数
     *
     * @param x x
     * @return boolean
     */
    private static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
            if (x == 1) {
                return false;
            }
        }
        return true;
    }
}
