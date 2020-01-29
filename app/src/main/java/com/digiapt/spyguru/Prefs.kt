package com.digiapt.spyguru

import android.content.Context
import android.util.Log
import kotlin.collections.ArrayList

class Prefs {
    companion object {

        val HOME = "com.huawei.android.launcher"
        val NULL = "null"

        val APPNAME = "MYAPPLICTION"
        val APP_KEY = "MYKEYING"
        val APP_KEY_NEW = "MYKEYINGNEW"
        val MODE = 0

        fun setAppValue(context: Context, app:String) {
            val prefs = context.getSharedPreferences(APPNAME,  MODE)
            val edit = prefs.edit()
            edit.putString(APP_KEY, app)
            edit.apply()
        }

        fun getAppValue(context: Context) : String {
            return context.getSharedPreferences(APPNAME, MODE).getString(APP_KEY, "null")!!
        }

        fun setNEWAppValue(context: Context, app:String) {
            val prefs = context.getSharedPreferences(APPNAME,  MODE)
            val edit = prefs.edit()
            edit.putString(APP_KEY_NEW, app)
            edit.apply()
        }

        fun getNEWAppValueLive(context: Context) : String {
            return context.getSharedPreferences(APPNAME, MODE).getString(APP_KEY_NEW, "null")!!
        }


            val exceptions = arrayListOf<String>("launcher", "android")

        fun checkList(checking:String, array: ArrayList<String>): Boolean {
            for (item in array) {
                Log.d("test_999", "aasd: "+item+"   "+checking)
                if (checking.contains(item)){
                    return false
                }
            }
            return true
        }

        fun reset(context: Context, condition:String) {
            if (condition.contains(exceptions.get(0))) {
                setNEWAppValue(context, "null")
            }
        }
    }
}