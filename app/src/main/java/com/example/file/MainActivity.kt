package com.example.file

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.file.databinding.ActivityMainBinding
import java.io.File
import java.io.FileWriter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fileDir = File(getExternalFilesDir(null), "testDirectory")
        binding.createFolder.setOnClickListener {
            if (!fileDir.exists()) {
                fileDir.mkdirs()
                Toast.makeText(this, "پوشه ساخته شد", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "پوشه قبلا وجود داشته است", Toast.LENGTH_SHORT).show()
            }
        }


        val textFile = File(fileDir, "file.txt")
        binding.createTextFile.setOnClickListener {
            val fileWriter = FileWriter(textFile , true)
            fileWriter.append("سلام")
            fileWriter.flush()
            fileWriter.close()
            Toast.makeText(this, "فایل متنی ساخته شد", Toast.LENGTH_SHORT).show()
        }
    }
}
