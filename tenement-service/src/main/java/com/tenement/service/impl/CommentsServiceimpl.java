package com.tenement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tenement.dao.mapper.CommentsMapper;
import com.tenement.domain.common.BeanUtils;
import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.common.StringUtils;
import com.tenement.domain.dto.BrokerResp;
import com.tenement.domain.dto.CommentsExmple;
import com.tenement.domain.dto.CommentsReq;
import com.tenement.domain.dto.CommentsResp;
import com.tenement.domain.po.Broker;
import com.tenement.domain.po.Comments;
import com.tenement.service.api.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 徐周
 * @date ：Created in 2020-04-07 14:15
 * @description：2
 * @version: 1
 */
@Service
public class CommentsServiceimpl implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    /**
     * 新增留言
     * @param req
     * @return
     */
    @Override
    public int addComments(CommentsReq req) {
        if(StringUtils.isEmpty(req.getContent())){
            throw new BusinessException(CommonResultCode.ILLEGAL_REQ_PARAMETER);
        }
        if(req.getContent().length()>500){
            throw new BusinessException(CommonResultCode.LENGTH_ERROR);
        }

        Comments comments = BeanUtils.convert(req, Comments.class);
        comments.setCreatetime(new Date());
        commentsMapper.insertSelective(comments);

        return 1;
    }

    /**
     * 留言回复
     * @param req
     * @return
     */
    @Override
    public int answerComments(CommentsReq req) {
        if(req.getId()==null && StringUtils.isEmpty(req.getAnswercontent())){
            throw new BusinessException(CommonResultCode.ILLEGAL_REQ_PARAMETER);
        }
        if(req.getAnswercontent().length()>500){
            throw new BusinessException(CommonResultCode.LENGTH_ERROR);
        }
        Comments comments = BeanUtils.convert(req, Comments.class);
        comments.setAnswertime(new Date());
        commentsMapper.updateByPrimaryKeySelective(comments);

        return 1;

    }
    @Override
    public int updateComments(CommentsReq req){
        if(req.getId()==null){
            throw new BusinessException(CommonResultCode.ILLEGAL_REQ_PARAMETER);
        }
        Comments comments=commentsMapper.selectByPrimaryKey(req.getId());
        if(comments==null){
            throw new BusinessException(CommonResultCode.ILLEGAL_REQ_PARAMETER);
        }
        if(req.getType()==2){
            comments.setDown(comments.getDown()+1);
        }
        if(req.getType()==1){
            comments.setTop(comments.getTop()+1);
        }
        commentsMapper.updateByPrimaryKeySelective(comments);
        return 1;
    }

    @Override
    public PageInfo<CommentsResp> listComments(CommentsReq req) {

        PageHelper.startPage(req.getPageNum(), req.getPageSize());

        CommentsExmple exmple=new CommentsExmple();
        if(req.getNewhouseid() !=null){
            exmple.setNewhouseid(req.getNewhouseid());
        }
        if(req.getUsedhouseid() !=null){
            exmple.setUsedhouseid(req.getUsedhouseid());
        }
        if(req.getRentinghouseid() !=null){
            exmple.setRentinghouseid(req.getRentinghouseid());
        }
        List<Comments> commentsList=commentsMapper.selectByList(exmple);
        if(commentsList !=null ){

            PageInfo<Comments> pageInfos=new PageInfo<Comments>(commentsList);

            long total=pageInfos.getTotal();
            int pagenum=pageInfos.getPageNum();
            int pagesize=pageInfos.getPageSize();

            List<CommentsResp> commentsRespList=BeanUtils.convertList(commentsList,CommentsResp.class);

            PageInfo<CommentsResp> pageInfo = new PageInfo<>(commentsRespList);
            pageInfo.setTotal(total);
            pageInfo.setPageNum(pagenum);
            pageInfo.setPageSize(pagesize);

            return pageInfo;
        }

        return null;
    }
}
