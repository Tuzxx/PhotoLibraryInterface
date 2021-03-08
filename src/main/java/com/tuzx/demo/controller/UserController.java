package com.tuzx.demo.controller;

import com.tuzx.demo.pojo.User;
import com.tuzx.demo.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    JavaMailSenderImpl mailSender;

    @CrossOrigin()
    @PostMapping("/login")
    public User getUser(@RequestBody User user) {
        if(userServiceImpl.getPassword(user.getUsername()).equals(user.getPassword())){
            return userServiceImpl.getUser(user.getUsername());
        } else {
            return null;
        }
    }

    @CrossOrigin
    @GetMapping("/getuser/{username}")
    public User getUserData(@PathVariable("username") String username) {
        return userServiceImpl.getUser(username);
    }

    @CrossOrigin()
    @PostMapping("/register")
    public String addUser(@RequestBody User user) {
        userServiceImpl.addUser(user);
        if (userServiceImpl.verifyUsername(user.getUsername()) > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    @CrossOrigin
    @GetMapping("/getusername/{username}")
    public Boolean checkUsername(@PathVariable("username") String username) {
        if (userServiceImpl.verifyUsername(username) > 0) {
            return false;
        } else {
            return true;
        }
    }

    @CrossOrigin
    @GetMapping("/sendEmailCode/{email}")
    public String sendCode(@PathVariable("email") String email) throws Exception {
        // 生成验证码
        int length = 6; // 验证码位数
        String code = "";
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                code += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                code += String.valueOf(random.nextInt(10));
            }
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("注册验证码");
        message.setText(code);
        message.setTo(email);
        message.setFrom("810852437@qq.com");

        mailSender.send(message);

        return code;
    }

    @CrossOrigin
    @PostMapping("/updatePassword")
    public String updatePassword(@RequestBody User user) {
        userServiceImpl.updatePassword(user);
        if (userServiceImpl.getPassword(user.getUsername()).equals(user.getPassword())) {
            return "success";
        } else {
            return "error";
        }
    }

    @CrossOrigin
    @GetMapping("/getuseremail/{username}")
    public String getUserEmail(@PathVariable("username") String username) {
        String email = userServiceImpl.getUserEmail(username);
        if(email != null) {
            return email;
        } else {
            return "error";
        }
    }

    @CrossOrigin
    @RequestMapping("/addphoto")
    @ResponseBody
    public String addPhoto(@RequestParam("image_data") MultipartFile file) {

        String newCompanyImageName = nameTheFile(file, "Photo");
        String newCompanyImagepath = "D:\\Study\\PhotoLibrary\\img\\"+newCompanyImageName;

        //文件上传
        if (!file.isEmpty()) {
            try {
                File newFile = new File(newCompanyImagepath);
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(newFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }
        return "http://localhost:9001/img/" + newCompanyImageName;
    }

    public String nameTheFile(MultipartFile file, String fileType) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-mm-ss");

        String extension = "";
        try {
            if (file != null && !file.isEmpty()) {
                String name = file.getOriginalFilename();
                extension = name.substring(name.lastIndexOf("."));
            }
        } catch (Exception e) {
            extension = "";
        }

        String fileName = fileType + "-" + date + "-" + time.format(formatter) + extension;

        return fileName;
    }

    @CrossOrigin
    @PostMapping("/updateuserprofile")
    public String updateUser(@RequestBody User user) {
        userServiceImpl.updateUser(user);
        return "success";
    }

    @Test
    public void test() {
        Date date = new Date();
        System.out.println(date);
    }

}
