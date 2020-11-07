package com.maxback.services;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.iot.model.CannedAccessControlList;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

/**
 * 
 * @author Damond Howard
 * @apiNote This is a client service that allows us to save files to amazon s3 servers
 *
 */
@Service
public class AmazonClient {
	private AmazonS3 s3client;
	
	private static Logger log = LoggerFactory.getLogger(AmazonClient.class);

	private final String endpointUrl = "arn:aws:iam::335746352675:user/felix-users/087346b25c-6e3db35509";
	private final String bucketName = "files";
	private final String accessKey = "AKIAU4LAKYYRWKUNL74N";
	private final String secretKey = "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";
	
	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(
				accessKey,
				secretKey
				);

		 this.s3client = AmazonS3ClientBuilder
			.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
			.withRegion(Regions.US_WEST_1)
			.build();
	}
	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	
	private String generateFileName(MultipartFile multipartFile) {
		return new Date().getTime() + "-" + multipartFile.getOriginalFilename().replace(" ", "_");
	}
	
	private void uploadFileTos3bucket(String fileName, File file) {
	    s3client.putObject(new PutObjectRequest(bucketName, fileName, file));
	}
	
	public String uploadFile(MultipartFile multipartFile) {
	    String fileUrl = "";
	    try {
	        File file = convertMultiPartToFile(multipartFile);
	        String fileName = generateFileName(multipartFile);
	        fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
	        uploadFileTos3bucket(fileName, file);
	        file.delete();
	    } catch (Exception e) {
	       e.printStackTrace();
	    }
	    log.info("uploading a file");
	    return fileUrl;
	}
	
	public String deleteFileFromS3Bucket(String fileUrl) {
	    String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
	    s3client.deleteObject(new DeleteObjectRequest(bucketName + "/", fileName));
	    return "Successfully deleted";
	}
}