package com.example.dicomdemo.service;

import com.example.dicomdemo.Repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;
}
