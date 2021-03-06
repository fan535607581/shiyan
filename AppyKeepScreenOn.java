package com.AppyKeepScreenOn;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ComponentContainer;

import java.net.InetAddress;/////////////////////////系统信息
import java.util.Set;
import java.util.TreeSet;
 

import java.text.SimpleDateFormat; //系统时间
import java.util.Date; //系统时间 

@DesignerComponent
(
    version = 10,//版本号
    category = ComponentCategory.EXTENSION,//组件类别，常用ComponentCategory.EXTENSION
    nonVisible = true//是否为可见组件
)

@SimpleObject(external = true)//是否为拓展组件
public class AppyKeepScreenOn extends AndroidNonvisibleComponent implements Component
{
    public static final int VERSION = 1;//版本号
    private ComponentContainer container;
    private Context context;
    private static final String LOG_TAG = "AppyKeepScreenOn";
    private final Activity activity;
    
    private boolean keepScreenOn = false;//屏幕状态初始为不常亮
    private boolean keep = false;//屏幕状态初始为不常亮
    private String result;
    private String state;
    
    int kk=100;
    String k = "神话传说";
   
    public AppyKeepScreenOn(ComponentContainer container)
    {
        super(container.$form());
        this.container = container;
        this.context = container.$context();
        Log.d("AppyKeepScreenOn", "AppyKeepScreenOn Created");
        this.activity = container.$context();
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)//返回屏幕是否设置为为常亮状态
    public String Result() { return this.result;}

    @DesignerProperty(editorType = "boolean",defaultValue = "False")//界面屏幕上的选择,布尔型，初始状态为假
	
    @SimpleProperty(description = "Check Enable to keep screen active and awake when App has focus. default is FALSE")
    public void KeepScreenOn(boolean enable)//设置屏幕状态为关或开
    {
        if(this.keepScreenOn != enable)
	{
            this.keepScreenOn = enable;
            if(enable) {this.container.$form().getWindow().addFlags(128);}
	    else {this.container.$form().getWindow().clearFlags(128);}
        }
   }

    @DesignerProperty(editorType = "int",defaultValue = "0")//界面屏幕上输入具体数值
    public void state(int enable)//设置屏幕状态为关或开
    {
      
   }
   
 
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)//返回屏幕是否正在为常亮状态,结果
    public boolean KeepScreenOn() {return this.keepScreenOn;}

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)//返回数值kk
    public int ServerSocket() {return this.kk;}
    
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)//返回字符串
    public String state() {return this.k;} 
    
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)//返回系统时间
    public static String getCurrentTime()
    {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //系统时间 
        String dateString = formatter.format(currentTime);  
        return dateString;  
    } 
}
