package kr.ko.dury008.mvc.domain;

import java.sql.Date;

import lombok.Data;

@Data //getter,setter 추가
public class Board {
	private int boardSeq;
	private String title;
	private String contents;
	private Date regDate;
	
}
