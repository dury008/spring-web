package kr.ko.dury008.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ko.dury008.mvc.domain.Board;
import kr.ko.dury008.mvc.parameter.BoardParameter;
import kr.ko.dury008.mvc.repository.BoardRepository;

@Service
public class BoardService { //게시판 service

	@Autowired
	private BoardRepository repository;
	
	public List<Board> getList() {
		return repository.getList();
	}
	
	public Board get(int boardSeq) {
		return repository.get(boardSeq);	
		}
	
	public void save(BoardParameter parameter) {
		//조회하여 리턴된 정보
		Board board = repository.get(parameter.getBoardSeq()); 
		if(board == null) {
			repository.save(parameter);
		} else {
			repository.update(parameter);
		}
	}

	public void delete(int boardSeq) {
		repository.delete(boardSeq);
	}
}
