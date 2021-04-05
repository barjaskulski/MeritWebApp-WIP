package com.merit.ewr;

import com.merit.sample.SampleEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Component
public class EwrService {
    private final EwrRepository ewrRepository;

    public EwrService(EwrRepository ewrRepository) {
        this.ewrRepository = ewrRepository;
    }

    public List<EwrEntity> getAllEwr() {
        return ewrRepository.findAll();
    }

    public EwrEntity getEwrById(long id){
        return ewrRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public EwrEntity addEwr(EwrEntity ewrEntity) {
        return ewrRepository.save(ewrEntity);
    }

    public void removeEwrById(long id) {
        EwrEntity ewrEntityToDelete = ewrRepository.findById(id).orElseThrow(NoSuchElementException::new);
        ewrRepository.delete(ewrEntityToDelete);
    }

}
