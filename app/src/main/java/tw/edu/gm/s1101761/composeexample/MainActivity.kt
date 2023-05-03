package tw.edu.gm.s1101761.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.edu.gm.s1101761.composeexample.ui.theme.ComposeExampleTheme
import kotlin.text.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var Animals = arrayListOf(R.drawable.animal0, R.drawable.animal1,
        R.drawable.animal2, R.drawable.animal3,
        R.drawable.animal4, R.drawable.animal5,
        R.drawable.animal6, R.drawable.animal7,
        R.drawable.animal8, R.drawable.animal9)

    var AnimalsName = arrayListOf("鴨子","企鵝","青蛙","貓頭鷹","海豚",
        "牛", "無尾熊", "獅子", "狐狸", "小雞")
    var msg = remember{ mutableStateOf("行動應用軟體開發")}
    var msg1 = remember{ mutableStateOf("請按我 ヾ(´ε`ヾ)")}
    var msg2 = remember{ mutableStateOf("趕緊的")}

    LazyRow{
        items(41){index ->
            Text(text = AnimalsName[index % 10])
            Image(
                painter = painterResource(id = Animals[index % 10]),
                contentDescription = "手掌圖片" ,
                modifier = Modifier.fillParentMaxWidth(1.0f))
            Text(text = " ")

        }

        item{

            Text(text = msg.value)
            Text(text = "作者:顏偉森")

            TextField(
                value = msg.value,
                onValueChange = {newText ->
                    msg.value = newText
                },
                label = { Text(text = "訊息")},
                placeholder = { Text(text = "請輸入你想表達的文字")}
            )

            Button(
                onClick = {
                    if (msg.value == "行動應用軟體開發"){
                        msg.value = "我這學期一定要ALL PASS ⁽⁽٩(๑˃̶͈̀ ᗨ ˂̶͈́)۶⁾⁾"
                        msg1.value = "還不按我 Σ(ﾟДﾟ；≡；ﾟдﾟ)"
                        msg2.value = "快來不及了"
                    }
                    else if(msg.value == "我這學期一定要ALL PASS ⁽⁽٩(๑˃̶͈̀ ᗨ ˂̶͈́)۶⁾⁾"){
                        msg.value = "悲哀人生，勉強過日子 (;´༎ຶД༎ຶ`)"
                        msg1.value = "你會後悔的▄︻┻┳═一"
                        msg2.value = "你給我等著\n"+"我記住你了"


                    }
                    else {
                        msg.value = "行動應用軟體開發"
                        msg1.value = "請按我 ヾ(´ε`ヾ)"
                        msg2.value = "趕緊的"
                    }
                },

                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                shape = RoundedCornerShape(40.dp),
                border = BorderStroke(3.dp, Color.Blue),
                elevation =  ButtonDefaults.elevation(
                    defaultElevation = 50.dp,
                    pressedElevation = 45.dp,
                    disabledElevation = 0.dp
                )

            ) {
                Text(text = msg1.value, color = Color.Blue)

                Image(
                    painterResource(id = R.drawable.animal10),
                    contentDescription ="Cart button icon",
                    modifier = Modifier.size(40.dp))

                Text(text = msg2.value, color = Color.Red)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeExampleTheme {
        Greeting("Android")
    }
}