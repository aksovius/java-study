package com.example.runnerz.run;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;
    
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository; 
    }

    @GetMapping("")
    List<Run> all() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable int id) {

        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found");
        }
        return run.get();
    }
    
    
}
