package com.xingheyuzhuan.shiguangschedule.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.xingheyuzhuan.shiguangschedule.shared.R

@Composable
actual fun DonateQrImage(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.donate_qr),
        contentDescription = "赞赏码",
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}
