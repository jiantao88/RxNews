package opensource.zjt.rxnews.bean;

import java.util.List;

/**
 * Created by JianTao on 16/1/25.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class ImageModel {

    /**
     * code : 200
     * msg : ok
     * newslist : [{"hottime":"2015-07-17","title":"那个抱走王明涵的，你上微信吗？看完这个你会心软吗？","description":"中国传统文化","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-667708.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MzA3OTg2NjEwNg==&amp;idx=5&amp;mid=209313388&amp;sn=7e30bd2851d22f69580e202c31fc7ecf&amp;qb_mtt_show_type=1"},{"hottime":"2015-06-12","title":"深悦地产风云榜丨房地产微信公众号一周榜单","description":"深悦会","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-530408.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5NTI4NDk0Mg==&amp;idx=4&amp;mid=206963932&amp;sn=595e66f68648b86fba04fbc3a58e623c&amp;qb_mtt_show_type=1"},{"hottime":"2015-06-14","title":"一条微信向全世界宣告，这就是惠州！","description":"西子湖畔","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-536516.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5NTAzMDQ0MA==&amp;idx=1&amp;mid=209423088&amp;sn=fc5c230b38e4485a01bdc7693714047b&amp;qb_mtt_show_type=1"},{"hottime":"2015-06-16","title":"昨晚微信朋友圈热传\u201c范冰冰良渚救小孩\u201d到底是怎么回事？","description":"都市快报","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-544298.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MTE1OTE0MzU2MQ==&amp;idx=1&amp;mid=210010983&amp;sn=dbcb2ab25208c2e39b011d633a0e3e4e&amp;qb_mtt_show_type=1"},{"hottime":"2015-06-16","title":"某女陪丈夫上山扫墓，因惧怕鞭炮，在车内，没事干，上微信.......","description":"教你学做魅力女人","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-543990.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5MTIxMDcyMA==&amp;idx=2&amp;mid=210670409&amp;sn=ec9cfea3bef0e518beccba8fe8a33984&amp;qb_mtt_show_type=1"},{"hottime":"2015-06-19","title":"送给微信所有好友，端午前打开~","description":"点点星光","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-556398.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MzA3MTQxODAxOA==&amp;idx=1&amp;mid=218128244&amp;sn=03b1e5f081406d61c8a78651347f56ee&amp;qb_mtt_show_type=1"},{"hottime":"2015-07-18","title":"丈夫和别人的妻子一夜未归，妻子微信上写道.....","description":"教您做好女人","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-676445.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5NzA4MjU4Ng==&amp;idx=5&amp;mid=211950986&amp;sn=e8c49f694443248ae2d8f173dbf842d4&amp;qb_mtt_show_type=1"},{"hottime":"2015-07-19","title":"【首个微信真人表情】校服angelababy欢迎下载","description":"Angelababy","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-676756.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=Mjc2NzgzNDE4MA==&amp;idx=1&amp;mid=212423157&amp;sn=e5b718581b79722a443bce1634f99bc7&amp;qb_mtt_show_type=1"},{"hottime":"2015-07-19","title":"哪位高人写的微信，被传疯了！","description":"人生感悟励志语录","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-677119.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5NTg1OTczMw==&amp;idx=1&amp;mid=749183945&amp;sn=9d0675d52557ba9717fc9e1f4e85da7c&amp;qb_mtt_show_type=1"},{"hottime":"2015-07-20","title":"子洲遭灾之际，榆林银杏酒店一员工在微信圈辱骂子洲人，引发众怒","description":"陕北山丹丹花","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-681387.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MzA4ODg4OTA3Mw==&amp;idx=1&amp;mid=208913836&amp;sn=43192f9a1d85fe3f88a26c7dcaa0e640&amp;qb_mtt_show_type=1"}]
     */

    private int code;
    private String msg;
    /**
     * hottime : 2015-07-17
     * title : 那个抱走王明涵的，你上微信吗？看完这个你会心软吗？
     * description : 中国传统文化
     * picUrl : http://zxpic.gtimg.com/infonew/0/wechat_pics_-667708.jpg/640
     * url : http://mp.weixin.qq.com/s?__biz=MzA3OTg2NjEwNg==&amp;idx=5&amp;mid=209313388&amp;sn=7e30bd2851d22f69580e202c31fc7ecf&amp;qb_mtt_show_type=1
     */

    private List<NewsImagelistEntity> newslist;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setNewslist(List<NewsImagelistEntity> newslist) {
        this.newslist = newslist;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public List<NewsImagelistEntity> getNewslist() {
        return newslist;
    }

    public static class NewsImagelistEntity {
        private String hottime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public void setHottime(String hottime) {
            this.hottime = hottime;
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

        public String getHottime() {
            return hottime;
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
    }
}
