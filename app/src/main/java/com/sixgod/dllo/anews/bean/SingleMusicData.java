package com.sixgod.dllo.anews.bean;

import java.util.List;

/**
 * Created by dllo on 16/3/19.
 */
public class SingleMusicData {

    /**
     * body : <p><!--VIDEO#0--></p>
     * users : []
     * replyCount : 0
     * ydbaike : []
     * link : []
     * votes : []
     * img : []
     * digest :
     * topiclist_news : []
     * dkeys : 四川话
     * ec : 曲晓东_NX3880
     * topiclist : []
     * docid : BI18KD7A00964KLQ
     * picnews : true
     * title : 轻松一刻 四川话版(3月3日)
     * tid : T1379040077136
     * video : [{"commentid":"","ref":"<!--VIDEO#0-->","topicid":"","cover":"http://img4.cache.netease.com/3g/2015/5/27/20150527174835a8511.jpg","alt":"轻松一刻四川话版(3月3日)","url_mp4":"http://audio.m.126.net/201603/02/0c09426b14867ee830fc2e97012f0ef9.mp3","broadcast":"in","videosource":"其他","commentboard":"","appurl":"","url_m3u8":"http://audio.m.126.net/201603/02/0c09426b14867ee830fc2e97012f0ef9.mp3","size":""}]
     * template : normal1
     * threadVote : 0
     * threadAgainst : 0
     * boboList : []
     * replyBoard : 3g_bbs
     * hasNext : false
     * voicecomment : off
     * relative_sys : []
     * apps : []
     * ptime : 2016-03-13 07:58:06
     */

    private String body;
    private int replyCount;
    private String digest;
    private String dkeys;
    private String ec;
    private String docid;
    private boolean picnews;
    private String title;
    private String tid;
    private String template;
    private int threadVote;
    private int threadAgainst;
    private String replyBoard;
    private boolean hasNext;
    private String voicecomment;
    private String ptime;
    private List<?> users;
    private List<?> ydbaike;
    private List<?> link;
    private List<?> votes;
    private List<?> img;
    private List<?> topiclist_news;
    private List<?> topiclist;
    /**
     * commentid :
     * ref : <!--VIDEO#0-->
     * topicid :
     * cover : http://img4.cache.netease.com/3g/2015/5/27/20150527174835a8511.jpg
     * alt : 轻松一刻四川话版(3月3日)
     * url_mp4 : http://audio.m.126.net/201603/02/0c09426b14867ee830fc2e97012f0ef9.mp3
     * broadcast : in
     * videosource : 其他
     * commentboard :
     * appurl :
     * url_m3u8 : http://audio.m.126.net/201603/02/0c09426b14867ee830fc2e97012f0ef9.mp3
     * size :
     */

    private List<VideoEntity> video;
    private List<?> boboList;
    private List<?> relative_sys;
    private List<?> apps;

    public void setBody(String body) {
        this.body = body;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public void setDkeys(String dkeys) {
        this.dkeys = dkeys;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public void setPicnews(boolean picnews) {
        this.picnews = picnews;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setThreadVote(int threadVote) {
        this.threadVote = threadVote;
    }

    public void setThreadAgainst(int threadAgainst) {
        this.threadAgainst = threadAgainst;
    }

    public void setReplyBoard(String replyBoard) {
        this.replyBoard = replyBoard;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public void setVoicecomment(String voicecomment) {
        this.voicecomment = voicecomment;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public void setUsers(List<?> users) {
        this.users = users;
    }

    public void setYdbaike(List<?> ydbaike) {
        this.ydbaike = ydbaike;
    }

    public void setLink(List<?> link) {
        this.link = link;
    }

    public void setVotes(List<?> votes) {
        this.votes = votes;
    }

    public void setImg(List<?> img) {
        this.img = img;
    }

    public void setTopiclist_news(List<?> topiclist_news) {
        this.topiclist_news = topiclist_news;
    }

    public void setTopiclist(List<?> topiclist) {
        this.topiclist = topiclist;
    }

    public void setVideo(List<VideoEntity> video) {
        this.video = video;
    }

    public void setBoboList(List<?> boboList) {
        this.boboList = boboList;
    }

    public void setRelative_sys(List<?> relative_sys) {
        this.relative_sys = relative_sys;
    }

    public void setApps(List<?> apps) {
        this.apps = apps;
    }

    public String getBody() {
        return body;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public String getDigest() {
        return digest;
    }

    public String getDkeys() {
        return dkeys;
    }

    public String getEc() {
        return ec;
    }

    public String getDocid() {
        return docid;
    }

    public boolean isPicnews() {
        return picnews;
    }

    public String getTitle() {
        return title;
    }

    public String getTid() {
        return tid;
    }

    public String getTemplate() {
        return template;
    }

    public int getThreadVote() {
        return threadVote;
    }

    public int getThreadAgainst() {
        return threadAgainst;
    }

    public String getReplyBoard() {
        return replyBoard;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public String getVoicecomment() {
        return voicecomment;
    }

    public String getPtime() {
        return ptime;
    }

    public List<?> getUsers() {
        return users;
    }

    public List<?> getYdbaike() {
        return ydbaike;
    }

    public List<?> getLink() {
        return link;
    }

    public List<?> getVotes() {
        return votes;
    }

    public List<?> getImg() {
        return img;
    }

    public List<?> getTopiclist_news() {
        return topiclist_news;
    }

    public List<?> getTopiclist() {
        return topiclist;
    }

    public List<VideoEntity> getVideo() {
        return video;
    }

    public List<?> getBoboList() {
        return boboList;
    }

    public List<?> getRelative_sys() {
        return relative_sys;
    }

    public List<?> getApps() {
        return apps;
    }

    public static class VideoEntity {
        private String commentid;
        private String ref;
        private String topicid;
        private String cover;
        private String alt;
        private String url_mp4;
        private String broadcast;
        private String videosource;
        private String commentboard;
        private String appurl;
        private String url_m3u8;
        private String size;

        public void setCommentid(String commentid) {
            this.commentid = commentid;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public void setTopicid(String topicid) {
            this.topicid = topicid;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public void setUrl_mp4(String url_mp4) {
            this.url_mp4 = url_mp4;
        }

        public void setBroadcast(String broadcast) {
            this.broadcast = broadcast;
        }

        public void setVideosource(String videosource) {
            this.videosource = videosource;
        }

        public void setCommentboard(String commentboard) {
            this.commentboard = commentboard;
        }

        public void setAppurl(String appurl) {
            this.appurl = appurl;
        }

        public void setUrl_m3u8(String url_m3u8) {
            this.url_m3u8 = url_m3u8;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getCommentid() {
            return commentid;
        }

        public String getRef() {
            return ref;
        }

        public String getTopicid() {
            return topicid;
        }

        public String getCover() {
            return cover;
        }

        public String getAlt() {
            return alt;
        }

        public String getUrl_mp4() {
            return url_mp4;
        }

        public String getBroadcast() {
            return broadcast;
        }

        public String getVideosource() {
            return videosource;
        }

        public String getCommentboard() {
            return commentboard;
        }

        public String getAppurl() {
            return appurl;
        }

        public String getUrl_m3u8() {
            return url_m3u8;
        }

        public String getSize() {
            return size;
        }
    }
}
