package com.softech.petben.repositories;

import com.softech.petben.domain.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer> {
    List<Faq> findByTitle(String title);
}
