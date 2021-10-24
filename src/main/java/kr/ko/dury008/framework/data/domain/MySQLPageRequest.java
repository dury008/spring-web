package kr.ko.dury008.framework.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MySQLPageRequest { //MYSQL 페이지 요청정보 및 계산된 값 포함
	private int page;
	private int size;
	
	@JsonIgnore
	@ApiModelProperty(hidden = true)
	private int limit;
	
	@JsonIgnore
	@ApiModelProperty(hidden = true)
	private int offset;
	
	public MySQLPageRequest (int page, int size, int limit, int offset) {
		this.page = page;
		this.size = size;
		this.limit = limit;
		this.offset = offset;
	}
	
}
