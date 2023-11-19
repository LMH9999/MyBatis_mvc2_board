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
import com.mvc2.mbmvc2.utils.Criteria;
import com.mvc2.mbmvc2.utils.PageMaker;

@WebServlet("/mvcboard/list.do")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MVCBoardDAO dao = new MVCBoardDAO();
        Map<String, Object> map = new HashMap<>();
        int totalCount = dao.selectCount(map);;
        System.out.println(totalCount);
//        List<MVCBoardDTO> boardLists = dao.selectListPage(map);

        String pageNum = request.getParameter("pageNum");
        Criteria criteria = new Criteria();
        int pageNumInt = 1;
        if (pageNum != null && !pageNum.equals("")) {
            try {
                pageNumInt = Integer.parseInt(pageNum.trim());
            } catch (Exception e) {
                System.out.println("숫자로 변환할 수 없는 pageNum");
                // default로 1을 준다.
            }
        }
        criteria.setPageNum(pageNumInt);

        map.put("pageNum", (criteria.getPageNum() - 1) * 10);
        List<MVCBoardDTO> boardLists = dao.selectListPageWithPaging(map);


        PageMaker pageMaker = new PageMaker(criteria, totalCount);
        request.setAttribute("pageMaker", pageMaker);
        map.remove("pageNum");
        request.setAttribute("map", map);


        request.setAttribute("totalCount",totalCount);
        request.setAttribute("boardLists", boardLists);
        request.getRequestDispatcher("/MVCBoard/List.jsp").forward(request, response);
    }
}
