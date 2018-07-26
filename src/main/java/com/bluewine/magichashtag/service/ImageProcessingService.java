package com.bluewine.magichashtag.service;

import java.util.List;

import com.bluewine.magichashtag.model.ImageDetails;

public interface ImageProcessingService {
	
	List<ImageDetails>listImageDetails();

	String PredictImage(String filename);

}
