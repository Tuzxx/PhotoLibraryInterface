package com.tuzx.demo.service.impl;

import com.tuzx.demo.mapper.ImgCardMapper;
import com.tuzx.demo.pojo.ImgCard;
import com.tuzx.demo.service.ImgCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgCardServiceImpl implements ImgCardService {
    @Autowired
    private ImgCardMapper imgCardMapper;

    @Override
    public List<ImgCard> showAll() {
        return imgCardMapper.showAll();
    }

    @Override
    public List<ImgCard> showSomeBodyAll(int uid) {
        return imgCardMapper.showSomeBodyAll(uid);
    }

    @Override
    public void postImgCard(ImgCard ic) {
        imgCardMapper.postImgCard(ic);
    }

    @Override
    public void deleteImgCard(int pid) {
        imgCardMapper.deleteImgCard(pid);
    }

    @Override
    public void incrementLike(int pid) {
        imgCardMapper.incrementLike(pid);
    }

    @Override
    public void decrementLike(int pid) {
        imgCardMapper.decrementLike(pid);
    }
}
