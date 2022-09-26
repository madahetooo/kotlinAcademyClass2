package com.bamboogeeks.kotlinacademyclass2.pushnotification.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bamboogeeks.kotlinacademyclass2.databinding.ActivityCloudMessagingAppBinding
import com.bamboogeeks.kotlinacademyclass2.pushnotification.model.NotificationData
import com.bamboogeeks.kotlinacademyclass2.pushnotification.model.PushNotification
import com.bamboogeeks.kotlinacademyclass2.pushnotification.service.FirebaseService
import com.bamboogeeks.kotlinacademyclass2.pushnotification.service.RetrofitInstance
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val TOPIC ="/topics/myTopic"
class CloudMessagingApp : AppCompatActivity() {
    val TAG = "CloudMessagingApp"
    private lateinit var binding: ActivityCloudMessagingAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCloudMessagingAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseService.sharedPref = getSharedPreferences("SharedPrefFile", Context.MODE_PRIVATE)
        FirebaseMessaging.getInstance().token.addOnSuccessListener { token->
            FirebaseService.token = token
            binding.etNotificationToken.setText(token)
        }
    FirebaseMessaging.getInstance().subscribeToTopic(TOPIC)
        binding.btnSendNotification.setOnClickListener {
            val notificationTitle =
                binding.etNotificationTitle.text.toString() // get the notification title
            val notificationMessage =
                binding.etNotificationMessage.text.toString() // get the notification title
            val recipientToken =
                binding.etNotificationToken.text.toString() // get the notification title

            if (notificationTitle.isNotEmpty() && notificationMessage.isNotEmpty() &&recipientToken.isNotEmpty() ){
                PushNotification(NotificationData(notificationTitle,notificationMessage),recipientToken).also {notification ->
                    sendNotification(notification)
                }
            }
        }
    }

    private fun sendNotification(notification: PushNotification) =
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.api.postNotification(notification)
                if (response.isSuccessful) {
                    Log.d(TAG, "${Gson().toJson(response)}")
                } else {
                    Log.d(TAG, response.errorBody().toString())
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@CloudMessagingApp, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
}