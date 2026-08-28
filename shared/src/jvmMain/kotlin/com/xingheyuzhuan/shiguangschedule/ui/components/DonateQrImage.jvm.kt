package com.xingheyuzhuan.shiguangschedule.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import shiguangschedule.shared.generated.resources.Res

@Composable
actual fun DonateQrImage(modifier: Modifier) {
    // 使用 Compose Resources 中的赞赏二维码（与 Android / iOS 共用同一份资源）。
    Image(
        painter = painterResource(Res.drawable.donate_qr),
        contentDescription = "赞赏码",
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}
