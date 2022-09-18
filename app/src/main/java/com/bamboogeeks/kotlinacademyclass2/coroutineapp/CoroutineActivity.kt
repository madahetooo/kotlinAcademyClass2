package com.bamboogeeks.kotlinacademyclass2.coroutineapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bamboogeeks.kotlinacademyclass2.databinding.ActivityCoroutineBinding
import kotlinx.coroutines.*

class CoroutineActivity : AppCompatActivity() {
    val TAG = "CoroutineActivity"
    private lateinit var binding: ActivityCoroutineBinding
    override fun onCreate(savedInstanceState: Bundle?) { // MAIN Thread
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch {
//
//            var answer1: String? = null
//            var answer2: String? = null
//            val job1 = launch(Dispatchers.IO) {
//                answer1 = doNetworkCallSimulation1()// SIMULATION 1
//            }
//            val job2 = launch(Dispatchers.IO) {
//                answer2 = doNetworkCallSimulation2() // SIMULATION 2
//            }
//            job1.join()
//            job2.join()
//            Log.d(TAG, "Answer1 : $answer1")
//            Log.d(TAG, "Answer1 : $answer2")

            var answer1 = async { doNetworkCallSimulation1() }
            var answer2 = async { doNetworkCallSimulation2() }
            Log.d(TAG, "Answer1 : ${answer1.await()}")
            Log.d(TAG, "Answer2 : ${answer2.await()}")

        }

    }

    suspend fun doNetworkCallSimulation1(): String {
        delay(4000L)
        return "Simulation 1"
    }

    suspend fun doNetworkCallSimulation2(): String {
        delay(4000L)
        return "Simulation 2"
    }
}