package com.example.dicomdemo.Repository;

import com.example.dicomdemo.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {

    List<Hospital> findByHname(String Hname);

    List<Hospital> findByHcode(String Hcode);
}
