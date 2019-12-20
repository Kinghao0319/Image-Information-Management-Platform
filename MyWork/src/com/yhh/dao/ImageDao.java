package com.yhh.dao;

import java.util.List;

import com.yhh.pojo.Image;

public interface ImageDao {
	int addImageDao(Image img);
	
	List<Image> watchImageDao(Image img);
	
	int deleteImageDao(String acquisition_time);
	
	int updateImageDao(Image img);
}
