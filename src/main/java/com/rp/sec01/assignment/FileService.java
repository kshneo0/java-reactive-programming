package com.rp.sec01.assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
	private static final Path PATH = Paths.get("src/main/resources/assignment/sec01");
			
	private static String readFile(String fileName) {
		try {
			return Files.readString(PATH.resolve(fileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void writeFile(String fileName, String content) {
		try {
			Files.writeString(PATH.resolve(fileName), content);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void deleteFile(String fileName) {
		try {
			Files.delete(PATH.resolve(fileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
