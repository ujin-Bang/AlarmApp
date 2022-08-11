package com.restart.alarmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //step0 뷰를 초기화 해주기
        initOnOffButton()
        initChageAlarmTimeButton()

        //step1 데이터 가져오기

        //step2 뷰에 데이터 그려주기


    }
    private fun initOnOffButton(){
        val onOffButton = findViewById<Button>(R.id.onOffButton)
        onOffButton.setOnClickListener {
            //저장한 데이터를 확읺나다.

            // 온오프에 따라 작업을 처리한다.

            //오프-> 알람 제거
            //온 -> 알람 등록

            //데이터를 저장한다.
        }
    }

    private fun initChageAlarmTimeButton(){
        val changeAlarmButton = findViewById<Button>(R.id.changeAlarmTimeButton)
            //현재 시간을 일단 가져온다.
            //TimePickDialog 띄워줘서 시간 설정을 하도록 하게끔 하고, 그 시간을 가져와서

            //데이터를 저장한다.
            //뷰를 업데이트한다.
            //기본에 있던 알람을 삭제한다.
    }
}