package com.digiapt.spyguru

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Build
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button

class BReciver :BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        Log.d("sdad", "sads")
        showFlashMsg(context)
    }

    private fun showFlashMsg(context: Context) {

        val wm = context!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val inflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.flash_msg, null)
        val params: WindowManager.LayoutParams
        setView(view, wm, context)
        if (Build.VERSION.SDK_INT >= 26) {
            params = WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
            )
        } else {
            params = WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
            )
        }
        params.gravity = Gravity.CENTER or Gravity.CENTER
        params.x = 0
        params.y = 0
        Log.d("ttt", "Sad: " + params.gravity)
        wm.addView(view, params)
        try {

        }catch (e:Exception) {
            Log.d("ttyy","sad: "+e.message)
        }
    }

    private fun setView(
        view: View?,
        wm: WindowManager,
        context: Context
    ) {
        val mBtnDismiss = view?.findViewById<Button>(R.id.btn_dismiss)

        mBtnDismiss?.setOnClickListener(View.OnClickListener {
            //            var count = getPrefs(context!!)
//            Log.d("result_12345", "onReceive:"+ getPrefs(context!!)+"    "+count)
//            while (count >= 0 ) {
            wm.removeView(view)
//                count--
//            }
        })
    }

}