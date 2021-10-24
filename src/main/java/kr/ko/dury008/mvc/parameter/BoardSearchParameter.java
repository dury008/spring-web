package kr.ko.dury008.mvc.parameter;

import kr.ko.dury008.mvc.domain.BoardType;
import lombok.Data;

@Data
public class BoardSearchParameter {
	private String keyword;
	private BoardType[] boardTypes;
	
	public BoardSearchParameter() {
		
	}
}
