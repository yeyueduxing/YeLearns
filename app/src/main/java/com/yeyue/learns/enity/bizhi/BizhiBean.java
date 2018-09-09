package com.yeyue.learns.enity.bizhi;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;

/**
 * Created by Administrator on 2017/11/4 0004.
 */
@Entity
public class BizhiBean extends BaseItem{
    /**
     * preview : http://img5.adesk.com/583d01b5da76f7386472a721
     * thumb : http://img5.adesk.com/583d01b5da76f7386472a721
     * img : http://img5.adesk.com/583d01b5da76f7386472a721
     * views : 0
     * cid : ["4e4d610cdf714d2966000003"]
     * ncos : 152
     * rank : 475819
     * url : []
     * source_type : wallpaper
     * tag : []
     * rule : ?imageView2/3/h/$<Height>
     * wp : http://img5.adesk.com/583d01b5da76f7386472a721
     * xr : false
     * cr : false
     * favs : 9552
     * atime : 1.480495802E9
     * type : wallpaper
     * id : 583d01b5da76f7386472a721
     * store : qiniu
     * desc :
     */
    @Id(autoincrement = true)
    private Long bizhiID;
    private String preview;
    private String thumb;
    private String img;
    private int views;
    private int ncos;
    private int rank;
    private String source_type;
    private String rule;
    private String wp;
    private boolean xr;
    private boolean cr;
    private int favs;
    private long atime;
    private String type;
    private String id;
    private String store;
    private String desc;
    @Transient
    private List<String> cid;
    @Transient
    private UserBean user;

    @Generated(hash = 1814828904)
    public BizhiBean(Long bizhiID, String preview, String thumb, String img,
            int views, int ncos, int rank, String source_type, String rule,
            String wp, boolean xr, boolean cr, int favs, long atime, String type,
            String id, String store, String desc) {
        this.bizhiID = bizhiID;
        this.preview = preview;
        this.thumb = thumb;
        this.img = img;
        this.views = views;
        this.ncos = ncos;
        this.rank = rank;
        this.source_type = source_type;
        this.rule = rule;
        this.wp = wp;
        this.xr = xr;
        this.cr = cr;
        this.favs = favs;
        this.atime = atime;
        this.type = type;
        this.id = id;
        this.store = store;
        this.desc = desc;
    }

    @Generated(hash = 703175124)
    public BizhiBean() {
    }

    @Override
    public int getItemType() {
        if(itemtype!=0){
            return itemtype;
        }
        return AdapterConstant.ITEM_BIZHI_DEFAULT;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getNcos() {
        return ncos;
    }

    public void setNcos(int ncos) {
        this.ncos = ncos;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSource_type() {
        return source_type;
    }

    public void setSource_type(String source_type) {
        this.source_type = source_type;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getWp() {
        return wp;
    }

    public void setWp(String wp) {
        this.wp = wp;
    }

    public boolean isXr() {
        return xr;
    }

    public void setXr(boolean xr) {
        this.xr = xr;
    }

    public boolean isCr() {
        return cr;
    }

    public void setCr(boolean cr) {
        this.cr = cr;
    }

    public int getFavs() {
        return favs;
    }

    public void setFavs(int favs) {
        this.favs = favs;
    }

    public long getAtime() {
        return atime;
    }

    public void setAtime(long atime) {
        this.atime = atime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getCid() {
        return cid;
    }

    public void setCid(List<String> cid) {
        this.cid = cid;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public Long getBizhiID() {
        return this.bizhiID;
    }

    public void setBizhiID(Long bizhiID) {
        this.bizhiID = bizhiID;
    }

    public boolean getXr() {
        return this.xr;
    }

    public boolean getCr() {
        return this.cr;
    }
}
