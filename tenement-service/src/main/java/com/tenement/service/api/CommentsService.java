package com.tenement.service.api;

import com.github.pagehelper.PageInfo;
import com.tenement.domain.dto.CommentsReq;
import com.tenement.domain.dto.CommentsResp;

/**
 * @author 徐周
 * @date ：Created in 2020-04-07 14:14
 * @description：2
 * @version: 1
 */
public interface CommentsService {

    int addComments(CommentsReq req);

    int answerComments(CommentsReq req);

    int updateComments(CommentsReq req);

    PageInfo<CommentsResp> listComments(CommentsReq req);
}
