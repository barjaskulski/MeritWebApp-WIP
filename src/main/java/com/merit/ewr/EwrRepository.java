package com.merit.ewr;

import com.merit.sample.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EwrRepository extends JpaRepository<EwrEntity,Long> {
    //List<SampleEntity> findAllByEwrIdIn(Long ewrId);
}
