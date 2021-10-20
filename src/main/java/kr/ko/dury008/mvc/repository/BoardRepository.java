package kr.ko.dury008.mvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ko.dury008.mvc.domain.Board;
import kr.ko.dury008.mvc.parameter.BoardParameter;

@Repository
public interface BoardRepository { //게시판 Repository
	List<Board> getList();
	
	Board get(int boardSeq);
	
	void save(BoardParameter board);
	
	void update(BoardParameter board);
	
	void delete(int boardSeq);
}
