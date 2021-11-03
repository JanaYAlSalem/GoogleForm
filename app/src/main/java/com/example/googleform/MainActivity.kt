package com.example.googleform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.googleform.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    lateinit var LinkXML: ActivityMainBinding // to initializes LinkXML in future time

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LinkXML = ActivityMainBinding.inflate(layoutInflater)  // initializes the binding object
        setContentView(LinkXML.root) // get root of XML

        LinkXML.nextButton.setOnClickListener { Next() } // call fun on button

    }



    private fun Next(){
        val inputNamef = LinkXML.inputFirstNumX.text.toString()
        val inputPass1 = LinkXML.inputPassX.text.toString()
        val inputPass2 = LinkXML.confirmPassX.text.toString()
        val inputNamel = LinkXML.inputLastNumX.text.toString()
        var Email = LinkXML.usernameX.text.toString()
        var emailPattern = "[a-zA-Z0-9._-]+@[gmail]+\\.+[com]+"

        if (TextUtils.isEmpty(inputNamef) == false &&
            TextUtils.isEmpty(inputPass1) == false &&
            TextUtils.isEmpty(inputPass2) == false &&
            TextUtils.isEmpty(Email) == false &&
            TextUtils.isEmpty(inputNamel) == false) {

            if(Email.trim { it <= ' ' }.matches(emailPattern.toRegex()) == false){
                Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            else if (inputPass1 == inputPass2) {
                Snackbar.make( findViewById(R.id.googleForm), "DONE", Snackbar.LENGTH_SHORT).show()
            } // end if pass
            else IsSamePassword()
        } // end if are not null
        else IsNullInfo()

    } // end fun of Show Informations

    private fun IsSamePassword() {
        Snackbar.make(findViewById(R.id.googleForm), "Sorry the password is not the same", Snackbar.LENGTH_SHORT).show()
    }  // end Is Same Password

    private fun IsNullInfo() {
        Snackbar.make( findViewById(R.id.googleForm), "Sorry some info is empty", Snackbar.LENGTH_SHORT).show()
    }  // end Is Null Info

} // Class


