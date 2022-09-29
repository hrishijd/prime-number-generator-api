package com.midaas.primenumbergenerator.generatorcomponent;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PrimeGenerator {
    public ArrayList<Integer> generate(int low,int high)
    {
        boolean prime[] = new boolean[high + 1];
        for (int i = 0; i <= high; i++)
            prime[i] = true;
        ArrayList<Integer> primeNos=new ArrayList<Integer>();
        for (int p = 2; p *(long) p <= high; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= high; i += p)
                    prime[i] = false;
            }
        }
        for (int i = low; i <= high; i++) {
            if (prime[i] == true && i!=0)
                primeNos.add(i);
        }
        return primeNos;
    }
}
