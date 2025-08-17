package com.example.upp_app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*

@Composable
fun Listing(
    names: List<String>,
    modifier: Modifier = Modifier,
    itemContent: @Composable (index: Int, name: String, firstVisibleIndex: Int, scrollOffset: Int) -> Unit
) {
    val listState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier.padding(vertical = 4.dp),
        state = listState
    ) {
        itemsIndexed(names) { index, name ->
            itemContent(
                index,
                name,
                listState.firstVisibleItemIndex,
                listState.firstVisibleItemScrollOffset
            )
        }
        item {
            Spacer(modifier = Modifier.height(96.dp))
        }
    }
}



/*@Composable
fun Listing(
    names: List<String> = List(10){"Item #$it"},
){
    LazyColumn (
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        items(names.size) { index ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            )
            {
                Row (
                    modifier = Modifier.padding(8.dp).fillMaxWidth()
                ){
                    Column (
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .weight(1f)
                    ){
                        Message(
                            title = names[index],
                            subtitle = "This is the subtitle of ${names[index]}"
                        )
                    }
                }
            }
        }


    }
}*/