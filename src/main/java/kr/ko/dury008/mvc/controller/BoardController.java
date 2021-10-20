package kr.ko.dury008.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.ko.dury008.configuration.exception.BaseException;
import kr.ko.dury008.configuration.http.BaseResponse;
import kr.ko.dury008.configuration.http.BaseResponseCode;
import kr.ko.dury008.mvc.domain.Board;
import kr.ko.dury008.mvc.parameter.BoardParameter;
import kr.ko.dury008.mvc.service.BoardService;

@RestController
@RequestMapping("/board")
@Api(tags = "게시판 API") //api 이름설정
public class BoardController { //게시판 컨트롤러
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired //스프링 컨테이너에서 관리하는 빈을 주입
	private BoardService service;
	
	@GetMapping
	@ApiOperation(value = "목록 조회", notes = "게시판 목록정보를 조회할수 있습니다.")
	public BaseResponse<List<Board>> getList() {
		logger.info("getLIst");
		return new BaseResponse<List<Board>>(service.getList());
	}
	
	@GetMapping("/{boardSeq}")
	@ApiOperation(value = "상세 조회", notes = "게시판 번호에 해당하는 상세 정보를 조회할 수 있습니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1")
	})
	public BaseResponse<Board> get(@PathVariable int boardSeq) {
		Board board = service.get(boardSeq);
		if (board == null) {
			throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] { "게시물" });
		}
		return new BaseResponse<Board>(service.get(boardSeq));	
		}
	
	
	@PutMapping("/save") //등록,수정처리
	@ApiOperation(value = "등록 / 수정처리", notes = "신규 게시물 저장 및 기존 게시물 업데이트가 가능합니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1"),
		@ApiImplicitParam(name = "title", value = "제목", example = "spring"),
		@ApiImplicitParam(name = "contents", value = "내용", example = "spring 강좌")
	})
	public BaseResponse<Integer> save(BoardParameter parameter) {
		if(StringUtils.isEmpty(parameter.getTitle())) {// 제목 null 체크
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "title", "제목" });
		}
		if(StringUtils.isEmpty(parameter.getContents())) {// 제목 null 체크
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "contents", "내용" });
		}
		service.save(parameter);
		return new BaseResponse<Integer>(parameter.getBoardSeq());
	}
	
	@PutMapping("/saveList1") //대용량 등록
	@ApiOperation(value = "대용량 등록처리1", notes = "대용량 등록처리1")
	public BaseResponse<Boolean> saveList1() {
		int count = 0;
		List<BoardParameter> list = new ArrayList<BoardParameter>();
		while(true) {
			count++;
			String title = RandomStringUtils.randomAlphabetic(10);
			String contents = RandomStringUtils.randomAlphabetic(10);
			list.add(new BoardParameter(title, contents));
			if(count >= 10000) {
				break;
			}	
		}
		long start = System.currentTimeMillis();
		service.saveList1(list);
		long end = System.currentTimeMillis();
		logger.info("실행 시간: {}", (end-start)/ 1000.0);
		return new BaseResponse<Boolean>(true);
		
	}
	
	@PutMapping("/saveList2") //대용량 등록
	@ApiOperation(value = "대용량 등록처리2", notes = "대용량 등록처리2")
	public BaseResponse<Boolean> saveList2() {
		int count = 0;
		List<BoardParameter> list = new ArrayList<BoardParameter>();
		while(true) {
			count++;
			String title = RandomStringUtils.randomAlphabetic(10);
			String contents = RandomStringUtils.randomAlphabetic(10);
			list.add(new BoardParameter(title, contents));
			if(count >= 10000) {
				break;
			}	
		}
		long start = System.currentTimeMillis();
		service.saveList2(list);
		long end = System.currentTimeMillis();
		logger.info("실행 시간: {}", (end-start)/ 1000.0);
		return new BaseResponse<Boolean>(true);
		
	}
	
	@DeleteMapping("/delete/{boardSeq}")
	@ApiOperation(value = "삭제처리", notes = "게시물 번호에 해당하는 정보를 삭제합니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1"),
	})
	public BaseResponse<Boolean> delete(@PathVariable int boardSeq) {
		Board board = service.get(boardSeq);
		if(board == null) {
			return new BaseResponse<Boolean>(false);
		}
		service.delete(boardSeq);
			return new BaseResponse<Boolean>(true);
	}
}
