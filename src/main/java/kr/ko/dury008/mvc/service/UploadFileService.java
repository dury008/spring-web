package kr.ko.dury008.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ko.dury008.mvc.domain.UploadFile;
import kr.ko.dury008.mvc.parameter.UploadFileParameter;
import kr.ko.dury008.mvc.repository.UploadFileRepository;

@Service
public class UploadFileService {
	@Autowired
	UploadFileRepository repository;
	
	public void save(UploadFileParameter parameter) {
		repository.save(parameter);
	}

	public UploadFile get(int uploadFileSeq) {
		return repository.get(uploadFileSeq);
		
	}
}
