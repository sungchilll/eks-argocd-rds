package basic.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import basic.service.S3Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/s3/files")
public class S3FileController {
	
	private final S3Service s3Service;
	
	@PostMapping
	public void uploadS3File(@RequestPart(value = "file", required = false) MultipartFile file) {
		try {
			s3Service.uploadS3File(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(value = "/{fileNo}")
	public ResponseEntity<Resource> downloadS3File(@PathVariable("fileNo") long fileNo) throws Exception {
		return s3Service.downloadS3File(fileNo);
	}
	
	@DeleteMapping("/{fileNo}")
	public ResponseEntity<String> deleteS3File(@PathVariable("fileNo") long fileNo) {
		try {
			s3Service.deleteS3File(fileNo);
			return ResponseEntity.ok("파일 삭제 성공");
		} catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body("파일 삭제 중 오류 발생: " + e.getMessage());
	    }
	}
}

