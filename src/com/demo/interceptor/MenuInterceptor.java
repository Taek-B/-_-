package com.demo.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.demo.beans.BoardInfoBean;
import com.demo.service.MenuService;

public class MenuInterceptor implements HandlerInterceptor {
	
	// 1번째 방법 : 필드 주입	
//	@Autowired
//	private MenuService menuService;
	
	private MenuService menuService;

	// 2번째 방법 : 생성자 주입
	public MenuInterceptor(MenuService menuService) {
		this.menuService = menuService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//테이블에서 게시판이름들을 가져와 메뉴에 전달
		
		List<BoardInfoBean> topMenuList = menuService.getMenuList();
		request.setAttribute("topMenuList", topMenuList);
		
		return true;
	}

}
