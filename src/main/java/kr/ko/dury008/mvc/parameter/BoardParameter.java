package kr.ko.dury008.mvc.parameter;

import lombok.Data;

@Data //getter,setter 추가
public class BoardParameter { //게시판등록수정용 DTO
	private int boardSeq;
	private String title;
	private String contents;
	
}