package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.beans.ContentBean;
import com.demo.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;


	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx, Model model) {
		model.addAttribute("board_info_idx", board_info_idx);
		return "board/main";
	}

	@GetMapping("/read")
	public String read() {
		return "board/read";
	}

	@GetMapping("/write")
	public String write(@ModelAttribute("writeContentBean") ContentBean writeContentBean) {
		return "board/write";
	}

	@PostMapping("/write_pro")
	public String write_pro(@ModelAttribute("writeContentBean") ContentBean writeContentBean, BindingResult result) {
		if (result.hasErrors()) {
			return "board/write";
		}
		
		//DB에 저장
		boardService.addContentInfo(writeContentBean);
		 
		System.out.print("실행 완료");
		return "board/write_success";
	}

	@GetMapping("/modify")
	public String modify() {
		return "board/modify";
	}

	@GetMapping("/delete")
	public String delete() {
		return "board/delete";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		System.out.println(request.getServletContext().getRealPath("/"));
		return "index";
	}

}
