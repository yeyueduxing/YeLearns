package com.yeyue.library.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.SeekBarPreference;
import android.support.v7.preference.SwitchPreferenceCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SPUtils;
import com.jess.arms.base.delegate.IFragment;
import com.jess.arms.integration.cache.Cache;
import com.jess.arms.integration.cache.CacheType;
import com.jess.arms.integration.lifecycle.FragmentLifecycleable;
import com.jess.arms.mvp.IPresenter;
import com.jess.arms.utils.ArmsUtils;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.yeyue.library.R;
import com.yeyue.library.constant.YeConstant;

import java.lang.reflect.Field;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

/**
 * @author li.xiao
 * @describe 通用设置界面
 * @time 2017-12-26 14:10
 */
public abstract class YeSettingFragment<P extends IPresenter> extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener, IFragment, FragmentLifecycleable {

    protected final String TAG = this.getClass().getSimpleName();
    private final BehaviorSubject<FragmentEvent> mLifecycleSubject = BehaviorSubject.create();
    private Cache<String, Object> mCache;
    @Inject
    protected P mPresenter;


    @NonNull
    @Override
    public final Subject<FragmentEvent> provideLifecycleSubject() {
        return mLifecycleSubject;
    }

    public YeSettingFragment() {
        //必须确保在Fragment实例化时setArguments()
        setArguments(new Bundle());
    }


    @NonNull
    @Override
    public synchronized Cache<String, Object> provideCache() {
        if (mCache == null) {
            mCache = ArmsUtils.obtainAppComponentFromContext(getActivity()).cacheFactory().build(CacheType.FRAGMENT_CACHE);
        }
        return mCache;
    }

    /**
     * 初始化配置文件
     * @return
     */
    public abstract int inflateMenu();

    /**
     * 点击监听
     * @param preference
     */
    public abstract void onItemClick(Preference preference);

    /**
     * 动态添加子节点
     * @return
     */
    public abstract List<Preference> getAddPreferences();

    /**
     * 自定义界面UI
     * @return
     */
    public abstract int getContentViewId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //使用反射修改设置页的界面资源
        // 得到私有字段
        if (getContentViewId() != 0) {
            Field privateStringField = null;
            try {
                privateStringField = PreferenceFragmentCompat.class.getDeclaredField("mLayoutResId");
                // 通过反射设置私有对象可以访问
                privateStringField.setAccessible(true);
                // 从父类中得到对象，并强制转换为想要的对象
                int fieldValue = (int) privateStringField.get(this);
                // 将私有对象设置为新的值
                privateStringField.set(this, getContentViewId());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        // Load the Preferences from the XML file
        addPreferencesFromResource(inflateMenu());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //获取配置文件Screen
        //遍历获取
        PreferenceScreen screen = getPreferenceScreen();
        if (getAddPreferences() != null && getAddPreferences().size() > 0) {
            for (int i = 0; i < getAddPreferences().size(); i++) {
                screen.addPreference(getAddPreferences().get(i));
            }
        }
        initPreferenceView(screen);

    }

    protected int getItemLayoutResId() {
        return R.layout.yeyue_preference_item;
    }

    protected int getGroupLayoutResId() {
        return R.layout.yeyue_preference_category;
    }

    protected int getSeekBarLayoutResId() {
        return R.layout.yeyue_preference_widget_seekbar;
    }

    protected void initPreferenceView(PreferenceGroup group) {
        int preferenceCount = group.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            Preference preference = group.getPreference(i);
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup groupPreference = ((PreferenceGroup) preference);
                if (getGroupLayoutResId() != 0) {
                    groupPreference.setLayoutResource(getGroupLayoutResId());
                }
                initPreferenceView(groupPreference);
            } else {
                if (preference instanceof SeekBarPreference && getSeekBarLayoutResId() != 0) {
                    preference.setLayoutResource(getSeekBarLayoutResId());
                } else if (getItemLayoutResId() != 0) {
                    preference.setLayoutResource(getItemLayoutResId());
                }
                //设置默认值
                if (!ObjectUtils.isEmpty(preference.getKey())) {
                    initItemView(preference);
                }
                preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        onItemClick(preference);
                        return true;
                    }
                });
            }
        }
    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference = findPreference(key);
        initItemView(preference);
    }

    protected void initItemView(Preference preference) {
        if (preference != null) {
            if (preference instanceof EditTextPreference) {
                if (preference.getKey().equals(getActivity().getString(R.string.YeConsKey_NetRetryMax))) {
                    preference.setSummary("网络请求错误重试次数：" + SPUtils.getInstance(YeConstant.ShareP.SPNAME).getString(preference.getKey()));
                } else if (preference.getKey().equals(getActivity().getString(R.string.YeConsKey_NetRetryDelay))) {
                    preference.setSummary("网络请求间隔时间：" + SPUtils.getInstance(YeConstant.ShareP.SPNAME).getString(preference.getKey()));
                } else {
                    preference.setSummary(SPUtils.getInstance(YeConstant.ShareP.SPNAME).getString(preference.getKey()));
                }
            } else if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                preference.setSummary(listPreference.getEntry());
            } else if (preference instanceof CheckBoxPreference) {
            } else if (preference instanceof SeekBarPreference) {
            } else if (preference instanceof SwitchPreferenceCompat) {
            } else {
                preference.setSummary(SPUtils.getInstance(YeConstant.ShareP.SPNAME).getString(preference.getKey()));
            }
        }
    }

    /**
     * 解决嵌套滑动顿卡问题
     *
     * @param inflater
     * @param parent
     * @param savedInstanceState
     * @return
     */
    @Override
    public RecyclerView onCreateRecyclerView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        RecyclerView recyclerView = super.onCreateRecyclerView(inflater, parent, savedInstanceState);
        recyclerView.setNestedScrollingEnabled(false);
        return recyclerView;
    }

    @Override
    public void onStart() {
        super.onStart();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onDestroyView() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroyView();
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDestroy();//释放资源
        this.mPresenter = null;
    }

    /**
     * 是否使用eventBus,默认为使用(true)，
     *
     * @return
     */
    @Override
    public boolean useEventBus() {
        return true;
    }
}
