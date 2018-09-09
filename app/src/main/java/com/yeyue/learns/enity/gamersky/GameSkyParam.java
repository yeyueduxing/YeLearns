package com.yeyue.learns.enity.gamersky;

/**
 * Created by Administrator on 2018/1/14 0014.
 */

public class GameSkyParam {

    /**
     * os : android
     * app : GSAPP
     * osVersion : 7.0
     * deviceType : Mi-4c
     * appVersion : 3.5.2
     * deviceId : 869545024839585
     * request : {"nodeIds":"16","elementsCountPerPage":"20","parentNodeId":"news","type":"","pageIndex":"1"}
     */

    private String os = "android";
    private String app = "GSAPP";
    private String osVersion = "7.0";
    private String deviceType = "Mi-4c";
    private String appVersion = "3.5.2";
    private String deviceId = "869545024839585";
    private SkyPost request;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public SkyPost getRequest() {
        return request;
    }

    public void setRequest(SkyPost request) {
        this.request = request;
    }

    public static class SkyPost {
        /**
         * nodeIds : 16
         * elementsCountPerPage : 20
         * parentNodeId : news
         * type :
         * pageIndex : 1
         */

        private String nodeIds;
        private String elementsCountPerPage;
        private String parentNodeId;
        private String type;
        private String pageIndex;

        public String getNodeIds() {
            return nodeIds;
        }

        public void setNodeIds(String nodeIds) {
            this.nodeIds = nodeIds;
        }

        public String getElementsCountPerPage() {
            return elementsCountPerPage;
        }

        public void setElementsCountPerPage(String elementsCountPerPage) {
            this.elementsCountPerPage = elementsCountPerPage;
        }

        public String getParentNodeId() {
            return parentNodeId;
        }

        public void setParentNodeId(String parentNodeId) {
            this.parentNodeId = parentNodeId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(String pageIndex) {
            this.pageIndex = pageIndex;
        }
    }
}
