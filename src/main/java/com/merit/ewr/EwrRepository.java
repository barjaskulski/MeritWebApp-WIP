package com.merit.ewr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EwrRepository extends JpaRepository<EwrEntity,Long> {
}
