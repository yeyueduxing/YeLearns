package com.yeyue.learns.ui.gank.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.R;
import com.yeyue.learns.contract.GankDayContract;
import com.yeyue.learns.di.component.DaggerGankDayComponent;
import com.yeyue.learns.di.module.GankDayModule;
import com.yeyue.learns.presenter.GankDayPresenter;
import com.yeyue.learns.ui.main.adapter.CommonListAdapter;
import com.yeyue.library.base.YeRecyFragment;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.widgets.percent.PercentRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class GankDayFragment extends YeRecyFragment<BaseItem, GankDayPresenter> implements GankDayContract.View<BaseItem>, CalendarView.OnDateSelectedListener, CalendarView.OnYearChangeListener {


    @BindView(R.id.calendarView)
    CalendarView calendarView;
    @BindView(R.id.tv_month_day)
    TextView tvMonthDay;
    @BindView(R.id.tv_year)
    TextView tvYear;
    @BindView(R.id.tv_lunar)
    TextView tvLunar;
    @BindView(R.id.ib_calendar)
    ImageView ibCalendar;
    @BindView(R.id.tv_current_day)
    TextView tvCurrentDay;
    @BindView(R.id.fl_current)
    FrameLayout flCurrent;
    @BindView(R.id.rl_tool)
    RelativeLayout rlTool;
    @BindView(R.id.recyLayout)
    PercentRelativeLayout recyLayout;
    private int year;
    private int month;
    private int day;

    public static GankDayFragment newInstance() {
        GankDayFragment fragment = new GankDayFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerGankDayComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .gankDayModule(new GankDayModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_gank_day;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        tvMonthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.showSelectLayout(year);
                tvLunar.setVisibility(View.GONE);
                tvYear.setVisibility(View.GONE);
                tvMonthDay.setText(String.valueOf(year));
            }
        });
        flCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.scrollToCurrent();
            }
        });

        calendarView.setOnYearChangeListener(this);
        calendarView.setOnDateSelectedListener(this);
        tvYear.setText(String.valueOf(calendarView.getCurYear()));
        year = calendarView.getCurYear();
        tvMonthDay.setText(calendarView.getCurMonth() + "月" + calendarView.getCurDay() + "日");
        tvLunar.setText("今日");
        tvCurrentDay.setText(String.valueOf(calendarView.getCurDay()));
        calendarView.setOnDateSelectedListener(this);
        mPresenter.getGankIoHistory();
        mPresenter.getDay(calendarView.getCurYear(), calendarView.getCurMonth(), calendarView.getCurDay());
    }

    private Calendar getSchemeCalendar(int year, int month, int day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        return calendar;
    }

    @Override
    protected void initData() {

    }

    /**
     * 此方法是让外部调用使fragment做一些操作的,比如说外部的activity想让fragment对象执行一些方法,
     * 建议在有多个需要让外界调用的方法时,统一传Message,通过what字段,来区分不同的方法,在setData
     * 方法中就可以switch做不同的操作,这样就可以用统一的入口方法做不同的事
     * <p>
     * 使用此方法时请注意调用时fragment的生命周期,如果调用此setData方法时onCreate还没执行
     * setData里却调用了presenter的方法时,是会报空的,因为dagger注入是在onCreated方法中执行的,然后才创建的presenter
     * 如果要做一些初始化操作,可以不必让外部调setData,在initData中初始化就可以了
     *
     * @param data
     */

    @Override
    public void setData(Object data) {

    }

    @Override
    public boolean enableRefresh() {
        return false;
    }

    @Override
    public boolean enableMore() {
        return false;
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

    }

    @Override
    public boolean isToolbar() {
        return false;
    }

    @Override
    public void onDataRefresh() {
        mPresenter.getDay(year, month, day);
    }

    @Override
    public void onDataLoadMore() {
        mPresenter.getDay(year, month, day);
    }

    @Override
    public BaseQuickAdapter<BaseItem, BaseViewHolder> getAdapter() {
        return new CommonListAdapter(new ArrayList());
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    @Override
    public void killMyself() {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public View getLoadView() {
        return null;
    }

    @Override
    public void initCalendar(List<Calendar> calendars) {
        if (calendars != null) {
            calendarView.setSchemeDate(calendars);
        }
    }

    @Override
    public void onYearChange(int i) {
        tvMonthDay.setText(String.valueOf(year));
    }

    @Override
    public void onDateSelected(Calendar calendar, boolean isClick) {
        if (year == calendar.getYear() && month == calendar.getMonth() && day == calendar.getDay()) {
            return;
        }
        tvLunar.setVisibility(View.VISIBLE);
        tvYear.setVisibility(View.VISIBLE);
        tvMonthDay.setText(calendar.getMonth() + "月" + calendar.getDay() + "日");
        tvYear.setText(String.valueOf(calendar.getYear()));
        tvLunar.setText(calendar.getLunar());
        year = calendar.getYear();
        year = calendar.getYear();
        month = calendar.getMonth();
        day = calendar.getDay();
        if (isClick) {
            mPresenter.getDay(calendar.getYear(), calendar.getMonth(), calendar.getDay());
        }
    }

}
