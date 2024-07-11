package com.npav.myrvapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.widget.SearchView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatSpinner
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.npav.myrvapp.adapter.DataClass
import com.npav.myrvapp.adapter.DataResponse
import com.npav.myrvapp.adapter.SampleAdapter
import com.npav.myrvapp.login.MainLoginActivity
import com.npav.myrvapp.retrofit.RetrofitClient
import com.npav.myrvapp.retrofit.RetrofitInterface
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.flow.*
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import kotlin.system.measureTimeMillis


class MainActivity : AppCompatActivity(), View.OnClickListener {

    val remModel: ArrayList<RemModel> = ArrayList<RemModel>()
    val samModelList: ArrayList<DataClass> = ArrayList<DataClass>()
    val samModelListBckup: ArrayList<DataClass> = ArrayList<DataClass>()
    var dataList: List<DataResponse> = ArrayList<DataResponse>()

    lateinit var rv_sample: RecyclerView
    lateinit var activity: Activity
    lateinit var remAdapter: RemAdapter
    lateinit var sampleAdapter: SampleAdapter
    lateinit var searchView: SearchView
    lateinit var spinnerData: AppCompatSpinner
    lateinit var sb_level: SeekBar
    lateinit var tv_level: TextView

    private val requestCodeDataRW = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()



      /* runBlocking{

           launch {
                simpleFlow().map{if(it%2==0){it+1}else{it+2} }.collect{
                    println("Inside ${coroutineContext}")
                    println("Inside thread ${Thread.currentThread().name}")
                    println("Collected value is $it") }

               *//*  simpleFlow().map{
                     it -> performRequest(it)
                 }.collect{
                     it -> println("Collected value is $it")
                 }*//*
               println("Processing done")
           }

       }
*/
       /* runBlocking<Unit> {

            simpleFlow()
                .onEach { check(it>4) }
                .catch { cause -> println("Cause of exception is $cause") }
                .onCompletion { println("Execution is finished") }
                .collect()

            val channel = Channel<Int>()
            try {
                launch{
                        for(i in 1..3){
                            channel.send(i*i)
                        }
                        repeat(5){println(channel.receive())}
                }
            } catch (e: Exception) {
            }

        }*/

    }

    private fun getEmployeeList(){
        val retrofitClient = RetrofitClient.getInstance()
        val retrofitInterface = retrofitClient.create(RetrofitInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try{
                val response = retrofitInterface.getTeamList("VXNlck5hbWU9U2FuZGVzaEIjVXNlcmlkPTE3MyNJc1RMPTE=")
                if(response.isSuccessful){
                    val employeeListResponse = response.body()
                    val status = employeeListResponse?.status
                    if(status == true){
                        dataList = employeeListResponse.data
                        Log.e("datalist.size()", dataList.size.toString())
                        sampleAdapter.notifyDataSetChanged()

                    }else{
                        Toast.makeText(applicationContext, "Something went wrong, please try again later.", Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(applicationContext, "Issue in loading data for employees", Toast.LENGTH_SHORT).show()
                }


            }catch (ex: Exception){
                ex.printStackTrace()
            }
        }
    }

    suspend fun performRequest(requestCode: Int): String{
        delay(1000)
        return "Request: $requestCode"
    }

    fun simpleFlow() = flow {
        println("Flow started")
            for (i in 1..5) {
                delay(100)
                emit(i)
            }
        println("inside ${Thread.currentThread().name}")
    }.flowOn(Dispatchers.IO)


    suspend fun haltPrint() {
        val job = CoroutineScope(Dispatchers.IO).launch {
            Log.e("Thread", Thread.currentThread().name)
            delay(2000)
        }

        job.join()

    }

    private fun init() {
        activity = this
        rv_sample = findViewById(R.id.rv_sample)
        searchView = findViewById(R.id.search_view)
        spinnerData = findViewById(R.id.acsp_data)
        sb_level = findViewById(R.id.sb_level)
        tv_level = findViewById(R.id.tv_level)
        findViewById<Button>(R.id.btn_search).setOnClickListener(this)

        if (!checkPermission()) {
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                requestCodeDataRW
            )
        }
        createSamRv();
        getEmployeeList()

        // createRemRv()

        searchItem()
        populateSpData()
        createSeekbar()
    }

    private fun createSeekbar() {
        sb_level.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tv_level.setText(p0?.progress.toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                tv_level.setText(p0?.progress.toString())
            }
        })
    }

    private fun populateSpData() {

        val arrayAdapter = ArrayAdapter<DataClass>(
            applicationContext,
            R.layout.spinner_item,
            R.id.tv_spitem,
            samModelListBckup
        )
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item)
        arrayAdapter.notifyDataSetChanged()
        spinnerData.adapter = arrayAdapter
        spinnerData.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                p3: Long
            ) {
                val selectedItem = adapterView?.selectedItem
                Toast.makeText(applicationContext, "value: $selectedItem", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {
            }
        }
        // spinnerData.onItemSelectedListener()
    }

    private fun searchItem() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                /* if(samModelList.contains()){

                 }*/
                query?.let {
                    if (query.isEmpty()) {
                        if (samModelList.size > 0) {
                            samModelList.clear()
                        }
                        samModelList.addAll(samModelListBckup)
                    }
                }
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                query?.let {
                    if (query.isEmpty()) {
                        if (samModelList.size > 0) {
                            samModelList.clear()
                        }
                        samModelList.addAll(samModelListBckup)
                    } else {
                        filter(it)
                    }
                }
                return false
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun filter(searchKey: String) {
        Log.e("inside", "filter")
        val samModelListResult: ArrayList<DataClass> = ArrayList<DataClass>()

        for (item in samModelListBckup) {
            Log.e("inside", "for")
            if (item.arg1.contains(searchKey, true)) {
                samModelListResult.add(item).also { Log.e("item.name()", item.arg1) }
            } else {
                Log.e("item.arg1", "Else case")
            }
        }

        if (samModelList.size > 0) {
            samModelList.clear()
        }

        samModelList.addAll(samModelListResult)
        sampleAdapter.notifyDataSetChanged()

    }

    private fun createSamRv() {
        samModelList.add(DataClass("Argument1", 4, 5.6f, 2300000, true))
        samModelList.add(DataClass("Argument2", 5, 3.5f, 4823980, true))
        samModelList.add(DataClass("Argument3", 1, 6.7f, 1783979, false))
        samModelList.add(DataClass("Argument4", 40, 1.99f, 4600000, false))
        samModelList.add(DataClass("Argument5", 3, 23.45f, 7700000, true))

        samModelListBckup.addAll(samModelList)

        sampleAdapter =
            SampleAdapter(dataList, applicationContext, object : SampleAdapter.SampleCallback {
                override fun executeOnClick(name: String) {
                    createFile(name)
                }
            })
        sampleAdapter.notifyDataSetChanged()
        val layoutManager = LinearLayoutManager(this)
        rv_sample.layoutManager = layoutManager
        rv_sample.adapter = sampleAdapter



    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            requestCodeDataRW -> {
                val readExtSPerm = PackageManager.PERMISSION_GRANTED == grantResults[0]
                val writeDataPerm = PackageManager.PERMISSION_GRANTED == grantResults[1]

                if (!readExtSPerm || !writeDataPerm) {
                    ActivityCompat.requestPermissions(
                        activity, arrayOf(
                            android.Manifest.permission.READ_EXTERNAL_STORAGE,
                            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                        ), requestCodeDataRW
                    )
                } else {
                    Log.e("Write permission", "granted")
                }
            }
        }

    }

    private fun checkPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            applicationContext,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun createFile(name: String) {
        var dir: File?

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dir = File(Environment.getExternalStorageDirectory().absolutePath + "/MyRVAppDir/")
        } else {
            dir = File(Environment.getExternalStorageDirectory().absolutePath, "MyRVAppDir")
        }

        if (!dir.exists()) {
            dir.mkdir()
        }

        var file: File?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            file = File(dir.absolutePath + "/" + name + "/")
        } else {
            file = File(dir.absolutePath, name)
        }
        if (!file.exists()) {
            file.createNewFile()
        }

        val fileWriter = FileWriter(file, true)
        val bufferWriter = BufferedWriter(fileWriter)
        bufferWriter.append(
            "I/AdrenoGLES-0: PFP: 0x016ee197, ME: 0x00000000\n" +
                    "D/hw-ProcessState: Binder ioctl to enable oneway spam detection failed: Invalid argument\n" +
                    "E/om.npav.myrvap: open libmigui.so failed! dlopen - dlopen failed: library \"libmigui.so\" not found\n" +
                    "D/DecorView[]: onWindowFocusChanged hasWindowFocus true\n" +
                    "D/DecorView[]: onWindowFocusChanged hasWindowFocus false\n" +
                    "W/om.npav.myrvapp: type=1400 audit(0.0:116937): avc: granted { execute } for path=\"" +
                    "/data/data/com.npav.myrvapp/code_cache/startup_agents/69880af5-agent.so\" dev=\"dm-12\" " +
                    "ino=237663 scontext=u:r:untrusted_app:s0:c204,c261,c512,c768 tcontext=u:object_r:app_data_file:s0:c204,c261,c512,c768 tclass=file app=com.npav.myrvapp"
        )
        bufferWriter.newLine()
        bufferWriter.close()

        val bufferedReader = BufferedReader(FileReader(file))
        val fileContent = bufferedReader.readText()
        Log.e("FileContent: ", fileContent)

    }

    private fun createRemRv() {
        remModel.add(RemModel(1, "Rem1", "Desc1"))
        remModel.add(RemModel(2, "Rem2", "Desc2"))
        remModel.add(RemModel(3, "Rem3", "Desc3"))
        remModel.add(RemModel(4, "Rem4", "Desc4"))
        remModel.add(RemModel(5, "Rem5", "Desc5"))
        remModel.add(RemModel(6, "Rem6", "Desc6"))
        remModel.add(RemModel(7, "Rem7", "Desc7"))


        remAdapter = RemAdapter(applicationContext, remModel, object : RemAdapter.RemCallback {
            override fun executeOnClick() {
                val alertDialog = AlertDialog.Builder(activity).setTitle("Sample alert dialog")
                    .setMessage("Sample alert message")
                    .setPositiveButton(android.R.string.yes) { dialog, which ->
                        Toast.makeText(
                            applicationContext,
                            "Yes button clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }.setNegativeButton(android.R.string.no) { dialog, which ->
                        Toast.makeText(
                            applicationContext,
                            "Negative button clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }.setNeutralButton("Neutral") { dialog, which ->
                        Toast.makeText(
                            applicationContext,
                            "Neutral button clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }.create()
                alertDialog.show()
            }
        })
        remAdapter.notifyDataSetChanged()

        val layoutManger = LinearLayoutManager(this)
        rv_sample.layoutManager = layoutManger
        rv_sample.adapter = remAdapter
    }

    override fun onClick(view: View?) {
        val id: Int? = view?.id

        when (id) {
            R.id.btn_search -> {

                createBottomDialog()

                /*  CoroutineScope(Dispatchers.Main).launch {

                      for(i in 0..10 ) Log.e("Before couroutine","$i ")
                      Log.e("Inside",Thread.currentThread().name)
                      haltPrint()
                      for(i in 0..10 ) Log.e("After couroutine","$i ")

                  }*/
            }
        }

    }

    private fun createBottomDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
        val idBtnDismiss = view.findViewById<Button>(R.id.idBtnDismiss)

        idBtnDismiss.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                bottomSheetDialog.dismiss()
            }
        })
        bottomSheetDialog.setCancelable(false)
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()

    }


}


