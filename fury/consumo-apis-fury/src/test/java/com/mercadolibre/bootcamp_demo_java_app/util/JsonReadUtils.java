package com.mercadolibre.bootcamp_demo_java_app.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

public class JsonReadUtils {
	public static byte[] getJsonContent(String fileName) throws URISyntaxException, IOException {
		ClassLoader classLoader = JsonReadUtils.class.getClassLoader();
		URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {

            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());

            File fileRef = new File(resource.toURI());
            return Files.readAllBytes(fileRef.toPath());            
        }
	}
}
