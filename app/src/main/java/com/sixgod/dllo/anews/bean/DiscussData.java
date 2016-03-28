package com.sixgod.dllo.anews.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/5.
 */
public class DiscussData implements Parcelable{

    /**
     * message : 操作成功
     * data : {"expertList":[{"expertId":"EX-433744285902633489","alias":"我是不正经小百科，擅长一本正经的胡说八道，承接任何问题，问我吧！","stitle":" ","picurl":"http://dingyue.nosdn.127.net/1Jm3CfzSp=BZf=VGC87iohPbeS7FQPykqctjM=hWYYFHu1450279121487.jpg","name":"一本道","description":"不自由撰稿人，非著名影视评论家，不知名媒体评论家，不精通医、农、工、商的不正经小百科，能够一本正经胡说八道的文字工作者。","headpicurl":"http://dingyue.nosdn.127.net/vMWN9LY2NA69doDi1HojdoiKrtPUbxDhXQ79v6e3=s94R1450278993650.jpg","classification":"人文","state":1,"expertState":1,"concernCount":120539,"createTime":1450279220317,"title":"文字工作者","questionCount":8826,"answerCount":1058},{"expertId":"EX6025502453593172562","alias":"我是经济学家宋清辉，关于经济政策走向、金融市场的问题，问我吧！","stitle":" ","picurl":"http://dingyue.nosdn.127.net/DbLoxRirflIT3aVa4PHT=zD4uZ5siBgoHRXfIdkyWYwv71456298121674.jpg","name":"宋清辉","description":"《证券日报》《南方都市报》等多家媒体的特约评论员，在新华网、《大公报》等海内外多家媒体开有专栏，2015年曾获《证券时报》社\u201c最具影响力财经观察员奖\u201d，主要研究领域为经济体制与金融市场。最近出版了《一本书读懂经济新常态》，这是我近年来对\u201c经济新常态\u201d的一些研究总结。身处商业社会，我刻意保持着与商业、权力的距离，我认为只有这样才能够更加客观公正地去研究和看待经济问题。","headpicurl":"http://dingyue.nosdn.127.net/uswWyipZfVr0b5UM2lHL7eKJP=FU0Fj1TI5BWhlpUjN7Y1453256235002.jpg","classification":"财经","state":1,"expertState":1,"concernCount":72291,"createTime":1453257105670,"title":"经济学家","questionCount":4886,"answerCount":1061},{"expertId":"EX8635704607709333696","alias":"我是心理治疗师李昂，关于焦虑、各种心理问题，问我吧！","stitle":" ","picurl":"http://dingyue.nosdn.127.net/wdUU8YFsG040MdDcwIPNShbempOdNCECEmgKZor2U463d1452502748700.jpg","name":"李昂","description":"积极·跨文化治疗师，Pab Group创始人，国际积极·跨文化治疗协会成员（WAPP），世界心理治疗协会成员（IFP）。现居北京，主要研究方向是心理治疗和心身医学。","headpicurl":"http://dingyue.nosdn.127.net/XzuY81cpkPO=u=wHlslWtRSyp=zVa6TkZGBUgbU6h38H91452499082879.jpg","classification":"健康","state":1,"expertState":1,"concernCount":65273,"createTime":1452496919512,"title":"心理治疗师","questionCount":1766,"answerCount":161},{"expertId":"EX-6248421739916863194","alias":"我是易者乔东，有关易经文化、个人命运，百姓百事等问题，问我吧！","stitle":" ","picurl":"http://dingyue.nosdn.127.net/MN3RNaa1tbb8BFAmHwZ7i0ltyu19HIroheVpowTPIrZj01452494050667.jpg","name":"乔东","description":"中国易经协会会员。出生在河洛文化之地，自小浸染在河洛文化之中，有幸得到中原多位民间易人传授占卜术数和风水，研习四柱八字、奇门遁甲、各派风水，后经长期的案例经验，将我国传统的术类应用到现代社会的各个方面，比如个人命运、婚姻状况、投资求财、企业管理、家居风水等等有着独特的研究。","headpicurl":"http://dingyue.nosdn.127.net/kIUA3O3OnsPMHnnCQ3NeXgOv=Jtcij9HTIFHy2zKxUYFY1451034744705.jpg","classification":"人文","state":1,"expertState":1,"concernCount":50660,"createTime":1450252647136,"title":"易者","questionCount":4951,"answerCount":563},{"expertId":"EX08942623910178780544","alias":"我是南开大学博导宁稼雨，关于传统文学与文化，从建安七子到竹林七贤的问题，问我吧！","stitle":" ","picurl":"http://dingyue.nosdn.127.net/Pn92urzfF00kl2csWcfyDcYesayd8zO60UG0eMsQLrT1Q1456902091877.jpg","name":"宁稼雨","description":"南开大学中文系教授，博士生导师，曾任古代文学教研室主任，天津市文学学会副秘书长，天津师范大学古籍研究所兼职研究员。主要从事古代文言小说和文学史与文化史的关系研究。","headpicurl":"http://dingyue.nosdn.127.net/YIS9WO=88Cnwd02QUR6ipgj6iSftyjkQz=kuzjQ48wXea1453452138899.jpg","classification":"人文","state":1,"expertState":1,"concernCount":36569,"createTime":1453452851705,"title":"南开大学文学院教授、博士生导师","questionCount":699,"answerCount":512},{"expertId":"EX08040586482694101835","alias":"我是胖编，一切关于轻松一刻与小编八卦，问我吧！","stitle":"","picurl":"http://dingyue.nosdn.127.net/6a8m0KY4WzwnpQtuD6bVbyNCh0h6t19XVqdpYiDarc7I41456825785937.jpg","name":"胖编","description":"我是胖编，是轻松一刻工作室的小编，网易新闻客户端王牌栏目《每日轻松一刻》以及精品频道《轻松一刻》的编辑。","headpicurl":"http://dingyue.nosdn.127.net/gRPPhE14QjTGEY4VMNut4GhW5SFUjrVd5zf7eDUs21NhQ1456825700338.jpg","classification":"娱乐","state":1,"expertState":1,"concernCount":5811,"createTime":1456825798792,"title":"编辑","questionCount":244,"answerCount":179},{"expertId":"EX03908568157480497885","alias":"我是心理学博士王非，关于国人思维模式、心理疏导、大众文化的问题，问我吧！","stitle":" ","picurl":"http://dingyue.nosdn.127.net/3CUrqHRaZOFP3H7g9OxjElUItUsxVgk0EAN=WWbjpTeKU1457078745496.jpg","name":"王非","description":"清华大学医学院博士后，研习学院派心理学12年，做过实验，发过问卷，杀过老鼠，扫过大脑，每天与数据拼个你死我活。从事科普写作6年，发表心理学科普文章数十篇，在网上随手辟谣，解答群众关心的心理学问题。\r\n","headpicurl":"http://dingyue.nosdn.127.net/bpkg2tMu5FDTTWhzPhmuhuXSoPL6q1nFkGGSCKkeAX47C1455777272902.jpg","classification":"社会","state":1,"expertState":1,"concernCount":26422,"createTime":1455854339157,"title":"心理学博士、科普作者","questionCount":830,"answerCount":110},{"expertId":"EX4571813090981463107","alias":"我是贵金属分析师韩伟翰，关于黄金白银购入时机、价格走势等问题，问我吧！","stitle":" ","picurl":"http://dingyue.nosdn.127.net/XneOgSZ=we92an3xOUMISpNzI1YophIBlmIxM0tNcPqqh1456304185788.jpg","name":"韩伟翰","description":"我是韩伟翰，现任网易贵金属分析师。多年来深入研究贵金属交易技术分析理论，先后担任操盘手，理财顾问，讲师，分析师等职务，投资风格稳健。曾任和讯特约分析师、东方财经《夜盘大战》特邀分析师，文章多次刊登于《中国黄金报》等专业财经媒体。","headpicurl":"http://dingyue.nosdn.127.net/1JbDM1ao66W9vXPw5c2PPHF3fZSYyrI9zBSrL29MCLTyb1455417364336.jpg","classification":"财经","state":1,"expertState":1,"concernCount":13961,"createTime":1455417587395,"title":"贵金属分析师","questionCount":363,"answerCount":316},{"expertId":"EX8295635936390353487","alias":"我是专栏作家陶短房，关于历史、国际政治的问题，问我吧！","stitle":" ","picurl":"http://dingyue.nosdn.127.net/jnVbc2MKy11QWaq9C0LHvk8wUo9yv2q6q02TnJdP2PzYo1453862409918.jpg","name":"陶短房","description":"知名专栏作家、评论人。陶短房，网络公知、旅居加拿大的中国专栏作家，现为《纵横周刊》非洲问题研究员。陶曾长期在非洲定居，对非洲政治、经济、文化情况比较关注。他涉猎范围广泛，小说、散文、文化评论等都常常见诸出版物，业余时间还以研究太平天国史闻名。","headpicurl":"http://dingyue.nosdn.127.net/jfTlben69cfEk9pkYZOS58N9DgNt3P2uvwkq37L83cPix1453860801445.jpg","classification":"人文","state":1,"expertState":1,"concernCount":26781,"createTime":1453862490589,"title":"专栏作家","questionCount":1294,"answerCount":836},{"expertId":"EX-8747811577431877920","alias":"我是律师蔡可尙，关于生育鼓励政策和二孩儿津贴的话题，问我吧！","stitle":" ","picurl":"http://dingyue.nosdn.127.net/WTWSZhtB0sQm9hTwHOrnrTMhQ3KRSUOvuru8eb471rrEW1457070684031.jpg","name":"蔡可尚","description":"我是蔡可尚，中国政法大学法学博士、北京师范大学法学博士后，业务领域：行政诉讼、刑事辩护、公司并购重组、兼并与收购 、外商直接和间接投资、返程投资、金融证券等。","headpicurl":"http://dingyue.nosdn.127.net/s5G1xavHU9ycsVwgFsELtCUjD5Jy4cpaCbB36bhO1jOeS1450337442454.jpg","classification":"社会","state":1,"expertState":1,"concernCount":5966,"createTime":1450351889709,"title":"律师","questionCount":166,"answerCount":122}]}
     * code : 1
     */

    private String message;
    private DataEntity data;
    private int code;

    protected DiscussData(Parcel in) {
        message = in.readString();
        code = in.readInt();
    }

    public static final Creator<DiscussData> CREATOR = new Creator<DiscussData>() {
        @Override
        public DiscussData createFromParcel(Parcel in) {
            return new DiscussData(in);
        }

        @Override
        public DiscussData[] newArray(int size) {
            return new DiscussData[size];
        }
    };

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public DataEntity getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeInt(code);
    }

    public static class DataEntity implements Parcelable{
        /**
         * expertId : EX-433744285902633489
         * alias : 我是不正经小百科，擅长一本正经的胡说八道，承接任何问题，问我吧！
         * stitle :
         * picurl : http://dingyue.nosdn.127.net/1Jm3CfzSp=BZf=VGC87iohPbeS7FQPykqctjM=hWYYFHu1450279121487.jpg
         * name : 一本道
         * description : 不自由撰稿人，非著名影视评论家，不知名媒体评论家，不精通医、农、工、商的不正经小百科，能够一本正经胡说八道的文字工作者。
         * headpicurl : http://dingyue.nosdn.127.net/vMWN9LY2NA69doDi1HojdoiKrtPUbxDhXQ79v6e3=s94R1450278993650.jpg
         * classification : 人文
         * state : 1
         * expertState : 1
         * concernCount : 120539
         * createTime : 1450279220317
         * title : 文字工作者
         * questionCount : 8826
         * answerCount : 1058
         */

        private ArrayList<ExpertListEntity> expertList;

        protected DataEntity(Parcel in) {
        }

        public static final Creator<DataEntity> CREATOR = new Creator<DataEntity>() {
            @Override
            public DataEntity createFromParcel(Parcel in) {
                return new DataEntity(in);
            }

            @Override
            public DataEntity[] newArray(int size) {
                return new DataEntity[size];
            }
        };

        public void setExpertList(ArrayList<ExpertListEntity> expertList) {
            this.expertList = expertList;
        }

        public ArrayList<ExpertListEntity> getExpertList() {
            return expertList;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        public static class ExpertListEntity implements Parcelable {
            private String expertId;
            private String alias;
            private String stitle;
            private String picurl;
            private String name;
            private String description;
            private String headpicurl;
            private String classification;
            private int state;
            private int expertState;
            private int concernCount;
            private long createTime;
            private String title;
            private int questionCount;
            private int answerCount;

            protected ExpertListEntity(Parcel in) {
                expertId = in.readString();
                alias = in.readString();
                stitle = in.readString();
                picurl = in.readString();
                name = in.readString();
                description = in.readString();
                headpicurl = in.readString();
                classification = in.readString();
                state = in.readInt();
                expertState = in.readInt();
                concernCount = in.readInt();
                createTime = in.readLong();
                title = in.readString();
                questionCount = in.readInt();
                answerCount = in.readInt();
            }

            public static final Creator<ExpertListEntity> CREATOR = new Creator<ExpertListEntity>() {
                @Override
                public ExpertListEntity createFromParcel(Parcel in) {
                    return new ExpertListEntity(in);
                }

                @Override
                public ExpertListEntity[] newArray(int size) {
                    return new ExpertListEntity[size];
                }
            };

            public void setExpertId(String expertId) {
                this.expertId = expertId;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public void setStitle(String stitle) {
                this.stitle = stitle;
            }

            public void setPicurl(String picurl) {
                this.picurl = picurl;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setHeadpicurl(String headpicurl) {
                this.headpicurl = headpicurl;
            }

            public void setClassification(String classification) {
                this.classification = classification;
            }

            public void setState(int state) {
                this.state = state;
            }

            public void setExpertState(int expertState) {
                this.expertState = expertState;
            }

            public void setConcernCount(int concernCount) {
                this.concernCount = concernCount;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setQuestionCount(int questionCount) {
                this.questionCount = questionCount;
            }

            public void setAnswerCount(int answerCount) {
                this.answerCount = answerCount;
            }

            public String getExpertId() {
                return expertId;
            }

            public String getAlias() {
                return alias;
            }

            public String getStitle() {
                return stitle;
            }

            public String getPicurl() {
                return picurl;
            }

            public String getName() {
                return name;
            }

            public String getDescription() {
                return description;
            }

            public String getHeadpicurl() {
                return headpicurl;
            }

            public String getClassification() {
                return classification;
            }

            public int getState() {
                return state;
            }

            public int getExpertState() {
                return expertState;
            }

            public int getConcernCount() {
                return concernCount;
            }

            public long getCreateTime() {
                return createTime;
            }

            public String getTitle() {
                return title;
            }

            public int getQuestionCount() {
                return questionCount;
            }

            public int getAnswerCount() {
                return answerCount;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(expertId);
                dest.writeString(alias);
                dest.writeString(stitle);
                dest.writeString(picurl);
                dest.writeString(name);
                dest.writeString(description);
                dest.writeString(headpicurl);
                dest.writeString(classification);
                dest.writeInt(state);
                dest.writeInt(expertState);
                dest.writeInt(concernCount);
                dest.writeLong(createTime);
                dest.writeString(title);
                dest.writeInt(questionCount);
                dest.writeInt(answerCount);
            }
        }
    }
}
