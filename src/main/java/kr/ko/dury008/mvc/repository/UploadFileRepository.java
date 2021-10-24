package kr.ko.dury008.mvc.repository;

import org.springframework.stereotype.Repository;

import kr.ko.dury008.mvc.domain.UploadFile;
import kr.ko.dury008.mvc.parameter.UploadFileParameter;


@Repository
public interface UploadFileRepository {
	
	void save(UploadFileParameter parameter);

	UploadFile get(int uploadFileSeq);
}
