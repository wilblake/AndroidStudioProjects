package com.example.wil.customlist

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    data class MyData (var myTitle:String, var myNum: Int)

    class MyAdaptor(val mycontext:Context?,
                    val resource: Int,
                    val objects: Array<out MyData>?) :
    ArrayAdapter<MyData>(mycontext, resource,objects)
    {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val inflater = (mycontext as Activity).layoutInflater
            val row=inflater.inflate(resource,parent,false)
            val title=row.findViewById<TextView>(R.id.title)
            val number=row.findViewById<TextView>(R.id.number)
            title.text=objects?.get(position)?.myTitle
            number.text=objects?.get(position)?.myNum.toString()
            return row
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val myDataArray=arrayOf(
                MyData("item1", 10),
                MyData("item2", 20),
                MyData("item3", 30),
                MyData("item4", 40),
                MyData("item5", 50),
                MyData("item6", 60)

        )
        val myAdapter  =  MyAdaptor(this,R.layout.mylayout,myDataArray)


        val lv= findViewById<ListView>(R.id.listView)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()         }
        lv.adapter=myAdapter

    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
