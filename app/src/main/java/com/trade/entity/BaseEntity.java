package com.trade.entity;

/**
 * Created by yixiaofei on 2017/3/6 0006.
 */

public class BaseEntity {
    //返回码
    private String retCode;
    //返回信息
    private String retMsg;
    //流水账号
    private String logNo;
    //会话ID
    private String sessionId;
    //页码信息
    public PageInfoBean pageInfo;

    public PageInfoBean getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoBean pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getLogNo() {
        return logNo;
    }

    public void setLogNo(String logNo) {
        this.logNo = logNo;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public static class PageInfoBean {
        /**
         * currentPageNum : 1
         * rowsOfPage : 10
         * totalPageCount : 1
         */

        private String currentPageNum;
        private String rowsOfPage;
        private String totalPageCount;

        public String getCurrentPageNum() {
            return currentPageNum;
        }

        public void setCurrentPageNum(String currentPageNum) {
            this.currentPageNum = currentPageNum;
        }

        public String getRowsOfPage() {
            return rowsOfPage;
        }

        public void setRowsOfPage(String rowsOfPage) {
            this.rowsOfPage = rowsOfPage;
        }

        public String getTotalPageCount() {
            return totalPageCount;
        }

        public void setTotalPageCount(String totalPageCount) {
            this.totalPageCount = totalPageCount;
        }
    }


}
