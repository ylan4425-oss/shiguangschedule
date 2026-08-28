package com.xingheyuzhuan.shiguangschedule.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DonateCapsuleButton(
    modifier: Modifier = Modifier
) {
    // 平台能力守卫：无赞赏二维码资源的平台直接隐藏入口，避免点击后弹出空二维码。
    // iOS / 桌面端现已通过 Compose Resources 提供二维码，故三端均为 true。
    if (!isDonateQrSupported) return

    var showDialog by remember { mutableStateOf(false) }

    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val capsuleScale by androidx.compose.animation.core.animateFloatAsState(
        targetValue = if (pressed) 0.9f else 1f,
        animationSpec = tween(durationMillis = 150),
        label = "capsuleScale"
    )

    // 收缩态：竖版胶囊（赞/赏 两字上下排列）
    Column(
        modifier = modifier
            .graphicsLayer {
                scaleX = capsuleScale
                scaleY = capsuleScale
            }
            .clip(RoundedCornerShape(16.dp))
            .background(
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.92f)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                showDialog = true
            }
            .padding(vertical = 10.dp, horizontal = 7.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "赞",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            lineHeight = 14.sp
        )
        Text(
            text = "赏",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            lineHeight = 14.sp
        )
    }

    // 全屏遮罩 + 卡片弹窗。
    // 不用 Dialog：Dialog 会随 showDialog=false 立即卸载，导致 exit 动画被中断。
    // 用 AnimatedVisibility(visible = showDialog) 会在合成树中保留内容直到退场动画结束，
    // 从而正常播放 fade/scale 退出动画。
    AnimatedVisibility(
        visible = showDialog,
        enter = fadeIn(animationSpec = tween(durationMillis = 200)),
        exit = fadeOut(animationSpec = tween(durationMillis = 150)),
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.45f))
                .clickable { showDialog = false },
            contentAlignment = Alignment.Center
        ) {
            // 卡片：缩放入场 / 退场
            AnimatedVisibility(
                visible = showDialog,
                enter = scaleIn(
                    initialScale = 0.85f,
                    animationSpec = tween(durationMillis = 250)
                ),
                exit = scaleOut(
                    targetScale = 0.85f,
                    animationSpec = tween(durationMillis = 150)
                )
            ) {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    modifier = Modifier
                        .padding(horizontal = 40.dp)
                        .fillMaxWidth()
                        // 消费卡片区域的点击，避免穿透到遮罩导致误关闭
                        .clickable { }
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                    ) {
                        // 顶部标题 + 关闭按钮
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "支持开发者",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(RoundedCornerShape(50))
                                    .background(
                                        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                                    )
                                    .clickable {
                                        showDialog = false
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "✕",
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "扫码赞赏，感谢支持",
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        Box(
                            modifier = Modifier
                                .size(200.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(MaterialTheme.colorScheme.surfaceVariant),
                            contentAlignment = Alignment.Center
                        ) {
                            DonateQrImage(modifier = Modifier.fillMaxSize())
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "点击任意位置关闭",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                        )
                    }
                }
            }
        }
    }

    // 系统返回键关闭
    BackHandler(enabled = showDialog) {
        showDialog = false
    }
}
