package com.a7pl4y3r.hosts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_host_auth.*

class HostAuth : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host_auth)

        btLogIn.setOnClickListener {

            if (dataIsValid() && hostWasFound())
                showMessage(this, "Login successful!", false)
            else
                showMessage(this, "Host was not found!", true)
        }

        btCreateHost.setOnClickListener {  }

    }

    private fun dataIsValid(): Boolean {

        if (etHostName.text.isEmpty() || etPassword.text.isEmpty())
            return false

        return true
    }

    private fun hostWasFound(): Boolean {

        val db = HostDb(this)
        val res = db.readData()

        res.moveToFirst()
        while (res.moveToNext())
            if (res.getString(1) == etHostName.toString()
                && res.getString(2) == etPassword.toString()) {

                db.close()
                res.close()
                return true
            }

        db.close()
        res.close()
        return false
    }
}
