package com.tuzx.demo.mapper;

import com.tuzx.demo.pojo.ImgCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImgCardMapper {
    public List<ImgCard> showAll();
    public List<ImgCard> showSomeBodyAll(int uid);
    public void postImgCard(ImgCard ic);
    public void deleteImgCard(int pid);
    public void incrementLike(int pid);
    public void decrementLike(int pid);
}
