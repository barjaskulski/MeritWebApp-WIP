package com.merit;

import com.merit.ewr.EwrEntity;
import com.merit.ewr.EwrRepository;
import com.merit.sample.SampleEntity;
import com.merit.sample.SampleRepository;
import com.merit.user.UserEntity;
import com.merit.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;
    private final SampleRepository sampleRepository;
    private final EwrRepository ewrRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, SampleRepository sampleRepository, EwrRepository ewrRepository) {
        this.userRepository = userRepository;
        this.sampleRepository = sampleRepository;
        this.ewrRepository = ewrRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(new UserEntity("bja","123","bartek","jas"));
        userRepository.save(new UserEntity("abr","123","adam","bra"));
        userRepository.save(new UserEntity("wsw","123","wojtek","swi"));
        userRepository.save(new UserEntity("sci","123","sebastian","cie"));
        userRepository.save(new UserEntity("kko","123","karolina","kol"));

        sampleRepository.save(new SampleEntity("001"));
        sampleRepository.save(new SampleEntity("002"));
        sampleRepository.save(new SampleEntity("003"));
        sampleRepository.save(new SampleEntity("004"));
        sampleRepository.save(new SampleEntity("005"));
        sampleRepository.save(new SampleEntity("006"));
        sampleRepository.save(new SampleEntity("007"));
        sampleRepository.save(new SampleEntity("008"));
        sampleRepository.save(new SampleEntity("009"));
        sampleRepository.save(new SampleEntity("010"));

        ewrRepository.save(new EwrEntity("K20210001","koral"));
        ewrRepository.save(new EwrEntity("K20210022","synek"));
        ewrRepository.save(new EwrEntity("K20210333","roksi"));
    }
}
