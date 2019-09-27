package com.baidu.mobstat;

import android.os.Build.VERSION;

public class Config {
    public static final String APPKEY_META_NAME = "BaiduMobAd_STAT_ID";
    public static final String APP_KEY = "k";
    public static final String APP_VERSION_CODE = "a";
    public static final String APP_VERSION_NAME = "n";
    public static final int APP_VERSION_NOT_INI_VALUE = -1;
    public static final long BPLUS_DELAY_TIME = 5000;
    public static final String CELL_LOCATION = "cl";
    public static final String CHANNEL = "c";
    public static final String CHANNEL_META_NAME = "BaiduMobAd_CHANNEL";
    public static final int CRASH_TYPE_JAVA = 0;
    public static final int CRASH_TYPE_NATIE = 1;
    public static final String CUID = "i";
    public static final String CUID_SEC = "ii";
    public static final String DEF_MAC_ID = "02:00:00:00:00:00";
    public static final String DEVICE_BLUETOOTH_MAC = "bm";
    public static final String DEVICE_HEIGHT = "h";
    public static final String DEVICE_ID = "d";
    public static final String DEVICE_ID_SEC = "dd";
    public static final String DEVICE_MAC_ID = "mc";
    public static final String DEVICE_NAME = "dn";
    public static final String DEVICE_WIDTH = "w";
    public static final String EVENT_AAC = "c";
    public static final String EVENT_AUTOTRACE = "at";
    public static final String EVENT_DURATION = "d";
    public static final String EVENT_EXT = "ext";
    public static final String EVENT_HIERARCHY = "h";
    public static final String EVENT_ID = "i";
    public static final String EVENT_LABEL = "l";
    public static final int EVENT_LIDU = 3600000;
    public static final String EVENT_PAGE = "p";
    public static final String EVENT_PART = "ev";
    public static final String EVENT_TIME = "t";
    public static final String EVENT_TIME_SEQUENCE = "s";
    public static final String EVENT_VIEW_TYPE = "v";
    public static final String EXCEPTION_CONTENT = "c";
    public static final String EXCEPTION_CRASH_TYPE = "ct";
    public static final String EXCEPTION_LOG_META_NAME = "BaiduMobAd_EXCEPTION_LOG";
    public static final String EXCEPTION_PART = "ex";
    public static final String EXCEPTION_TIME = "t";
    public static final String EXCEPTION_TYPE = "y";
    public static final String EXCEPTION_VERSION = "v";
    public static final String EXCEPT_FILE_NAME = "__local_except_cache.json";
    public static final int EXT_ITEM_LIMIT_BYTES = 1024;
    public static final String FEEDBACK_PART = "fe";
    public static final String GET_CELL_LOCATION = "BaiduMobAd_CELL_LOCATION";
    public static final String GET_GPS_LOCATION = "BaiduMobAd_GPS_LOCATION";
    public static final String GET_WIFI_LOCATION = "BaiduMobAd_WIFI_LOCATION";
    public static final String GPS_LOCATION = "gl";
    public static final String HEADER_EXT = "ext";
    public static final String HEADER_PART = "he";
    public static final String LAST_AP_INFO_FILE_NAME = "__local_ap_info_cache.json";
    public static final String LAST_SESSION_FILE_NAME = "__local_last_session.json";
    public static final String LINKED_WAY = "l";
    public static final String LOG_SEND_URL = (VERSION.SDK_INT < 9 ? LOG_SEND_URL_NOSSL : LOG_SEND_URL_SSL);
    public static final String LOG_SEND_URL_NOSSL = "http://hmma.baidu.com/app.gif";
    public static final String LOG_SEND_URL_SSL = "https://hmma.baidu.com/app.gif";
    public static final String MANUFACTURER = "ma";
    public static final int MAX_CACHE_JSON_CAPACITY = 204800;
    public static final int MAX_CACHE_JSON_CAPACIT_EXCEPTION = 5120;
    public static final long MAX_LOG_DATA_EXSIT_TIME = 604800000;
    public static final boolean MERGE_EVENT = true;
    public static final String MODEL = "m";
    public static final String NULL_DEVICE_ID = "000000000000000";
    public static final String ONLY_WIFI_META_NAME = "BaiduMobAd_ONLY_WIFI";
    public static final String OPERATOR = "op";

    /* renamed from: OS */
    public static final String f3050OS = "o";
    public static final String OS_SYSVERSION = "sv";
    public static final String OS_VERSION = "s";
    public static final String PACKAGE_NAME = "pn";
    public static final String PAGE_EXT = "ext";
    public static final String PLATFORM_TYPE = "pt";
    public static final String PREFIX_SEND_DATA = "__send_data_";
    public static final String PRINCIPAL_PART = "pr";
    public static final String PROCESS_CLASS = "scl";
    public static final String PROCESS_LABEL = "pl";
    public static final String RES_PREFIX = "__local_";
    public static final boolean SDK_ENABLE_MAC = true;
    public static final boolean SDK_FOR_MB_DEV = false;
    public static final boolean SDK_INTERNAL = false;
    public static final boolean SDK_RELEASE = true;
    public static final String SDK_TAG = "tg";
    public static final int SDK_TAG_VALUE = 1;
    public static final boolean SDK_WITH_AUTOTRACE = false;
    public static final int SDK_WITH_BPLUS = 2;
    public static final int SENDING_LOG_TIMER_PERIOD = 3600000;
    public static final String SEND_STRATEGY_META_NAME = "BaiduMobAd_SEND_STRATEGY";
    public static final String SEQUENCE_INDEX = "sq";
    public static final String SESSION_COUNTED = "c";
    public static final int SESSION_PERIOD = 30000;
    public static final String SESSION_STARTTIME = "ss";
    public static final String SESSTION_ACTIVITY_AUTOTRACE = "at";
    public static final String SESSTION_ACTIVITY_DURATION = "d";
    public static final String SESSTION_ACTIVITY_NAME = "n";
    public static final String SESSTION_ACTIVITY_START = "ps";
    public static final String SESSTION_ACTIVITY_TITLE = "t";
    public static final String SESSTION_END_TIME = "e";
    public static final String SESSTION_ID = "i";
    public static final String SESSTION_PAGE_VIEW = "p";
    public static final String SESSTION_START_TIME = "s";
    public static final String SESSTION_TRACK_END_TIME = "e2";
    public static final String SESSTION_TRACK_START_TIME = "s2";
    public static final String SESSTION_TRIGGER_CATEGORY = "pc";
    public static final String SIGN = "sign";
    public static final String STAMP = "t";
    public static final String STAT_CACHE_FILE_NAME = "__local_stat_cache.json";
    public static final String STAT_SDK_CHANNEL = "sc";
    public static final int STAT_SDK_CHANNEL_VALUE = 0;
    public static final String STAT_SDK_TYPE = "st";
    public static final String STAT_SDK_VERSION = "v";
    public static final String STAT_SDK_VERSION_NUM = "3.7.5.5";
    public static final String TIME_INTERVAL_META_NAME = "BaiduMobAd_TIME_INTERVAL";
    public static final String WIFI_LOCATION = "wl2";

    public enum EventViewType {
        BUTTON(1);
        

        /* renamed from: a */
        private int f3052a;

        private EventViewType(int i) {
            this.f3052a = i;
        }

        public int getValue() {
            return this.f3052a;
        }

        public String toString() {
            return String.valueOf(this.f3052a);
        }
    }

    public class SessionInvokeCategory {
        public static final int ActivityInvoke = 1;
        public static final int ApiInvoke = 0;
        public static final int CustomInvoke = 3;
        public static final int FragmentInvoke = 2;
    }
}
