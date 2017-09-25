package com.example.root.test.bean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */

public class WeatherInfo{

    /**
     * message : Success !
     * status : 200
     * city : 杭州
     * count : 2
     * data : {"shidu":"68%","pm25":17,"pm10":35,"quality":"良","wendu":"25","ganmao":"极少数敏感人群应减少户外活动","yesterday":{"date":"03日星期日","sunrise":"05:36","high":"高温 30.0℃","low":"低温 24.0℃","sunset":"18:21","aqi":57,"fx":"东北风","fl":"3-4级","type":"阴","notice":"阴天没有晴天的明朗，却依然明亮"},"forecast":[{"date":"04日星期一","sunrise":"05:37","high":"高温 33.0℃","low":"低温 25.0℃","sunset":"18:19","aqi":38,"fx":"东风","fl":"3-4级","type":"多云","notice":"悠悠的云里有淡淡的诗"},{"date":"05日星期二","sunrise":"05:37","high":"高温 34.0℃","low":"低温 25.0℃","sunset":"18:18","aqi":53,"fx":"东北风","fl":"<3级","type":"雷阵雨","notice":"雷雨闪电时，应切断电器电源，以免损坏"},{"date":"06日星期三","sunrise":"05:38","high":"高温 30.0℃","low":"低温 25.0℃","sunset":"18:17","aqi":64,"fx":"北风","fl":"<3级","type":"阵雨","notice":"今日有短时阵雨，外出请携带雨具"},{"date":"07日星期四","sunrise":"05:38","high":"高温 29.0℃","low":"低温 23.0℃","sunset":"18:16","aqi":59,"fx":"东北风","fl":"<3级","type":"阵雨","notice":"突如其来的雨，总叫让人措手不及"},{"date":"08日星期五","sunrise":"05:39","high":"高温 31.0℃","low":"低温 24.0℃","sunset":"18:15","aqi":64,"fx":"东风","fl":"<3级","type":"多云","notice":"绵绵的云朵，形状千变万化"}]}
     */

    private String message;
    private int status;
    private String city;
    private int count;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", city='" + city + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        /**
         * shidu : 68%
         * pm25 : 17.0
         * pm10 : 35.0
         * quality : 良
         * wendu : 25
         * ganmao : 极少数敏感人群应减少户外活动
         * yesterday : {"date":"03日星期日","sunrise":"05:36","high":"高温 30.0℃","low":"低温 24.0℃","sunset":"18:21","aqi":57,"fx":"东北风","fl":"3-4级","type":"阴","notice":"阴天没有晴天的明朗，却依然明亮"}
         * forecast : [{"date":"04日星期一","sunrise":"05:37","high":"高温 33.0℃","low":"低温 25.0℃","sunset":"18:19","aqi":38,"fx":"东风","fl":"3-4级","type":"多云","notice":"悠悠的云里有淡淡的诗"},{"date":"05日星期二","sunrise":"05:37","high":"高温 34.0℃","low":"低温 25.0℃","sunset":"18:18","aqi":53,"fx":"东北风","fl":"<3级","type":"雷阵雨","notice":"雷雨闪电时，应切断电器电源，以免损坏"},{"date":"06日星期三","sunrise":"05:38","high":"高温 30.0℃","low":"低温 25.0℃","sunset":"18:17","aqi":64,"fx":"北风","fl":"<3级","type":"阵雨","notice":"今日有短时阵雨，外出请携带雨具"},{"date":"07日星期四","sunrise":"05:38","high":"高温 29.0℃","low":"低温 23.0℃","sunset":"18:16","aqi":59,"fx":"东北风","fl":"<3级","type":"阵雨","notice":"突如其来的雨，总叫让人措手不及"},{"date":"08日星期五","sunrise":"05:39","high":"高温 31.0℃","low":"低温 24.0℃","sunset":"18:15","aqi":64,"fx":"东风","fl":"<3级","type":"多云","notice":"绵绵的云朵，形状千变万化"}]
         */

        private String shidu;
        private double pm25;
        private double pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public double getPm25() {
            return pm25;
        }

        public void setPm25(double pm25) {
            this.pm25 = pm25;
        }

        public double getPm10() {
            return pm10;
        }

        public void setPm10(double pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "shidu='" + shidu + '\'' +
                    ", pm25=" + pm25 +
                    ", pm10=" + pm10 +
                    ", quality='" + quality + '\'' +
                    ", wendu='" + wendu + '\'' +
                    ", ganmao='" + ganmao + '\'' +
                    ", yesterday=" + yesterday +
                    ", forecast=" + forecast +
                    '}';
        }

        public static class YesterdayBean extends ForecastBean {

        }

        public static class ForecastBean {
            /**
             * date : 04日星期一
             * sunrise : 05:37
             * high : 高温 33.0℃
             * low : 低温 25.0℃
             * sunset : 18:19
             * aqi : 38.0
             * fx : 东风
             * fl : 3-4级
             * type : 多云
             * notice : 悠悠的云里有淡淡的诗
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }

            @Override
            public String toString() {
                return "ForecastBean{" +
                        "date='" + date + '\'' +
                        ", sunrise='" + sunrise + '\'' +
                        ", high='" + high + '\'' +
                        ", low='" + low + '\'' +
                        ", sunset='" + sunset + '\'' +
                        ", aqi=" + aqi +
                        ", fx='" + fx + '\'' +
                        ", fl='" + fl + '\'' +
                        ", type='" + type + '\'' +
                        ", notice='" + notice + '\'' +
                        '}';
            }
        }
    }
}
