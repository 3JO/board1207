package org.sean.persistence;

import java.sql.Connection;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sean.domain.BoardVO;
import org.sean.domain.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DataSourceTest {
	
	@Inject
	private BoardDAO dao;
	
	protected static final Logger logger = LoggerFactory.getLogger(DataSourceTest.class);
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void testConnection() throws Exception{
		
		System.out.println(ds);
		logger.info(ds.toString());
		
		Connection con = ds.getConnection();
		
		System.out.println(con);
		logger.info(con.toString());
		
		con.close();
		
	}
	
	@Test
	public void testCreate()throws Exception{
		
		BoardVO vo = new BoardVO();
		vo.setTitle("새로운 글을 넣습니다.");
		vo.setContent("새로운 글을 넣습니다.");
		vo.setWriter("user00");
		dao.create(vo);
		
	}
	
	@Test
	public void testRead() throws Exception{
		
		logger.info(dao.read(240).toString());
		
	}
	
	@Test
	public void testListPage()throws Exception{
		
		int page = 2;
		
		List<BoardVO> list = dao.listPage(page);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno()+ ":" + boardVO.getTitle());
		}
		
	}
	
	@Test
	public void testListCriteria()throws Exception{
		
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPage(10);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}
	
	@Test
	public void testURI()throws Exception{
		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.path("/board/read")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build();
		
		logger.info("/board/read?bno=12&perPageNum=20");
		logger.info(uri.toString());
		
	}
	
}
