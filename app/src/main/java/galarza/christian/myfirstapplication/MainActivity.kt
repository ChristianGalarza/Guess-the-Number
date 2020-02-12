package galarza.christian.myfirstapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //var counter:Int = 0
    var numero:Int = 0
    var numeroAuxAlto:Int = 100
    var numeroAuxBajo:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rango0:TextView = findViewById(R.id.aux) as TextView
        val rango1:TextView = findViewById(R.id.aux2) as TextView
        val label:TextView = findViewById(R.id.etiqueta) as TextView
        val down:Button = findViewById(R.id.down) as Button
        down.isEnabled=false
        val up:Button = findViewById(R.id.up) as Button
        up.isEnabled=false
        val generate:Button = findViewById(R.id.generate) as Button
        val win:Button = findViewById(R.id.win) as Button
        win.isEnabled=false
        var isNumber:Boolean=label.text.matches("-?\\d+(\\.\\d+)?".toRegex())

        generate.setOnClickListener{
            numero= Random.nextInt(0,100)
            label.setText("$numero")
            if(isNumber){
                generate.isEnabled = false
            }
            rango0.setText("$numeroAuxBajo")
            rango1.setText("$numeroAuxAlto")
            down.isEnabled=true
            up.isEnabled=true
            win.isEnabled=true
        }
        up.setOnClickListener{
            numeroAuxBajo=numero
            rango0.setText("$numeroAuxBajo")
            rango1.setText("$numeroAuxAlto")
            numero = Random.nextInt(numeroAuxBajo,numeroAuxAlto)
            label.setText("$numero")
        }
        down.setOnClickListener{
            numeroAuxAlto=numero
            rango0.setText("$numeroAuxBajo")
            rango1.setText("$numeroAuxAlto")
            numero = Random.nextInt(numeroAuxBajo,numeroAuxAlto)
            label.setText("$numero")
        }
        win.setOnClickListener{
            generate.isEnabled=true
            down.isEnabled=false
            up.isEnabled=false
            win.isEnabled=false
            label.setText("Genera numero")
            numero = 0
            numeroAuxAlto = 100
            numeroAuxBajo = 0
        }

    }
}