package com.sixgod.dllo.anews.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/3/2.
 */
public class WholeNewsData<T> {

    /**
     * template : manual
     * hasCover : false
     * hasHead : 1
     * skipID : 73459
     * alias : Top News
     * hasImg : 1
     * digest : 2016年全国两会即将启幕，场内外全程直播，敬请关注！
     * hasIcon : true
     * skipType : live
     * cid : C1348646712614
     * docid : 9IG74V5H00963VRO_BH4TEBDOpingguanupdateDoc
     * title : 王国庆:今天开会 没想到"雾霾来了"
     * hasAD : 1
     * TAGS : 正在直播
     * order : 1
     * priority : 999
     * live_info : {"end_time":"2016-03-16 18:00:00.0","user_count":1912312,"roomId":73459,"start_time":"2016-03-02 08:00:00.0","type":0,"video":true}
     * lmodify : 2016-03-02 07:43:49
     * ename : iosnews
     * tname : 头条
     * imgsrc : http://img6.cache.netease.com/3g/2016/3/2/20160302155935ddf3c.jpg
     * ads : [{"title":"叙多国记者遭炮击受伤 含中国籍记者","tag":"photoset","imgsrc":"http://img2.cache.netease.com/3g/2016/3/2/2016030211391852362.jpg","subtitle":"","url":"00AO0001|112072"},{"title":"人大记者证件发放 记者扫二维码领取","tag":"photoset","imgsrc":"http://img3.cache.netease.com/3g/2016/3/2/2016030210385601820.jpg","subtitle":"","url":"00AN0001|112061"},{"title":"印度\"高考\"开始 考生\"备战\"至最后","tag":"photoset","imgsrc":"http://img6.cache.netease.com/3g/2016/3/2/2016030210103153b7f.jpg","subtitle":"","url":"00AO0001|112054"},{"title":"意大利华人游行 反对歧视和暴力抢劫","tag":"photoset","imgsrc":"http://img1.cache.netease.com/3g/2016/3/2/20160302085016c1337.jpg","subtitle":"","url":"00AO0001|112045"},{"title":"山西对进京旅客二次安检保两会安全","tag":"photoset","imgsrc":"http://img1.cache.netease.com/3g/2016/3/2/201603020828464baa2.jpg","subtitle":"","url":"00AN0001|112039"}]
     * ptime : 2016-03-02 07:43:49
     * TAG : 正在直播
     */

    private ArrayList<T1348647853363Entity> T1348647853363;

    public void setT1348647853363(ArrayList<T1348647853363Entity> T1348647853363) {
        this.T1348647853363 = T1348647853363;
    }

    public ArrayList<T1348647853363Entity> getT1348647853363() {
        return T1348647853363;
    }

    public static class T1348647853363Entity {
        private String template;
        private boolean hasCover;
        private int hasHead;
        private String skipID;
        private String alias;
        private int hasImg;
        private String digest;
        private boolean hasIcon;
        private String skipType;
        private String cid;
        private String docid;
        private String title;
        private int hasAD;
        private String TAGS;
        private int order;
        private int priority;
        /**
         * end_time : 2016-03-16 18:00:00.0
         * user_count : 1912312
         * roomId : 73459
         * start_time : 2016-03-02 08:00:00.0
         * type : 0
         * video : true
         */

        private LiveInfoEntity live_info;
        private String lmodify;
        private String ename;
        private String tname;
        private String imgsrc;
        private String ptime;
        private String TAG;
        /**
         * title : 叙多国记者遭炮击受伤 含中国籍记者
         * tag : photoset
         * imgsrc : http://img2.cache.netease.com/3g/2016/3/2/2016030211391852362.jpg
         * subtitle :
         * url : 00AO0001|112072
         */

        private List<AdsEntity> ads;

        public void setTemplate(String template) {
            this.template = template;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public void setTAGS(String TAGS) {
            this.TAGS = TAGS;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public void setLive_info(LiveInfoEntity live_info) {
            this.live_info = live_info;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public void setTAG(String TAG) {
            this.TAG = TAG;
        }

        public void setAds(List<AdsEntity> ads) {
            this.ads = ads;
        }

        public String getTemplate() {
            return template;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public int getHasHead() {
            return hasHead;
        }

        public String getSkipID() {
            return skipID;
        }

        public String getAlias() {
            return alias;
        }

        public int getHasImg() {
            return hasImg;
        }

        public String getDigest() {
            return digest;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public String getSkipType() {
            return skipType;
        }

        public String getCid() {
            return cid;
        }

        public String getDocid() {
            return docid;
        }

        public String getTitle() {
            return title;
        }

        public int getHasAD() {
            return hasAD;
        }

        public String getTAGS() {
            return TAGS;
        }

        public int getOrder() {
            return order;
        }

        public int getPriority() {
            return priority;
        }

        public LiveInfoEntity getLive_info() {
            return live_info;
        }

        public String getLmodify() {
            return lmodify;
        }

        public String getEname() {
            return ename;
        }

        public String getTname() {
            return tname;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public String getPtime() {
            return ptime;
        }

        public String getTAG() {
            return TAG;
        }

        public List<AdsEntity> getAds() {
            return ads;
        }

        public static class LiveInfoEntity {
            private String end_time;
            private int user_count;
            private int roomId;
            private String start_time;
            private int type;
            private boolean video;

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public void setUser_count(int user_count) {
                this.user_count = user_count;
            }

            public void setRoomId(int roomId) {
                this.roomId = roomId;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public void setType(int type) {
                this.type = type;
            }

            public void setVideo(boolean video) {
                this.video = video;
            }

            public String getEnd_time() {
                return end_time;
            }

            public int getUser_count() {
                return user_count;
            }

            public int getRoomId() {
                return roomId;
            }

            public String getStart_time() {
                return start_time;
            }

            public int getType() {
                return type;
            }

            public boolean isVideo() {
                return video;
            }
        }

        public static class AdsEntity {
            private String title;
            private String tag;
            private String imgsrc;
            private String subtitle;
            private String url;

            public void setTitle(String title) {
                this.title = title;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTitle() {
                return title;
            }

            public String getTag() {
                return tag;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public String getUrl() {
                return url;
            }
        }
    }
}
