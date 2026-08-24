package com.xingheyuzhuan.shiguangschedule.ui.schoolselection.web

/**
 * 通用适配脚本
 *
 * 当学校专属的 JS 适配脚本不存在时，使用此脚本作为回退。
 * 它会通过桥接协议提示用户该学校暂无自动导入适配，
 * 用户仍可在 WebView 中手动浏览教务系统。
 */
object GenericAdapterScript {

    val script: String = """
(function() {
    console.log("[时光课程表] 使用通用适配脚本");

    if (window.shiguangBridge) {
        try {
            window.shiguangBridge.showToast("该学校暂无自动导入适配，请手动浏览教务系统");
        } catch(e) {
            console.error("桥接调用失败:", e);
        }

        if (window.shiguangBridgePromise) {
            window.shiguangBridgePromise.showAlert(
                "提示",
                "该学校暂无自动导入适配脚本。\n\n您可以：\n1. 在此页面登录教务系统\n2. 进入课表页面查看课程\n3. 手动添加课程到课表\n\n如需开发适配脚本，请访问项目仓库提交Issue。",
                "知道了"
            ).then(function() {
                console.log("[时光课程表] 用户已确认提示");
            }).catch(function(e) {
                console.error("[时光课程表] 显示提示失败:", e);
            });
        }
    } else {
        console.warn("[时光课程表] 桥接未就绪，仅显示网页");
    }
})();
""".trimIndent()
}
