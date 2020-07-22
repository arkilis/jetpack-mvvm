package au.com.flyingbits.jetpacktestkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private var myViewModel: MyViewModel? = null
    private val TAG: String = "Running Order"
    private var btnAdd: Button? = null
    private var btnMinus: Button? = null
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        btnAdd = findViewById(R.id.button_add)
        btnMinus = findViewById(R.id.button_minus)
        textView = findViewById(R.id.text_view)

        myViewModel!!.getNum().observe(this, Observer<Int>() {
            this.textView?.setText(myViewModel!!.getNum().value.toString())
        })

        btnAdd?.setOnClickListener {
            myViewModel!!.addNum(1)
        }

        btnMinus?.setOnClickListener {
            myViewModel!!.addNum(-1)
        }

    }
}
