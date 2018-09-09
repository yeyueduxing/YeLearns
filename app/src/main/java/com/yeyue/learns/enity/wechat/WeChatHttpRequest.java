package com.yeyue.learns.enity.wechat;

import java.util.List;

/**
 * Created by li.xiao on 2018-1-11.
 */

public class WeChatHttpRequest {

    /**
     * code : 200
     * msg : ok
     * newslist : [{"ctime":"2015-07-17","title":"那个抱走王明涵的，你上微信吗？看完这个你会心软吗？","description":"中国传统文化","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-667708.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MzA3OTg2NjEwNg==&amp;idx=5&amp;mid=209313388&amp;sn=7e30bd2851d22f69580e202c31fc7ecf"},{"ctime":"2015-06-12","title":"深悦地产风云榜丨房地产微信公众号一周榜单","description":"深悦会","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-530408.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5NTI4NDk0Mg==&amp;idx=4&amp;mid=206963932&amp;sn=595e66f68648b86fba04fbc3a58e623c"},{"ctime":"2015-06-14","title":"一条微信向全世界宣告，这就是惠州！","description":"西子湖畔","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-536516.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5NTAzMDQ0MA==&amp;idx=1&amp;mid=209423088&amp;sn=fc5c230b38e4485a01bdc7693714047b"}]
     */

    private int code;
    private String msg;
    private List<WeChat> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<WeChat> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<WeChat> newslist) {
        this.newslist = newslist;
    }
}
