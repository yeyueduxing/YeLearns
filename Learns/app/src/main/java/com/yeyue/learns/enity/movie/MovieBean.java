package com.yeyue.learns.enity.movie;

import com.google.gson.annotations.SerializedName;
import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

import java.util.List;

/**
 * Created by li.xiao on 2018-1-25.
 */

public class MovieBean extends BaseItem {

    /**
     * rating : {"max":10,"average":2.4,"details":{"1":71,"3":3,"2":5,"5":1,"4":0},"stars":"15","min":0}
     * reviews_count : 11
     * videos : [{"source":{"literal":"qq","pic":"http://img3.doubanio.com/f/movie/38764466321ab88dfa19a1f826570367a19ce116/pics/movie/video-qq.png","name":"腾讯视频"},"sample_link":"http://v.qq.com/x/cover/xzvr5axh7r6u524.html?ptag=douban.movie","video_id":"xzvr5axh7r6u524","need_pay":false},{"source":{"literal":"youku","pic":"http://img3.doubanio.com/f/movie/3bb15010bb66a89962a5faf0f7f071fec8aaa763/pics/movie/logo_youku_small.png","name":"优酷视频"},"sample_link":"http://v.youku.com/v_show/id_XMjc4ODU0NzA4MA==.html?tpa=dW5pb25faWQ9MTAzNTY1XzEwMDAwMV8wMV8wMQ","video_id":"XMjc4ODU0NzA4MA==","need_pay":false},{"source":{"literal":"iqiyi","pic":"http://img3.doubanio.com/f/movie/e59bf8556426206eab3591f88a6c8ef8bf371a56/pics/movie/video_icon_new.png","name":"爱奇艺视频"},"sample_link":"http://www.iqiyi.com/v_19rr7csgsk.html?vfm=m_331_dbdy","video_id":"19rr7csgsk","need_pay":false}]
     * wish_count : 236
     * original_title : 恐怖理发店
     * blooper_urls : []
     * collect_count : 638
     * images : {"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2406903891.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2406903891.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2406903891.jpg"}
     * douban_site :
     * year : 2017
     * popular_comments : [{"rating":{"max":5,"value":1,"min":0},"useful_count":136,"author":{"uid":"147408877","avatar":"http://img3.doubanio.com/icon/u147408877-1.jpg","signature":"","alt":"http://www.douban.com/people/147408877/","id":"147408877","name":"turnin'"},"subject_id":"26865690","content":"刘哔又有素材了，我先帮你占个座","created_at":"2017-01-06 14:01:18","id":"1132901642"},{"rating":{"max":5,"value":1,"min":0},"useful_count":0,"author":{"uid":"148567170","avatar":"http://img3.doubanio.com/icon/u148567170-8.jpg","signature":"","alt":"http://www.douban.com/people/148567170/","id":"148567170","name":"伞丁飞豌豆"},"subject_id":"26865690","content":"娱乐大众","created_at":"2017-08-29 22:09:42","id":"1236367277"},{"rating":{"max":5,"value":1,"min":0},"useful_count":0,"author":{"uid":"41782473","avatar":"http://img3.doubanio.com/icon/u41782473-43.jpg","signature":"我爱电影 电影爱我～","alt":"http://www.douban.com/people/41782473/","id":"41782473","name":"Summer 璇"},"subject_id":"26865690","content":"忙别的爱奇艺自动播下一个电影播的，还好我没怎么看","created_at":"2017-10-20 15:46:26","id":"1259468187"},{"rating":{"max":5,"value":1,"min":0},"useful_count":25,"author":{"uid":"gw150080","avatar":"http://img3.doubanio.com/icon/u40137705-5.jpg","signature":"就这样等着你的身影破雾而来。","alt":"http://www.douban.com/people/gw150080/","id":"40137705","name":"悠悠兔..."},"subject_id":"26865690","content":"黑子很帅很呆萌。美发师傅质朴爷们。盗猎者硬朗彪悍，第二个盗猎者是带着猥琐的性感大叔。。。\"办卡么，办卡有优惠，染发还是烫发，剪发让总监设计还是首席总监设计还是国际总监设计？不做一个护理么今天打八折。不买个洗发用品么？\"恩，确实挺恐怖！","created_at":"2017-01-06 10:50:58","id":"1132823470"}]
     * alt : https://movie.douban.com/subject/26865690/
     * id : 26865690
     * mobile_url : https://movie.douban.com/subject/26865690/mobile
     * photos_count : 27
     * pubdate : 2017-01-06
     * title : 恐怖理发店
     * do_count : null
     * has_video : true
     * share_url : http://m.douban.com/movie/subject/26865690
     * seasons_count : null
     * languages : ["汉语普通话"]
     * schedule_url :
     * writers : [{"avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"","name":"纪然","alt":"https://movie.douban.com/celebrity/1366595/","id":"1366595"},{"avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490348628.29.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490348628.29.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490348628.29.jpg"},"name_en":"Shilei Lu","name":"陆诗雷","alt":"https://movie.douban.com/celebrity/1360707/","id":"1360707"}]
     * pubdates : ["2017-01-06(中国大陆)"]
     * website :
     * tags : ["惊悚","烂片","一个星都不想给！","烂片之中的烂片啊~","垃圾","呵呵","中国","狗屎","真的好恐怖啊！","烂透了"]
     * has_schedule : false
     * durations : ["89分钟"]
     * genres : ["爱情","悬疑","惊悚"]
     * collection : null
     * trailers : [{"medium":"http://img3.doubanio.com/img/trailer/medium/2395934439.jpg?","title":"预告片：正式版 (中文字幕)","subject_id":"26865690","alt":"https://movie.douban.com/trailer/206905/","small":"http://img3.doubanio.com/img/trailer/small/2395934439.jpg?","resource_url":"http://vt1.doubanio.com/201801251609/f2cd87f982918f00b758907107341fd6/view/movie/M/302060905.mp4","id":"206905"},{"medium":"http://img3.doubanio.com/img/trailer/medium/2408079427.jpg?","title":"预告片：终极版 (中文字幕)","subject_id":"26865690","alt":"https://movie.douban.com/trailer/209536/","small":"http://img3.doubanio.com/img/trailer/small/2408079427.jpg?","resource_url":"http://vt1.doubanio.com/201801251609/cc74bb2030cd6842a04e82cd86770855/view/movie/M/302090536.mp4","id":"209536"},{"medium":"http://img3.doubanio.com/img/trailer/medium/2406384532.jpg?","title":"预告片：激情版 (中文字幕)","subject_id":"26865690","alt":"https://movie.douban.com/trailer/209076/","small":"http://img3.doubanio.com/img/trailer/small/2406384532.jpg?","resource_url":"http://vt1.doubanio.com/201801251609/08a40ab5d7c5fe2927cf95c257880eba/view/movie/M/302090076.mp4","id":"209076"}]
     * episodes_count : null
     * trailer_urls : ["http://vt1.doubanio.com/201801251609/f2cd87f982918f00b758907107341fd6/view/movie/M/302060905.mp4","http://vt1.doubanio.com/201801251609/cc74bb2030cd6842a04e82cd86770855/view/movie/M/302090536.mp4","http://vt1.doubanio.com/201801251609/08a40ab5d7c5fe2927cf95c257880eba/view/movie/M/302090076.mp4"]
     * has_ticket : false
     * bloopers : []
     * clip_urls : []
     * current_season : null
     * casts : [{"avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1403756298.69.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1403756298.69.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1403756298.69.jpg"},"name_en":"Guoer Yin","name":"殷果儿","alt":"https://movie.douban.com/celebrity/1340984/","id":"1340984"},{"avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"Qingan Ren","name":"任青安","alt":"https://movie.douban.com/celebrity/1359164/","id":"1359164"},{"avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451209491.55.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451209491.55.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451209491.55.jpg"},"name_en":"SungGoo Kang","name":"姜星丘","alt":"https://movie.douban.com/celebrity/1353667/","id":"1353667"},{"avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1478601324.49.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1478601324.49.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1478601324.49.jpg"},"name_en":"Jiamin Chen","name":"陈嘉敏","alt":"https://movie.douban.com/celebrity/1340988/","id":"1340988"}]
     * countries : ["中国大陆"]
     * mainland_pubdate : 2017-01-06
     * photos : [{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2411789693.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2411789693.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2411789693.jpg","alt":"https://movie.douban.com/photos/photo/2411789693/","id":"2411789693","icon":"http://img3.doubanio.com/view/photo/icon/public/p2411789693.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2406383762.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2406383762.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2406383762.jpg","alt":"https://movie.douban.com/photos/photo/2406383762/","id":"2406383762","icon":"http://img3.doubanio.com/view/photo/icon/public/p2406383762.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2411789707.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2411789707.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2411789707.jpg","alt":"https://movie.douban.com/photos/photo/2411789707/","id":"2411789707","icon":"http://img3.doubanio.com/view/photo/icon/public/p2411789707.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2411789702.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2411789702.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2411789702.jpg","alt":"https://movie.douban.com/photos/photo/2411789702/","id":"2411789702","icon":"http://img3.doubanio.com/view/photo/icon/public/p2411789702.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2408074732.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2408074732.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2408074732.jpg","alt":"https://movie.douban.com/photos/photo/2408074732/","id":"2408074732","icon":"http://img3.doubanio.com/view/photo/icon/public/p2408074732.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2408074723.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2408074723.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2408074723.jpg","alt":"https://movie.douban.com/photos/photo/2408074723/","id":"2408074723","icon":"http://img3.doubanio.com/view/photo/icon/public/p2408074723.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2408074715.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2408074715.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2408074715.jpg","alt":"https://movie.douban.com/photos/photo/2408074715/","id":"2408074715","icon":"http://img3.doubanio.com/view/photo/icon/public/p2408074715.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2406383761.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2406383761.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2406383761.jpg","alt":"https://movie.douban.com/photos/photo/2406383761/","id":"2406383761","icon":"http://img3.doubanio.com/view/photo/icon/public/p2406383761.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2406383759.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2406383759.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2406383759.jpg","alt":"https://movie.douban.com/photos/photo/2406383759/","id":"2406383759","icon":"http://img3.doubanio.com/view/photo/icon/public/p2406383759.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2395927790.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2395927790.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2395927790.jpg","alt":"https://movie.douban.com/photos/photo/2395927790/","id":"2395927790","icon":"http://img3.doubanio.com/view/photo/icon/public/p2395927790.jpg"}]
     * summary : 位于深山小镇的理发店发生的一系列灵异奇闻，殷果儿、任青安、姜星丘等人陷入危难绝境中无法脱身，和理发店有关联的人物接连被惨绝杀害，血腥残暴引来人心惶惶，而抽丝剥茧之后的真相更加令人心惊胆战。
     * clips : []
     * subtype : movie
     * directors : [{"avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490348628.29.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490348628.29.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490348628.29.jpg"},"name_en":"Shilei Lu","name":"陆诗雷","alt":"https://movie.douban.com/celebrity/1360707/","id":"1360707"}]
     * comments_count : 287
     * popular_reviews : [{"rating":{"max":5,"value":1,"min":0},"title":"国产恐怖片，注定成烂片？","subject_id":"26865690","author":{"uid":"123404248","avatar":"http://img3.doubanio.com/icon/u123404248-3.jpg","signature":"","alt":"http://www.douban.com/people/123404248/","id":"123404248","name":"世界奇妙物语"},"summary":"这一系列国产恐怖片太多，现在总结下国产电影拍摄门槛为什么这么低\u2026\u2026 1.找个导演，内地导演优先考虑(省钱)。 2.去网上热搜榜（也是经纪公司）上挑几个网红明星（省钱）。网红明星就像木偶一样被装扮上了。 3.去...","alt":"https://movie.douban.com/review/8301338/","id":"8301338"},{"rating":{"max":5,"value":1,"min":0},"title":"2017年1月14日","subject_id":"26865690","author":{"uid":"106658069","avatar":"http://img3.doubanio.com/icon/u106658069-3.jpg","signature":"","alt":"http://www.douban.com/people/106658069/","id":"106658069","name":"白安"},"summary":"小萌说要去看，从头到尾全是槽点，这剧本无论怎么拍都不会好了\u2026怪不得邓sir对我写的鬼故事如此有信心，因为大家都是这水平吗\u2026 不过老实说，这个编剧犯的错误我也犯过：故事和线索不集中。写《杀人犯》的时候，...","alt":"https://movie.douban.com/review/8823383/","id":"8823383"},{"rating":{"max":5,"value":1,"min":0},"title":"导演别拍电影了，快回家陪你父母，不然小心他们扮鬼吓你！","subject_id":"26865690","author":{"uid":"BIANJU20170418","avatar":"http://img3.doubanio.com/icon/u82851721-3.jpg","signature":"","alt":"http://www.douban.com/people/BIANJU20170418/","id":"82851721","name":"游侠一笑"},"summary":"《恐怖游泳馆》、《恐怖电影院》，恐怖厕所、恐怖你妈隔壁，继\u201c诡\u201d、\u201c惊魂\u201d、\u201c灵\u201d、\u201c怨\u201d后，国产可怕片的片名誓要在\u201c恐怖\u201d路上走到底。  一连看了三部菲尔幕出品的国产恐怖片，这也够恐怖的，还是那句...","alt":"https://movie.douban.com/review/8578229/","id":"8578229"},{"rating":{"max":5,"value":1,"min":0},"title":"差到不行","subject_id":"26865690","author":{"uid":"158559795","avatar":"http://img3.doubanio.com/icon/user_normal.jpg","signature":"","alt":"http://www.douban.com/people/158559795/","id":"158559795","name":"依旧箜絔"},"summary":"真的很烂 很烂 成了喜剧 如果评论涉及电影和小说的结局和关键情节，请勾选「有关键情节透露」，豆瓣将显示提示，以免没有看过的人扫兴。  为了尊重创作者的劳动，请不要转载他人文章或提供下载信息。豆瓣鼓励有益...","alt":"https://movie.douban.com/review/8394178/","id":"8394178"},{"rating":{"max":5,"value":1,"min":0},"title":"老套路没创意","subject_id":"26865690","author":{"uid":"149343489","avatar":"http://img3.doubanio.com/icon/u149343489-1.jpg","signature":"","alt":"http://www.douban.com/people/149343489/","id":"149343489","name":"🗿"},"summary":"烂片 嘈点太多了好吗 前面刚开始有鬼出现 后面大部分都是情感戏 最后结果又是人为扮鬼 很多现象也是无法解释的 电为什么说停就停 为什么里面的人可以轻松找到模特厘米的代号？ 每个人那么容易认出自己的手掌印 ？...","alt":"https://movie.douban.com/review/8278482/","id":"8278482"},{"rating":{"max":5,"value":1,"min":0},"title":"?","subject_id":"26865690","author":{"uid":"154276285","avatar":"http://img3.doubanio.com/icon/u154276285-1.jpg","signature":"","alt":"http://www.douban.com/people/154276285/","id":"154276285","name":"👧"},"summary":"超级烂片，让她爹玩一宿，预告片剪辑不错，此片看完预告片即可，看了多余，漏洞百出，穿帮镜头无数，无厘头到了极致。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。...","alt":"https://movie.douban.com/review/8278145/","id":"8278145"},{"rating":{"max":5,"value":4,"min":0},"title":"《恐怖理发店》：青丝犹在，魂魄已飞","subject_id":"26865690","author":{"uid":"41576647","avatar":"http://img3.doubanio.com/icon/user_normal.jpg","signature":"","alt":"http://www.douban.com/people/41576647/","id":"41576647","name":"丑鱼尼莫"},"summary":"《恐怖理发店》讲述的是一个发生在理发店的灵异事件，而灵异的背后，总有一些说不清道不明的真相在作祟。但是，当真相一点点水落石出的时候，又总会叫人心悸、惊厥，毛骨悚然，不寒而栗的感觉也悄上心头。  荒山...","alt":"https://movie.douban.com/review/8239886/","id":"8239886"},{"rating":{"max":5,"value":4,"min":0},"title":"Word天呀！以后再也不敢去理发店了","subject_id":"26865690","author":{"uid":"70359207","avatar":"http://img3.doubanio.com/icon/u70359207-8.jpg","signature":"百度百家、今日头条作家、影评人","alt":"http://www.douban.com/people/70359207/","id":"70359207","name":"大侃"},"summary":"  惊悚、恐怖类的影片，每周都在影院里现身，不但有固定的消费群体和受众，还时不时灵光一闪在票房上创出佳绩，《恐怖游泳馆》、《床下有人》、《枕边有张脸》等都是其中的代表。当下，观众的欣赏口味不断提升，...","alt":"https://movie.douban.com/review/8239440/","id":"8239440"},{"rating":{"max":5,"value":4,"min":0},"title":"美发洗浴杀人一条龙服务","subject_id":"26865690","author":{"uid":"2466058","avatar":"http://img3.doubanio.com/icon/u2466058-2.jpg","signature":"","alt":"http://www.douban.com/people/2466058/","id":"2466058","name":"乌鸦电影"},"summary":"理发店能出什么幺蛾子？还能搞出点旁门左道不成？这部《恐怖理发店》实则让人产生好奇。   理发店如今是泛泛地称谓，客人到里面可不止理发，还包括美容美发、运气好了还可以遇到一条龙服务。当然，无论你是什么人...","alt":"https://movie.douban.com/review/8240666/","id":"8240666"},{"rating":{"max":5,"value":4,"min":0},"title":"乡村人皮客栈玩转猎杀游戏","subject_id":"26865690","author":{"uid":"renlyuan","avatar":"http://img3.doubanio.com/icon/u63738807-3.jpg","signature":"爱看电影","alt":"http://www.douban.com/people/renlyuan/","id":"63738807","name":"铁任的电影笔记"},"summary":"贺岁大战已经打响，媒体都在聚焦《长城》《西游伏妖篇》这样的大阵仗，而历史的经验告诉我们，期待越高往往会失望越大，雷声大的未必下雨点，，反倒是在并不起眼的地方，往往潜伏着未预料的宝藏。果然，我们等到...","alt":"https://movie.douban.com/review/8239441/","id":"8239441"}]
     * ratings_count : 592
     * aka : ["Ghost in Barber's"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String original_title;
    private int collect_count;
    private MovieImage images;
    private String douban_site;
    private String year;
    private String alt;
    private String id;
    private String mobile_url;
    private int photos_count;
    private String pubdate;
    private String title;
    private Object do_count;
    private boolean has_video;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private String website;
    private boolean has_schedule;
    private Object collection;
    private Object episodes_count;
    private boolean has_ticket;
    private Object current_season;
    private String mainland_pubdate;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<MovieVideo> videos;
    private List<MovieComment> popular_comments;
    private List<String> languages;
    private List<MoviePerson> writers;
    private List<String> pubdates;
    private List<String> tags;
    private List<String> durations;
    private List<String> genres;
    private List<MovieTrailer> trailers;
    private List<String> trailer_urls;
    private List<MoviePerson> casts;
    private List<String> countries;
    private List<MovieImage> photos;
    private List<?> clips;
    private List<MoviePerson> directors;
    private List<MovieComment> popular_reviews;
    private List<String> aka;

    @Override
    public int getItemType() {
        if(itemtype==0){
            return AdapterConstant.ITME_MOVIE_DEFAULT;
        }
        return itemtype;
    }

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public MovieImage getImages() {
        return images;
    }

    public void setImages(MovieImage images) {
        this.images = images;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public int getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(int photos_count) {
        this.photos_count = photos_count;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isHas_schedule() {
        return has_schedule;
    }

    public void setHas_schedule(boolean has_schedule) {
        this.has_schedule = has_schedule;
    }

    public Object getCollection() {
        return collection;
    }

    public void setCollection(Object collection) {
        this.collection = collection;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public boolean isHas_ticket() {
        return has_ticket;
    }

    public void setHas_ticket(boolean has_ticket) {
        this.has_ticket = has_ticket;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<MovieVideo> getVideos() {
        return videos;
    }

    public void setVideos(List<MovieVideo> videos) {
        this.videos = videos;
    }

    public List<MovieComment> getPopular_comments() {
        return popular_comments;
    }

    public void setPopular_comments(List<MovieComment> popular_comments) {
        this.popular_comments = popular_comments;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<MoviePerson> getWriters() {
        return writers;
    }

    public void setWriters(List<MoviePerson> writers) {
        this.writers = writers;
    }

    public List<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(List<String> pubdates) {
        this.pubdates = pubdates;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<MovieTrailer> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<MovieTrailer> trailers) {
        this.trailers = trailers;
    }

    public List<String> getTrailer_urls() {
        return trailer_urls;
    }

    public void setTrailer_urls(List<String> trailer_urls) {
        this.trailer_urls = trailer_urls;
    }

    public List<MoviePerson> getCasts() {
        return casts;
    }

    public void setCasts(List<MoviePerson> casts) {
        this.casts = casts;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<MovieImage> getPhotos() {
        return photos;
    }

    public void setPhotos(List<MovieImage> photos) {
        this.photos = photos;
    }

    public List<?> getClips() {
        return clips;
    }

    public void setClips(List<?> clips) {
        this.clips = clips;
    }

    public List<MoviePerson> getDirectors() {
        return directors;
    }

    public void setDirectors(List<MoviePerson> directors) {
        this.directors = directors;
    }

    public List<MovieComment> getPopular_reviews() {
        return popular_reviews;
    }

    public void setPopular_reviews(List<MovieComment> popular_reviews) {
        this.popular_reviews = popular_reviews;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean extends BaseItem{
        /**
         * max : 10
         * average : 2.4
         * details : {"1":71,"3":3,"2":5,"5":1,"4":0}
         * stars : 15
         * min : 0
         */

        private int max;
        private float average;
        private DetailsBean details;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public float getAverage() {
            return average;
        }

        public void setAverage(float average) {
            this.average = average;
        }

        public DetailsBean getDetails() {
            return details;
        }

        public void setDetails(DetailsBean details) {
            this.details = details;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public static class DetailsBean extends BaseItem{
            /**
             * 1 : 71.0
             * 3 : 3.0
             * 2 : 5.0
             * 5 : 1.0
             * 4 : 0.0
             */

            @SerializedName("1")
            private double _$1;
            @SerializedName("3")
            private double _$3;
            @SerializedName("2")
            private double _$2;
            @SerializedName("5")
            private double _$5;
            @SerializedName("4")
            private double _$4;

            public double get_$1() {
                return _$1;
            }

            public void set_$1(double _$1) {
                this._$1 = _$1;
            }

            public double get_$3() {
                return _$3;
            }

            public void set_$3(double _$3) {
                this._$3 = _$3;
            }

            public double get_$2() {
                return _$2;
            }

            public void set_$2(double _$2) {
                this._$2 = _$2;
            }

            public double get_$5() {
                return _$5;
            }

            public void set_$5(double _$5) {
                this._$5 = _$5;
            }

            public double get_$4() {
                return _$4;
            }

            public void set_$4(double _$4) {
                this._$4 = _$4;
            }
        }
    }


}
