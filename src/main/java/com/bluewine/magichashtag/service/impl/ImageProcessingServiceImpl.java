package com.bluewine.magichashtag.service.impl;

import java.io.File;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluewine.magichashtag.model.ImageDetails;
import com.bluewine.magichashtag.repository.ImageDetailsRepository;
import com.bluewine.magichashtag.service.ImageProcessingService;

import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.api.request.model.PredictRequest;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.model.Model;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Concept;


@Service
public class ImageProcessingServiceImpl implements ImageProcessingService{
	
	private ImageDetailsRepository imageDetailsRepository;
	
	private final ClarifaiClient clarifaiClient;
	private Model<Concept> generalModel ;
	@Autowired
	public ImageProcessingServiceImpl(ImageDetailsRepository imageDetailsRepository) {
		
		this.imageDetailsRepository=imageDetailsRepository;
		clarifaiClient=new ClarifaiBuilder("e595b40f59974f1ca41312550015f522").buildSync();
		generalModel= clarifaiClient.getDefaultModels().generalModel();
		
	}

	@Transactional
	@Override
	public List<ImageDetails> listImageDetails() {	
		
		return (List<ImageDetails>)imageDetailsRepository.findAll();		
		
	}
	

	@Override
	public String PredictImage(String imageName) {
		
		return predict(imageName);
//		ImageDetails imageDetails = new ImageDetails();
//		imageDetails.setAppId(22);
//		imageDetails.setImageId("adasf122");
//		imageDetails.setTags("#shop #food");
//		imageDetailsRepository.save(imageDetails);
	}

	private String predict(String imageName) {
		
		PredictRequest<Concept> request = generalModel.predict().withInputs(
		        ClarifaiInput.forImage(new File("E:\\\\SpringBootProjectz\\"+imageName))
		    );
		List<ClarifaiOutput<Concept>> result = request.executeSync().get();
		return result.toString();
		
	}
	
	

}
