# Android
대충 끄적이며 공부한 내용

## Activity
뷰를 그릴 수 있는 캔버스.
새로운 엑티비티를 실행할 때 이전 엑티비티는 BackStack에 저장함
=> Activity 생명 주기

LifeCycle
- 사용자가 앱을 사용하는 도중에 전화가 걸려오거나 다른 앱으로 전환할 때 충돌하지 않도록 합니다
- 사용자가 앱을 활발하게 사용하지 않는 경우 소중한 시스템 리소스를 소비하지 않도록 합니다
- 사용자가 앱에서 나갔다가 나중에 돌아왔을때 사용자의 진행상태를 손실하지 않도록 합니다
- 화면이 가로 방향과 세로 방향간에 회전할 경우 , 충돌하거나 사용자의 진행 상태를 손실하지 않도록 합니다

## Fragment
추가, 삭제 가능한 모듈시 엑티비티 섹션
액티비티 안에서 액티비티 처럼 사용할 수 있는 "하위 액티비티" 같은 개념
Context 존재 X

## Intent
메시지 객체, 다른 구성이나 엑티비티 작업 요청 가능

액티비티 시작
서비스 시작
브로드캐스트 전달

## Permission
스케줄 캘린더 
카메라연락처마이크폰상태 센서 스토리지
manifests -> AndroidManifest.xml
application 밖에 입력해야함

## Request Permission
안드로이드 6.0 (API23이상) 런타임에 권한 요청

위험 권한 종류
달력, 카메라, 전화, 마이크, 위치 정보, SMS, 스토리지, 센서, 연락처
( 사용자 허가를 받아야 사용 가능 API 24 마시멜로우)

## Handler Thread
Thread : 여러작업을 동시에 해주는 기능
쓰레드 충돌 해결을 위해 Handler 사용
안드로이드는 핸들러 없이 메인 쓰레드를 건들 수 없음

## Context
안드로이드에서는 화면 구성단을 말함
현재 사용되고 있는 어플리케이션에 대한 포괄적인 정보를 지니고 있는 객체

## AsyncTask
Thread + Handler => AsyncTask

## Broadcast
스마트폰의 상태가 변경 되었을때 설치된 모든 앱들에게 전송되는 기능
Intent.ACTION_BOOT_COMPLETED 처럼 정적 브로드캐스트도 가능

## FCM
푸시 알람. 무료, 배터리 절약, 다른 플랫폼과 호환 가능
Tool/Firebase 다운로드

기본 푸시 아이콘 설정 필요
<meta-data android:name="com.google.firebase.messaging.default_notification_icon"  
  android:resource="@drawable/ic_launcher_background"/>
  
토큰을 받아야 함
var token = FirebaseInstanceId.getInstance().token

https://console.firebase.google.com/u/1/project/fcmfirebaseproject-f63af/notification?hl=ko

## Service
앱이 종료 되어도 독립적으로 작동 되는 백그라운드 쓰레드

## ShardedPreference
안드로이드 내부 캐시 저장
