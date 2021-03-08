package com.tuzx.demo.controller;

import com.tuzx.demo.pojo.ImgCard;
import com.tuzx.demo.service.impl.ImgCardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
public class ImgCardController {

    @Autowired
    private ImgCardServiceImpl imgCardService;

    @CrossOrigin
    @PostMapping("/postcard")
    public void postCard(@RequestBody ImgCard ic) {
        Date date = new Date();
        ic.setDatee(date);
        imgCardService.postImgCard(ic);
    }

    @CrossOrigin
    @GetMapping("/showall")
    public List<ImgCard> showAll() {
        List<ImgCard> list = imgCardService.showAll();
        Collections.reverse(list);
        return list;
    }

    @CrossOrigin
    @GetMapping("/showoneall/{uid}")
    public List<ImgCard> showSomeBodyAll(@PathVariable("uid") int uid) {
        List<ImgCard> list = imgCardService.showSomeBodyAll(uid);
        Collections.reverse(list);
        return list;
    }

    @CrossOrigin
    @DeleteMapping("/deletecard/{pid}")
    public String deleteCard(@PathVariable("pid") int pid) {
        imgCardService.deleteImgCard(pid);
        return "success";
    }

    @CrossOrigin
    @GetMapping("/likeadd/{pid}")
    public void likeIncrement(@PathVariable("pid") int pid) {
        imgCardService.incrementLike(pid);
    }

    @CrossOrigin
    @GetMapping("/likereduce/{pid}")
    public void likeDecrement(@PathVariable("pid") int pid) {
        imgCardService.decrementLike(pid);
    }
}
