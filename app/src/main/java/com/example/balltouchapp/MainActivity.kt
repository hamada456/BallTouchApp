package com.example.balltouchapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
//Viewのインポート文
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //XMLを使わないのでコメントアウト↓
        //setContentView(R.layout.activity_main)

        //XMLではなく、↓のBallViewを表示する
        val ballView = BallView(this)
        setContentView(ballView)
    }

    //class　クラス名:()継承元のクラス名()　にcontext、(引数)を追加
    //すると親のメソッドを使うことが出来る。
    class BallView(context: Context?) : View(context) {
        //paint：図形の描画
        private var paint: Paint = Paint()
        //縦横、Float型
        private var circleX:Float = 200F
        private var circleY:Float = 200F

        //onDrawで描画の準備
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            canvas?.drawColor(Color.RED)//カンバスの色、null許容なので
            //色と丸い図形
            paint.color = Color.YELLOW
            //たて、よこ、半径radius
            canvas?.drawCircle(circleX,circleY,50F,paint)
        }

        //画面タッチされた時はonTouchEvent
        override fun onTouchEvent(event: MotionEvent?): Boolean {
            //タッチポジションの代入、!!はnullを許容しない！
            circleX = event!!.x
            circleY = event!!.y
            //無効化、毎回更新し続ける時は
            invalidate()

            //↓ return false この処理が終わってないので次の処理に行く、次の処理はないのでおかしくなる
            //return super.onTouchEvent(event)

            //処理が終わって報告が返される
            return true
        }

    }
}