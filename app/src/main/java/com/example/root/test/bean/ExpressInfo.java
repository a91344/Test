package com.example.root.test.bean;

import java.util.List;

/**
 * Created by root on 17-9-3.
 */

public class ExpressInfo {

    /**
     * message : ok
     * nu : 886078172246088777
     * ischeck : 1
     * condition : F00
     * com : yuantong
     * status : 200
     * state : 3
     * data : [{"time":"2017-08-20 13:49:56","ftime":"2017-08-20 13:49:56","context":"客户 签收人: 邮件收发章 已签收 感谢使用圆通速递，期待再次为您服务","location":null},{"time":"2017-08-20 09:05:05","ftime":"2017-08-20 09:05:05","context":"萧山第四十一分公司公司(点击查询电话)徐** 派件中 派件员电话15558068187","location":null},{"time":"2017-08-20 06:23:03","ftime":"2017-08-20 06:23:03","context":"浙江省杭州市萧山中部公司 已发出,下一站 萧山第四十一分公司","location":null},{"time":"2017-08-20 04:49:46","ftime":"2017-08-20 04:49:46","context":"杭州转运中心 已发出,下一站 浙江省杭州市萧山中部","location":null},{"time":"2017-08-20 04:36:54","ftime":"2017-08-20 04:36:54","context":"杭州转运中心 已收入","location":null},{"time":"2017-08-19 21:24:57","ftime":"2017-08-19 21:24:57","context":"浙江省温州市瑞安市公司 已发出,下一站 杭州转运中心","location":null},{"time":"2017-08-19 21:18:18","ftime":"2017-08-19 21:18:18","context":"浙江省温州市瑞安市公司 已打包","location":null},{"time":"2017-08-19 21:05:57","ftime":"2017-08-19 21:05:57","context":"浙江省温州市瑞安市公司(点击查询电话) 已揽收","location":null},{"time":"2017-08-19 18:26:58","ftime":"2017-08-19 18:26:58","context":"浙江省温州市瑞安市公司 取件人: 王梅梅 已收件","location":null}]
     */

    private String message;
    private String nu;
    private String ischeck;
    private String condition;
    private String com;
    private String status;
    private String state;
    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNu() {
        return nu;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ExpressInfo{" +
                "message='" + message + '\'' +
                ", nu='" + nu + '\'' +
                ", ischeck='" + ischeck + '\'' +
                ", condition='" + condition + '\'' +
                ", com='" + com + '\'' +
                ", status='" + status + '\'' +
                ", state='" + state + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        /**
         * time : 2017-08-20 13:49:56
         * ftime : 2017-08-20 13:49:56
         * context : 客户 签收人: 邮件收发章 已签收 感谢使用圆通速递，期待再次为您服务
         * location : null
         */

        private String time;
        private String ftime;
        private String context;
        private Object location;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getFtime() {
            return ftime;
        }

        public void setFtime(String ftime) {
            this.ftime = ftime;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public Object getLocation() {
            return location;
        }

        public void setLocation(Object location) {
            this.location = location;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "time='" + time + '\'' +
                    ", ftime='" + ftime + '\'' +
                    ", context='" + context + '\'' +
                    ", location=" + location +
                    '}';
        }
    }
}
