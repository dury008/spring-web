package kr.ko.dury008.mvc.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.ko.dury008.framework.data.domain.PageRequestParameter;
import kr.ko.dury008.mvc.domain.Board;
import kr.ko.dury008.mvc.parameter.BoardParameter;
import kr.ko.dury008.mvc.parameter.BoardSearchParameter;

@Repository
public interface BoardRepository { //게시판 Repository
	List<Board> getList(PageRequestParameter<BoardSearchParameter> parameter);
	
	Board get(int boardSeq);
	
	void save(BoardParameter board);
	
	void saveList(Map<String, Object> paramMap);
	
	void update(BoardParameter board);
	
	void delete(int boardSeq);
}
