package com.merit.sample;

import lombok.extern.slf4j.Slf4j;
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
    public SampleEntity getSampleById(@PathVariable long sampleId) {
        return sampleService.getSampleById(sampleId);
    }

    @PostMapping("/sample")
    public SampleEntity addSample(@RequestBody SampleEntity sampleEntity) {
        return sampleService.addSample(sampleEntity);
    }

    @DeleteMapping("/sample/{sampleId}")
    public void removeSampleById(@PathVariable long sampleId) {
        sampleService.removeSampleById(sampleId);
    }

    @DeleteMapping("/sample/{ewrId}")
    public void removeSampleByEwr(@RequestBody long ewrId) {
        sampleService.removeSampleByEwr(ewrId);
    }
}
