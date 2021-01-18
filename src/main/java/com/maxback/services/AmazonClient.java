package com.maxback.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
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
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

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

	private final String bucketName = "files";
	private final String accessKey = "AKIAU4LAKYYR5JF3UWES";
	private final String secretKey = "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";
	private final String userArn = "arn:aws:iam::335746352675:user/felix-users/8bf7f8e151-682bc9cca2";
	
	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(
				accessKey,
				secretKey
				);

		 this.s3client = AmazonS3ClientBuilder
			.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
			.withRegion(Regions.US_EAST_1)
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
	    s3client.putObject(new PutObjectRequest(bucketName, fileName, file)); //filename is the key
	}
	
	public String uploadFile(MultipartFile multipartFile) {
		 String fileName = "";
		    try {
		        File file = convertMultiPartToFile(multipartFile);
		        fileName = generateFileName(multipartFile);
		        uploadFileTos3bucket(fileName, file);
		        file.delete();
		    } catch (Exception e) {
		       e.printStackTrace();
		    }
		    log.info("uploading a file");
		    return fileName;
	}
	
	public File downloadFileFromS3(String filename) {
		File localFile = new File(filename);
		ObjectMetadata object = s3client.getObject(new GetObjectRequest(bucketName, filename), localFile);
		return localFile;
	}
	
	public URL getFileUrl(String filename) {
		return s3client.getUrl(bucketName, filename);
	}
	
	public String deleteFileFromS3Bucket(String fileUrl) {
	    String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
	    s3client.deleteObject(new DeleteObjectRequest(bucketName + "/", fileName));
	    return "Successfully deleted";
	}
}