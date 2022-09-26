package com.bamboogeeks.kotlinacademyclass2.pushnotification.model

data class PushNotification(
    val data: NotificationData,
    val to:String
) {
}