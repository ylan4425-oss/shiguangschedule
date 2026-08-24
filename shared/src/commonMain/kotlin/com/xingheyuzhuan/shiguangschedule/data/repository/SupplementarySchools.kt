package com.xingheyuzhuan.shiguangschedule.data.repository

import school_index.Adapter
import school_index.AdapterCategory
import school_index.School

/**
 * 补充学校列表
 *
 * 这些学校未包含在官方适配仓库 (shiguang_warehouse) 中，
 * 在此以代码形式内置，确保小众院校用户也能在列表中找到自己的学校。
 *
 * 注意：学校教务系统 URL 基于常见模式推测，可能需要更新。
 * 实际的 JS 适配脚本 (asset_js_path) 需后续开发，否则 WebView 可打开教务页面但无法自动导入课程。
 */
object SupplementarySchools {

    val schools: List<School> = listOf(
        // --- 云南省 ---
        School(
            id = "WSXY",
            name = "文山学院",
            initial = "W",
            resource_folder = "wsxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "WSXY_01",
                    adapter_name = "文山学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "wsxy.js",
                    import_url = "https://jwxt.wsxy.edu.cn/",
                    description = "文山学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "PEXY",
            name = "普洱学院",
            initial = "P",
            resource_folder = "pexy",
            adapters = listOf(
                Adapter(
                    adapter_id = "PEXY_01",
                    adapter_name = "普洱学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "pexy.js",
                    import_url = "https://jwxt.peuni.edu.cn/",
                    description = "普洱学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "BSXY",
            name = "保山学院",
            initial = "B",
            resource_folder = "bsxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "BSXY_01",
                    adapter_name = "保山学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "bsxy.js",
                    import_url = "https://jwxt.bsxy.edu.cn/",
                    description = "保山学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "ZTXY",
            name = "昭通学院",
            initial = "Z",
            resource_folder = "ztxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "ZTXY_01",
                    adapter_name = "昭通学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "ztxy.js",
                    import_url = "https://jwxt.ztu.edu.cn/",
                    description = "昭通学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "HHXY",
            name = "红河学院",
            initial = "H",
            resource_folder = "hhxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "HHXY_01",
                    adapter_name = "红河学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "hhxy.js",
                    import_url = "https://jwxt.uoh.edu.cn/",
                    description = "红河学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "DXKJ",
            name = "滇西科技师范学院",
            initial = "D",
            resource_folder = "dxkj",
            adapters = listOf(
                Adapter(
                    adapter_id = "DXKJ_01",
                    adapter_name = "滇西科技师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "dxkj.js",
                    import_url = "https://jwxt.wdxu.edu.cn/",
                    description = "滇西科技师范学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "CXSF",
            name = "楚雄师范学院",
            initial = "C",
            resource_folder = "cxsf",
            adapters = listOf(
                Adapter(
                    adapter_id = "CXSF_01",
                    adapter_name = "楚雄师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "cxsf.js",
                    import_url = "https://jwxt.cxtc.edu.cn/",
                    description = "楚雄师范学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "YXSF",
            name = "玉溪师范学院",
            initial = "Y",
            resource_folder = "yxsf",
            adapters = listOf(
                Adapter(
                    adapter_id = "YXSF_01",
                    adapter_name = "玉溪师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "yxsf.js",
                    import_url = "https://jwxt.yxtc.edu.cn/",
                    description = "玉溪师范学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),

        // --- 贵州省 ---
        School(
            id = "KLYX",
            name = "凯里学院",
            initial = "K",
            resource_folder = "klyx",
            adapters = listOf(
                Adapter(
                    adapter_id = "KLYX_01",
                    adapter_name = "凯里学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "klyx.js",
                    import_url = "https://jwxt.kluniv.edu.cn/",
                    description = "凯里学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "TRXY",
            name = "铜仁学院",
            initial = "T",
            resource_folder = "trxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "TRXY_01",
                    adapter_name = "铜仁学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "trxy.js",
                    import_url = "https://jwxt.tru.edu.cn/",
                    description = "铜仁学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "ASXY",
            name = "安顺学院",
            initial = "A",
            resource_folder = "asxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "ASXY_01",
                    adapter_name = "安顺学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "asxy.js",
                    import_url = "https://jwxt.asu.edu.cn/",
                    description = "安顺学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "LPSS",
            name = "六盘水师范学院",
            initial = "L",
            resource_folder = "lpss",
            adapters = listOf(
                Adapter(
                    adapter_id = "LPSS_01",
                    adapter_name = "六盘水师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "lpss.js",
                    import_url = "https://jwxt.lpssy.edu.cn/",
                    description = "六盘水师范学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "XYMZ",
            name = "兴义民族师范学院",
            initial = "X",
            resource_folder = "xymz",
            adapters = listOf(
                Adapter(
                    adapter_id = "XYMZ_01",
                    adapter_name = "兴义民族师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "xymz.js",
                    import_url = "https://jwxt.xynun.edu.cn/",
                    description = "兴义民族师范学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "QNMZ",
            name = "黔南民族师范学院",
            initial = "Q",
            resource_folder = "qnmz",
            adapters = listOf(
                Adapter(
                    adapter_id = "QNMZ_01",
                    adapter_name = "黔南民族师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "qnmz.js",
                    import_url = "https://jwxt.sgmtu.edu.cn/",
                    description = "黔南民族师范学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),

        // --- 广西壮族自治区 ---
        School(
            id = "HCXY",
            name = "河池学院",
            initial = "H",
            resource_folder = "hcxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "HCXY_01",
                    adapter_name = "河池学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "hcxy.js",
                    import_url = "https://jwxt.hcnu.edu.cn/",
                    description = "河池学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "BSYX",
            name = "百色学院",
            initial = "B",
            resource_folder = "bsyx",
            adapters = listOf(
                Adapter(
                    adapter_id = "BSYX_01",
                    adapter_name = "百色学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "bsyx.js",
                    import_url = "https://jwxt.bsuc.edu.cn/",
                    description = "百色学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "HZXY",
            name = "贺州学院",
            initial = "H",
            resource_folder = "hzxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "HZXY_01",
                    adapter_name = "贺州学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "hzxy.js",
                    import_url = "https://jwxt.hzu.gx.cn/",
                    description = "贺州学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "WZXY",
            name = "梧州学院",
            initial = "W",
            resource_folder = "wzxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "WZXY_01",
                    adapter_name = "梧州学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "wzxy.js",
                    import_url = "https://jwxt.wzu.edu.cn/",
                    description = "梧州学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),

        // --- 其他省份 ---
        School(
            id = "WYXY",
            name = "武夷学院",
            initial = "W",
            resource_folder = "wyxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "WYXY_01",
                    adapter_name = "武夷学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "wyxy.js",
                    import_url = "https://jwxt.wuyiu.edu.cn/",
                    description = "武夷学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "LSXY",
            name = "丽水学院",
            initial = "L",
            resource_folder = "lsxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "LSXY_01",
                    adapter_name = "丽水学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "lsxy.js",
                    import_url = "https://jwxt.lsu.edu.cn/",
                    description = "丽水学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "SYXY",
            name = "邵阳学院",
            initial = "S",
            resource_folder = "syxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "SYXY_01",
                    adapter_name = "邵阳学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "syxy.js",
                    import_url = "https://jwxt.hnsyu.edu.cn/",
                    description = "邵阳学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "HHXY2",
            name = "怀化学院",
            initial = "H",
            resource_folder = "hhxy2",
            adapters = listOf(
                Adapter(
                    adapter_id = "HHXY2_01",
                    adapter_name = "怀化学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "hhxy2.js",
                    import_url = "https://jwxt.hhtc.edu.cn/",
                    description = "怀化学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "YCXY",
            name = "宜春学院",
            initial = "Y",
            resource_folder = "ycxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "YCXY_01",
                    adapter_name = "宜春学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "ycxy.js",
                    import_url = "https://jwxt.ycu.edu.cn/",
                    description = "宜春学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "JGSU",
            name = "井冈山大学",
            initial = "J",
            resource_folder = "jgsu",
            adapters = listOf(
                Adapter(
                    adapter_id = "JGSU_01",
                    adapter_name = "井冈山大学教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "jgsu.js",
                    import_url = "https://jwxt.jgsu.edu.cn/",
                    description = "井冈山大学教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "GZXY",
            name = "广州学院(原广州大学松田学院)",
            initial = "G",
            resource_folder = "gzxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "GZXY_01",
                    adapter_name = "广州学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "gzxy.js",
                    import_url = "https://jwxt.gzist.edu.cn/",
                    description = "广州学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "HDXY",
            name = "邯郸学院",
            initial = "H",
            resource_folder = "hdxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "HDXY_01",
                    adapter_name = "邯郸学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "hdxy.js",
                    import_url = "https://jwxt.hdc.edu.cn/",
                    description = "邯郸学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "XCXY",
            name = "许昌学院",
            initial = "X",
            resource_folder = "xcxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "XCXY_01",
                    adapter_name = "许昌学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "xcxy.js",
                    import_url = "https://jwxt.xcu.edu.cn/",
                    description = "许昌学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "HYXY",
            name = "衡阳师范学院",
            initial = "H",
            resource_folder = "hyxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "HYXY_01",
                    adapter_name = "衡阳师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "hyxy.js",
                    import_url = "https://jwxt.hynu.edu.cn/",
                    description = "衡阳师范学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "YYXY",
            name = "岳阳学院",
            initial = "Y",
            resource_folder = "yyxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "YYXY_01",
                    adapter_name = "岳阳学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "yyxy.js",
                    import_url = "https://jwxt.yyu.edu.cn/",
                    description = "岳阳学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "NCXY",
            name = "内江师范学院",
            initial = "N",
            resource_folder = "ncxy",
            adapters = listOf(
                Adapter(
                    adapter_id = "NCXY_01",
                    adapter_name = "内江师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "ncxy.js",
                    import_url = "https://jwxt.njtc.edu.cn/",
                    description = "内江师范学院教务系统导入适配",
                    maintainer = "community"
                )
            )
        )
    )

    /**
     * 已存在的学校 ID 集合，用于去重。
     */
    fun existingIds(warehouseSchools: List<School>): Set<String> =
        warehouseSchools.map { it.id }.toSet()

    /**
     * 获取补充学校列表，排除已在仓库中存在的学校。
     */
    fun getSupplementarySchools(existingIds: Set<String>): List<School> =
        schools.filter { it.id !in existingIds }
}
