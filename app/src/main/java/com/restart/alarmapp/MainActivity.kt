package com.restart.alarmapp

import android.app.TimePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inspector.IntFlagMapping
import android.widget.Button
import android.widget.TextView
import androidx.core.content.edit
import java.util.*

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

    private fun initOnOffButton() {
        val onOffButton = findViewById<Button>(R.id.onOffButton)
        onOffButton.setOnClickListener {
            //저장한 데이터를 확읺나다.

            // 온오프에 따라 작업을 처리한다.

            //오프-> 알람 제거
            //온 -> 알람 등록

            //데이터를 저장한다.
        }
    }

    private fun initChageAlarmTimeButton() {
        val changeAlarmButton = findViewById<Button>(R.id.changeAlarmTimeButton)

        //현재 시간을 일단 가져온다.
        //TimePickDialog 띄워줘서 시간 설정을 하도록 하게끔 하고, 그 시간을 가져와서
        //데이터를 저장한다.
        //뷰를 업데이트한다.
        //기본에 있던 알람을 삭제한다.
        changeAlarmButton.setOnClickListener {
            val calendar = Calendar.getInstance() //캘린더 클래스 객체화. 현재 시간 기본설정.

            //타임피커 다이얼로그띄우기 : 기본설정- 캘린더에서 현재 시간 가져오기.
            TimePickerDialog(this, { picker, hour, minute ->
                val model = saveAlarmModel(hour, minute, false)

            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false)
                .show()

        }
        }


    //데이터 저장된 함수만들기. 여러곳에서 사용하기 때문에 함수로 따로 빼기.
    private fun saveAlarmModel(
        hour: Int,
        minute: Int,
        onOff: Boolean
    ): AlarmDisplayModel {
        val model = AlarmDisplayModel(hour, minute, false)

        val sharedPreferences = getSharedPreferences("time",Context.MODE_PRIVATE) //쉐어드프리퍼런스에 저장

        with(sharedPreferences.edit()){ //쉐어드프리퍼런스를 .edit()로 열기. whit함수는 쉐어드프리퍼런스.edit과 함께할 수 있는 작업들을 with스코프에 저장하는 기능.
            putString("alarm", model.makeDataForDB()) //putString저장
            putBoolean("onOff", model.onOff) //putBoolean으로 저장
            commit() //쉐어드프리퍼런스의 에디터를 가지고 with함수로 실행시켰기 때문에 마지막에 commit()을 해주어야 데이터가 저장이 됨.
        }

//        sharedPreferences.edit(){  //쉐어드프리퍼런스.edit()로 열어서 {}안에 스코프를 열어서 작성하면 edit이 자동으로 실행
//
//        }

        return model
    }
}