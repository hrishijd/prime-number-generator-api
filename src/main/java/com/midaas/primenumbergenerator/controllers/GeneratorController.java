package com.midaas.primenumbergenerator.controllers;

import com.midaas.primenumbergenerator.generatorcomponent.PrimeGenerator;
import com.midaas.primenumbergenerator.models.PrimeNumberRequest;
import com.midaas.primenumbergenerator.repository.PrimeNumberRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class GeneratorController {
    @Autowired
    PrimeGenerator primeGenerator;
    @Autowired
    PrimeNumberRequestRepository primeNumberRequestRepository;
    @RequestMapping(method = RequestMethod.GET,value = "/primes")
    public ResponseEntity getPrimes(@RequestParam int low,@RequestParam int high)
    {
        //primeGenerator.generate(low,high);
        System.out.println("ok");
        try {
            PrimeNumberRequest primeNumberRequest = new PrimeNumberRequest();
            primeNumberRequest.setDate(Date.valueOf(LocalDate.now()));
            primeNumberRequest.setLow(low);
            primeNumberRequest.setHigh(high);
            ArrayList<Integer> list = primeGenerator.generate(low, high);
            primeNumberRequest.setPrimes(list);
            primeNumberRequestRepository.save(primeNumberRequest);
            return ResponseEntity.ok(primeNumberRequest);
        }
        catch (Exception e) {
            return ResponseEntity.ok(e.getClass());
        }
    }
}
