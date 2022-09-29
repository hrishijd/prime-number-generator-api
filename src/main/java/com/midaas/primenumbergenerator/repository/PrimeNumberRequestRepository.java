package com.midaas.primenumbergenerator.repository;

import com.midaas.primenumbergenerator.models.PrimeNumberRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimeNumberRequestRepository extends JpaRepository<PrimeNumberRequest,Long> {
}
