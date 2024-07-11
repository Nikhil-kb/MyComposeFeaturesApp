package com.npav.myrvapp.activity

import android.annotation.SuppressLint
import android.database.Cursor
import android.graphics.Paint.Align
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.UserDictionary
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.List
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.loader.content.CursorLoader
import coil.compose.AsyncImage
import com.npav.myrvapp.R
import com.npav.myrvapp.activity.models.*
import com.npav.myrvapp.activity.new_compose_screens.*
import com.npav.myrvapp.activity.screens.*
import com.npav.myrvapp.activity.ui.theme.MyRVAppTheme
import com.npav.myrvapp.enum.ExEnum
import com.npav.myrvapp.screens.*
import com.npav.myrvapp.viewmodels.IDViewModelProviderFactory
import com.npav.myrvapp.viewmodels.ImageDownloadViewModel
import kotlinx.coroutines.launch

class NewComposeActivity : ComponentActivity() {

    private val TAG = "NewComposeActivity"

    val contentList = listOf(
        ContentModel(
            "Viruses",
            "These are programs that attach themselves to legitimate files and spread when those files are executed. Viruses can corrupt or delete data, spread to other files, and replicate across a system or network.",
            Color(0xFF44B9AE),
            Icons.Outlined.List
        ),
        ContentModel(
            "Worms",
            "Worms are self-replicating programs that spread without needing to attach themselves to other files. They often exploit security vulnerabilities to infect other devices and can cause network congestion and data loss.",
            Color(0xFF2F757E),
            Icons.Outlined.List
        ),
        ContentModel(
            "Trojan Horses",
            "Trojans are malicious programs disguised as legitimate software. They can create backdoors, allowing attackers to gain unauthorized access to a system, steal data , or carry out other malicious activities.",
            Color(0xFFD6CB67),
            Icons.Outlined.List
        ),
        ContentModel(
            "Ransomware",
            "Ransomware encrypts a victim's files and demands a ransom payment in exchange for the decryption key. It can effectively lock users out of their own data until the ransom is paid.",
            Color(0xFF1FAF25),
            Icons.Outlined.List
        ),
        ContentModel(
            "Spyware",
            "Spyware is designed to secretly gather information about a user's activities, often without their knowledge or consent. This information can include personal data, browsing habits, and more.",
            Color(0xFFFF5722),
            Icons.Outlined.List
        ),
        ContentModel(
            "Adware",
            "Adware displays unwanted advertisements on a user's system. While not always harmful in the traditional sense, it can be intrusive and impact system performance.",
            Color(0xFF550DD5),
            Icons.Outlined.List
        ),
        ContentModel(
            "Keyloggers",
            "Keyloggers record the keystrokes made by a user, allowing attackers to capture sensitive information like passwords, credit card numbers, and other confidential data.",
            Color(0xFF0E65AA),
            Icons.Outlined.List
        )

    )

    val checkItemList = listOf(
        "item1",
        "item2",
        "item3",
        "item4",
        "item5",
        "item6",
        "item7",
        "item8"
    )

    val waFeatureList = mutableListOf<GridFeaturesModel>(
        GridFeaturesModel(
            image = Icons.Default.Send,
            title = "Document",
            color = Color.Gray
        ),


        GridFeaturesModel(
            image = Icons.Default.Call,
            title = "Camera",
            color = Color.LightGray
        ),


        GridFeaturesModel(
            image = Icons.Default.Email,
            title = "Gallery",
            color = Color.Red
        ),


        GridFeaturesModel(
            image = Icons.Default.Favorite,
            title = "Audio",
            color = Color.Green
        ),


        GridFeaturesModel(
            image = Icons.Default.Edit,
            title = "Catalogue",
            color = Color.Magenta
        ),


        GridFeaturesModel(
            image = Icons.Default.Home,
            title = "Quick Reply",
            color = Color.Cyan
        ),


        GridFeaturesModel(
            image = Icons.Default.CheckCircle,
            title = "Location",
            color = Color.Blue
        ),

        GridFeaturesModel(
            image = Icons.Default.Clear,
            title = "Contact",
            color = Color.Yellow
        ),

        GridFeaturesModel(
            image = Icons.Default.AddCircle,
            title = "Poll",
            color = Color.Green
        )

    )

    val featureList = mutableListOf<FeatureModel>()
    val intermediateMessageList = ArrayList<MessageData>()

    val staggeredDataModelList = ArrayList<StaggeredDataModel>()

    @SuppressLint("Range")
    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createFeatureList()

        Log.e(TAG, "onCreate: ${ExEnum.CYAN} - ${ExEnum.CYAN.ordinal}")
        val diViewModel = ViewModelProvider(this, IDViewModelProviderFactory(application)).get(
            ImageDownloadViewModel::class.java
        )

        setContent {
            MyRVAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {

                    Button(onClick = {
                        diViewModel.downloadImageFromUrl(
                            context = application,
                            "https://buffer.com/cdn-cgi/image/w=1000,fit=contain,q=90,f=auto/library/content/images/size/w600/2023/10/free-images.jpg"
                        )
                    }) {
                            Text(text = "Download Image")
                    }


                    //createMessageDataList()
                    //ChatCompose(intermediateMessageList, waFeatureList)
                    //FlowRowComposeNew()
                    //SingleImagePicker()
                    //IntrinsicCompose()
                    //SelectImageCompose()

                    /*
                    var wordsCursor: Cursor? = null
                    val project: Array<String> = arrayOf(
                        ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
                    )

                    val cursorLoader = CursorLoader(this,
                        ContactsContract.Contacts.CONTENT_URI,
                        project,
                        null,
                        null,
                        null
                        )
                    wordsCursor = cursorLoader.loadInBackground()

                    var words = "\n"

                    when (wordsCursor?.count) {
                        null -> {
                            Toast.makeText(LocalContext.current, "Exception", Toast.LENGTH_SHORT).show()
                        }

                        0 -> {
                            Toast.makeText(LocalContext.current, "No match found", Toast.LENGTH_SHORT).show()
                        }

                        else -> {
                            while (wordsCursor.moveToNext()){
                                words += wordsCursor.getString(wordsCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)) + "\n"

                            }
                        }
                    }

                    ContentProviderCompose("Words: $words")*/

                    //ModalDrawerNewCompose()
                    //HorizontalPagerCompose2(checkItemList, featureList)
                    //FlowRowCompose()
                    // VerticalPagerCompose()
                    //HPContainerCompose()
                    //GradientCardCompose()
                    //RadioButtonCompose()
                    //SwitchCompose()
                    //CheckBoxCompose(checkItemList)
                    //ContentsComposeList(contentList = contentList)
                    //ExposedDropdownBoxCompose()
                    //BlackGridComposable()
                }
            }
        }

    }


    private fun createMessageDataList() {
        intermediateMessageList.add(
            MessageData(
                "Cache value1",
                "A very common pattern is to have the UI observe a LiveData source (for example, using Room as the source of truth) and have another process to update it like fetching new data from network and writing it to the database."
            )
        )
        intermediateMessageList.add(
            MessageData(
                "Cache value2",
                "A very common pattern is to have the UI observe a LiveData source (for example, using Room as the source of truth) and have another process to update it like fetching new data from network and writing it to the database."
            )
        )
        intermediateMessageList.add(
            MessageData(
                "Cache value3",
                "A very common pattern is to have the UI observe a LiveData source (for example, using Room as the source of truth) and have another process to update it like fetching new data from network and writing it to the database."
            )
        )
        intermediateMessageList.add(
            MessageData(
                "Cache value4",
                "A very common pattern is to have the UI observe a LiveData source (for example, using Room as the source of truth) and have another process to update it like fetching new data from network and writing it to the database."
            )
        )
        intermediateMessageList.add(
            MessageData(
                "Cache value5",
                "A very common pattern is to have the UI observe a LiveData source (for example, using Room as the source of truth) and have another process to update it like fetching new data from network and writing it to the database."
            )
        )
        intermediateMessageList.add(
            MessageData(
                "Cache value6",
                "A very common pattern is to have the UI observe a LiveData source (for example, using Room as the source of truth) and have another process to update it like fetching new data from network and writing it to the database."
            )
        )
        intermediateMessageList.add(
            MessageData(
                "Cache value7",
                "A very common pattern is to have the UI observe a LiveData source (for example, using Room as the source of truth) and have another process to update it like fetching new data from network and writing it to the database."
            )
        )
    }

    private fun createFeatureList() {
        featureList.add(FeatureModel(1, "Duplicate File Fixer", R.drawable.ic_malicious_app_new))
        featureList.add(FeatureModel(2, "Schedule Scan", R.drawable.ic_maliciious_files_new))
        featureList.add(FeatureModel(3, "Motion Alarm", R.drawable.ic_weak_settings_new))
        featureList.add(FeatureModel(4, "Apps Usage", R.drawable.ic_trojans_new))
        featureList.add(FeatureModel(5, "Photo Vault", R.drawable.ic_adware_new))
        featureList.add(FeatureModel(6, "App Manager", R.drawable.ic_spyware_new))
        featureList.add(FeatureModel(7, "Privacy Control", R.drawable.ic_ransomeware_new))
        featureList.add(FeatureModel(8, "Lock An App", R.drawable.ic_phishing_new))
        featureList.add(FeatureModel(9, "SMS Phishing", R.drawable.ic_spam_new))
    }

}




