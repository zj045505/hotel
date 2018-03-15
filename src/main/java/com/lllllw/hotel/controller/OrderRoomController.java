package com.lllllw.hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lllllw.hotel.model.RoomType;
import com.lllllw.hotel.service.OrderRoomService;

@Controller
public class OrderRoomController {
	
	@Autowired
	OrderRoomService orderRoomService;
	
	@RequestMapping(value = "/searchPage")
	public String searchRoomType(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		String time = request.getParameter("time");
		int member = 0;
		if(request.getParameter("member") != null && !"".equals(request.getParameter("member"))){
			member = Integer.parseInt(request.getParameter("member"));
		}
		List<RoomType>  roomTypeList = orderRoomService.selectRoomType(time, member);
		request.setAttribute("roomTypeList", roomTypeList);
		request.setAttribute("time", time);
		request.setAttribute("member", member);
		return "front/search";
	}
	
	
}