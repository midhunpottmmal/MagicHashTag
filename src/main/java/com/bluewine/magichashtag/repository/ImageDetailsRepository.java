package com.bluewine.magichashtag.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bluewine.magichashtag.model.ImageDetails;

@Repository
public interface ImageDetailsRepository extends CrudRepository<ImageDetails,Integer> {
	List<ImageDetails> findByImageId(String imageId);
}
