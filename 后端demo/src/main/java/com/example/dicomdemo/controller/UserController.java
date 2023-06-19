package com.example.dicomdemo.controller;

import com.example.dicomdemo.Repository.HospitalRepository;
import com.example.dicomdemo.Repository.UserRepository;
import com.example.dicomdemo.entity.Hospital;
import com.example.dicomdemo.entity.User;
//import com.example.dicomdemo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private FileService fileService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HospitalRepository hospitalRepository;


    @Autowired
    ResourceLoader resourceLoader;


    @PostMapping("/getStaff")
    public List<User> GetStaff(@RequestBody User user){

        List<User> Users = userRepository.findByCnameAndUtypeAndUname(user.getHname(), user.getUtype(), user.getUname());
        return Users;
    }

    @PostMapping("/changeAuth")
    public String changeAuth(@RequestBody User user){
        List<User> users = userRepository.findByUname(user.getUname());
        users.get(0).setUauth(user.getUauth());
        userRepository.save(users.get(0));
        return "修改成功";
    }

    @PostMapping("/inf")
    public List<User> Inf(@RequestBody User user){
        List<User> Users = userRepository.findByUname(user.getUname());
        return Users;
    }

    @PostMapping("/adminf")
    public List<Hospital> AdmInf(@RequestBody User user){
        List<User> Users = userRepository.findByUname(user.getUname());
        String hname = Users.get(0).getHname();
        List<Hospital> hospitals = hospitalRepository.findByHname(hname);
        return hospitals;
    }

    @PostMapping("/changeinf")
    public String ChangeInf(@RequestBody User user){
        List<User> Users = userRepository.findByUname(user.getUname());
        User user2 = Users.get(0);
        user2.setUpassword(user.getUpassword());
        List<Hospital> hospitals = hospitalRepository.findByHcode(user.getHcode());
        if(!hospitals.isEmpty()){
            user2.setUauth("1");
            user2.setHname(hospitals.get(0).getHname());
            user2.setUtype("staff");
        }
        userRepository.save(user2);
        return "修改成功！";
    }

//    @RequestMapping("/upload/file")
//    public UploadFileResponse uploadFile(
//            @RequestParam("file") MultipartFile file,@RequestParam("uname") String uname){
//
//        String fileName = fileService.storeFile(file,uname);
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/user/downloadFile/")
//                .path(fileName)
//                .toUriString();
//        //获取上传用户名
//        System.out.println(uname);
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }




    //下载日志文件
//    @RequestMapping("/downloadFile/{fileName:.+}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
//        Resource resource = fileService.loadFileAsResource(fileName);
//        String contentType = null;
//        try {
//            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//        } catch (IOException ex) {
//
//        }
//
//        if(contentType == null) {
//            contentType = "application/octet-stream";
//        }
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }

}