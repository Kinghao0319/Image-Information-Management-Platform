package com.yhh.service.impl;

import java.util.List;

import com.yhh.dao.ImageDao;
import com.yhh.dao.impl.ImageDaoImpl;
import com.yhh.pojo.Image;
import com.yhh.service.ImageService;

public class ImageServiceImpl implements ImageService{
	
	ImageDao imgd=new ImageDaoImpl();
	
	@Override
	public int addImageService(Image img) {
		return imgd.addImageDao(img);
	}
	
	@Override
	public List<Image> watchImageService(Image img) {
		List<Image> li=imgd.watchImageDao(img);
		
		return li;
	}
	
	@Override
	public int deleteImageService(String acquisition_time) {
		
		return imgd.deleteImageDao(acquisition_time);
	}
	
	@Override
	public int updateImageService(Image img) {
		// TODO Auto-generated method stub
		return imgd.updateImageDao(img);
	}
}
