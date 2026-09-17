package com.mustafa.pharmacyapp

import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val medicines = listOf(
        "Panadol",
        "Augmentin",
        "Flagyl",
        "Glucophage",
        "Neurobin",
        "Mamacare",
        "Pregabalin",
        "Duphaston"
    )

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showWelcome()
    }

    private fun showWelcome() {
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(40, 40, 40, 40)
        }

        val title = TextView(this).apply {
            text = "صيدليتي"
            textSize = 32f
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "\nنظام تسجيل أصناف الصيدلية\n"
            textSize = 18f
            gravity = Gravity.CENTER
        }

        val start = Button(this).apply {
            text = "هيا نبدأ"
            textSize = 22f
            setOnClickListener {
                index = 0
                showMedicine()
            }
        }

        layout.addView(title)
        layout.addView(subtitle)
        layout.addView(start)

        setContentView(layout)
    }

    private fun showMedicine() {

        if (index >= medicines.size) {
            showFinished()
            return
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(50, 50, 50, 50)
        }

        val progress = TextView(this).apply {
            text = "${index + 1} / ${medicines.size}"
            textSize = 18f
            gravity = Gravity.CENTER
        }

        val medicine = TextView(this).apply {
            text = "\n${medicines[index]}\n"
            textSize = 30f
            gravity = Gravity.CENTER
        }

        val quantity = EditText(this).apply {
            hint = "أدخل الكمية"
            inputType = android.text.InputType.TYPE_CLASS_NUMBER
            gravity = Gravity.CENTER
        }

        val next = Button(this).apply {
            text = "حفظ والتالي"
            setOnClickListener {
                index++
                showMedicine()
            }
        }

        layout.addView(progress)
        layout.addView(medicine)
        layout.addView(quantity)
        layout.addView(next)

        setContentView(layout)
    }

    private fun showFinished() {

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(40, 40, 40, 40)
        }

        val done = TextView(this).apply {
            text = "✓\nتم الانتهاء من تسجيل الأصناف"
            textSize = 26f
            gravity = Gravity.CENTER
        }

        val again = Button(this).apply {
            text = "البدء من جديد"
            setOnClickListener {
                showWelcome()
            }
        }

        layout.addView(done)
        layout.addView(again)

        setContentView(layout)
    }
}
