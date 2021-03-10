package com.hazelcast.demo.contractfirst;

import lombok.Data;

import java.util.List;

@Data
public class PersonModel {
    private String userName;
    private int age;
    private List<String> emails;
}
