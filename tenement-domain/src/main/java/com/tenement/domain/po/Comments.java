package com.tenement.domain.po;

import java.util.Date;

public class Comments {
    private Integer id;

    private Integer uid;

    private Integer newhouseid;

    private Integer usedhouseid;

    private Integer rentinghouseid;

    private String content;

    private Date createtime;

    private Integer top;

    private Integer answeruid;

    private Date answertime;

    private String answercontent;

    private Integer down;

    private String answernmae;

    private String usernmae;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getNewhouseid() {
        return newhouseid;
    }

    public void setNewhouseid(Integer newhouseid) {
        this.newhouseid = newhouseid;
    }

    public Integer getUsedhouseid() {
        return usedhouseid;
    }

    public void setUsedhouseid(Integer usedhouseid) {
        this.usedhouseid = usedhouseid;
    }

    public Integer getRentinghouseid() {
        return rentinghouseid;
    }

    public void setRentinghouseid(Integer rentinghouseid) {
        this.rentinghouseid = rentinghouseid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getAnsweruid() {
        return answeruid;
    }

    public void setAnsweruid(Integer answeruid) {
        this.answeruid = answeruid;
    }

    public Date getAnswertime() {
        return answertime;
    }

    public void setAnswertime(Date answertime) {
        this.answertime = answertime;
    }

    public String getAnswercontent() {
        return answercontent;
    }

    public void setAnswercontent(String answercontent) {
        this.answercontent = answercontent;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    public String getAnswernmae() {
        return answernmae;
    }

    public void setAnswernmae(String answernmae) {
        this.answernmae = answernmae;
    }

    public String getUsernmae() {
        return usernmae;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }
}