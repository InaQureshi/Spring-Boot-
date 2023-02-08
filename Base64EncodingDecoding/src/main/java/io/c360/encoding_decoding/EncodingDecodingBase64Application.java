package io.c360.encoding_decoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootApplication
public class EncodingDecodingBase64Application {

	public static void main(String[] args) throws UnsupportedEncodingException {

		final String uploadFolderpath="C:\\Users\\DELL\\Desktop\\uploaded_";
		String filepath="C:\\Users\\DELL\\Desktop\\havetoedit.txt";


		final String textData="This Text For Encoding Test";
		String encodedtext= Base64.getEncoder().encodeToString(textData.getBytes(StandardCharsets.UTF_8));
		System.out.println("Encoded Text : "+encodedtext);
		String encodedurl=Base64.getUrlEncoder().encodeToString(uploadFolderpath.getBytes(StandardCharsets.UTF_8));
		System.out.println("URL "+encodedurl);
		String encodedFile=Base64.getMimeEncoder().encodeToString(uploadFolderpath.getBytes(StandardCharsets.UTF_8));
		System.out.println("File : "+encodedFile);

		byte[] decodedArr=Base64.getDecoder().decode(encodedtext);
		String decodedText= new String(decodedArr,StandardCharsets.UTF_8);
		System.out.println("Decoded Text :" +decodedText);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("havetoedit.txt"));
			writer.write("Written with BufferedWriter");


		} catch (IOException e) {
			throw new RuntimeException(e);
		}



		SpringApplication.run(EncodingDecodingBase64Application.class, args);
	}

}
