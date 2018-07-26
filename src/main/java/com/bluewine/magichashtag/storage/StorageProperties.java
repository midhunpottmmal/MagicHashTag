package com.bluewine.magichashtag.storage;

import org.springframework.stereotype.Component;

@Component
public class StorageProperties {
	
	/**
     * Folder location for storing files
     */
    private String location = "E:\\SpringBootProjectz";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
