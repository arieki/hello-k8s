package id.talentia.hellok8s;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class TimeCompelityTest {
    
    @Test
    public void testCheckPrimeNumber() {
        assertTrue(isPrime(5));
    }

    @Test
    public void testFibMemoization() {
        int n = 6;
        int[] memo = new int[n+1];
        for(int i = 0; i < n; i++) {
            System.out.println(i + ":" + fibMemoization(i, memo));
        }
    }

    @Test
    public void testPrintPowerOf(){
        int curr = powerOf2(10);
    }

    @Test
    public void testGenerateRandomUUID() {
        System.out.println(UUID.randomUUID().toString());
    }

    public int powerOf2(int n){
        if(n < 1)return 0;
        else if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int prev = powerOf2(n/2);
            int curr = prev *2;
            System.out.println(curr);
            return curr;
        }
    }

    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if(n% i == 0) return false;
        }
        return true;
    }

    public int fibMemoization(int n, int[] memo) {
        if(n <= 0) return 0;
        else if(n == 1) return 1;
        else if(memo[n] > 0) return memo[n];

        memo[n] = fibMemoization(n-1, memo) + fibMemoization(n-2, memo);
        return memo[n];
    }
}