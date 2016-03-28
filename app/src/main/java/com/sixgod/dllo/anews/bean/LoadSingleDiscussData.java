package com.sixgod.dllo.anews.bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/3/11.
 */
public class LoadSingleDiscussData {

    /**
     * message : 操作成功
     * data : [{"question":{"questionId":"QUESTION07717747146456411812","content":"老师你好，我想去上海卖房子。现在不知道是去链家还是我爱我家收益好？","relatedExpertId":"EX05811127224573584601","userName":"看客999","userHeadPicUrl":"http://q.qlogo.cn/qqapp/100346651/692C8F13CBBCF74431774D0336276F42/100","state":"replied","cTime":1457340615371},"answer":{"answerId":"ANSWER8249469752902518068","board":"3g_bbs","commentId":"BHT2SGOM009617BE","relatedQuestionId":"QUESTION07717747146456411812","content":"去链家吧！毕竟资金还是安全些\u2026","specialistName":"王心满","specialistHeadPicUrl":"http://dingyue.nosdn.127.net/zYPgEE2dHYFIvos=T0RYRVFp4B4JRfdOssEcnldpgu1nU1456222337435.jpg","supportCount":2,"replyCount":0,"cTime":1457689577404}},{"question":{"questionId":"QUESTION6078233286926117839","content":"你好，我想问我媳妇有一套房，我现在买13平的房，契税是多少","relatedExpertId":"EX05811127224573584601","userName":"浪花读感","userHeadPicUrl":"","state":"replied","cTime":1457345147196},"answer":{"answerId":"ANSWER8230386866512319706","board":"3g_bbs","commentId":"BHT2QQEQ009617BE","relatedQuestionId":"QUESTION6078233286926117839","content":"二套要交3%的契税！以家庭为核算的！","specialistName":"王心满","specialistHeadPicUrl":"http://dingyue.nosdn.127.net/zYPgEE2dHYFIvos=T0RYRVFp4B4JRfdOssEcnldpgu1nU1456222337435.jpg","supportCount":3,"replyCount":0,"cTime":1457689577202}},{"question":{"questionId":"QUESTION03033744613511983272","content":"为什么说解决商品房库存问题必须涨价销售？","relatedExpertId":"EX05811127224573584601","userName":"寸心白衫4zn3","userHeadPicUrl":"http://wx.qlogo.cn/mmopen/Kwg1Hs1pPD1YOHc3J3Rib0tgNv5cib5jfZicyGm8lu8s4MrFM2LmDfrumpWzjWUlfRB4dDbZaRSUCBUtEpuCN08WbXn0B9tQPwic/0","state":"replied","cTime":1457356351016},"answer":{"answerId":"ANSWER5257967668957428550","board":"3g_bbs","commentId":"BHT2OUNF009617BE","relatedQuestionId":"QUESTION03033744613511983272","content":"这是市场走向，大势所趋！","specialistName":"王心满","specialistHeadPicUrl":"http://dingyue.nosdn.127.net/zYPgEE2dHYFIvos=T0RYRVFp4B4JRfdOssEcnldpgu1nU1456222337435.jpg","supportCount":1,"replyCount":0,"cTime":1457689576796}},{"question":{"questionId":"QUESTION05983552162028688596","content":"王老师您好，如果要把房子过户到儿子名下，需要什么手续？交多少税金？谢谢","relatedExpertId":"EX05811127224573584601","userName":"李局长助理小李","userHeadPicUrl":"http://imgm.ph.126.net/CWIjPuA3UD9IKJO7_kbdjw==/6631411912843493100.jpg","state":"replied","cTime":1457496676307},"answer":{"answerId":"ANSWER1813722853416634002","board":"3g_bbs","commentId":"BHT2N1UA009617BE","relatedQuestionId":"QUESTION05983552162028688596","content":"走房屋赠予\u2026只要交3%的契税和赠予公证费","specialistName":"王心满","specialistHeadPicUrl":"http://dingyue.nosdn.127.net/zYPgEE2dHYFIvos=T0RYRVFp4B4JRfdOssEcnldpgu1nU1456222337435.jpg","supportCount":0,"replyCount":0,"cTime":1457689576577}},{"question":{"questionId":"QUESTION08877192121493221263","content":"你好！请问北京海淀区五棵松紫金长安的房子一平米10万能买吗？","relatedExpertId":"EX05811127224573584601","userName":"红领巾Guo","userHeadPicUrl":"http://tp1.sinaimg.cn/5356274216/180/5717417343/1","state":"replied","cTime":1457681633607},"answer":{"answerId":"ANSWER04472798744037241914","board":"3g_bbs","commentId":"BHT2JVJR009617BE","relatedQuestionId":"QUESTION08877192121493221263","content":"这要看你需求，如果你必须要买房可以考虑买了！","specialistName":"王心满","specialistHeadPicUrl":"http://dingyue.nosdn.127.net/zYPgEE2dHYFIvos=T0RYRVFp4B4JRfdOssEcnldpgu1nU1456222337435.jpg","supportCount":3,"replyCount":0,"cTime":1457689576440}},{"question":{"questionId":"QUESTION01599635346823951450","content":"预算在250到300万之间 请给推荐个好地段的房子 东 南 北 都行","relatedExpertId":"EX05811127224573584601","userName":"操蛋的时代","userHeadPicUrl":"http://img1.cache.netease.com/t/img/default80.png","state":"replied","cTime":1457682546105},"answer":{"answerId":"ANSWER08685711400554773200","board":"3g_bbs","commentId":"BHT2AO01009617BE","relatedQuestionId":"QUESTION01599635346823951450","content":"北边吧【北\n五环】附近我好几个朋友都在那买的！","specialistName":"王心满","specialistHeadPicUrl":"http://dingyue.nosdn.127.net/zYPgEE2dHYFIvos=T0RYRVFp4B4JRfdOssEcnldpgu1nU1456222337435.jpg","supportCount":0,"replyCount":0,"cTime":1457689575450}},{"question":{"questionId":"QUESTION2878323496487727595","content":"我和我老婆共同拥有一套房子，双方公积金贷款的，未还清。如果现在离婚，我想把房子和贷款的债务都转移到她名下，请问这样可以么？需要怎么办手续？如果手续办理完毕，我再以自己名字买房，是否是首套？谢谢","relatedExpertId":"EX05811127224573584601","userName":"马甲SXUV","userHeadPicUrl":"http://q.qlogo.cn/qqapp/100346651/84B5D0559A23049D1C01BA6D5E635708/100","state":"replied","cTime":1456723728965},"answer":{"answerId":"ANSWER6159259683554017526","board":"3g_bbs","commentId":"BH57CV5R009617BE","relatedQuestionId":"QUESTION2878323496487727595","content":"协议一定要把这些写清楚，然后要把房本换到你爱人名下！就可以是首套","specialistName":"王心满","specialistHeadPicUrl":"http://dingyue.nosdn.127.net/zYPgEE2dHYFIvos=T0RYRVFp4B4JRfdOssEcnldpgu1nU1456222337435.jpg","supportCount":3,"replyCount":1,"cTime":1456886714622}},{"question":{"questionId":"QUESTION8563461525712183841","content":"请问你是中原地产的吗？","relatedExpertId":"EX05811127224573584601","userName":"BreezeAPOW","userHeadPicUrl":"http://q.qlogo.cn/qqapp/100346651/4677596411A8AFFEB5A6D256C6C3E58F/100","state":"replied","cTime":1456724907312},"answer":{"answerId":"ANSWER02717480427716586395","board":"3g_bbs","commentId":"BH57A4K8009617BE","relatedQuestionId":"QUESTION8563461525712183841","content":"亲，不是的","specialistName":"王心满","specialistHeadPicUrl":"http://dingyue.nosdn.127.net/zYPgEE2dHYFIvos=T0RYRVFp4B4JRfdOssEcnldpgu1nU1456222337435.jpg","supportCount":2,"replyCount":0,"cTime":1456886235886}},{"question":{"questionId":"QUESTION5196840425077434620","content":"北京商住两用的房子，价格是什么趋势？","relatedExpertId":"EX05811127224573584601","userName":"aslizhang","userHeadPicUrl":"","state":"replied","cTime":1456728035920},"answer":{"answerId":"ANSWER6760900053866556674","board":"3g_bbs","commentId":"BH579L6T009617BE","relatedQuestionId":"QUESTION5196840425077434620","content":"要看具体的区域位置\u2026","specialistName":"王心满","specialistHeadPicUrl":"http://dingyue.nosdn.127.net/zYPgEE2dHYFIvos=T0RYRVFp4B4JRfdOssEcnldpgu1nU1456222337435.jpg","supportCount":1,"replyCount":1,"cTime":1456886235812}},{"question":{"questionId":"QUESTION5749110022170342234","content":"请问，用公司名义买房划算吗？","relatedExpertId":"EX05811127224573584601","userName":"aslizhang","userHeadPicUrl":"","state":"replied","cTime":1456728809801},"answer":{"answerId":"ANSWER6041057728180272137","board":"3g_bbs","commentId":"BH5792HL009617BE","relatedQuestionId":"QUESTION5749110022170342234","content":"现在是可以的，目前有好多都是公司名义买的\u2026","specialistName":"王心满","specialistHeadPicUrl":"http://dingyue.nosdn.127.net/zYPgEE2dHYFIvos=T0RYRVFp4B4JRfdOssEcnldpgu1nU1456222337435.jpg","supportCount":1,"replyCount":0,"cTime":1456886235511}}]
     * code : 1
     */

    private String message;
    private int code;
    /**
     * question : {"questionId":"QUESTION07717747146456411812","content":"老师你好，我想去上海卖房子。现在不知道是去链家还是我爱我家收益好？","relatedExpertId":"EX05811127224573584601","userName":"看客999","userHeadPicUrl":"http://q.qlogo.cn/qqapp/100346651/692C8F13CBBCF74431774D0336276F42/100","state":"replied","cTime":1457340615371}
     * answer : {"answerId":"ANSWER8249469752902518068","board":"3g_bbs","commentId":"BHT2SGOM009617BE","relatedQuestionId":"QUESTION07717747146456411812","content":"去链家吧！毕竟资金还是安全些\u2026","specialistName":"王心满","specialistHeadPicUrl":"http://dingyue.nosdn.127.net/zYPgEE2dHYFIvos=T0RYRVFp4B4JRfdOssEcnldpgu1nU1456222337435.jpg","supportCount":2,"replyCount":0,"cTime":1457689577404}
     */

    private ArrayList<DataEntity> data;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(ArrayList<DataEntity> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public ArrayList<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        /**
         * questionId : QUESTION07717747146456411812
         * content : 老师你好，我想去上海卖房子。现在不知道是去链家还是我爱我家收益好？
         * relatedExpertId : EX05811127224573584601
         * userName : 看客999
         * userHeadPicUrl : http://q.qlogo.cn/qqapp/100346651/692C8F13CBBCF74431774D0336276F42/100
         * state : replied
         * cTime : 1457340615371
         */

        private QuestionEntity question;
        /**
         * answerId : ANSWER8249469752902518068
         * board : 3g_bbs
         * commentId : BHT2SGOM009617BE
         * relatedQuestionId : QUESTION07717747146456411812
         * content : 去链家吧！毕竟资金还是安全些…
         * specialistName : 王心满
         * specialistHeadPicUrl : http://dingyue.nosdn.127.net/zYPgEE2dHYFIvos=T0RYRVFp4B4JRfdOssEcnldpgu1nU1456222337435.jpg
         * supportCount : 2
         * replyCount : 0
         * cTime : 1457689577404
         */

        private AnswerEntity answer;

        public void setQuestion(QuestionEntity question) {
            this.question = question;
        }

        public void setAnswer(AnswerEntity answer) {
            this.answer = answer;
        }

        public QuestionEntity getQuestion() {
            return question;
        }

        public AnswerEntity getAnswer() {
            return answer;
        }

        public static class QuestionEntity {
            private String questionId;
            private String content;
            private String relatedExpertId;
            private String userName;
            private String userHeadPicUrl;
            private String state;
            private long cTime;

            public void setQuestionId(String questionId) {
                this.questionId = questionId;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setRelatedExpertId(String relatedExpertId) {
                this.relatedExpertId = relatedExpertId;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public void setUserHeadPicUrl(String userHeadPicUrl) {
                this.userHeadPicUrl = userHeadPicUrl;
            }

            public void setState(String state) {
                this.state = state;
            }

            public void setCTime(long cTime) {
                this.cTime = cTime;
            }

            public String getQuestionId() {
                return questionId;
            }

            public String getContent() {
                return content;
            }

            public String getRelatedExpertId() {
                return relatedExpertId;
            }

            public String getUserName() {
                return userName;
            }

            public String getUserHeadPicUrl() {
                return userHeadPicUrl;
            }

            public String getState() {
                return state;
            }

            public long getCTime() {
                return cTime;
            }
        }

        public static class AnswerEntity {
            private String answerId;
            private String board;
            private String commentId;
            private String relatedQuestionId;
            private String content;
            private String specialistName;
            private String specialistHeadPicUrl;
            private int supportCount;
            private int replyCount;
            private long cTime;

            public void setAnswerId(String answerId) {
                this.answerId = answerId;
            }

            public void setBoard(String board) {
                this.board = board;
            }

            public void setCommentId(String commentId) {
                this.commentId = commentId;
            }

            public void setRelatedQuestionId(String relatedQuestionId) {
                this.relatedQuestionId = relatedQuestionId;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setSpecialistName(String specialistName) {
                this.specialistName = specialistName;
            }

            public void setSpecialistHeadPicUrl(String specialistHeadPicUrl) {
                this.specialistHeadPicUrl = specialistHeadPicUrl;
            }

            public void setSupportCount(int supportCount) {
                this.supportCount = supportCount;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
            }

            public void setCTime(long cTime) {
                this.cTime = cTime;
            }

            public String getAnswerId() {
                return answerId;
            }

            public String getBoard() {
                return board;
            }

            public String getCommentId() {
                return commentId;
            }

            public String getRelatedQuestionId() {
                return relatedQuestionId;
            }

            public String getContent() {
                return content;
            }

            public String getSpecialistName() {
                return specialistName;
            }

            public String getSpecialistHeadPicUrl() {
                return specialistHeadPicUrl;
            }

            public int getSupportCount() {
                return supportCount;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public long getCTime() {
                return cTime;
            }
        }
    }
}
