package com.merit.sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<SampleEntity,Long> {
    List<SampleEntity> findByEwrList(String ewrName);
}
