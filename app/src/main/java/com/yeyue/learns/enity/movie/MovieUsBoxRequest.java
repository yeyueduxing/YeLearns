package com.yeyue.learns.enity.movie;

import java.util.List;

/**
 * Created by li.xiao on 2018-1-29.
 */

public class MovieUsBoxRequest {

    private int count;
    private int start;
    private int total;
    private String title;
    private List<MovieUsBox> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MovieUsBox> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<MovieUsBox> subjects) {
        this.subjects = subjects;
    }

    public static class MovieUsBox{
        private int box;
        private int rank;
        private int delta;
        private MovieBean subject;

        public int getBox() {
            return box;
        }

        public void setBox(int box) {
            this.box = box;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public MovieBean getSubject() {
            return subject;
        }

        public void setSubject(MovieBean subject) {
            this.subject = subject;
        }

        public int getDelta() {
            return delta;
        }

        public void setDelta(int delta) {
            this.delta = delta;
        }
    }
}
