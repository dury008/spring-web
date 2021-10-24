package kr.ko.dury008.mvc.parameter;

import kr.ko.dury008.mvc.domain.BoardType;
import lombok.Data;

@Data //getter,setter 추가
public class BoardParameter { //게시판등록수정용 DTO
	private int boardSeq;
	private BoardType boardType;
	private String title;
	private String contents;
	private boolean delYn;
	
	public BoardParameter() {
		
	}
	
	public BoardParameter(String title, String contents) {
		this.title = title;
		this.contents = contents;
		this.boardType = BoardType.NOTICE;
		this.delYn = false;
	}
}