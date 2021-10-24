package kr.ko.dury008.mvc.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data //getter,setter 추가
public class Board {
	private int boardSeq;
	private BoardType boardType;
	private String title;
	private String contents;
	private int viewCount;
	private Timestamp regDate;
	private boolean delYn;
	
}
