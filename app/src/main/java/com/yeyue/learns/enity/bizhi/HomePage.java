package com.yeyue.learns.enity.bizhi;

import java.util.List;

/**
 * Created by Administrator on 2017/11/4 0004.
 */

public class HomePage {

    /**
     * msg : success
     * res : {"wallpaper":[{"preview":"http://img5.adesk.com/583d01b5da76f7386472a721",
     * "thumb":"http://img5.adesk.com/583d01b5da76f7386472a721","img":"http://img5.adesk
     * .com/583d01b5da76f7386472a721","views":0,"cid":["4e4d610cdf714d2966000003"],"ncos":152,
     * "rank":475819,"url":[],"source_type":"wallpaper","tag":[],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/583d01b5da76f7386472a721",
     * "xr":false,"cr":false,"favs":9552,"atime":1.480495802E9,"type":"wallpaper",
     * "id":"583d01b5da76f7386472a721","store":"qiniu","desc":""},{"preview":"http://img5.adesk
     * .com/58eaf7b9e7bce713a62b6a0f","thumb":"http://img5.adesk.com/58eaf7b9e7bce713a62b6a0f",
     * "img":"http://img5.adesk.com/58eaf7b9e7bce713a62b6a0f","views":0,
     * "cid":["4e4d610cdf714d2966000007"],"ncos":186,"rank":523178,"url":[],
     * "source_type":"wallpaper","tag":["王者荣耀","游戏","李白","皮肤","酷炫"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/58eaf7b9e7bce713a62b6a0f",
     * "xr":false,"cr":false,"favs":4489,"atime":1.491807422E9,"type":"wallpaper",
     * "id":"58eaf7b9e7bce713a62b6a0f","store":"qiniu","desc":""},{"preview":"http://img0.adesk
     * .com/download/5796fd5394e5cc65ed8423b5","thumb":"http://img0.adesk
     * .com/download/5796fd5494e5cc65ed8423d7","img":"http://img0.adesk
     * .com/download/5796fd5494e5cc65ed8423e1","views":0,"cid":["4e58c2570569791a19000000"],
     * "ncos":315,"rank":525630,"url":[],"source_type":"wallpaper","tag":["宠物的秘密生活","动画片","卡通",
     * "可爱","兔子"],"wp":"http://img0.adesk.com/wallpaper?imgid=5795ceda69401b71df5e64a2",
     * "xr":false,"cr":false,"favs":6925,"atime":1.469513044E9,"type":"wallpaper",
     * "id":"5795ceda69401b71df5e64a2","store":"adesk","desc":"《宠物的秘密生活》（The Secret Life of
     * Pets）"},{"preview":"http://img5.adesk.com/593e5e8ae7bce77808ca85ab",
     * "thumb":"http://img5.adesk.com/593e5e8ae7bce77808ca85ab","img":"http://img5.adesk
     * .com/593e5e8ae7bce77808ca85ab","views":0,"cid":["4e4d610cdf714d2966000003"],"ncos":1019,
     * "rank":433480,"url":[],"source_type":"wallpaper","tag":["动漫","女孩","黑白","紫瞳","潮流","非主流"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/593e5e8ae7bce77808ca85ab",
     * "xr":false,"cr":false,"favs":8931,"atime":1.497333785E9,"type":"wallpaper",
     * "id":"593e5e8ae7bce77808ca85ab","store":"qiniu","desc":""},{"preview":"http://img0.adesk
     * .com/download/5853599794e5cc1c073fe8dd","thumb":"http://img0.adesk
     * .com/download/5853599894e5cc1c073fe8fb","img":"http://img0.adesk
     * .com/download/5853599894e5cc1c073fe904","views":0,"cid":["5109e04e48d5b9364ae9ac45"],
     * "ncos":25,"rank":201877,"url":[],"source_type":"wallpaper","tag":["文字","情感","纯色","黑白"],
     * "wp":"http://img0.adesk.com/wallpaper?imgid=5850f11869401b34865eed9a","xr":false,
     * "cr":false,"favs":2940,"atime":1.481857432E9,"type":"wallpaper",
     * "id":"5850f11869401b34865eed9a","store":"adesk","desc":""},{"preview":"http://img0.adesk
     * .com/download/57c1657f94e5cc7ff6984dc9","thumb":"http://img0.adesk
     * .com/download/57c1657f94e5cc7ff6984de7","img":"http://img0.adesk
     * .com/download/57c1657f94e5cc7ff6984df0","views":0,"cid":["5109e04e48d5b9364ae9ac45"],
     * "ncos":15,"rank":145123,"url":[],"source_type":"wallpaper","tag":["文字","简单","纯色背景","简约"],
     * "wp":"http://img0.adesk.com/wallpaper?imgid=57baf7c969401b644d276d76","xr":false,
     * "cr":false,"favs":1735,"atime":1.472292223E9,"type":"wallpaper",
     * "id":"57baf7c969401b644d276d76","store":"adesk","desc":""},{"preview":"http://img5.adesk
     * .com/59fabd95e7bce729500bca3b","thumb":"http://img5.adesk.com/59fabd95e7bce729500bca3b",
     * "img":"http://img5.adesk.com/59fabd95e7bce729500bca3b","views":0,
     * "cid":["5109e04e48d5b9364ae9ac45"],"ncos":4,"rank":5763,"url":[],
     * "source_type":"wallpaper","tag":["李白","王者荣耀","黑白","表白","文字"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/59fabd95e7bce729500bca3b",
     * "xr":false,"cr":false,"favs":97,"atime":1.509717782E9,"type":"wallpaper",
     * "id":"59fabd95e7bce729500bca3b","store":"qiniu","desc":""},{"preview":"http://img5.adesk
     * .com/59e6fad0e7bce729bf148d6e","thumb":"http://img5.adesk.com/59e6fad0e7bce729bf148d6e",
     * "img":"http://img5.adesk.com/59e6fad0e7bce729bf148d6e","views":0,
     * "cid":["4e4d610cdf714d2966000007"],"ncos":10,"rank":33879,"url":[],
     * "source_type":"wallpaper","tag":["孙悟空","地狱火","王者荣耀","炫酷","游戏"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/59e6fad0e7bce729bf148d6e",
     * "xr":false,"cr":false,"favs":235,"atime":1.508428624E9,"type":"wallpaper",
     * "id":"59e6fad0e7bce729bf148d6e","store":"qiniu","desc":""},{"preview":"http://img0.adesk
     * .com/download/539f78ff69401b44983f62d6","thumb":"http://img0.adesk
     * .com/download/5098a6ca16b37b570d0284a4","img":"http://img0.adesk
     * .com/download/539f790069401b44983f62d8","views":3,"cid":["4e4d610cdf714d2966000004"],
     * "ncos":26,"rank":139150,"url":[],"source_type":"wallpaper","tag":[],
     * "wp":"http://img0.adesk.com/wallpaper?imgid=5005431206ff62743500296c","xr":false,
     * "cr":false,"favs":1583,"atime":1.34252213E9,"type":"wallpaper",
     * "id":"5005431206ff62743500296c","store":"adesk",
     * "desc":"【99种方式说谢谢-感谢哥们】世界杯的时候每晚熬夜看球，为你准备了零食啤酒一起战到天明。\n-安卓壁纸2014感恩节专题-"},
     * {"preview":"http://img5.adesk.com/59ddbbd1e7bce729d564fad8","thumb":"http://img5.adesk
     * .com/59ddbbd1e7bce729d564fad8","img":"http://img5.adesk.com/59ddbbd1e7bce729d564fad8",
     * "views":0,"cid":["4e4d610cdf714d2966000001"],"ncos":14,"rank":44867,"url":[],
     * "source_type":"wallpaper","tag":["狗","白色","草地","可爱","萌","动物","博美"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/59ddbbd1e7bce729d564fad8",
     * "xr":false,"cr":false,"favs":615,"atime":1.507816983E9,"type":"wallpaper",
     * "id":"59ddbbd1e7bce729d564fad8","store":"qiniu","desc":""},{"preview":"http://img5.adesk
     * .com/583a6ea9da76f747b17be5fe","thumb":"http://img5.adesk.com/583a6ea9da76f747b17be5fe",
     * "img":"http://img5.adesk.com/583a6ea9da76f747b17be5fe","views":0,
     * "cid":["4e4d610cdf714d2966000003"],"ncos":52,"rank":82706,"url":[],
     * "source_type":"wallpaper","tag":["动漫","二次元","少女","萌"],"rule":"?imageView2/3/h/$<Height>",
     * "wp":"http://img5.adesk.com/583a6ea9da76f747b17be5fe","xr":false,"cr":false,"favs":2269,
     * "atime":1.48025394E9,"type":"wallpaper","id":"583a6ea9da76f747b17be5fe","store":"qiniu",
     * "desc":""},{"preview":"http://img5.adesk.com/59d4f6ffe7bce77bbf6df62d",
     * "thumb":"http://img5.adesk.com/59d4f6ffe7bce77bbf6df62d","img":"http://img5.adesk
     * .com/59d4f6ffe7bce77bbf6df62d","views":0,"cid":["4e4d610cdf714d2966000000"],"ncos":8,
     * "rank":14313,"url":[],"source_type":"wallpaper","tag":[],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/59d4f6ffe7bce77bbf6df62d",
     * "xr":false,"cr":false,"favs":394,"atime":1.507689512E9,"type":"wallpaper",
     * "id":"59d4f6ffe7bce77bbf6df62d","store":"qiniu","desc":""},{"preview":"http://img5.adesk
     * .com/59f2db85e7bce729bf149033","thumb":"http://img5.adesk.com/59f2db85e7bce729bf149033",
     * "img":"http://img5.adesk.com/59f2db85e7bce729bf149033","views":0,
     * "cid":["4ef0a3330569795757000000"],"ncos":18,"rank":36003,"url":[],
     * "source_type":"wallpaper","tag":["插画","朱颜","佳人","伞","龙"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/59f2db85e7bce729bf149033",
     * "xr":false,"cr":false,"favs":717,"atime":1.509235383E9,"type":"wallpaper",
     * "id":"59f2db85e7bce729bf149033","store":"qiniu","desc":"作者 | 古戈力"},
     * {"preview":"http://img5.adesk.com/59f96529e7bce729d56500ea","thumb":"http://img5.adesk
     * .com/59f96529e7bce729d56500ea","img":"http://img5.adesk.com/59f96529e7bce729d56500ea",
     * "views":0,"cid":["4e4d610cdf714d2966000000"],"ncos":12,"rank":6177,"url":[],
     * "source_type":"wallpaper","tag":["马尾","网球","气质","美女","运动","阳光"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/59f96529e7bce729d56500ea",
     * "xr":false,"cr":false,"favs":247,"atime":1.509710584E9,"type":"wallpaper",
     * "id":"59f96529e7bce729d56500ea","store":"qiniu","desc":"摄影 | KIWIsi"},
     * {"preview":"http://img5.adesk.com/59f822a8e7bce729aa47edf0","thumb":"http://img5.adesk
     * .com/59f822a8e7bce729aa47edf0","img":"http://img5.adesk.com/59f822a8e7bce729aa47edf0",
     * "views":0,"cid":["4e4d610cdf714d2966000002"],"ncos":1,"rank":1289,"url":[],
     * "source_type":"wallpaper","tag":["小屋","湖","倒影","山水","唯美","绿色"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/59f822a8e7bce729aa47edf0",
     * "xr":false,"cr":false,"favs":32,"atime":1.509753784E9,"type":"wallpaper",
     * "id":"59f822a8e7bce729aa47edf0","store":"qiniu","desc":""},{"preview":"http://img5.adesk
     * .com/58847ea2e7bce740e2b080bf","thumb":"http://img5.adesk.com/58847ea2e7bce740e2b080bf",
     * "img":"http://img5.adesk.com/58847ea2e7bce740e2b080bf","views":0,
     * "cid":["4e4d610cdf714d2966000003"],"ncos":112,"rank":365496,"url":[],
     * "source_type":"wallpaper","tag":["动漫","二次元","刀剑神域","桐人","武器"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/58847ea2e7bce740e2b080bf",
     * "xr":false,"cr":false,"favs":6817,"atime":1.485763219E9,"type":"wallpaper",
     * "id":"58847ea2e7bce740e2b080bf","store":"qiniu","desc":""},{"preview":"http://img5.adesk
     * .com/59f8228ae7bce729760f4d21","thumb":"http://img5.adesk.com/59f8228ae7bce729760f4d21",
     * "img":"http://img5.adesk.com/59f8228ae7bce729760f4d21","views":0,
     * "cid":["4e4d610cdf714d2966000002"],"ncos":0,"rank":1738,"url":[],
     * "source_type":"wallpaper","tag":["山水","倒影","唯美","树","湖","风景"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/59f8228ae7bce729760f4d21",
     * "xr":false,"cr":false,"favs":34,"atime":1.509696184E9,"type":"wallpaper",
     * "id":"59f8228ae7bce729760f4d21","store":"qiniu","desc":""},{"preview":"http://img5.adesk
     * .com/585344729a1aa3796b960ed0","thumb":"http://img5.adesk.com/585344729a1aa3796b960ed0",
     * "img":"http://img5.adesk.com/585344729a1aa3796b960ed0","views":0,
     * "cid":["4e4d610cdf714d2966000003"],"ncos":37,"rank":202254,"url":[],
     * "source_type":"wallpaper","tag":["你的名字","动漫","电影","二次元","三叶","泷"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/585344729a1aa3796b960ed0",
     * "xr":false,"cr":false,"favs":3768,"atime":1.482405602E9,"type":"wallpaper",
     * "id":"585344729a1aa3796b960ed0","store":"qiniu","desc":""},{"preview":"http://img5.adesk
     * .com/59f59c15e7bce77b0027a54e","thumb":"http://img5.adesk.com/59f59c15e7bce77b0027a54e",
     * "img":"http://img5.adesk.com/59f59c15e7bce77b0027a54e","views":0,
     * "cid":["4e4d610cdf714d2966000003"],"ncos":5,"rank":5079,"url":[],
     * "source_type":"wallpaper","tag":[],"rule":"?imageView2/3/h/$<Height>",
     * "wp":"http://img5.adesk.com/59f59c15e7bce77b0027a54e","xr":false,"cr":false,"favs":265,
     * "atime":1.509714002E9,"type":"wallpaper","id":"59f59c15e7bce77b0027a54e","store":"qiniu",
     * "desc":""},{"preview":"http://img5.adesk.com/59e5878ae7bce729d564fc3e",
     * "thumb":"http://img5.adesk.com/59e5878ae7bce729d564fc3e","img":"http://img5.adesk
     * .com/59e5878ae7bce729d564fc3e","views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":41,
     * "rank":120663,"url":[],"source_type":"wallpaper","tag":["FBI","搞笑","个性","黑色","幽默","锁屏",
     * "文字壁纸"],"rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
     * .com/59e5878ae7bce729d564fc3e","xr":false,"cr":false,"favs":1396,"atime":1.508306581E9,
     * "type":"wallpaper","id":"59e5878ae7bce729d564fc3e","store":"qiniu","desc":""},
     * {"preview":"http://img5.adesk.com/59b75bb6e7bce72961f10302","thumb":"http://img5.adesk
     * .com/59b75bb6e7bce72961f10302","img":"http://img5.adesk.com/59b75bb6e7bce72961f10302",
     * "views":0,"cid":["4ef0a3330569795757000000"],"ncos":1,"rank":18068,"url":[],
     * "source_type":"wallpaper","tag":["插画","小清新","可爱","猫咪"],"rule":"?imageView2/3/h/$<Height>",
     * "wp":"http://img5.adesk.com/59b75bb6e7bce72961f10302","xr":false,"cr":false,"favs":387,
     * "atime":1.505224983E9,"type":"wallpaper","id":"59b75bb6e7bce72961f10302","store":"qiniu",
     * "desc":""},{"preview":"http://img5.adesk.com/59b75bb7e7bce729eca94b5c",
     * "thumb":"http://img5.adesk.com/59b75bb7e7bce729eca94b5c","img":"http://img5.adesk
     * .com/59b75bb7e7bce729eca94b5c","views":0,"cid":["4ef0a3330569795757000000"],"ncos":2,
     * "rank":18441,"url":[],"source_type":"wallpaper","tag":["插画","小清新","可爱"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/59b75bb7e7bce729eca94b5c",
     * "xr":false,"cr":false,"favs":360,"atime":1.505628184E9,"type":"wallpaper",
     * "id":"59b75bb7e7bce729eca94b5c","store":"qiniu","desc":""},{"preview":"http://img5.adesk
     * .com/59f17f3de7bce72961f10c0b","thumb":"http://img5.adesk.com/59f17f3de7bce72961f10c0b",
     * "img":"http://img5.adesk.com/59f17f3de7bce72961f10c0b","views":0,
     * "cid":["5109e04e48d5b9364ae9ac45"],"ncos":8,"rank":25063,"url":[],
     * "source_type":"wallpaper","tag":["手写","简单","表白","个性","黑白","文字"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/59f17f3de7bce72961f10c0b",
     * "xr":false,"cr":false,"favs":461,"atime":1.509170593E9,"type":"wallpaper",
     * "id":"59f17f3de7bce72961f10c0b","store":"qiniu","desc":""},{"preview":"http://img5.adesk
     * .com/59f8228ae7bce72994d9085d","thumb":"http://img5.adesk.com/59f8228ae7bce72994d9085d",
     * "img":"http://img5.adesk.com/59f8228ae7bce72994d9085d","views":0,
     * "cid":["4e4d610cdf714d2966000002"],"ncos":0,"rank":533,"url":[],"source_type":"wallpaper",
     * "tag":["铁道","树","雪","轨道","白色"],"rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
     * .com/59f8228ae7bce72994d9085d","xr":false,"cr":false,"favs":12,"atime":1.509760996E9,
     * "type":"wallpaper","id":"59f8228ae7bce72994d9085d","store":"qiniu","desc":""},
     * {"preview":"http://img5.adesk.com/59f96527e7bce729aa47ee33","thumb":"http://img5.adesk
     * .com/59f96527e7bce729aa47ee33","img":"http://img5.adesk.com/59f96527e7bce729aa47ee33",
     * "views":0,"cid":["4e4d610cdf714d2966000000"],"ncos":3,"rank":7213,"url":[],
     * "source_type":"wallpaper","tag":["马尾","网球","气质","美女","运动","阳光"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/59f96527e7bce729aa47ee33",
     * "xr":false,"cr":false,"favs":252,"atime":1.509667394E9,"type":"wallpaper",
     * "id":"59f96527e7bce729aa47ee33","store":"qiniu","desc":"摄影 | KIWIsi"},
     * {"preview":"http://img0.adesk.com/download/58971481e7bce749f6ea71da",
     * "thumb":"http://img0.adesk.com/download/58971482e7bce749f6ea71f9","img":"http://img0.adesk
     * .com/download/58971482e7bce749f6ea7203","views":0,"cid":["4fb47a465ba1c65561000028"],
     * "ncos":23,"rank":100230,"url":[],"source_type":"wallpaper","tag":["物语","花","冬天","雪","玫瑰"],
     * "wp":"http://img0.adesk.com/wallpaper?imgid=58662a3669401b34865f2220","xr":false,
     * "cr":false,"favs":1878,"atime":1.486296194E9,"type":"wallpaper",
     * "id":"58662a3669401b34865f2220","store":"adesk","desc":""},{"preview":"http://img0.adesk
     * .com/download/583be4f894e5cc3b1fd38edd","thumb":"http://img0.adesk
     * .com/download/583be4f994e5cc3b1fd38efb","img":"http://img0.adesk
     * .com/download/583be4f994e5cc3b1fd38f04","views":0,"cid":["4e4d610cdf714d2966000004"],
     * "ncos":34,"rank":158818,"url":[],"source_type":"wallpaper","tag":["卡通","仓鼠","可爱","萌",
     * "围巾"],"wp":"http://img0.adesk.com/wallpaper?imgid=5837f88069401b34865eae17","xr":false,
     * "cr":false,"favs":3155,"atime":1.480320249E9,"type":"wallpaper",
     * "id":"5837f88069401b34865eae17","store":"adesk","desc":""},{"preview":"http://img0.adesk
     * .com/download/579713eb94e5cc145ba312a4","thumb":"http://img0.adesk
     * .com/download/579713ec94e5cc145ba312c6","img":"http://img0.adesk
     * .com/download/579713ec94e5cc145ba312cf","views":0,"cid":["4e4d610cdf714d2966000000"],
     * "ncos":23,"rank":89125,"url":[],"source_type":"wallpaper","tag":["清纯","文艺","萌妹子","可爱",
     * "清新"],"wp":"http://img0.adesk.com/wallpaper?imgid=5794900169401b1a43f2d4f3","xr":false,
     * "cr":false,"favs":1445,"atime":1.469518828E9,"type":"wallpaper",
     * "id":"5794900169401b1a43f2d4f3","store":"adesk","desc":"出镜/卵母细胞"},
     * {"preview":"http://img0.adesk.com/download/57b19c2094e5cc6c12d83cdb",
     * "thumb":"http://img0.adesk.com/download/57b19c2094e5cc6c12d83cf9","img":"http://img0.adesk
     * .com/download/57b19c2094e5cc6c12d83d02","views":0,"cid":["5109e04e48d5b9364ae9ac45"],
     * "ncos":73,"rank":285877,"url":[],"source_type":"wallpaper","tag":[],
     * "wp":"http://img0.adesk.com/wallpaper?imgid=57b00edc69401b19f52b5959","xr":false,
     * "cr":false,"favs":2796,"atime":1.471257632E9,"type":"wallpaper",
     * "id":"57b00edc69401b19f52b5959","store":"adesk","desc":""},{"preview":"http://img0.adesk
     * .com/download/56fc680e94e5cc1ab09f962b","thumb":"http://img0.adesk
     * .com/download/56fc680f94e5cc1ab09f9650","img":"http://img0.adesk
     * .com/download/56fc680f94e5cc1ab09f965c","views":0,"cid":["4fb47a305ba1c60ca5000223"],
     * "ncos":7,"rank":17859,"url":[],"source_type":"wallpaper","tag":["风景","植物","花","树","阳光",
     * "房子"],"wp":"http://img0.adesk.com/wallpaper?imgid=56fbd5b169401b6e18ca6223","xr":false,
     * "cr":false,"favs":174,"atime":1.459382287E9,"type":"wallpaper",
     * "id":"56fbd5b169401b6e18ca6223","store":"adesk","desc":""}],
     * "homepage":[{"items":[{"notice":"1、【新增】首页新增美女、动漫，更丰富的图片资源。\r\n2、【优化】新版本更流畅，快来更新体验吧。",
     * "code":177,"force":[],"name":"5.7.7","title":"有新版本，快来更新吧","url":"http://s.adesk
     * .com/apk/Androidesk-release-androidesk.apk","_id":"599d563fe7bce729500bb926","fnotice":"",
     * "atime":1.503483455E9,"id":"599d563fe7bce729500bb926"}],"type":14,"title":"版本更新"},
     * {"items":[{"status":true,"value":{"ename":"美腿特辑","isfeed":false,"tag":[],
     * "id":"534644f948d5b95a9ae3a575","top":9,"type":1,"status":"online","user":{"gcid":"",
     * "name":"ZhouKIMI","gender":1,"follower":204,"avatar":"http://img0.adesk
     * .com/download/563b25ed94e5cc562285aad5","viptime":9.782784E8,"following":0,"isvip":false,
     * "id":"528c24922d74c818c3d9b730"},"favs":16798,"atime":1.397114105E9,"desc":"狂秀美腿的季节要来啦~！",
     * "name":"美腿特辑","url":[],"cover":"http://img0.adesk.com/download/5815b7a794e5cc3778275681",
     * "lcover":"http://img0.adesk.com/download/5815b7a794e5cc37782756ae","subname":"美腿",
     * "sn":42},"atime":1.509724983E9,"target":"534644f948d5b95a9ae3a575",
     * "img":"59fafa80e7bce74352003ea8","module":1,"sn":1,"_id":"59fafa80e7bce74352003eab",
     * "type":7,"id":"59fafa80e7bce74352003eab","thumb":"http://img0.adesk
     * .com/download/59fafa80e7bce74352003ea8"},{"status":true,"value":{"status":"online",
     * "ename":"","atime":1.459069168E9,"user":{"gender":1,"cache":false,"id":"None",
     * "avatar":"http://s.adesk.com/picasso/avatar_default.png","name":"安卓壁纸用户None"},"url":[],
     * "desc":"1930年成立于斯图加特，以生产高级跑车闻名于世界车坛。创始人费迪南德·波尔舍（同费迪南德·保时捷）是一位享誉世界车坛的著名设计师",
     * "cover":"http://img5.adesk.com/59a9075fe7bce72994d8f9fb?imageView2/3/h/240",
     * "id":"56f7a0f069401b4eb5d53131","tag":[],"sn":999,"lcover":"http://img5.adesk
     * .com/59a9075fe7bce72994d8f9fb?imageView2/3/h/720","favs":1960,"type":1,"isfeed":false,
     * "name":"保时捷"},"atime":1.509638582E9,"target":"56f7a0f069401b4eb5d53131",
     * "img":"59fafaade7bce742cdcaf3d5","module":1,"sn":2,"_id":"59fafaade7bce742cdcaf3d8",
     * "type":7,"id":"59fafaade7bce742cdcaf3d8","thumb":"http://img0.adesk
     * .com/download/59fafaade7bce742cdcaf3d5"},{"status":true,"value":{"url":"http://service
     * .videowp.adesk.com/web/banner/adesk?id=5964b3eee7bce71dd4feefc8"},"atime":1.509339242E9,
     * "target":"http://service.videowp.adesk.com/web/banner/adesk?id=5964b3eee7bce71dd4feefc8",
     * "img":"59f6af75e7bce729760f4c52","module":1,"sn":3,"_id":"59f6af75e7bce729760f4c55",
     * "type":22,"id":"59f6af75e7bce729760f4c55","thumb":"http://img0.adesk
     * .com/download/59f6af75e7bce729760f4c52"},{"status":true,"value":{"status":"online",
     * "ename":"每日开出一朵花","name":"每日开出一朵花","url":[],"user":{"gcid":"","name":"融雪之前","gender":1,
     * "follower":1797,"avatar":"http://img0.adesk.com/download/53a7e1b12d74c827b3973705",
     * "viptime":9.782784E8,"following":0,"isvip":false,"id":"5370b3c02d74c805fcebeae7"},
     * "cover":"http://img0.adesk.com/download/546c3c1c69401b3aa2b95859",
     * "id":"546c079469401b2336e67c5b","tag":[],"sn":999,"lcover":"http://img0.adesk
     * .com/download/546c3c1c69401b3aa2b95877","favs":5959,"atime":1.416365972E9,"type":1,
     * "isfeed":false,"desc":"哪怕错过一季的芬芳，也要相信，始终有一朵花只为你开放。"},"atime":1.509379383E9,
     * "target":"546c079469401b2336e67c5b","img":"59f1c8dbe7bce729aa47ebb3","module":1,"sn":4,
     * "_id":"59f1c8dbe7bce729aa47ebb6","type":7,"id":"59f1c8dbe7bce729aa47ebb6",
     * "thumb":"http://img0.adesk.com/download/59f1c8dbe7bce729aa47ebb3"}],"type":13,
     * "title":"小编精选"},{"items":[{"preview":"http://img5.adesk.com/59f3082ae7bce729d564ff6f",
     * "thumb":"http://img5.adesk.com/59f3082ae7bce729d564ff6f","img":"http://img5.adesk
     * .com/59f3082ae7bce729d564ff6f","views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":4,
     * "rank":8894,"url":[],"tag":["小乔","王者荣耀","个性","文字","可爱","萌"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/59f3082ae7bce729d564ff6f",
     * "xr":false,"cr":false,"favs":92,"atime":1.509249783E9,"id":"59f3082ae7bce729d564ff6f",
     * "store":"qiniu","desc":""},{"preview":"http://img5.adesk.com/59f3082ae7bce729aa47ece2",
     * "thumb":"http://img5.adesk.com/59f3082ae7bce729aa47ece2","img":"http://img5.adesk
     * .com/59f3082ae7bce729aa47ece2","views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":6,
     * "rank":10913,"url":[],"tag":["王昭君","王者荣耀","个性","文字","可爱","萌"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/59f3082ae7bce729aa47ece2",
     * "xr":false,"cr":false,"favs":155,"atime":1.509235384E9,"id":"59f3082ae7bce729aa47ece2",
     * "store":"qiniu","desc":""},{"preview":"http://img5.adesk.com/59f30829e7bce72961f10dc2",
     * "thumb":"http://img5.adesk.com/59f30829e7bce72961f10dc2","img":"http://img5.adesk
     * .com/59f30829e7bce72961f10dc2","views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":3,
     * "rank":11357,"url":[],"tag":["李白","王者荣耀","个性","文字","可爱","萌"],
     * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk.com/59f30829e7bce72961f10dc2",
     * "xr":false,"cr":false,"favs":135,"atime":1.509292623E9,"id":"59f30829e7bce72961f10dc2",
     * "store":"qiniu","desc":""},{"preview":"http://img5.adesk.com/59f30829e7bce729500bc88f",
     * "thumb":"http://img5.adesk.com/59f30829e7bce729500bc88f","img":"http://img5.adesk
     * .com/59f30829e7bce729500bc88f","views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":3,
     * "rank":9659,"url":[],"tag":["王者荣耀","个性","文字","可爱","萌"],"rule":"?imageView2/3/h/$<Height>",
     * "wp":"http://img5.adesk.com/59f30829e7bce729500bc88f","xr":false,"cr":false,"favs":107,
     * "atime":1.509235384E9,"id":"59f30829e7bce729500bc88f","store":"qiniu","desc":""},
     * {"preview":"http://img5.adesk.com/59f30829e7bce729500bc88e","thumb":"http://img5.adesk
     * .com/59f30829e7bce729500bc88e","img":"http://img5.adesk.com/59f30829e7bce729500bc88e",
     * "views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":3,"rank":11989,"url":[],"tag":["诸葛亮",
     * "王者荣耀","个性","文字","可爱","萌"],"rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
     * .com/59f30829e7bce729500bc88e","xr":false,"cr":false,"favs":171,"atime":1.509336193E9,
     * "id":"59f30829e7bce729500bc88e","store":"qiniu","desc":""},{"preview":"http://img5.adesk
     * .com/59f30829e7bce729d564ff6e","thumb":"http://img5.adesk.com/59f30829e7bce729d564ff6e",
     * "img":"http://img5.adesk.com/59f30829e7bce729d564ff6e","views":0,
     * "cid":["5109e04e48d5b9364ae9ac45"],"ncos":4,"rank":6163,"url":[],"tag":["孙尚香","王者荣耀","个性",
     * "文字","可爱","萌"],"rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
     * .com/59f30829e7bce729d564ff6e","xr":false,"cr":false,"favs":66,"atime":1.509292623E9,
     * "id":"59f30829e7bce729d564ff6e","store":"qiniu","desc":""}],"stime":1.509724981E12,
     * "type":1,"hometype":"chosen","title":"猥琐发育，别浪！"},{"items":[{"ncos":0,
     * "thumb":"http://img5.adesk.com/59facebde7bce729760f4dcb","img":"http://img5.adesk
     * .com/59facebde7bce729760f4dcb","cid":["4fb47a465ba1c65561000028"],"url":[],
     * "rule":"?imageView2/3/h/$<Height>","atime":1.509789784E9,"views":0,"rank":32,"tag":["芒果",
     * "水果","盘子","刀","桌布"],"user":{"name":"一念夕雾","viptime":1.499843851E9,"auth":"adesk",
     * "follower":2892,"avatar":"http://img0.adesk.com/download/59cf77ec0422085f6f76f58d",
     * "isvip":false,"id":"5965cd0be7bce7312ef79fbf"},"wp":"http://img5.adesk
     * .com/59facebde7bce729760f4dcb","xr":false,"cr":false,"favs":2,"preview":"http://img5.adesk
     * .com/59facebde7bce729760f4dcb","id":"59facebde7bce729760f4dcb","store":"qiniu","desc":""},
     * {"ncos":0,"thumb":"http://img5.adesk.com/59fad30de7bce729eca957bb",
     * "img":"http://img5.adesk.com/59fad30de7bce729eca957bb","cid":["4e4d610cdf714d2966000002"],
     * "url":[],"rule":"?imageView2/3/h/$<Height>","atime":1.509789783E9,"views":0,"rank":79,
     * "tag":["花","粉色","兰花","树枝","花苞"],"user":{"name":"一念夕雾","viptime":1.499843851E9,
     * "auth":"adesk","follower":2892,"avatar":"http://img0.adesk
     * .com/download/59cf77ec0422085f6f76f58d","isvip":false,"id":"5965cd0be7bce7312ef79fbf"},
     * "wp":"http://img5.adesk.com/59fad30de7bce729eca957bb","xr":false,"cr":false,"favs":1,
     * "preview":"http://img5.adesk.com/59fad30de7bce729eca957bb",
     * "id":"59fad30de7bce729eca957bb","store":"qiniu","desc":""},{"ncos":0,
     * "thumb":"http://img5.adesk.com/59fad1d0e7bce729bf1491d5","img":"http://img5.adesk
     * .com/59fad1d0e7bce729bf1491d5","cid":["4fb47a195ba1c60ca5000222"],"url":[],
     * "rule":"?imageView2/3/h/$<Height>","atime":1.509789782E9,"views":0,"rank":95,"tag":["蝴蝶",
     * "水","创意","水珠","设计"],"user":{"name":"一念夕雾","viptime":1.499843851E9,"auth":"adesk",
     * "follower":2892,"avatar":"http://img0.adesk.com/download/59cf77ec0422085f6f76f58d",
     * "isvip":false,"id":"5965cd0be7bce7312ef79fbf"},"wp":"http://img5.adesk
     * .com/59fad1d0e7bce729bf1491d5","xr":false,"cr":false,"favs":4,"preview":"http://img5.adesk
     * .com/59fad1d0e7bce729bf1491d5","id":"59fad1d0e7bce729bf1491d5","store":"qiniu","desc":""},
     * {"ncos":0,"thumb":"http://img5.adesk.com/59fac597e7bce72994d90906",
     * "img":"http://img5.adesk.com/59fac597e7bce72994d90906","cid":["4e4d610cdf714d2966000001"],
     * "url":[],"rule":"?imageView2/3/h/$<Height>","atime":1.509789782E9,"views":0,"rank":53,
     * "tag":["蝴蝶","灰蝶","花","昆虫","动物"],"user":{"name":"一念夕雾","viptime":1.499843851E9,
     * "auth":"adesk","follower":2892,"avatar":"http://img0.adesk
     * .com/download/59cf77ec0422085f6f76f58d","isvip":false,"id":"5965cd0be7bce7312ef79fbf"},
     * "wp":"http://img5.adesk.com/59fac597e7bce72994d90906","xr":false,"cr":false,"favs":1,
     * "preview":"http://img5.adesk.com/59fac597e7bce72994d90906",
     * "id":"59fac597e7bce72994d90906","store":"qiniu","desc":""},{"ncos":0,
     * "thumb":"http://img5.adesk.com/59facebee7bce729aa47ee99","img":"http://img5.adesk
     * .com/59facebee7bce729aa47ee99","cid":["4fb47a465ba1c65561000028"],"url":[],
     * "rule":"?imageView2/3/h/$<Height>","atime":1.509782584E9,"views":0,"rank":110,
     * "tag":["三明治","肉","蔬菜","番茄","西红柿","美食"],"user":{"name":"一念夕雾","viptime":1.499843851E9,
     * "auth":"adesk","follower":2892,"avatar":"http://img0.adesk
     * .com/download/59cf77ec0422085f6f76f58d","isvip":false,"id":"5965cd0be7bce7312ef79fbf"},
     * "wp":"http://img5.adesk.com/59facebee7bce729aa47ee99","xr":false,"cr":false,"favs":2,
     * "preview":"http://img5.adesk.com/59facebee7bce729aa47ee99",
     * "id":"59facebee7bce729aa47ee99","store":"qiniu","desc":""},{"ncos":3,
     * "thumb":"http://img5.adesk.com/59fa7bb4e7bce729760f4db5","img":"http://img5.adesk
     * .com/59fa7bb4e7bce729760f4db5","cid":["4e4d610cdf714d2966000000"],"url":[],
     * "rule":"?imageView2/3/h/$<Height>","atime":1.509760997E9,"views":0,"rank":685,
     * "tag":["丸子头","柠檬","可爱","清纯"],"user":{"name":"该昵称已被占有","viptime":1.482992719E9,
     * "auth":"adesk","follower":3101,"avatar":"http://img0.adesk
     * .com/download/5864acb09fd71a34ac937f84","isvip":false,"id":"5864ac4f9fd71a34ac937f81"},
     * "wp":"http://img5.adesk.com/59fa7bb4e7bce729760f4db5","xr":false,"cr":false,"favs":22,
     * "preview":"http://img5.adesk.com/59fa7bb4e7bce729760f4db5",
     * "id":"59fa7bb4e7bce729760f4db5","store":"qiniu","desc":""}],"type":1,"hometype":"upload",
     * "title":"用户上传"}],"alert":{"msg":""}}
     * code : 0
     */

    private String msg;
    private ResBean res;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResBean getRes() {
        return res;
    }

    public void setRes(ResBean res) {
        this.res = res;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResBean {
        /**
         * wallpaper : [{"preview":"http://img5.adesk.com/583d01b5da76f7386472a721",
         * "thumb":"http://img5.adesk.com/583d01b5da76f7386472a721","img":"http://img5.adesk
         * .com/583d01b5da76f7386472a721","views":0,"cid":["4e4d610cdf714d2966000003"],
         * "ncos":152,"rank":475819,"url":[],"source_type":"wallpaper","tag":[],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/583d01b5da76f7386472a721","xr":false,"cr":false,"favs":9552,
         * "atime":1.480495802E9,"type":"wallpaper","id":"583d01b5da76f7386472a721",
         * "store":"qiniu","desc":""},{"preview":"http://img5.adesk
         * .com/58eaf7b9e7bce713a62b6a0f","thumb":"http://img5.adesk
         * .com/58eaf7b9e7bce713a62b6a0f","img":"http://img5.adesk.com/58eaf7b9e7bce713a62b6a0f",
         * "views":0,"cid":["4e4d610cdf714d2966000007"],"ncos":186,"rank":523178,"url":[],
         * "source_type":"wallpaper","tag":["王者荣耀","游戏","李白","皮肤","酷炫"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/58eaf7b9e7bce713a62b6a0f","xr":false,"cr":false,"favs":4489,
         * "atime":1.491807422E9,"type":"wallpaper","id":"58eaf7b9e7bce713a62b6a0f",
         * "store":"qiniu","desc":""},{"preview":"http://img0.adesk
         * .com/download/5796fd5394e5cc65ed8423b5","thumb":"http://img0.adesk
         * .com/download/5796fd5494e5cc65ed8423d7","img":"http://img0.adesk
         * .com/download/5796fd5494e5cc65ed8423e1","views":0,"cid":["4e58c2570569791a19000000"],
         * "ncos":315,"rank":525630,"url":[],"source_type":"wallpaper","tag":["宠物的秘密生活","动画片",
         * "卡通","可爱","兔子"],"wp":"http://img0.adesk.com/wallpaper?imgid=5795ceda69401b71df5e64a2",
         * "xr":false,"cr":false,"favs":6925,"atime":1.469513044E9,"type":"wallpaper",
         * "id":"5795ceda69401b71df5e64a2","store":"adesk","desc":"《宠物的秘密生活》（The Secret Life of
         * Pets）"},{"preview":"http://img5.adesk.com/593e5e8ae7bce77808ca85ab",
         * "thumb":"http://img5.adesk.com/593e5e8ae7bce77808ca85ab","img":"http://img5.adesk
         * .com/593e5e8ae7bce77808ca85ab","views":0,"cid":["4e4d610cdf714d2966000003"],
         * "ncos":1019,"rank":433480,"url":[],"source_type":"wallpaper","tag":["动漫","女孩","黑白",
         * "紫瞳","潮流","非主流"],"rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/593e5e8ae7bce77808ca85ab","xr":false,"cr":false,"favs":8931,
         * "atime":1.497333785E9,"type":"wallpaper","id":"593e5e8ae7bce77808ca85ab",
         * "store":"qiniu","desc":""},{"preview":"http://img0.adesk
         * .com/download/5853599794e5cc1c073fe8dd","thumb":"http://img0.adesk
         * .com/download/5853599894e5cc1c073fe8fb","img":"http://img0.adesk
         * .com/download/5853599894e5cc1c073fe904","views":0,"cid":["5109e04e48d5b9364ae9ac45"],
         * "ncos":25,"rank":201877,"url":[],"source_type":"wallpaper","tag":["文字","情感","纯色",
         * "黑白"],"wp":"http://img0.adesk.com/wallpaper?imgid=5850f11869401b34865eed9a",
         * "xr":false,"cr":false,"favs":2940,"atime":1.481857432E9,"type":"wallpaper",
         * "id":"5850f11869401b34865eed9a","store":"adesk","desc":""},
         * {"preview":"http://img0.adesk.com/download/57c1657f94e5cc7ff6984dc9",
         * "thumb":"http://img0.adesk.com/download/57c1657f94e5cc7ff6984de7",
         * "img":"http://img0.adesk.com/download/57c1657f94e5cc7ff6984df0","views":0,
         * "cid":["5109e04e48d5b9364ae9ac45"],"ncos":15,"rank":145123,"url":[],
         * "source_type":"wallpaper","tag":["文字","简单","纯色背景","简约"],"wp":"http://img0.adesk
         * .com/wallpaper?imgid=57baf7c969401b644d276d76","xr":false,"cr":false,"favs":1735,
         * "atime":1.472292223E9,"type":"wallpaper","id":"57baf7c969401b644d276d76",
         * "store":"adesk","desc":""},{"preview":"http://img5.adesk
         * .com/59fabd95e7bce729500bca3b","thumb":"http://img5.adesk
         * .com/59fabd95e7bce729500bca3b","img":"http://img5.adesk.com/59fabd95e7bce729500bca3b",
         * "views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":4,"rank":5763,"url":[],
         * "source_type":"wallpaper","tag":["李白","王者荣耀","黑白","表白","文字"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59fabd95e7bce729500bca3b","xr":false,"cr":false,"favs":97,"atime":1.509717782E9,
         * "type":"wallpaper","id":"59fabd95e7bce729500bca3b","store":"qiniu","desc":""},
         * {"preview":"http://img5.adesk.com/59e6fad0e7bce729bf148d6e","thumb":"http://img5.adesk
         * .com/59e6fad0e7bce729bf148d6e","img":"http://img5.adesk.com/59e6fad0e7bce729bf148d6e",
         * "views":0,"cid":["4e4d610cdf714d2966000007"],"ncos":10,"rank":33879,"url":[],
         * "source_type":"wallpaper","tag":["孙悟空","地狱火","王者荣耀","炫酷","游戏"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59e6fad0e7bce729bf148d6e","xr":false,"cr":false,"favs":235,"atime":1.508428624E9,
         * "type":"wallpaper","id":"59e6fad0e7bce729bf148d6e","store":"qiniu","desc":""},
         * {"preview":"http://img0.adesk.com/download/539f78ff69401b44983f62d6",
         * "thumb":"http://img0.adesk.com/download/5098a6ca16b37b570d0284a4",
         * "img":"http://img0.adesk.com/download/539f790069401b44983f62d8","views":3,
         * "cid":["4e4d610cdf714d2966000004"],"ncos":26,"rank":139150,"url":[],
         * "source_type":"wallpaper","tag":[],"wp":"http://img0.adesk
         * .com/wallpaper?imgid=5005431206ff62743500296c","xr":false,"cr":false,"favs":1583,
         * "atime":1.34252213E9,"type":"wallpaper","id":"5005431206ff62743500296c",
         * "store":"adesk","desc":"【99种方式说谢谢-感谢哥们】世界杯的时候每晚熬夜看球，为你准备了零食啤酒一起战到天明。\n-安卓壁纸2014
         * 感恩节专题-"},{"preview":"http://img5.adesk.com/59ddbbd1e7bce729d564fad8",
         * "thumb":"http://img5.adesk.com/59ddbbd1e7bce729d564fad8","img":"http://img5.adesk
         * .com/59ddbbd1e7bce729d564fad8","views":0,"cid":["4e4d610cdf714d2966000001"],"ncos":14,
         * "rank":44867,"url":[],"source_type":"wallpaper","tag":["狗","白色","草地","可爱","萌","动物",
         * "博美"],"rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59ddbbd1e7bce729d564fad8","xr":false,"cr":false,"favs":615,"atime":1.507816983E9,
         * "type":"wallpaper","id":"59ddbbd1e7bce729d564fad8","store":"qiniu","desc":""},
         * {"preview":"http://img5.adesk.com/583a6ea9da76f747b17be5fe","thumb":"http://img5.adesk
         * .com/583a6ea9da76f747b17be5fe","img":"http://img5.adesk.com/583a6ea9da76f747b17be5fe",
         * "views":0,"cid":["4e4d610cdf714d2966000003"],"ncos":52,"rank":82706,"url":[],
         * "source_type":"wallpaper","tag":["动漫","二次元","少女","萌"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/583a6ea9da76f747b17be5fe","xr":false,"cr":false,"favs":2269,"atime":1.48025394E9,
         * "type":"wallpaper","id":"583a6ea9da76f747b17be5fe","store":"qiniu","desc":""},
         * {"preview":"http://img5.adesk.com/59d4f6ffe7bce77bbf6df62d","thumb":"http://img5.adesk
         * .com/59d4f6ffe7bce77bbf6df62d","img":"http://img5.adesk.com/59d4f6ffe7bce77bbf6df62d",
         * "views":0,"cid":["4e4d610cdf714d2966000000"],"ncos":8,"rank":14313,"url":[],
         * "source_type":"wallpaper","tag":[],"rule":"?imageView2/3/h/$<Height>",
         * "wp":"http://img5.adesk.com/59d4f6ffe7bce77bbf6df62d","xr":false,"cr":false,
         * "favs":394,"atime":1.507689512E9,"type":"wallpaper","id":"59d4f6ffe7bce77bbf6df62d",
         * "store":"qiniu","desc":""},{"preview":"http://img5.adesk
         * .com/59f2db85e7bce729bf149033","thumb":"http://img5.adesk
         * .com/59f2db85e7bce729bf149033","img":"http://img5.adesk.com/59f2db85e7bce729bf149033",
         * "views":0,"cid":["4ef0a3330569795757000000"],"ncos":18,"rank":36003,"url":[],
         * "source_type":"wallpaper","tag":["插画","朱颜","佳人","伞","龙"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59f2db85e7bce729bf149033","xr":false,"cr":false,"favs":717,"atime":1.509235383E9,
         * "type":"wallpaper","id":"59f2db85e7bce729bf149033","store":"qiniu","desc":"作者 | 古戈力"},
         * {"preview":"http://img5.adesk.com/59f96529e7bce729d56500ea","thumb":"http://img5.adesk
         * .com/59f96529e7bce729d56500ea","img":"http://img5.adesk.com/59f96529e7bce729d56500ea",
         * "views":0,"cid":["4e4d610cdf714d2966000000"],"ncos":12,"rank":6177,"url":[],
         * "source_type":"wallpaper","tag":["马尾","网球","气质","美女","运动","阳光"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59f96529e7bce729d56500ea","xr":false,"cr":false,"favs":247,"atime":1.509710584E9,
         * "type":"wallpaper","id":"59f96529e7bce729d56500ea","store":"qiniu","desc":"摄影 |
         * KIWIsi"},{"preview":"http://img5.adesk.com/59f822a8e7bce729aa47edf0",
         * "thumb":"http://img5.adesk.com/59f822a8e7bce729aa47edf0","img":"http://img5.adesk
         * .com/59f822a8e7bce729aa47edf0","views":0,"cid":["4e4d610cdf714d2966000002"],"ncos":1,
         * "rank":1289,"url":[],"source_type":"wallpaper","tag":["小屋","湖","倒影","山水","唯美","绿色"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59f822a8e7bce729aa47edf0","xr":false,"cr":false,"favs":32,"atime":1.509753784E9,
         * "type":"wallpaper","id":"59f822a8e7bce729aa47edf0","store":"qiniu","desc":""},
         * {"preview":"http://img5.adesk.com/58847ea2e7bce740e2b080bf","thumb":"http://img5.adesk
         * .com/58847ea2e7bce740e2b080bf","img":"http://img5.adesk.com/58847ea2e7bce740e2b080bf",
         * "views":0,"cid":["4e4d610cdf714d2966000003"],"ncos":112,"rank":365496,"url":[],
         * "source_type":"wallpaper","tag":["动漫","二次元","刀剑神域","桐人","武器"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/58847ea2e7bce740e2b080bf","xr":false,"cr":false,"favs":6817,
         * "atime":1.485763219E9,"type":"wallpaper","id":"58847ea2e7bce740e2b080bf",
         * "store":"qiniu","desc":""},{"preview":"http://img5.adesk
         * .com/59f8228ae7bce729760f4d21","thumb":"http://img5.adesk
         * .com/59f8228ae7bce729760f4d21","img":"http://img5.adesk.com/59f8228ae7bce729760f4d21",
         * "views":0,"cid":["4e4d610cdf714d2966000002"],"ncos":0,"rank":1738,"url":[],
         * "source_type":"wallpaper","tag":["山水","倒影","唯美","树","湖","风景"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59f8228ae7bce729760f4d21","xr":false,"cr":false,"favs":34,"atime":1.509696184E9,
         * "type":"wallpaper","id":"59f8228ae7bce729760f4d21","store":"qiniu","desc":""},
         * {"preview":"http://img5.adesk.com/585344729a1aa3796b960ed0","thumb":"http://img5.adesk
         * .com/585344729a1aa3796b960ed0","img":"http://img5.adesk.com/585344729a1aa3796b960ed0",
         * "views":0,"cid":["4e4d610cdf714d2966000003"],"ncos":37,"rank":202254,"url":[],
         * "source_type":"wallpaper","tag":["你的名字","动漫","电影","二次元","三叶","泷"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/585344729a1aa3796b960ed0","xr":false,"cr":false,"favs":3768,
         * "atime":1.482405602E9,"type":"wallpaper","id":"585344729a1aa3796b960ed0",
         * "store":"qiniu","desc":""},{"preview":"http://img5.adesk
         * .com/59f59c15e7bce77b0027a54e","thumb":"http://img5.adesk
         * .com/59f59c15e7bce77b0027a54e","img":"http://img5.adesk.com/59f59c15e7bce77b0027a54e",
         * "views":0,"cid":["4e4d610cdf714d2966000003"],"ncos":5,"rank":5079,"url":[],
         * "source_type":"wallpaper","tag":[],"rule":"?imageView2/3/h/$<Height>",
         * "wp":"http://img5.adesk.com/59f59c15e7bce77b0027a54e","xr":false,"cr":false,
         * "favs":265,"atime":1.509714002E9,"type":"wallpaper","id":"59f59c15e7bce77b0027a54e",
         * "store":"qiniu","desc":""},{"preview":"http://img5.adesk
         * .com/59e5878ae7bce729d564fc3e","thumb":"http://img5.adesk
         * .com/59e5878ae7bce729d564fc3e","img":"http://img5.adesk.com/59e5878ae7bce729d564fc3e",
         * "views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":41,"rank":120663,"url":[],
         * "source_type":"wallpaper","tag":["FBI","搞笑","个性","黑色","幽默","锁屏","文字壁纸"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59e5878ae7bce729d564fc3e","xr":false,"cr":false,"favs":1396,
         * "atime":1.508306581E9,"type":"wallpaper","id":"59e5878ae7bce729d564fc3e",
         * "store":"qiniu","desc":""},{"preview":"http://img5.adesk
         * .com/59b75bb6e7bce72961f10302","thumb":"http://img5.adesk
         * .com/59b75bb6e7bce72961f10302","img":"http://img5.adesk.com/59b75bb6e7bce72961f10302",
         * "views":0,"cid":["4ef0a3330569795757000000"],"ncos":1,"rank":18068,"url":[],
         * "source_type":"wallpaper","tag":["插画","小清新","可爱","猫咪"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59b75bb6e7bce72961f10302","xr":false,"cr":false,"favs":387,"atime":1.505224983E9,
         * "type":"wallpaper","id":"59b75bb6e7bce72961f10302","store":"qiniu","desc":""},
         * {"preview":"http://img5.adesk.com/59b75bb7e7bce729eca94b5c","thumb":"http://img5.adesk
         * .com/59b75bb7e7bce729eca94b5c","img":"http://img5.adesk.com/59b75bb7e7bce729eca94b5c",
         * "views":0,"cid":["4ef0a3330569795757000000"],"ncos":2,"rank":18441,"url":[],
         * "source_type":"wallpaper","tag":["插画","小清新","可爱"],"rule":"?imageView2/3/h/$<Height>",
         * "wp":"http://img5.adesk.com/59b75bb7e7bce729eca94b5c","xr":false,"cr":false,
         * "favs":360,"atime":1.505628184E9,"type":"wallpaper","id":"59b75bb7e7bce729eca94b5c",
         * "store":"qiniu","desc":""},{"preview":"http://img5.adesk
         * .com/59f17f3de7bce72961f10c0b","thumb":"http://img5.adesk
         * .com/59f17f3de7bce72961f10c0b","img":"http://img5.adesk.com/59f17f3de7bce72961f10c0b",
         * "views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":8,"rank":25063,"url":[],
         * "source_type":"wallpaper","tag":["手写","简单","表白","个性","黑白","文字"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59f17f3de7bce72961f10c0b","xr":false,"cr":false,"favs":461,"atime":1.509170593E9,
         * "type":"wallpaper","id":"59f17f3de7bce72961f10c0b","store":"qiniu","desc":""},
         * {"preview":"http://img5.adesk.com/59f8228ae7bce72994d9085d","thumb":"http://img5.adesk
         * .com/59f8228ae7bce72994d9085d","img":"http://img5.adesk.com/59f8228ae7bce72994d9085d",
         * "views":0,"cid":["4e4d610cdf714d2966000002"],"ncos":0,"rank":533,"url":[],
         * "source_type":"wallpaper","tag":["铁道","树","雪","轨道","白色"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59f8228ae7bce72994d9085d","xr":false,"cr":false,"favs":12,"atime":1.509760996E9,
         * "type":"wallpaper","id":"59f8228ae7bce72994d9085d","store":"qiniu","desc":""},
         * {"preview":"http://img5.adesk.com/59f96527e7bce729aa47ee33","thumb":"http://img5.adesk
         * .com/59f96527e7bce729aa47ee33","img":"http://img5.adesk.com/59f96527e7bce729aa47ee33",
         * "views":0,"cid":["4e4d610cdf714d2966000000"],"ncos":3,"rank":7213,"url":[],
         * "source_type":"wallpaper","tag":["马尾","网球","气质","美女","运动","阳光"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59f96527e7bce729aa47ee33","xr":false,"cr":false,"favs":252,"atime":1.509667394E9,
         * "type":"wallpaper","id":"59f96527e7bce729aa47ee33","store":"qiniu","desc":"摄影 |
         * KIWIsi"},{"preview":"http://img0.adesk.com/download/58971481e7bce749f6ea71da",
         * "thumb":"http://img0.adesk.com/download/58971482e7bce749f6ea71f9",
         * "img":"http://img0.adesk.com/download/58971482e7bce749f6ea7203","views":0,
         * "cid":["4fb47a465ba1c65561000028"],"ncos":23,"rank":100230,"url":[],
         * "source_type":"wallpaper","tag":["物语","花","冬天","雪","玫瑰"],"wp":"http://img0.adesk
         * .com/wallpaper?imgid=58662a3669401b34865f2220","xr":false,"cr":false,"favs":1878,
         * "atime":1.486296194E9,"type":"wallpaper","id":"58662a3669401b34865f2220",
         * "store":"adesk","desc":""},{"preview":"http://img0.adesk
         * .com/download/583be4f894e5cc3b1fd38edd","thumb":"http://img0.adesk
         * .com/download/583be4f994e5cc3b1fd38efb","img":"http://img0.adesk
         * .com/download/583be4f994e5cc3b1fd38f04","views":0,"cid":["4e4d610cdf714d2966000004"],
         * "ncos":34,"rank":158818,"url":[],"source_type":"wallpaper","tag":["卡通","仓鼠","可爱","萌",
         * "围巾"],"wp":"http://img0.adesk.com/wallpaper?imgid=5837f88069401b34865eae17",
         * "xr":false,"cr":false,"favs":3155,"atime":1.480320249E9,"type":"wallpaper",
         * "id":"5837f88069401b34865eae17","store":"adesk","desc":""},
         * {"preview":"http://img0.adesk.com/download/579713eb94e5cc145ba312a4",
         * "thumb":"http://img0.adesk.com/download/579713ec94e5cc145ba312c6",
         * "img":"http://img0.adesk.com/download/579713ec94e5cc145ba312cf","views":0,
         * "cid":["4e4d610cdf714d2966000000"],"ncos":23,"rank":89125,"url":[],
         * "source_type":"wallpaper","tag":["清纯","文艺","萌妹子","可爱","清新"],"wp":"http://img0.adesk
         * .com/wallpaper?imgid=5794900169401b1a43f2d4f3","xr":false,"cr":false,"favs":1445,
         * "atime":1.469518828E9,"type":"wallpaper","id":"5794900169401b1a43f2d4f3",
         * "store":"adesk","desc":"出镜/卵母细胞"},{"preview":"http://img0.adesk
         * .com/download/57b19c2094e5cc6c12d83cdb","thumb":"http://img0.adesk
         * .com/download/57b19c2094e5cc6c12d83cf9","img":"http://img0.adesk
         * .com/download/57b19c2094e5cc6c12d83d02","views":0,"cid":["5109e04e48d5b9364ae9ac45"],
         * "ncos":73,"rank":285877,"url":[],"source_type":"wallpaper","tag":[],
         * "wp":"http://img0.adesk.com/wallpaper?imgid=57b00edc69401b19f52b5959","xr":false,
         * "cr":false,"favs":2796,"atime":1.471257632E9,"type":"wallpaper",
         * "id":"57b00edc69401b19f52b5959","store":"adesk","desc":""},
         * {"preview":"http://img0.adesk.com/download/56fc680e94e5cc1ab09f962b",
         * "thumb":"http://img0.adesk.com/download/56fc680f94e5cc1ab09f9650",
         * "img":"http://img0.adesk.com/download/56fc680f94e5cc1ab09f965c","views":0,
         * "cid":["4fb47a305ba1c60ca5000223"],"ncos":7,"rank":17859,"url":[],
         * "source_type":"wallpaper","tag":["风景","植物","花","树","阳光","房子"],"wp":"http://img0.adesk
         * .com/wallpaper?imgid=56fbd5b169401b6e18ca6223","xr":false,"cr":false,"favs":174,
         * "atime":1.459382287E9,"type":"wallpaper","id":"56fbd5b169401b6e18ca6223",
         * "store":"adesk","desc":""}]
         * homepage : [{"items":[{"notice":"1、【新增】首页新增美女、动漫，更丰富的图片资源。\r\n2、【优化】新版本更流畅，快来更新体验吧。",
         * "code":177,"force":[],"name":"5.7.7","title":"有新版本，快来更新吧","url":"http://s.adesk
         * .com/apk/Androidesk-release-androidesk.apk","_id":"599d563fe7bce729500bb926",
         * "fnotice":"","atime":1.503483455E9,"id":"599d563fe7bce729500bb926"}],"type":14,
         * "title":"版本更新"},{"items":[{"status":true,"value":{"ename":"美腿特辑","isfeed":false,
         * "tag":[],"id":"534644f948d5b95a9ae3a575","top":9,"type":1,"status":"online",
         * "user":{"gcid":"","name":"ZhouKIMI","gender":1,"follower":204,
         * "avatar":"http://img0.adesk.com/download/563b25ed94e5cc562285aad5",
         * "viptime":9.782784E8,"following":0,"isvip":false,"id":"528c24922d74c818c3d9b730"},
         * "favs":16798,"atime":1.397114105E9,"desc":"狂秀美腿的季节要来啦~！","name":"美腿特辑","url":[],
         * "cover":"http://img0.adesk.com/download/5815b7a794e5cc3778275681",
         * "lcover":"http://img0.adesk.com/download/5815b7a794e5cc37782756ae","subname":"美腿",
         * "sn":42},"atime":1.509724983E9,"target":"534644f948d5b95a9ae3a575",
         * "img":"59fafa80e7bce74352003ea8","module":1,"sn":1,"_id":"59fafa80e7bce74352003eab",
         * "type":7,"id":"59fafa80e7bce74352003eab","thumb":"http://img0.adesk
         * .com/download/59fafa80e7bce74352003ea8"},{"status":true,"value":{"status":"online",
         * "ename":"","atime":1.459069168E9,"user":{"gender":1,"cache":false,"id":"None",
         * "avatar":"http://s.adesk.com/picasso/avatar_default.png","name":"安卓壁纸用户None"},
         * "url":[],"desc":"1930年成立于斯图加特，以生产高级跑车闻名于世界车坛。创始人费迪南德·波尔舍（同费迪南德·保时捷）是一位享誉世界车坛的著名设计师",
         * "cover":"http://img5.adesk.com/59a9075fe7bce72994d8f9fb?imageView2/3/h/240",
         * "id":"56f7a0f069401b4eb5d53131","tag":[],"sn":999,"lcover":"http://img5.adesk
         * .com/59a9075fe7bce72994d8f9fb?imageView2/3/h/720","favs":1960,"type":1,"isfeed":false,
         * "name":"保时捷"},"atime":1.509638582E9,"target":"56f7a0f069401b4eb5d53131",
         * "img":"59fafaade7bce742cdcaf3d5","module":1,"sn":2,"_id":"59fafaade7bce742cdcaf3d8",
         * "type":7,"id":"59fafaade7bce742cdcaf3d8","thumb":"http://img0.adesk
         * .com/download/59fafaade7bce742cdcaf3d5"},{"status":true,"value":{"url":"http://service
         * .videowp.adesk.com/web/banner/adesk?id=5964b3eee7bce71dd4feefc8"},
         * "atime":1.509339242E9,"target":"http://service.videowp.adesk
         * .com/web/banner/adesk?id=5964b3eee7bce71dd4feefc8","img":"59f6af75e7bce729760f4c52",
         * "module":1,"sn":3,"_id":"59f6af75e7bce729760f4c55","type":22,
         * "id":"59f6af75e7bce729760f4c55","thumb":"http://img0.adesk
         * .com/download/59f6af75e7bce729760f4c52"},{"status":true,"value":{"status":"online",
         * "ename":"每日开出一朵花","name":"每日开出一朵花","url":[],"user":{"gcid":"","name":"融雪之前",
         * "gender":1,"follower":1797,"avatar":"http://img0.adesk
         * .com/download/53a7e1b12d74c827b3973705","viptime":9.782784E8,"following":0,
         * "isvip":false,"id":"5370b3c02d74c805fcebeae7"},"cover":"http://img0.adesk
         * .com/download/546c3c1c69401b3aa2b95859","id":"546c079469401b2336e67c5b","tag":[],
         * "sn":999,"lcover":"http://img0.adesk.com/download/546c3c1c69401b3aa2b95877",
         * "favs":5959,"atime":1.416365972E9,"type":1,"isfeed":false,
         * "desc":"哪怕错过一季的芬芳，也要相信，始终有一朵花只为你开放。"},"atime":1.509379383E9,
         * "target":"546c079469401b2336e67c5b","img":"59f1c8dbe7bce729aa47ebb3","module":1,
         * "sn":4,"_id":"59f1c8dbe7bce729aa47ebb6","type":7,"id":"59f1c8dbe7bce729aa47ebb6",
         * "thumb":"http://img0.adesk.com/download/59f1c8dbe7bce729aa47ebb3"}],"type":13,
         * "title":"小编精选"},{"items":[{"preview":"http://img5.adesk.com/59f3082ae7bce729d564ff6f",
         * "thumb":"http://img5.adesk.com/59f3082ae7bce729d564ff6f","img":"http://img5.adesk
         * .com/59f3082ae7bce729d564ff6f","views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":4,
         * "rank":8894,"url":[],"tag":["小乔","王者荣耀","个性","文字","可爱","萌"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59f3082ae7bce729d564ff6f","xr":false,"cr":false,"favs":92,"atime":1.509249783E9,
         * "id":"59f3082ae7bce729d564ff6f","store":"qiniu","desc":""},
         * {"preview":"http://img5.adesk.com/59f3082ae7bce729aa47ece2","thumb":"http://img5.adesk
         * .com/59f3082ae7bce729aa47ece2","img":"http://img5.adesk.com/59f3082ae7bce729aa47ece2",
         * "views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":6,"rank":10913,"url":[],
         * "tag":["王昭君","王者荣耀","个性","文字","可爱","萌"],"rule":"?imageView2/3/h/$<Height>",
         * "wp":"http://img5.adesk.com/59f3082ae7bce729aa47ece2","xr":false,"cr":false,
         * "favs":155,"atime":1.509235384E9,"id":"59f3082ae7bce729aa47ece2","store":"qiniu",
         * "desc":""},{"preview":"http://img5.adesk.com/59f30829e7bce72961f10dc2",
         * "thumb":"http://img5.adesk.com/59f30829e7bce72961f10dc2","img":"http://img5.adesk
         * .com/59f30829e7bce72961f10dc2","views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":3,
         * "rank":11357,"url":[],"tag":["李白","王者荣耀","个性","文字","可爱","萌"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59f30829e7bce72961f10dc2","xr":false,"cr":false,"favs":135,"atime":1.509292623E9,
         * "id":"59f30829e7bce72961f10dc2","store":"qiniu","desc":""},
         * {"preview":"http://img5.adesk.com/59f30829e7bce729500bc88f","thumb":"http://img5.adesk
         * .com/59f30829e7bce729500bc88f","img":"http://img5.adesk.com/59f30829e7bce729500bc88f",
         * "views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":3,"rank":9659,"url":[],
         * "tag":["王者荣耀","个性","文字","可爱","萌"],"rule":"?imageView2/3/h/$<Height>",
         * "wp":"http://img5.adesk.com/59f30829e7bce729500bc88f","xr":false,"cr":false,
         * "favs":107,"atime":1.509235384E9,"id":"59f30829e7bce729500bc88f","store":"qiniu",
         * "desc":""},{"preview":"http://img5.adesk.com/59f30829e7bce729500bc88e",
         * "thumb":"http://img5.adesk.com/59f30829e7bce729500bc88e","img":"http://img5.adesk
         * .com/59f30829e7bce729500bc88e","views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":3,
         * "rank":11989,"url":[],"tag":["诸葛亮","王者荣耀","个性","文字","可爱","萌"],
         * "rule":"?imageView2/3/h/$<Height>","wp":"http://img5.adesk
         * .com/59f30829e7bce729500bc88e","xr":false,"cr":false,"favs":171,"atime":1.509336193E9,
         * "id":"59f30829e7bce729500bc88e","store":"qiniu","desc":""},
         * {"preview":"http://img5.adesk.com/59f30829e7bce729d564ff6e","thumb":"http://img5.adesk
         * .com/59f30829e7bce729d564ff6e","img":"http://img5.adesk.com/59f30829e7bce729d564ff6e",
         * "views":0,"cid":["5109e04e48d5b9364ae9ac45"],"ncos":4,"rank":6163,"url":[],
         * "tag":["孙尚香","王者荣耀","个性","文字","可爱","萌"],"rule":"?imageView2/3/h/$<Height>",
         * "wp":"http://img5.adesk.com/59f30829e7bce729d564ff6e","xr":false,"cr":false,"favs":66,
         * "atime":1.509292623E9,"id":"59f30829e7bce729d564ff6e","store":"qiniu","desc":""}],
         * "stime":1.509724981E12,"type":1,"hometype":"chosen","title":"猥琐发育，别浪！"},
         * {"items":[{"ncos":0,"thumb":"http://img5.adesk.com/59facebde7bce729760f4dcb",
         * "img":"http://img5.adesk.com/59facebde7bce729760f4dcb",
         * "cid":["4fb47a465ba1c65561000028"],"url":[],"rule":"?imageView2/3/h/$<Height>",
         * "atime":1.509789784E9,"views":0,"rank":32,"tag":["芒果","水果","盘子","刀","桌布"],
         * "user":{"name":"一念夕雾","viptime":1.499843851E9,"auth":"adesk","follower":2892,
         * "avatar":"http://img0.adesk.com/download/59cf77ec0422085f6f76f58d","isvip":false,
         * "id":"5965cd0be7bce7312ef79fbf"},"wp":"http://img5.adesk
         * .com/59facebde7bce729760f4dcb","xr":false,"cr":false,"favs":2,
         * "preview":"http://img5.adesk.com/59facebde7bce729760f4dcb",
         * "id":"59facebde7bce729760f4dcb","store":"qiniu","desc":""},{"ncos":0,
         * "thumb":"http://img5.adesk.com/59fad30de7bce729eca957bb","img":"http://img5.adesk
         * .com/59fad30de7bce729eca957bb","cid":["4e4d610cdf714d2966000002"],"url":[],
         * "rule":"?imageView2/3/h/$<Height>","atime":1.509789783E9,"views":0,"rank":79,
         * "tag":["花","粉色","兰花","树枝","花苞"],"user":{"name":"一念夕雾","viptime":1.499843851E9,
         * "auth":"adesk","follower":2892,"avatar":"http://img0.adesk
         * .com/download/59cf77ec0422085f6f76f58d","isvip":false,
         * "id":"5965cd0be7bce7312ef79fbf"},"wp":"http://img5.adesk
         * .com/59fad30de7bce729eca957bb","xr":false,"cr":false,"favs":1,
         * "preview":"http://img5.adesk.com/59fad30de7bce729eca957bb",
         * "id":"59fad30de7bce729eca957bb","store":"qiniu","desc":""},{"ncos":0,
         * "thumb":"http://img5.adesk.com/59fad1d0e7bce729bf1491d5","img":"http://img5.adesk
         * .com/59fad1d0e7bce729bf1491d5","cid":["4fb47a195ba1c60ca5000222"],"url":[],
         * "rule":"?imageView2/3/h/$<Height>","atime":1.509789782E9,"views":0,"rank":95,
         * "tag":["蝴蝶","水","创意","水珠","设计"],"user":{"name":"一念夕雾","viptime":1.499843851E9,
         * "auth":"adesk","follower":2892,"avatar":"http://img0.adesk
         * .com/download/59cf77ec0422085f6f76f58d","isvip":false,
         * "id":"5965cd0be7bce7312ef79fbf"},"wp":"http://img5.adesk
         * .com/59fad1d0e7bce729bf1491d5","xr":false,"cr":false,"favs":4,
         * "preview":"http://img5.adesk.com/59fad1d0e7bce729bf1491d5",
         * "id":"59fad1d0e7bce729bf1491d5","store":"qiniu","desc":""},{"ncos":0,
         * "thumb":"http://img5.adesk.com/59fac597e7bce72994d90906","img":"http://img5.adesk
         * .com/59fac597e7bce72994d90906","cid":["4e4d610cdf714d2966000001"],"url":[],
         * "rule":"?imageView2/3/h/$<Height>","atime":1.509789782E9,"views":0,"rank":53,
         * "tag":["蝴蝶","灰蝶","花","昆虫","动物"],"user":{"name":"一念夕雾","viptime":1.499843851E9,
         * "auth":"adesk","follower":2892,"avatar":"http://img0.adesk
         * .com/download/59cf77ec0422085f6f76f58d","isvip":false,
         * "id":"5965cd0be7bce7312ef79fbf"},"wp":"http://img5.adesk
         * .com/59fac597e7bce72994d90906","xr":false,"cr":false,"favs":1,
         * "preview":"http://img5.adesk.com/59fac597e7bce72994d90906",
         * "id":"59fac597e7bce72994d90906","store":"qiniu","desc":""},{"ncos":0,
         * "thumb":"http://img5.adesk.com/59facebee7bce729aa47ee99","img":"http://img5.adesk
         * .com/59facebee7bce729aa47ee99","cid":["4fb47a465ba1c65561000028"],"url":[],
         * "rule":"?imageView2/3/h/$<Height>","atime":1.509782584E9,"views":0,"rank":110,
         * "tag":["三明治","肉","蔬菜","番茄","西红柿","美食"],"user":{"name":"一念夕雾","viptime":1.499843851E9,
         * "auth":"adesk","follower":2892,"avatar":"http://img0.adesk
         * .com/download/59cf77ec0422085f6f76f58d","isvip":false,
         * "id":"5965cd0be7bce7312ef79fbf"},"wp":"http://img5.adesk
         * .com/59facebee7bce729aa47ee99","xr":false,"cr":false,"favs":2,
         * "preview":"http://img5.adesk.com/59facebee7bce729aa47ee99",
         * "id":"59facebee7bce729aa47ee99","store":"qiniu","desc":""},{"ncos":3,
         * "thumb":"http://img5.adesk.com/59fa7bb4e7bce729760f4db5","img":"http://img5.adesk
         * .com/59fa7bb4e7bce729760f4db5","cid":["4e4d610cdf714d2966000000"],"url":[],
         * "rule":"?imageView2/3/h/$<Height>","atime":1.509760997E9,"views":0,"rank":685,
         * "tag":["丸子头","柠檬","可爱","清纯"],"user":{"name":"该昵称已被占有","viptime":1.482992719E9,
         * "auth":"adesk","follower":3101,"avatar":"http://img0.adesk
         * .com/download/5864acb09fd71a34ac937f84","isvip":false,
         * "id":"5864ac4f9fd71a34ac937f81"},"wp":"http://img5.adesk
         * .com/59fa7bb4e7bce729760f4db5","xr":false,"cr":false,"favs":22,
         * "preview":"http://img5.adesk.com/59fa7bb4e7bce729760f4db5",
         * "id":"59fa7bb4e7bce729760f4db5","store":"qiniu","desc":""}],"type":1,
         * "hometype":"upload","title":"用户上传"}]
         * alert : {"msg":""}
         */

        private AlertBean alert;
        private List<BizhiBean> wallpaper;
        private List<DayRecommend> homepage;

        public AlertBean getAlert() {
            return alert;
        }

        public void setAlert(AlertBean alert) {
            this.alert = alert;
        }

        public List<BizhiBean> getWallpaper() {
            return wallpaper;
        }

        public void setWallpaper(List<BizhiBean> wallpaper) {
            this.wallpaper = wallpaper;
        }

        public List<DayRecommend> getHomepage() {
            return homepage;
        }

        public void setHomepage(List<DayRecommend> homepage) {
            this.homepage = homepage;
        }

        public static class AlertBean {
            /**
             * msg :
             */

            private String msg;

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }
        }

    }
}
