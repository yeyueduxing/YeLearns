package com.yeyue.learns.enity.diycode;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

import java.util.List;

/**
 * Created by li.xiao on 2018-1-5.
 */

public class DiySiteList extends BaseItem{

    /**
     * sites : [{"name":"Gratisography","url":"http://www.gratisography.com","avatar_url":"https://favicon.b0.upaiyun.com/ip2/www.gratisography.com.ico"},{"name":"Unsplash","url":"http://unsplash.com","avatar_url":"https://favicon.b0.upaiyun.com/ip2/unsplash.com.ico"},{"name":"Publicdomainarchive","url":"http://publicdomainarchive.com","avatar_url":"https://favicon.b0.upaiyun.com/ip2/publicdomainarchive.com.ico"},{"name":"pixabay","url":"http://pixabay.com","avatar_url":"https://favicon.b0.upaiyun.com/ip2/pixabay.com.ico"},{"name":"pexels","url":"http://www.pexels.com","avatar_url":"https://favicon.b0.upaiyun.com/ip2/www.pexels.com.ico"},{"name":"peakpx","url":"http://www.peakpx.com","avatar_url":"https://favicon.b0.upaiyun.com/ip2/www.peakpx.com.ico"},{"name":"pixite source","url":"http://source.pixite.co","avatar_url":"https://favicon.b0.upaiyun.com/ip2/source.pixite.co.ico"},{"name":"泼辣有图","url":"http://www.polayoutu.com/collections","avatar_url":"https://diycode.b0.upaiyun.com/site/2017/703bb38696fa400114f3f5802362bef9.png"},{"name":"visualhunt","url":"http://visualhunt.com","avatar_url":"https://diycode.b0.upaiyun.com/site/2017/8d723702fa1d85c94f8e61e066646dbc.png"}]
     * name : Free high-resolution pictures WebSites － 免费高清无版权图片素材网站
     * id : 21
     */

    private String name;
    private int id;
    private List<DiySite> sites;

    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_DIY_SITE_LIST;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<DiySite> getSites() {
        return sites;
    }

    public void setSites(List<DiySite> sites) {
        this.sites = sites;
    }
}
