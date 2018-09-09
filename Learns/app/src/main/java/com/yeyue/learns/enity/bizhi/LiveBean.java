package com.yeyue.learns.enity.bizhi;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2017-12-18.
 */
public class LiveBean extends BaseItem{
    /**
     * comment : 还好   还好   我收藏了吧！❤❤😊😊😊 想kai--tao-宝-wang--dian+Q1107731036公司提供货源.负责单品发货.负责产品售后.提供技术老师！ 打伞的牛仔锅调皮的小桃子 顶下 坐沙发喽
     * ename : naughtypanda.zip
     * oid : null
     * uid : null
     * mfg : 0
     * ncos : 1
     * rank : 124697
     * tag : 卡通
     纯色
     简约
     顽皮熊猫
     蓝色
     可爱
     * video : {"mp4":"52d35b5c48d5b914e2a1ffe7"}
     * conf : {"v":0,"f":null}
     * xr : false
     * cr : []
     * favs : 327
     * atime : 2013-04-03T17:34:05.694000
     * id : 515bf78d48d5b9079e0f98eb
     * size : 395117
     * preview : http://live.dl.ltimg.net/livezip/download/52d35b5c48d5b914e2a1ffe7?type=mp4
     * name : 顽皮熊猫
     * zip : http://live.dl.ltimg.net/livezip/download/515bf78d48d5b9079e0f98e6
     * cid : []
     * url : []
     * pview : 515bf78d48d5b9079e0f98e9
     * imgid : http://live.dl.ltimg.net/frame/download/515bf78d48d5b9079e0f98e9
     * sid : []
     * aid : []
     * desc :
     * view : 39672
     * score : 0
     * diy : false
     */

    private String comment;
    private String ename;
    private Object oid;
    private Object uid;
    private int mfg;
    private int ncos;
    private int rank;
    private String tag;
    private boolean xr;
    private int favs;
    private String atime;
    private String id;
    private int size;
    private String preview;
    private String name;
    private String zip;
    private String pview;
    private String imgid;
    private String desc;
    private int view;
    private int score;
    private boolean diy;

    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_BIZHI_LIVE_DEFAULT;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Object getOid() {
        return oid;
    }

    public void setOid(Object oid) {
        this.oid = oid;
    }

    public Object getUid() {
        return uid;
    }

    public void setUid(Object uid) {
        this.uid = uid;
    }

    public int getMfg() {
        return mfg;
    }

    public void setMfg(int mfg) {
        this.mfg = mfg;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isXr() {
        return xr;
    }

    public void setXr(boolean xr) {
        this.xr = xr;
    }

    public int getFavs() {
        return favs;
    }

    public void setFavs(int favs) {
        this.favs = favs;
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPview() {
        return pview;
    }

    public void setPview(String pview) {
        this.pview = pview;
    }

    public String getImgid() {
        return imgid;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isDiy() {
        return diy;
    }

    public void setDiy(boolean diy) {
        this.diy = diy;
    }
}
