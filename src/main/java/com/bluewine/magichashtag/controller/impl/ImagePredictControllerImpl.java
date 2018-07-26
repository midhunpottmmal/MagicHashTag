package com.bluewine.magichashtag.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bluewine.magichashtag.controller.ImagePredictController;
import com.bluewine.magichashtag.model.ImageDetails;
import com.bluewine.magichashtag.service.ImageProcessingService;
import com.bluewine.magichashtag.storage.StorageService;

@RestController
@RequestMapping("/imagePredict")
public class ImagePredictControllerImpl implements ImagePredictController{
	
	private StorageService storageService;
	private ImageProcessingService imageProcessingService;
	
	@Autowired
	public ImagePredictControllerImpl(ImageProcessingService imageProcessingService,StorageService storageService) {
		this.imageProcessingService=imageProcessingService;
		this.storageService=storageService;
	}
	
	
	@GetMapping
	@Override
	public List<ImageDetails> predictImage() {
		
		return this.imageProcessingService.listImageDetails();
	}

	
	@Override
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public String postPredictImage(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {
		
		String filename = this.storageService.store(file);
		System.out.println(filename);
		return this.imageProcessingService.PredictImage(filename);
		
		
	}

}
