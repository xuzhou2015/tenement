package com.tenement.dao.mapper;

import com.tenement.domain.dto.CommentsExmple;
import com.tenement.domain.po.Comments;

import java.util.List;

public interface CommentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer id);

    List<Comments> selectByList(CommentsExmple exmple);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}