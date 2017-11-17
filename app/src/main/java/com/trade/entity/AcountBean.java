package com.trade.entity;

import java.util.List;

/**
 * Created by yixiaofei on 2017/3/6 0006.
 */

public class AcountBean extends BaseEntity {

    private List<UserBean> result;

    public List<UserBean> getResult() {
        return result;
    }

    public void setResult(List<UserBean> result) {
        this.result = result;
    }

    public class UserBean{
        /**
         * memloginid : 用户ID
         * photo : 图像
         * name : 昵称
         * score : 积分
         * advancepayment : 余额
         * membertype : 类型(1会员，2商家)
         */

        private String memloginid;
        private String photo;
        private String name;
        private String score;
        private String advancepayment;
        private String membertype;
        private String paypwd;

        public String getMemloginid() {
            return memloginid;
        }

        public void setMemloginid(String memloginid) {
            this.memloginid = memloginid;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getAdvancepayment() {
            return advancepayment;
        }

        public void setAdvancepayment(String advancepayment) {
            this.advancepayment = advancepayment;
        }

        public String getMembertype() {
            return membertype;
        }

        public void setMembertype(String membertype) {
            this.membertype = membertype;
        }

        public String getPaypwd() {
            return paypwd;
        }

        public void setPaypwd(String paypwd) {
            this.paypwd = paypwd;
        }
    }
}
