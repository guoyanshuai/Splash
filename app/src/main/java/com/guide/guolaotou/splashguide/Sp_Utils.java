package com.guide.guolaotou.splashguide;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Tom on 2017/3/19.
 */

public class Sp_Utils {
    public static final String  spFileName = "guide";

    public static String getString(Context context,String strKey) {
        SharedPreferences sp = context.getSharedPreferences(spFileName,Context.MODE_PRIVATE);
       String result =  sp.getString(strKey,"");
        return result;
    }
    public static String getString(Context context,String strKey,String strDefault) {
        SharedPreferences sp = context.getSharedPreferences(spFileName,Context.MODE_PRIVATE);
        String result =  sp.getString(strKey,strDefault);
        return result;
    }
    public static void putString(Context context,String strKey,String string)
    {
        SharedPreferences sp = context.getSharedPreferences(spFileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(strKey,string);
        editor.commit();
    }
    public static Boolean getBoolen(Context context,String strKey) {
        SharedPreferences sp = context.getSharedPreferences(spFileName,Context.MODE_PRIVATE);
        Boolean result =  sp.getBoolean(strKey,false);
        return result;
    }
    public static Boolean getBoolen(Context context,String strKey,Boolean strDefault) {
        SharedPreferences sp = context.getSharedPreferences(spFileName,Context.MODE_PRIVATE);
        Boolean result =  sp.getBoolean(strKey,strDefault);
        return result;
    }
    public static void putBoolen(Context context,String strKey,Boolean bool)
    {
        SharedPreferences sp = context.getSharedPreferences(spFileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(strKey,bool);
        editor.commit();
    }
    public static int  getInt(Context context,String strKey) {
        SharedPreferences sp = context.getSharedPreferences(spFileName,Context.MODE_PRIVATE);
        int result =  sp.getInt(strKey,-1);
        return result;
    }
    public static int getInt(Context context,String strKey,int strDefault) {
        SharedPreferences sp = context.getSharedPreferences(spFileName,Context.MODE_PRIVATE);
        int result =  sp.getInt(strKey,strDefault);
        return result;
    }
    public static void putInt(Context context,String strKey,int integer)
    {
        SharedPreferences sp = context.getSharedPreferences(spFileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(strKey,integer);
        editor.commit();
    }
    public static long getLong(Context context,String strKey) {
        SharedPreferences sp = context.getSharedPreferences(spFileName,Context.MODE_PRIVATE);
        long result =  sp.getLong(strKey,-1);
        return result;
    }
    public static long getLong(Context context,String strKey,long strdef) {
        SharedPreferences sp = context.getSharedPreferences(spFileName,Context.MODE_PRIVATE);
        long result =  sp.getLong(strKey,strdef);
        return result;
    }
    public static void putLong(Context context,String strKey,long strlong)
    {
        SharedPreferences sp = context.getSharedPreferences(spFileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(strKey,strlong);
        editor.commit();
    }

}
