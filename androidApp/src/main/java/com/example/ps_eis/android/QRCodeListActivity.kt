package com.example.ps_eis.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ps_eis.CodeClass
import com.google.firebase.database.*
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.activity_list.*
import java.util.Calendar.getInstance

class QRCodeListActivity : AppCompatActivity() {

    private lateinit var db : FirebaseFirestore
    private lateinit var codeRecyclerview : RecyclerView
    private lateinit var codeArrayList : ArrayList<CodeClass>
    private lateinit var codeAdapter: QrCodeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode_list)

        codeRecyclerview = findViewById(R.id.codeRecyclerView)
        codeRecyclerview.layoutManager = LinearLayoutManager(this)
        codeRecyclerview.setHasFixedSize(true)

        codeArrayList = arrayListOf()


        codeAdapter = QrCodeAdapter(codeArrayList)

        codeRecyclerview.adapter = codeAdapter

        getCodeData()

    }

    private fun getCodeData() {

        db = FirebaseFirestore.getInstance()


        db.collection("Scans").
            addSnapshotListener(object : EventListener<QuerySnapshot> {
                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                    if (error != null) {
                        Log.e("Firestore Error", error.message.toString())
                        return
                    }
                    for (dc: DocumentChange in value?.documentChanges!!) {
                        if (dc.type == DocumentChange.Type.ADDED) {
                            codeArrayList.add(dc.document.toObject(CodeClass::class.java))
                        }
                    }

                    codeAdapter.notifyDataSetChanged()


                }


            })
    }
}