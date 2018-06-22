package org.tobap.com.commonintent

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(android.Manifest.permission.READ_CONTACTS,
                    android.Manifest.permission.SEND_SMS,
                    android.Manifest.permission.CAMERA),0)
        }

        button.setOnClickListener { setAlaram() }
        button2.setOnClickListener { openWebPage() }
        button3.setOnClickListener { sendSMS() }
        button4.setOnClickListener { openEmail() }
        button7.setOnClickListener { openContact() }
        button6.setOnClickListener { openAlbum() }
        button5.setOnClickListener { openCamera() }
    }

    fun setAlaram() {
        var intent = Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "알람 설정")
                .putExtra(AlarmClock.EXTRA_HOUR, 7)
                .putExtra(AlarmClock.EXTRA_MINUTES, 0)
        startActivity(intent)
    }

    fun openWebPage() {
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com"))
        intent.`package` = "com.android.chrome"
        startActivity(intent)
    }

    fun sendSMS() {
        var intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("smsto:010-1234-1234")
        intent.putExtra("sms_body", "Hello World")
        startActivity(intent)
    }

    fun openEmail()
    {
        var intent = Intent(Intent.EXTRA_EMAIL)
        intent.data   = Uri.parse("mailto:asd@naver.com")
        intent.putExtra(Intent.EXTRA_SUBJECT, "문의 사항")
        intent.putExtra(Intent.EXTRA_TEXT, "문의 내용")
        startActivity(intent)
    }

    fun openContact() {
        var intent = Intent(Intent.ACTION_PICK)
        intent.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
        startActivityForResult(intent,0)
    }

    fun openAlbum() {
        var intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent,1)
    }

    fun openCamera() {
        var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent , 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == Activity.RESULT_OK)
        {
            var contactUri = data!!.data
            var projection = arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER)
            var cursor = contentResolver.query(contactUri, projection, null,null,null)
            cursor.moveToFirst()
            var numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            var number = cursor.getString(numberIndex)
            println(number)
        }
        if (requestCode == 1 && resultCode == Activity.RESULT_OK)
        {
            var imageUri = data!!.data
            imageView.setImageURI(imageUri)
        }
        if (requestCode == 2 && resultCode == Activity.RESULT_OK)
        {
            var bitmap = data!!.getParcelableExtra<Bitmap>("data")
            imageView.setImageBitmap(bitmap)
        }
    }
}
