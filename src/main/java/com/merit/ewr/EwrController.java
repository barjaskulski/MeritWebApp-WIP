package com.merit.ewr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class EwrController {

    private final EwrService ewrService;

    public EwrController(EwrService ewrService) {
        this.ewrService = ewrService;
    }

    @GetMapping("/ewr")
    public List<EwrEntity> getAllEwr() {
        return ewrService.getAllEwr();
    }

    @GetMapping("/ewr/{ewrId}")
    public EwrEntity getEwrById(@PathVariable long ewrId) {
        return ewrService.getEwrById(ewrId);
    }

    @PostMapping("/ewr")
    public EwrEntity addEwr(@RequestBody EwrEntity ewrEntity) {
        return ewrService.addEwr(ewrEntity);
    }

    @DeleteMapping("/ewr/{ewrId}")
    public void removeEwrById(@PathVariable long ewrId) {
        ewrService.removeEwrById(ewrId);
    }
}
