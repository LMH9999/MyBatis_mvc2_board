package com.mvc2.mbmvc2.mybatis;


import com.mvc2.mbmvc2.dto.MVCBoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface MVCBoardMapper {
    int selectCount(Map<String, Object> map);
    List<MVCBoardDTO> selectListPage(Map<String, Object> map);

    List<MVCBoardDTO> selectListPageWithPaging(Map<String, Object> map);

    int insertWrite(MVCBoardDTO dto);

    MVCBoardDTO selectView(String idx);

    int updateVisitCount(String idx);

    int downCountPlus(String idx);

    int confirmPassword(Map<String, String> map);

    int deletePost(String idx);

    int updatePost(MVCBoardDTO dto);
}
