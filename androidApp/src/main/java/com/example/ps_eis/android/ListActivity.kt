package com.example.ps_eis.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ps_eis.Client
import com.example.ps_eis.DataClass
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.json.JSONArray
import org.json.JSONObject


class ListActivity : AppCompatActivity() {

    private val mainScope = MainScope()

    //private val greeting = Greeting()
    private val client = Client()

    private lateinit var rv: RecyclerView
    private lateinit var newArrayList: ArrayList<DataClass>
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: ListAdapter
    private lateinit var content: ArrayList<DataClass>

    lateinit var formatView: Array<String>
    lateinit var langView: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        //val testView: TextView = findViewById(R.id.testView)





        var response = ""
        runBlocking {
            launch {
                response = Client().getRequest()
            }
        }


        /***
        mainScope.launch{
        kotlin.runCatching {
        client.getRequest()
        }.onSuccess {
        textView.text = it
        }
        }***/

        initContent(response)
        initRecylcerView()



    }

    private fun initRecylcerView() {
        rv = findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        adapter = ListAdapter(content)

        rv.layoutManager = layoutManager
        rv.adapter = adapter

        rv.addItemDecoration(DividerItemDecoration(rv.context, layoutManager.orientation))
    }

    private fun initContent(response:String) {
        content = ArrayList()

        //initialize var zettelJson
        var listJson: JSONArray
        listJson = JSONArray(response)
        //val greetingsList: JSONObject = listJson.getJSONArray(0)

        val totalGreetingsCount = listJson.length()


        for (i in 0 until totalGreetingsCount) {
            val jsonList = listJson.getJSONObject(i)
            //val formatData = JSONObject(listGreetings.getJSONObject(i).getString("string"))
            //val langData = JSONObject(listGreetings.getJSONObject(i).getString("lang"))

            val formatData = jsonList.getString("string")
            val langData = jsonList.getString("lang")

            val item = DataClass(formatData.toString(), langData.toString())
            content += item

        }


    }

}
