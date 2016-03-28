package com.sixgod.dllo.anews.bean;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/3/8.
 */
public class ReadData {

    /**
     * boardid : dy_wemedia_bbs
     * clkNum : 0
     * digest : 张柏芝在"喜剧之王"中颜值简直惊为天人，没道理不红。
     * docid : BHISKVHC05178P46
     * downTimes : 1
     * id : BHISKVHC05178P46
     * img : http://img1.cache.netease.com/3g/2016/3/7/20160307204340487eb.png
     * imgType : 0
     * imgsrc : http://img1.cache.netease.com/3g/2016/3/7/20160307204340487eb.png
     * picCount : 1
     * pixel : 270*202
     * program : HY
     * prompt : 有20条新内容，点击刷新
     * ptime : 2016-03-07 17:59:20
     * recType : -1
     * replyCount : 4209
     * replyid : BHISKVHC05178P46
     * source : 天天有娱
     * template : normal
     * title : 她曾那么完美 没人比她更努力
     * unlikeReason : ["电视/1","很黄很暴力/6","标题党/6","张柏芝/3","来源:天天有娱/4","内容重复/6"]
     * upTimes : 1
     */
    @SerializedName("推荐")
    private ArrayList<RecommendEntity> recommend;

    public void setRecommend(ArrayList<RecommendEntity> recommend) {
        this.recommend = recommend;
    }

    public ArrayList<RecommendEntity> getRecommend() {
        return recommend;
    }

    public static class RecommendEntity {
        private String boardid;
        private int clkNum;
        private String digest;
        private String docid;
        private int downTimes;
        private String id;
        private String img;
        private int imgType;
        private String imgsrc;
        private int picCount;
        private String pixel;
        private String program;
        private String prompt;
        private String ptime;
        private int recType;
        private int replyCount;
        private String replyid;
        private String source;
        private String template;
        private String title;
        private int upTimes;
        private ArrayList<ImgnewextraEntity> imgnewextra;
//        private ArrayList<String> imgnewextra;
        private List<String> unlikeReason;

        public ArrayList<ImgnewextraEntity> getImgnewextra() {
            return imgnewextra;
        }

        public void setImgnewextra(ArrayList<ImgnewextraEntity> imgnewextra) {
            this.imgnewextra = imgnewextra;
        }
        //        public ArrayList<String> getImgnewextra() {
//            return imgnewextra;
//        }
//
//        public void setImgnewextra(ArrayList<String> imgnewextra) {
//            this.imgnewextra = imgnewextra;
//        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public void setClkNum(int clkNum) {
            this.clkNum = clkNum;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public void setDownTimes(int downTimes) {
            this.downTimes = downTimes;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setImgType(int imgType) {
            this.imgType = imgType;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public void setPicCount(int picCount) {
            this.picCount = picCount;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }

        public void setProgram(String program) {
            this.program = program;
        }

        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public void setRecType(int recType) {
            this.recType = recType;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public void setReplyid(String replyid) {
            this.replyid = replyid;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setUpTimes(int upTimes) {
            this.upTimes = upTimes;
        }

        public void setUnlikeReason(List<String> unlikeReason) {
            this.unlikeReason = unlikeReason;
        }

        public String getBoardid() {
            return boardid;
        }

        public int getClkNum() {
            return clkNum;
        }

        public String getDigest() {
            return digest;
        }

        public String getDocid() {
            return docid;
        }

        public int getDownTimes() {
            return downTimes;
        }

        public String getId() {
            return id;
        }

        public String getImg() {
            return img;
        }

        public int getImgType() {
            return imgType;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public int getPicCount() {
            return picCount;
        }

        public String getPixel() {
            return pixel;
        }

        public String getProgram() {
            return program;
        }

        public String getPrompt() {
            return prompt;
        }

        public String getPtime() {
            return ptime;
        }

        public int getRecType() {
            return recType;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public String getReplyid() {
            return replyid;
        }

        public String getSource() {
            return source;
        }

        public String getTemplate() {
            return template;
        }

        public String getTitle() {
            return title;
        }

        public int getUpTimes() {
            return upTimes;
        }

        public List<String> getUnlikeReason() {
            return unlikeReason;
        }
    }
    public static class ImgnewextraEntity {
        private String imgsrc;

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getImgsrc() {
            return imgsrc;
        }
    }
}
