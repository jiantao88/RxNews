package opensource.zjt.rxnews.bean;

import android.os.Parcel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JianTao on 16/1/10.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class NewsModel extends BaseModel {
    /**
     * code : 200
     * msg : ok
     * newslist : [{"ctime":"2016-01-09 21:51","title":"苹果iPhone自动弹iCloud登录窗?小心已被黑","description":"苹果iPhone自动弹iCloud登录窗?小心已被黑...","picUrl":"http://mat1.gtimg.com/tech/00Jamesdu/2014/index/remark/2.png","url":"http://tech.qq.com/a/20160109/031741.htm"},{"ctime":"2016-01-09 21:15","title":"这种技术让手机1分钟充满电","description":"这种技术让手机1分钟充满电...","picUrl":"http://img1.gtimg.com/tech/pics/hv1/159/252/2001/130179444.jpg","url":"http://tech.qq.com/a/20160109/031312.htm"},{"ctime":"2016-01-09 16:32","title":"世界首个合法电子人：体内植入科技产品","description":"世界首个合法电子人：体内植入科技产品...","picUrl":"http://img1.gtimg.com/tech/pics/hv1/218/248/2001/130178483.jpg","url":"http://tech.qq.com/a/20160109/025918.htm"},{"ctime":"2016-01-09 18:29","title":"迪斯尼CEO为何要求高管热衷科技？","description":"迪斯尼CEO为何要求高管热衷科技？...","picUrl":"http://mat1.gtimg.com/tech/00Jamesdu/2014/index/remark/2.png","url":"http://tech.qq.com/a/20160109/028558.htm"},{"ctime":"2016-01-09 18:42","title":"快播死了，但P2P是永恒的","description":"快播死了，但P2P是永恒的...","picUrl":"http://img1.gtimg.com/tech/pics/hv1/23/249/2001/130178543.jpg","url":"http://tech.qq.com/a/20160109/028705.htm"},{"ctime":"2016-01-09 08:27","title":"印度挤掉加拿大成为成人视频第三大观看国家","description":"印度挤掉加拿大成为成人视频第三大观看国家...","picUrl":"http://mat1.gtimg.com/tech/00Jamesdu/2014/index/remark/2.png","url":"http://tech.qq.com/a/20160109/009940.htm"},{"ctime":"2016-01-09 09:31","title":"猎鹰九号将再次发射 SpaceX三度挑战海上着陆","description":"猎鹰九号将再次发射 SpaceX三度挑战海上着陆...","picUrl":"http://img1.gtimg.com/tech/pics/hv1/137/204/2001/130167182.jpg","url":"http://tech.qq.com/a/20160109/012618.htm"},{"ctime":"2016-01-09 10:09","title":"吹牛过度 明星无人机企业CES展跳票","description":"吹牛过度 明星无人机企业CES展跳票...","picUrl":"http://mat1.gtimg.com/tech/00Jamesdu/2014/index/remark/2.png","url":"http://tech.qq.com/a/20160109/014182.htm"},{"ctime":"2016-01-09 09:21","title":"iPhone 7有三种设计方案正在测试","description":"iPhone 7有三种设计方案正在测试...","picUrl":"http://img1.gtimg.com/tech/pics/hv1/58/214/2001/130169653.jpg","url":"http://tech.qq.com/a/20160109/012276.htm"},{"ctime":"2016-01-09 10:24","title":"不专业的审判无法得到公正的结果","description":"不专业的审判无法得到公正的结果...","picUrl":"http://mat1.gtimg.com/tech/00Jamesdu/2014/index/remark/2.png","url":"http://tech.qq.com/a/20160109/014631.htm"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2016-01-09 21:51
     * title : 苹果iPhone自动弹iCloud登录窗?小心已被黑
     * description : 苹果iPhone自动弹iCloud登录窗?小心已被黑...
     * picUrl : http://mat1.gtimg.com/tech/00Jamesdu/2014/index/remark/2.png
     * url : http://tech.qq.com/a/20160109/031741.htm
     */

    private List<NewslistEntity> newslist;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setNewslist(List<NewslistEntity> newslist) {
        this.newslist = newslist;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public List<NewslistEntity> getNewslist() {
        return newslist;
    }

    public static class NewslistEntity extends BaseModel {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCtime() {
            return ctime;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public String getUrl() {
            return url;
        }

        @Override
        public String toString() {
            return "NewslistEntity{" +
                    "ctime='" + ctime + '\'' +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", picUrl='" + picUrl + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeString(this.ctime);
            dest.writeString(this.title);
            dest.writeString(this.description);
            dest.writeString(this.picUrl);
            dest.writeString(this.url);
        }

        public NewslistEntity() {
        }

        protected NewslistEntity(Parcel in) {
            super(in);
            this.ctime = in.readString();
            this.title = in.readString();
            this.description = in.readString();
            this.picUrl = in.readString();
            this.url = in.readString();
        }

        public static final Creator<NewslistEntity> CREATOR = new Creator<NewslistEntity>() {
            public NewslistEntity createFromParcel(Parcel source) {
                return new NewslistEntity(source);
            }

            public NewslistEntity[] newArray(int size) {
                return new NewslistEntity[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.code);
        dest.writeString(this.msg);
        dest.writeList(this.newslist);
    }

    public NewsModel() {
        super();
    }

    protected NewsModel(Parcel in) {
        super(in);
        this.code = in.readInt();
        this.msg = in.readString();
        this.newslist = new ArrayList<NewslistEntity>();
        in.readList(this.newslist, List.class.getClassLoader());
    }

    public static final Creator<NewsModel> CREATOR = new Creator<NewsModel>() {
        public NewsModel createFromParcel(Parcel source) {
            return new NewsModel(source);
        }

        public NewsModel[] newArray(int size) {
            return new NewsModel[size];
        }
    };

    @Override
    public String toString() {
        return "NewsModel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", newslist=" + newslist.size() +
                '}';
    }
}
