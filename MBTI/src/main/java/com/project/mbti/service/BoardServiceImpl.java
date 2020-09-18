package com.project.mbti.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mbti.dao.BoardDao;
import com.project.mbti.vo.Board;


// 이 클래스가 서비스 계층(비즈니스 로직)의 컴포넌트(Bean) 임을 선언하고 있다.
@Service
public class BoardServiceImpl implements BoardService {

	private static final int PAGE_SIZE = 10;	
	private static final int PAGE_GROUP = 10;
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public Map<String, Object> boardList(
			int pageNum, String type, String keyword) {

		int currentPage = pageNum;	
		int startRow = (currentPage - 1) * PAGE_SIZE;		
		int listCount = 0;
		boolean searchOption = (type.equals("null") 
				|| keyword.equals("null")) ? false : true; 
		
		listCount = boardDao.getBoardCount(type, keyword);		
	
		List<Board> boardList = boardDao.boardList(
				startRow, PAGE_SIZE, type, keyword);
		
		int pageCount = 
				listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
	
		int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1
				- (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);		
					
		int endPage = startPage + PAGE_GROUP - 1;

		if(endPage > pageCount) {
			endPage = pageCount;
		}	
		
		/* View 페이지에서 필요한 데이터를 Map에 저장한다.
		 * 현재 페이지, 전체 페이지 수, 페이지 그룹의 시작 페이지와 마지막 페이지
		 * 게시 글 리스트의 수, 한 페이지에 보여 줄 게시 글 리스트의 데이터를 Map에
		 * 저장해 컨트롤러로 전달한다.
		 **/
		Map<String, Object> modelMap = new HashMap<String, Object>();		
		
		modelMap.put("boardList", boardList);
		modelMap.put("pageCount", pageCount);
		modelMap.put("startPage", startPage);
		modelMap.put("endPage", endPage);
		modelMap.put("currentPage", currentPage);
		modelMap.put("listCount", listCount);
		modelMap.put("pageGroup", PAGE_GROUP);
		modelMap.put("searchOption", searchOption);
		
		// 검색 요청이면 type과 keyword를 모델에 저장한다.
		if(searchOption) {
			
			/* IE에서 링크로 요청 시 파라미터에 한글이 포함되면 IE는 URLEncoding을
			 * 하지 않고 서버로 전송하는데 톰캣 7.06x 버전에서 정상적으로 동작하던 것이
			 * 7.07x 버전에서는 Invalid character found in the request target
			 * 이라는 에러가 발생한다. 이 문제는 java.net 패키지의 URLEncoder
			 * 클래스를 이용해 수동으로 URLEncoding을 해주면 해결할 수 있다.
			 * 크롬 브라우저는 링크로 요청 시 파라미터에 한글이 포함되어 있으면 브라우저 
			 * 주소창에는 한글 그대로 표시되지만 UTF-8로 URLEncoding을 해준다.
			 **/
			try {
				modelMap.put("keyword", URLEncoder.encode(keyword, "utf-8"));
			} catch (UnsupportedEncodingException e) {					
				e.printStackTrace();
			}
			modelMap.put("word", keyword);
			modelMap.put("type", type);
		}
		
		return modelMap;
	}

	/* BoardDao를 이용해 게시판 테이블에서
	 * no에 해당하는 게시 글 을 읽어와 반환하는 메서드 
 	 * isCount == true 면 게시 상세보기, false 면 게시 글 수정 폼 요청임 
	 **/
	@Override
	public Board getBoard(int no, boolean isCount) {
		return boardDao.getBoard(no, isCount);
	}

	// BoardDao를 이용해 새로운 게시 글을 추가하는 메서드
	@Override
	public void insertBoard(Board board) {			
		// 파일 업로드가 완료되면 BoardDao를 이용해 게시 글을 DB에 저장한다.
		boardDao.insertBoard(board);
	
	}
	
	/* 게시 글 수정, 삭제 시 비밀번호 입력을 체크하는 메서드
	 * 
	 * - 게시 글의 비밀번호가 맞으면 : true를 반환
	 * - 게시 글의 비밀번호가 맞지 않으면 : false를 반환
	 **/
	public boolean isPassCheck(int no, String pass) {	
		return boardDao.isPassCheck(no, pass);
	}
	
	// BoardDao를 이용해 게시 글을 수정하는 메서드
	@Override
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}

	// BoardDao를 이용해 no에 해당하는 게시 글을 삭제하는 메서드
	@Override
	public void deleteBoard(int no) {
		boardDao.deleteBoard(no);
	}
}
