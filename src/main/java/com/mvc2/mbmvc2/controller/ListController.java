package com.mvc2.mbmvc2.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvc2.mbmvc2.dao.MVCBoardDAO;
import com.mvc2.mbmvc2.dto.MVCBoardDTO;

@WebServlet("/mvcboard/list.do")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MVCBoardDAO dao = new MVCBoardDAO();
        Map<String, Object> map = new HashMap<>();
        int totalCount = dao.selectCount(map);;
        System.out.println(totalCount);
        List<MVCBoardDTO> boardLists = dao.selectListPage(map);


        request.setAttribute("totalCount",totalCount);
        request.setAttribute("boardLists", boardLists);
        request.getRequestDispatcher("/MVCBoard/List.jsp").forward(request, response);
    }
}
