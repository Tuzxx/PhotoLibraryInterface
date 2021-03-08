package com.tuzx.demo.service;

import com.tuzx.demo.pojo.ImgCard;

import java.util.List;

public interface ImgCardService {
    public List<ImgCard> showAll();
    public List<ImgCard> showSomeBodyAll(int uid);
    public void postImgCard(ImgCard ic);
    public void deleteImgCard(int pid);
    public void incrementLike(int pid);
    public void decrementLike(int pid);
}
