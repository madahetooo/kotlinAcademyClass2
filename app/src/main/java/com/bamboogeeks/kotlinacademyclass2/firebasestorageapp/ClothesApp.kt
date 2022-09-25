package com.bamboogeeks.kotlinacademyclass2.firebasestorageapp

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bamboogeeks.kotlinacademyclass2.R
import com.bamboogeeks.kotlinacademyclass2.databinding.ActivityClothesAppBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

private const val REQUEST_CODE_IMAGE_PICK = 0
@Suppress("DEPRECATION")
class ClothesApp : AppCompatActivity() {
    var currentImage: Uri? = null
    val imageReference = Firebase.storage.reference
    private lateinit var binding: ActivityClothesAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClothesAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivClothesImage.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, REQUEST_CODE_IMAGE_PICK)
            }
        }
        binding.btnUploadImage.setOnClickListener {
            uploadImageToStorage("myImage")
        }
        binding.btnDowloadImage.setOnClickListener {
            downloadImageFromStorage("myImage")
        }
        binding.btnDeleteImage.setOnClickListener {
            deleteImageFromStorage("myImage")
        }
        listAllImagesFromStorage()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_IMAGE_PICK) {
            data?.data.let {
                currentImage = it
                binding.ivClothesImage.setImageURI(currentImage)
            }
        }
    }

    private fun uploadImageToStorage(fileName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                currentImage?.let {
                    imageReference.child("images/$fileName").putFile(it).await()
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@ClothesApp,
                            "Image Uploaded Successfully",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@ClothesApp, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun downloadImageFromStorage(fileName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val maxDownloadSize = 5L * 1024 * 1024
                val imageByte =
                    imageReference.child("images/$fileName").getBytes(maxDownloadSize).await()
                val imageBitMap = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.size)
                withContext(Dispatchers.Main) {
                    binding.ivClothesImage.setImageBitmap(imageBitMap)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@ClothesApp, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun deleteImageFromStorage(fileName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                imageReference.child("images/$fileName").delete().await()
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@ClothesApp, "Image Deleted Successfully", Toast.LENGTH_LONG)
                        .show()

                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@ClothesApp, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun listAllImagesFromStorage() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                var allImages = imageReference.child("images/").listAll().await()
                val listOfImagesUrls = mutableListOf<String>()
                for (singleImage in allImages.items) {
                    val itemUrl = singleImage.downloadUrl.await()
                    listOfImagesUrls.add(itemUrl.toString())
                }
                withContext(Dispatchers.Main) {
                    val clothesImageAdapter = ClothesImageAdapter(listOfImagesUrls)
                    binding.rvClothesImages.apply {
                        adapter = clothesImageAdapter
                        layoutManager = LinearLayoutManager(this@ClothesApp)
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@ClothesApp, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}