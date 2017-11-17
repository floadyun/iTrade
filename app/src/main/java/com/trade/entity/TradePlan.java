package com.trade.entity;


/*
 *
 * @copyright : 深圳市腾飞科技有限公司版权所有
 *
 * @author : ${Author}
 *
 * @version :1.0
 *
 * @creation date: 2017/6/25
 *
 * @description:交易计划model
 *
 * @update date :
 */
public class TradePlan extends BaseEntity {

    public String plantitle="";

    private String userphoto;

    private String username;

    public String type="";

    public  String openprice="";

    public  String targetprice="";

    public  String stopprice="";

    public  String content="";

    public String stauts="";

    private long vistors;

    private long praise;

    private long comment;

    public String getPlantitle() {
        return plantitle;
    }

    public void setPlantitle(String plantitle) {
        this.plantitle = plantitle;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOpenprice() {
        return openprice;
    }

    public void setOpenprice(String openprice) {
        this.openprice = openprice;
    }

    public String getTargetprice() {
        return targetprice;
    }

    public void setTargetprice(String targetprice) {
        this.targetprice = targetprice;
    }

    public String getStopprice() {
        return stopprice;
    }

    public void setStopprice(String stopprice) {
        this.stopprice = stopprice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

    public long getVistors() {
        return vistors;
    }

    public void setVistors(long vistors) {
        this.vistors = vistors;
    }

    public long getPraise() {
        return praise;
    }

    public void setPraise(long praise) {
        this.praise = praise;
    }

    public long getComment() {
        return comment;
    }

    public void setComment(long comment) {
        this.comment = comment;
    }
}
