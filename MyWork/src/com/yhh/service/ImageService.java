package com.yhh.service;

import java.util.List;

import com.yhh.pojo.Image;

public interface ImageService {
	//增加图片
	int addImageService(Image img);
	//查找图片
	List<Image> watchImageService(Image img);
	//删除图片
	int deleteImageService(String acquisition_time);
	
	int updateImageService(Image img);
}
