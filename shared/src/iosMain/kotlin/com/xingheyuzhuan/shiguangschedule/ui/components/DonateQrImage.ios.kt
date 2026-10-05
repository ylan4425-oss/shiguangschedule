/*
 * 文件已被修改（Modified file）— 依据 Apache License 2.0 第 4(b) 条标注。
 * 原始项目：时光课程表（Copyright 2025 XingHeYuZhuan，Apache License 2.0）。
 * 本文件在原项目基础上由维护者修改，具体修改见仓库根目录 NOTICE 文件。
 * 原始许可证与版权声明见仓库根目录 LICENSE 文件，本文件其余部分仍受原许可证约束。
 */
package com.xingheyuzhuan.shiguangschedule.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import shiguangschedule.shared.generated.resources.Res

@Composable
actual fun DonateQrImage(modifier: Modifier) {
    // 使用 Compose Resources 中的赞赏二维码（与 Android / 桌面共用同一份资源）。
    Image(
        painter = painterResource(Res.drawable.donate_qr),
        contentDescription = "赞赏码",
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}
