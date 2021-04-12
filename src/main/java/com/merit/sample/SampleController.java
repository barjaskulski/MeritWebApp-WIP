package com.merit.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/sample")
    public List<SampleEntity> getAllSample() {
        return sampleService.getAllSample();
    }

    @GetMapping("/sample/{sampleId}")
    public SampleEntity getSampleById(@PathVariable Long sampleId) {
        return sampleService.getSampleById(sampleId);
    }

    @PostMapping("/sample")
    @ResponseStatus(HttpStatus.CREATED)
    public SampleEntity addSample(@RequestBody SampleEntity sampleEntity) {
        return sampleService.addSample(sampleEntity);
    }

    @DeleteMapping("/sample/{sampleId}")
    public void removeSampleById(@PathVariable Long sampleId) {
        sampleService.removeSampleById(sampleId);
    }

    //---------------------------- TO DO ----------------
//    @DeleteMapping("/sample/{ewrId}")
//    public void removeSampleByEwr(@RequestBody Long ewrId) {
//        sampleService.removeSampleByEwr(ewrId);
//    }
//
//    @GetMapping("/sample/ewr/{ewrName}")
//    public List<SampleEntity> getAllSamplesFromEwr(@PathVariable String ewrName) {
//        return sampleService.findByEwrList(ewrName);
//    }
    //----------------------------------------------------


}
