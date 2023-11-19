package com.mvc2.mbmvc2.dao;


import com.mvc2.mbmvc2.dto.MVCBoardDTO;
import com.mvc2.mbmvc2.mybatis.MVCBoardMapper;
import com.mvc2.mbmvc2.mybatis.MyBatisSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class MVCBoardDAO  {
    public int selectCount(Map<String, Object> map){
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        MVCBoardMapper mapper = sqlSession.getMapper(MVCBoardMapper.class);
        int result = mapper.selectCount(map);
        System.out.println("selectCount - 행 개수 = " + result);
        sqlSession.close();
        return result;
    }
    public List<MVCBoardDTO> selectListPage(Map<String,Object> map){
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        MVCBoardMapper mapper = sqlSession.getMapper(MVCBoardMapper.class);
        List<MVCBoardDTO> result = mapper.selectListPage(map);
        sqlSession.close();
        return result;
    }
}
