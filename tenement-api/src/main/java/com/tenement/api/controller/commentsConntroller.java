package com.tenement.api.controller;

import com.github.pagehelper.PageInfo;
import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.common.Response;
import com.tenement.domain.dto.CommentsReq;
import com.tenement.domain.dto.CommentsResp;
import com.tenement.domain.util.ResponseUtils;
import com.tenement.domain.vo.SysUserVo;
import com.tenement.service.api.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 徐周
 * @date ：Created in 2020-04-07 16:04
 * @description：2
 * @version: 1
 */
@RestController
@RequestMapping("/house/comments")
public class commentsConntroller {

    @Autowired
    private CommentsService commentsService;

    /**
     * 新增留言
     * @param
     * @return
     */
    @RequestMapping("/addComments")
    public Response addComments(HttpServletRequest request, @RequestBody CommentsReq req)throws BusinessException {

        HttpSession session = request.getSession();
        SysUserVo sysUserVo = (SysUserVo) session.getAttribute("user");
        if (sysUserVo == null) {
            throw new BusinessException(CommonResultCode.LONING);
        }
        req.setUid(sysUserVo.getId());
        commentsService.addComments(req);
        return ResponseUtils.createSuccess();
    }
    /**
     * 留言回复
     * @param
     * @return
     */
    @RequestMapping("/answerComments")
    public Response answerComments(HttpServletRequest request, @RequestBody CommentsReq req)throws BusinessException {

        HttpSession session = request.getSession();
        SysUserVo sysUserVo = (SysUserVo) session.getAttribute("user");
        if (sysUserVo == null) {
            throw new BusinessException(CommonResultCode.LONING);
        }
        req.setAnsweruid(sysUserVo.getId());
        commentsService.answerComments(req);
        return ResponseUtils.createSuccess();
    }
    /**
     * 留言置顶和踩
     * @param
     * @return
     */
    @RequestMapping("/updateComments")
    public Response updateComments(HttpServletRequest request, @RequestBody CommentsReq req)throws BusinessException {

        HttpSession session = request.getSession();
        SysUserVo sysUserVo = (SysUserVo) session.getAttribute("user");
        if (sysUserVo == null) {
            throw new BusinessException(CommonResultCode.LONING);
        }
        commentsService.updateComments(req);
        return ResponseUtils.createSuccess();
    }

    /**
     * 留言列表
     * @param
     * @return
     */
    @RequestMapping("/listComments")
    public Response<PageInfo<CommentsResp>> listComments(HttpServletRequest request, @RequestBody CommentsReq req)throws BusinessException {

        PageInfo<CommentsResp> pageInfo=commentsService.listComments(req);
        return ResponseUtils.createSuccess(pageInfo);
    }

}
