package com.hazelcast.demo.contractfirst;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class PersonController {
    
    private Map<String, PersonModel> storage = new ConcurrentHashMap<>();
    
    @PostMapping("/persons")
    public void create(@RequestBody PersonModel person) {
        storage.put(person.getUserName(), person);
    }
}
