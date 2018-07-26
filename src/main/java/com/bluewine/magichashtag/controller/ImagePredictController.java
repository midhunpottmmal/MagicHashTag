package com.bluewine.magichashtag.controller;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bluewine.magichashtag.model.ImageDetails;

public interface ImagePredictController {	
	
	List<ImageDetails> predictImage();
	
	String postPredictImage(MultipartFile file, RedirectAttributes redirectAttributes);
}
