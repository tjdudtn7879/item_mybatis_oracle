package com.lgy.item_mybatis_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.item_mybatis_oracle.dao.ItemDAO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view");
		
		return "item_write";
	}
	
	@RequestMapping("/write_result")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write_result");
		
		model.addAttribute("request", request);
		
//		service = new ItemWriteService();
//		service.execute(model);
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		
		dao.write(request.getParameter("name")
				, Integer.parseInt(request.getParameter("price"))
				, request.getParameter("description"));
		
		return "write_result";
	}
//	게시판 목록 조회
	@RequestMapping("/content_view")
	public String list(Model model) {
		log.info("@# content_view");
		
//		service = new ItemContentService();
//		service.execute(model);
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		model.addAttribute("content_view", dao.list());
		
		return "content_view";
	}
}
