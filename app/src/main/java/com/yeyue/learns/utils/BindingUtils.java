package com.yeyue.learns.utils;

import android.app.Activity;
import android.view.View;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.CMFragment;
import com.yeyue.learns.enity.bizhi.BizhiAlbumBean;
import com.yeyue.learns.enity.bizhi.BizhiBean;
import com.yeyue.learns.enity.bizhi.DetailBean;
import com.yeyue.learns.enity.bizhi.GankBean;
import com.yeyue.learns.enity.bizhi.LiveBean;
import com.yeyue.learns.enity.bizhi.UserBean;
import com.yeyue.learns.enity.bizhi.VerCategory;
import com.yeyue.learns.enity.bizhi.VideoBean;
import com.yeyue.learns.enity.bizhi.VideoCategory;
import com.yeyue.learns.enity.bizhi.WalCategory;
import com.yeyue.learns.enity.diycode.DiyNew;
import com.yeyue.learns.enity.diycode.DiySite;
import com.yeyue.learns.enity.diycode.DiyTopic;
import com.yeyue.learns.enity.diycode.DiyUser;
import com.yeyue.learns.enity.gamersky.GamerSkyBean;
import com.yeyue.learns.enity.gank.GankData;
import com.yeyue.learns.enity.movie.MovieBean;
import com.yeyue.learns.enity.movie.MovieComment;
import com.yeyue.learns.enity.movie.MovieCount;
import com.yeyue.learns.enity.movie.MovieImage;
import com.yeyue.learns.enity.movie.MoviePerson;
import com.yeyue.learns.enity.wechat.WeChat;
import com.yeyue.learns.ui.gamersky.activity.GamerSkyWebActivity;
import com.yeyue.library.base.YeWebActivity;
import com.yeyue.library.widgets.viewbigimage.ViewBigImageActivity;

/**
  *@describe
  *@author li.xiao
  *@time 2017-11-2 13:59
  */
public class BindingUtils {
    public static void openDiyTopic(View view, DiyTopic diyTopic){
        if(diyTopic!=null && view!=null){
            ActivityUtils.openDiyTopDetailActivity((Activity) view.getContext(),diyTopic);
        }
    }
    public static void openDiyTopicNode(View view, DiyTopic diyTopic){
        if(diyTopic!=null && view!=null){
            CMFragment cmFragment = new CMFragment();
            cmFragment.setType(Constant.DIYCODE_TOPIC_NODE);
            cmFragment.setExtend(diyTopic.getNode_id()+"");
            cmFragment.setTitle(diyTopic.getNode_name());
            ActivityUtils.openCommonFragmentActivity((Activity) view.getContext(),cmFragment);
        }
    }
    public static void openDiyNew(View view, DiyNew diyNew){
        if(diyNew!=null && view!=null){
            YeWebActivity.loadUrl(view.getContext(),diyNew.getAddress(),diyNew.getTitle());
        }
    }
    public static void openDiySite(View view, DiySite diyNew){
        if(diyNew!=null && view!=null){
            YeWebActivity.loadUrl(view.getContext(),diyNew.getUrl(),diyNew.getName());
        }
    }
    public static void openDiyUser(View view, DiyUser diyUser){
        if(diyUser!=null && view!=null){
            ActivityUtils.openDiyUserActivity((Activity) view.getContext(),diyUser);
        }
    }
    public static void openGankFuli(View view, GankData gankData){
        if(gankData!=null && view!=null){
            ViewBigImageActivity.openImageSingleActivity((Activity) view.getContext(),gankData.getUrl());
        }
    }
    public static void openGankData(View view, GankData gankData){
        if(gankData!=null && view!=null){
            YeWebActivity.loadUrl((Activity) view.getContext(),gankData.getUrl(),gankData.getDesc());
        }
    }
    public static void openGankType(View view, GankData gankData){
        if(gankData!=null && view!=null){
            CMFragment cmFragment = new CMFragment();
            cmFragment.setType(Constant.Gank_DATA_TYPE);
            cmFragment.setExtend(gankData.getType()+"");
            cmFragment.setTitle(gankData.getType());
            ActivityUtils.openCommonFragmentActivity((Activity) view.getContext(),cmFragment);
        }
    }

    public static void openWeChat(View view, WeChat diyNew){
        if(diyNew!=null && view!=null){
            YeWebActivity.loadUrl(view.getContext(),diyNew.getUrl(),diyNew.getTitle());
        }
    }

    public static void openGamerSkyBean(View view, GamerSkyBean gamerSkyBean){
        if(gamerSkyBean!=null && view!=null){
            String url = Constant.Domain.GAMERSKY_URL+"/v1/ContentDetail/"+gamerSkyBean.getContentId()+"/1";
            GamerSkyWebActivity.loadUrl(view.getContext(),url,gamerSkyBean.getTitle());
        }
    }

    public static void openMovieBean(View view, MovieBean movieBean){
        if(movieBean!=null && view!=null){
            ActivityUtils.openMovieDetailActivity((Activity) view.getContext(),movieBean);
        }
    }

    public static void openMoviePerson(View view, MoviePerson person){
        if(person!=null && view!=null){
            ActivityUtils.openMovieCelebrityActivity((Activity) view.getContext(),person);
        }
    }

    public static void openMovieImage(View view, MovieImage item){
        if(item!=null && view!=null){
            ViewBigImageActivity.openImageSingleActivity((Activity) view.getContext(),item.getCover());
        }
    }
    public static void openMovieCommentDefault(View view, MovieComment item){
        if(item!=null && view!=null){
            //ActivityUtils.openMovieFragmentActivity((Activity) view.getContext(),Constant.MOVIE_COMMENT_DEFAULT,item.getSubject_id());
        }
    }
    public static void openMovieCommentReview(View view, MovieComment item){
        if(item!=null && view!=null){
            String url = "https://movie.douban.com/review/"+item.getId()+"/";
            YeWebActivity.loadUrl(view.getContext(),url,item.getTitle());
        }
    }
    public static void openDouBanPeople(View view, String userId,String name){
        if(userId!=null && view!=null){
            String url = "    https://m.douban.com/people/"+userId+"/";
            YeWebActivity.loadUrl(view.getContext(),url,name);
        }
    }
    public static void openMovieCount(View view, MovieCount item){
        if(item!=null && view!=null){
            if(item!=null && item.getObject()!=null){
                if(item.getObject() instanceof MovieImage){
                    MovieImage image = (MovieImage) item.getObject();
                    ActivityUtils.openMovieFragmentActivity((Activity) view.getContext(),Constant.MOVIE_PHOTOS_LIST,image.getSubjectId());
                }else if(item.getObject() instanceof MovieComment){
                    MovieComment comment = (MovieComment) item.getObject();
                    if(comment.getItemType()== AdapterConstant.ITME_MOVIE_COMMENT_DEFAULT){
                        ActivityUtils.openMovieFragmentActivity((Activity) view.getContext(),Constant.MOVIE_COMMENT_DEFAULT,comment.getSubject_id());
                    }else{
                        ActivityUtils.openMovieFragmentActivity((Activity) view.getContext(),Constant.MOVIE_COMMENT_REVIEW,comment.getSubject_id());
                    }
                }
            }
        }
    }

    public static void openGankDetail(View view, GankBean gankBean){
        if(gankBean!=null && view!=null){
            String url = gankBean.getUrl();
            if("福利".equals(gankBean.getType())){
                ViewBigImageActivity.openImageSingleActivity((Activity) view.getContext(),url);
            }else{
                YeWebActivity.loadUrl(view.getContext(),url,gankBean.getDesc());
            }
        }
    }

    public static void oepnBizhiDetail(View view, BizhiBean bizhiBean, int type){
        if(bizhiBean!=null && view!=null && view.getContext()!=null && view.getContext() instanceof Activity){
            DetailBean detailBean = new DetailBean();
            if(bizhiBean.getUser()==null){
                UserBean userBean = new UserBean();
                userBean.setName("一念夕雾");
                userBean.setAvatar("http://img0.adesk.com/download/59cf77ec0422085f6f76f58d");
                userBean.setId("5965cd0be7bce7312ef79fbf");
                detailBean.setUser(userBean);
            }else{
                detailBean.setUser(bizhiBean.getUser());
            }
            detailBean.setId(bizhiBean.getId());
            detailBean.setCover(bizhiBean.getPreview());
            detailBean.setThumb(bizhiBean.getThumb());
            detailBean.setRank(bizhiBean.getRank());
            detailBean.setFavs(bizhiBean.getFavs());
            detailBean.setType(type);
            ActivityUtils.openDetailActivity((Activity) view.getContext(),detailBean);
        }
    }

    public static void oepnLiveDetail(View view, LiveBean liveBean){
        if(liveBean!=null && view!=null && view.getContext()!=null && view.getContext() instanceof Activity){
            DetailBean detailBean = new DetailBean();
            UserBean userBean = new UserBean();
            userBean.setName("一念夕雾");
            userBean.setAvatar("http://img0.adesk.com/download/59cf77ec0422085f6f76f58d");
            userBean.setId("5965cd0be7bce7312ef79fbf");
            detailBean.setId(liveBean.getId());
            detailBean.setUser(userBean);
            detailBean.setCover(liveBean.getPreview());
            detailBean.setThumb(liveBean.getPreview());
            detailBean.setRank(liveBean.getRank());
            detailBean.setFavs(liveBean.getFavs());
            detailBean.setType(2);
            ActivityUtils.openDetailActivity((Activity) view.getContext(),detailBean);
        }
    }
    public static void openDayRecommendActivity(View view){
        if( view!=null && view.getContext()!=null && view.getContext() instanceof Activity){
            ActivityUtils.openDayRecommendActivity((Activity) view.getContext());
        }
    }

    public static void openCategoryActivity(View view, WalCategory.CategoryBean categoryBean){
        if( view!=null  && categoryBean!=null && view.getContext()!=null && view.getContext() instanceof Activity){
            ActivityUtils.openCategoryActivity((Activity) view.getContext(),categoryBean);
        }
    }
    public static void openCategoryActivity(View view, VerCategory categoryBean){
        if( view!=null  && categoryBean!=null && view.getContext()!=null && view.getContext() instanceof Activity){
            ActivityUtils.openCategoryActivity((Activity) view.getContext(),categoryBean);
        }
    }
    public static void openCategoryActivity(View view, VideoCategory videoCategory){
        if( view!=null  && videoCategory!=null && view.getContext()!=null && view.getContext() instanceof Activity){
            ActivityUtils.openCategoryActivity((Activity) view.getContext(),videoCategory);
        }
    }
    public static void openAlbumDetailActivity(View view, BizhiAlbumBean albumBean){
        if( view!=null  && albumBean!=null && view.getContext()!=null && view.getContext() instanceof Activity){
            ActivityUtils.openAlbumDetailActivity((Activity) view.getContext(),albumBean);
        }
    }

    public static void oepnVideoDetail(View view, VideoBean videoBean){
        if( view!=null  && videoBean!=null && view.getContext()!=null && view.getContext() instanceof Activity){
            ActivityUtils.openVideoDetailActivity((Activity) view.getContext(),videoBean);
            //ViewBigImageActivity.openImageSingleActivity((Activity) view.getContext(),videoBean.getView_video());
        }
    }
    public static void openUserBean(View view, UserBean item){
        if( view!=null  && item!=null && view.getContext()!=null && view.getContext() instanceof Activity){
            ActivityUtils.openUserActivity((Activity) view.getContext(),item);
        }
    }
    public static void openBizhiHomeTag(View view, int type){
        if( view!=null   && view.getContext()!=null && view.getContext() instanceof Activity){
            switch (type){
                case 2:
                    ActivityUtils.openCategoryActivity((Activity) view.getContext(),Constant.BIZHI_HOME_TAG_GIRL);
                    break;
                case 3:
                    ActivityUtils.openCategoryActivity((Activity) view.getContext(),Constant.BIZHI_HOME_TAG_ANIMATION);
                    break;
                default:
                    ActivityUtils.openCategoryActivity((Activity) view.getContext(),Constant.BIZHI_HOME_TAG_GIRL);
                    break;
            }
        }
    }
}
