/*
 * 新增文件（New file）— 基于 Apache License 2.0 贡献。
 * 原始项目：时光课程表（Copyright 2025 XingHeYuZhuan，Apache License 2.0）。
 * 本文件由维护者新增，整体分发仍须遵守 Apache License 2.0。
 * 详见仓库根目录 LICENSE 与 NOTICE 文件。
 */
package com.xingheyuzhuan.shiguangschedule.ui.components

/**
 * 平台是否支持展示赞赏二维码。
 *
 * 赞赏二维码为 Android 专属资源（微信/支付宝赞赏码 PNG），
 * 桌面端（jvm）与 iOS 端目前没有对应的二维码资源。
 * 为避免在这两个平台上渲染出“点击后弹出空二维码”的坏体验，
 * 用该能力标志统一控制赞赏入口的显隐，而非在各处散落 no-op 判断。
 */
expect val isDonateQrSupported: Boolean
