package com.merit.ewr;

import com.merit.sample.SampleEntity;
import com.merit.sample.SampleService;
import com.merit.user.UserEntity;
import com.merit.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class EwrController {

    EwrService ewrService;
    SampleService sampleService;
    UserService userService;

    @Autowired
    public EwrController(EwrService ewrService, SampleService sampleService, UserService userService) {
        this.ewrService = ewrService;
        this.sampleService = sampleService;
        this.userService = userService;
    }

    @GetMapping("/ewr")
    public List<EwrEntity> getAllEwr() {
        return ewrService.getAllEwr();
    }

    @GetMapping("/ewr/{ewrId}")
    public EwrEntity getEwrById(@PathVariable Long ewrId) {
        return ewrService.getEwrById(ewrId);
    }

    @PostMapping("/ewr")
    @ResponseStatus(HttpStatus.CREATED)
    public EwrEntity addEwr(@RequestBody EwrEntity ewrEntity) {
        return ewrService.addEwr(ewrEntity);
    }

    @DeleteMapping("/ewr/{ewrId}")
    public void removeEwrById(@PathVariable Long ewrId) {
        ewrService.removeEwrById(ewrId);
    }

    //--------------------------------- samples actions in ewr ---------------------------------------------------------
    @PutMapping("/ewr/{ewrId}/addSample/{sampleId}")
    public EwrEntity addSampleToEwr(
            @PathVariable Long ewrId,
            @PathVariable Long sampleId
    ){
        EwrEntity ewrEntity = ewrService.getEwrById(ewrId);
        SampleEntity sampleEntity = sampleService.getSampleById(sampleId);
        ewrEntity.addSampleToEwr(sampleEntity);
        return ewrService.addEwr(ewrEntity);
    }

    @PutMapping("/ewr/{ewrId}/removeSample/{sampleId}")
    public EwrEntity removeSampleFromEwr(
            @PathVariable Long ewrId,
            @PathVariable Long sampleId
    ){
        EwrEntity ewrEntity = ewrService.getEwrById(ewrId);
        SampleEntity sampleEntity = sampleService.getSampleById(sampleId);
        ewrEntity.removeSampleFromEwr(sampleEntity);
        return ewrService.addEwr(ewrEntity);
    }

    //----------------------------------- users actions in ewr ---------------------------------------------------------

    @PutMapping("/ewr/{ewrId}/addUser/{userId}")
    public EwrEntity addUserToEwr(
            @PathVariable Long ewrId,
            @PathVariable Long userId
    ){
        EwrEntity ewrEntity = ewrService.getEwrById(ewrId);
        UserEntity userEntity = userService.getUserById(userId);
        ewrEntity.addUserToEwr(userEntity);
        return ewrService.addEwr(ewrEntity);
    }

    @PutMapping("/ewr/{ewrId}/removeUser/{userId}")
    public EwrEntity removeUserFromEwr(
            @PathVariable Long ewrId,
            @PathVariable Long userId
    ){
        EwrEntity ewrEntity = ewrService.getEwrById(ewrId);
        UserEntity userEntity = userService.getUserById(userId);
        ewrEntity.removeUserFromEwr(userEntity);
        return ewrService.addEwr(ewrEntity);
    }
}
