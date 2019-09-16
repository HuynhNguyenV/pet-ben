package com.softech.petben.repositories;

import com.softech.petben.domain.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
