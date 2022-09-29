package com.midaas.primenumbergenerator.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.ArrayList;

@Entity
@Data
public class PrimeNumberRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int low;
    private int high;
    private Date date;
    private ArrayList<Integer> primes;
}
