package com.example.dicomdemo.controller;

import com.example.dicomdemo.Repository.HospitalRepository;
import com.example.dicomdemo.Repository.UserRepository;
import com.example.dicomdemo.entity.Hospital;
import com.example.dicomdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Random;

//@WebServlet("/adm/login")
@RestController
@RequestMapping("/adm")
public class LoginController{
    public static Random random;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HospitalRepository hospitalRepository;


    @PostMapping("/login")
    public String Login(@RequestBody User user){
        String uname;
        String utype;
//        return user.getUname();
        List<User> Users = userRepository.findByUname(user.getUname());
        String pass= user.getUpassword();

        if(Users.isEmpty()|| !Objects.equals(pass, Users.get(0).getUpassword())){
            return "失败";
        }else{
            uname = Users.get(0).getUname();
            utype = Users.get(0).getUtype();
            return utype;
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        String hinf;
        String hcode;
        if(Objects.equals(user.getUtype(), "idi")){
            user.setUauth(null);
            user.setHname(null);
            if(userRepository.findByUname(user.getUname()).isEmpty()) {
                userRepository.save(user);
                if (!userRepository.findByUname(user.getUname()).isEmpty()) {
                return "注册成功";
                } else {
                return "注册失败";
                }
            }else{
                return "已有该用户！";
            }
        }else{
            hinf = user.getUauth();
            user.setUauth(null);
            Hospital com = new Hospital();
            com.setHname(user.getHname());
            com.setHinf(hinf);
            int max=1000000;
            int min=100000;
            random=new Random();
            hcode = String.valueOf(random.nextInt(max)%(max-min+1)+min);
            com.setCcode(hcode);
            hospitalRepository.save(com);
            if(userRepository.findByUname(user.getUname()).isEmpty()) {
                userRepository.save(user);
                return "注册成功！";
            }else{
                return "已有该用户！";
            }
        }
    }


}
