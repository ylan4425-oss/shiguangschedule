package com.xingheyuzhuan.shiguangschedule.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * 赞赏二维码图片。
 * 由于 Compose Multiplatform 资源对 PNG 的支持在本项目配置下不稳定，
 * 使用 expect/actual 由各平台自行提供实现；Android 端使用 Android 资源加载。
 */
@Composable
expect fun DonateQrImage(modifier: Modifier = Modifier)
