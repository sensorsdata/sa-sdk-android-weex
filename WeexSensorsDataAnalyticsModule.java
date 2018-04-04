package com.weex.app;

import android.util.Log;

import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class WeexSensorsDataAnalyticsModule extends WXModule {

    private static final String MODULE_NAME = "WeexSensorsDataAnalyticsModule";
    private static final String MODULE_VERSION = "1.0.0";
    private static final String LOGTAG = "SA.Weex";

    /**
     * 导出 track 方法给 Weex 使用.
     * 代码埋点
     *
     * @param eventName  事件名称
     * @param properties 事件的具体属性
     *                   Weex 示例：
     *                   const modal = weex.requireModule('WeexSensorsDataAnalyticsModule')
     *                   modal.track("AddToFav",{"ProductID":123456,"UserLevel":"VIP"})
     */
    @JSMethod(uiThread = true)
    public void track(String eventName, HashMap<String, Object> properties) {
        try {
            SensorsDataAPI.sharedInstance().track(eventName, convertToJSONObject(properties));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    /**
     * Map 转换成 JSONObject
     */
    private JSONObject convertToJSONObject(HashMap<String, Object> properties) {
        JSONObject json = new JSONObject();
        if (properties == null) {
            return json;
        }
        for (String key : properties.keySet()) {
            if (key != null) {
                Object value = properties.get(key);
                if (value != null) {
                    try {
                        json.put(key, value);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return json;
    }

    /**
     * 导出 trackTimerBegin 方法给 Weex 使用.
     * 初始化事件的计时器，默认计时单位为毫秒(计时开始).
     *
     * @param eventName 事件名称
     *                  weex 示例：
     *                  const modal = weex.requireModule('WeexSensorsDataAnalyticsModule')
     *                  modal.trackTimerBegin("viewTimer")
     */
    @JSMethod(uiThread = true)
    public void trackTimerBegin(String eventName) {
        try {
            SensorsDataAPI.sharedInstance().trackTimerBegin(eventName);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    /**
     * 导出 trackTimerEnd 方法给 Weex 使用.
     * 初始化事件的计时器，默认计时单位为毫秒(计时开始).
     *
     * @param eventName 事件名称
     *                  weex 示例：
     *                  const modal = weex.requireModule('WeexSensorsDataAnalyticsModule')
     *                  modal.trackTimerEnd("viewTimer")
     */
    @JSMethod(uiThread = true)
    public void trackTimerEnd(String eventName, HashMap<String, Object> properties) {
        try {
            SensorsDataAPI.sharedInstance().trackTimerEnd(eventName, convertToJSONObject(properties));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    /**
     * 导出 clearTrackTimer 方法给 Weex 使用.
     * 清除所有事件计时器
     * weex 示例：
     * const modal = weex.requireModule('WeexSensorsDataAnalyticsModule')
     * modal.clearTrackTimer()
     */
    @JSMethod(uiThread = true)
    public void clearTrackTimer() {
        try {
            SensorsDataAPI.sharedInstance().clearTrackTimer();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    /**
     * 导出 login 方法给 Weex 使用.
     * 登录事件
     *
     * @param loginId 登录 ID
     *                weex 示例：
     *                const modal = weex.requireModule('WeexSensorsDataAnalyticsModule')
     *                modal.login("developer@sensorsdata.cn")
     */
    @JSMethod(uiThread = true)
    public void login(String loginId) {
        try {
            SensorsDataAPI.sharedInstance().login(loginId);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    /**
     * 导出 logout 方法给 Weex 使用.
     * 登出事件
     * weex 示例：
     * const modal = weex.requireModule('WeexSensorsDataAnalyticsModule')
     * modal.logout()
     */
    @JSMethod(uiThread = true)
    public void logout() {
        try {
            SensorsDataAPI.sharedInstance().logout();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    /**
     * 导出 trackInstallation 方法给 Weex 使用.
     * 用于记录首次安装激活、渠道追踪的事件.
     *
     * @param eventName  事件名称
     * @param properties 事件的属性
     *                   weex 示例：
     *                   const modal = weex.requireModule('WeexSensorsDataAnalyticsModule')
     *                   modal.trackInstallation("AppInstall",{"$utm_source":"渠道A","$utm_campaign":"广告A"})
     */
    @JSMethod(uiThread = true)
    public void trackInstallation(String eventName, HashMap<String, Object> properties) {
        try {
            SensorsDataAPI.sharedInstance().trackInstallation(eventName, convertToJSONObject(properties));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    /**
     * 导出 trackViewScreen 方法给 Weex 使用.
     * weex 中 Tab 切换页面的时候调用，用于记录 $AppViewScreen 事件.
     *
     * @param url        页面的 url  记录到 $url 字段中(如果不需要此属性，可以传 null ).
     * @param properties 页面的属性.
     *                   weex 示例:
     *                   const modal = weex.requireModule('WeexSensorsDataAnalyticsModule')
     *                   modal.trackViewScreen(null,{"$title":"主页","$screen_name":"cn.sensorsdata.demo.Home"})
     */
    @JSMethod(uiThread = true)
    public void trackViewScreen(String url, HashMap<String, Object> properties) {
        try {
            SensorsDataAPI.sharedInstance().trackViewScreen(url, convertToJSONObject(properties));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    /**
     * 导出 profileSet 方法给 Weex 使用.
     * 设置用户属性
     *
     * @param properties 用户属性
     *                   weex 示例:
     *                   const modal = weex.requireModule('WeexSensorsDataAnalyticsModule')
     *                   modal.profileSet({"sex":"男"}))
     */
    @JSMethod(uiThread = true)
    public void profileSet(HashMap<String, Object> properties) {
        try {
            SensorsDataAPI.sharedInstance().profileSet(convertToJSONObject(properties));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    /**
     * 导出 profileSetOnce 方法给 Weex 使用.
     * 首次设置用户的一个或多个 Profile.
     * 与profileSet接口不同的是，如果之前存在，则忽略，否则，新创建.
     *
     * @param properties 属性列表
     *                   weex 示例:
     *                   const modal = weex.requireModule('WeexSensorsDataAnalyticsModule')
     *                   modal.profileSetOnce({"sex":"男"}))
     */
    @JSMethod(uiThread = true)
    public void profileSetOnce(HashMap<String, Object> properties) {
        try {
            SensorsDataAPI.sharedInstance().profileSetOnce(convertToJSONObject(properties));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    /**
     * 导出 profileIncrement 方法给 Weex 使用.
     * 给一个数值类型的Profile增加一个数值. 只能对数值型属性进行操作，若该属性
     * 未设置，则添加属性并设置默认值为0.
     *
     * @param property 属性名称
     * @param value    属性的值，值的类型只允许为 Number.
     *                 weex 示例:
     *                 const modal = weex.requireModule('WeexSensorsDataAnalyticsModule')
     *                 modal.profileIncrement("money",10)
     */
    @JSMethod(uiThread = true)
    public void profileIncrement(String property, Double value) {
        try {
            SensorsDataAPI.sharedInstance().profileIncrement(property, value);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    /**
     * 导出 profileAppend 方法给 Weex 使用.
     * 给一个列表类型的 Profile 增加一个元素.
     *
     * @param property 属性名称.
     * @param value    新增的元素.
     *                 weex 示例:
     *                 const modal = weex.requireModule('WeexSensorsDataAnalyticsModule')
     *                 modal.profileAppend("VIP","Gold")
     */
    @JSMethod(uiThread = true)
    public void profileAppend(String property, String value) {
        try {
            SensorsDataAPI.sharedInstance().profileAppend(property, value);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    /**
     * 导出 profileUnset 方法给 Weex 使用.
     * 删除用户的一个 Profile.
     *
     * @param property 属性名称.
     *                 weex 示例:
     *                 const modal = weex.requireModule('WeexSensorsDataAnalyticsModule')
     *                 modal.profileUnset("sex")
     */
    @JSMethod(uiThread = true)
    public void profileUnset(String property) {
        try {
            SensorsDataAPI.sharedInstance().profileUnset(property);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    /**
     * 导出 profileDelete 方法给 Weex 使用.
     * 删除用户所有 Profile.
     * weex 示例:
     * const modal = weex.requireModule('WeexSensorsDataAnalyticsModule')
     * modal.profileDelete()
     */
    @JSMethod(uiThread = true)
    public void profileDelete() {
        try {
            SensorsDataAPI.sharedInstance().profileDelete();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

}