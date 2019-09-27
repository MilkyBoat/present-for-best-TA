package com.baidu.mobstat;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

public interface ICooperService {
    boolean checkCellLocationSetting(Context context);

    boolean checkGPSLocationSetting(Context context);

    boolean checkWifiLocationSetting(Context context);

    String getAppChannel(Context context);

    String getAppKey(Context context);

    int getAppVersionCode(Context context);

    String getAppVersionName(Context context);

    String getCUID(Context context, boolean z);

    String getDeviceId(TelephonyManager telephonyManager, Context context);

    String getHost();

    String getLinkedWay(Context context);

    String getMTJSDKVersion();

    String getOSVersion();

    String getOperator(TelephonyManager telephonyManager);

    String getPhoneModel();

    String getSecretValue(String str);

    int getTagValue();

    void installHeader(Context context, JSONObject jSONObject);
}
