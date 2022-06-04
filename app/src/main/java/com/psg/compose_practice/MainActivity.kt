package com.psg.compose_practice

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.psg.compose_practice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}


// Column, Row, 곂치기 Box

@Composable
fun Greeting(name: String) {
    Scaffold( // Material 디자인 사용 가능
        topBar = {
            TopAppBar(title = { Text("컴포즈 테스트 앱") },
                backgroundColor = Color(0xfff25287))
    },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = { }) {
            Text(text = "클릭")
        } }
    ) {
//        Text(text = "Hello $name!")
        MyComposableView()
    }
}

@Composable
fun MyRowItem(){
    Row(
        Modifier
            .padding(10.dp)
            .background(Color(0xffeaffd0))
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "안녕하세요!",
            Modifier
                .padding(all = 10.dp)
                .background(Color.Yellow))
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요!")
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요!")
    }
}

@Composable
fun MyComposableView(){
    Log.d("TAG", "MyComposableView: ")
    // Horizontal Linear
//    Row(
//        Modifier
//            .padding(10.dp)
//            .background(Color(0xffeaffd0)),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(text = "안녕하세요!",
//            Modifier
//                .padding(all = 10.dp)
//                .background(Color.Yellow))
//        Spacer(modifier = Modifier.size(10.dp))
//        Text(text = "안녕하세요!")
//        Spacer(modifier = Modifier.size(10.dp))
//        Text(text = "안녕하세요!")
//    }

    // Vertical Linear
    Column(
        Modifier
            .background(Color.Green)
            .verticalScroll(rememberScrollState())
    ) {
        for (i in 0..30){
            MyRowItem()
        }
    }
//        Row(
//            Modifier
//                .padding(10.dp)
//                .background(Color(0xffeaffd0)),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(text = "안녕하세요!",
//                Modifier
//                    .padding(all = 10.dp)
//                    .background(Color.Yellow))
//            Spacer(modifier = Modifier.size(10.dp))
//            Text(text = "안녕하세요!")
//            Spacer(modifier = Modifier.size(10.dp))
//            Text(text = "안녕하세요!")
//        }
//        Row(
//            Modifier
//                .padding(10.dp)
//                .background(Color(0xffeaffd0)),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(text = "안녕하세요!",
//                Modifier
//                    .padding(all = 10.dp)
//                    .background(Color.Yellow))
//            Spacer(modifier = Modifier.size(10.dp))
//            Text(text = "안녕하세요!")
//            Spacer(modifier = Modifier.size(10.dp))
//            Text(text = "안녕하세요!")
//        }
//    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        Greeting("Android")
    }
}