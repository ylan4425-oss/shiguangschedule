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
 * 每所学校根据其教务系统平台类型，复用官方仓库中的通用平台适配脚本：
 * - 正方教务系统: zhengfang_jiaowu/zhengfang_01.js
 * - 金智/URP教务系统: urp_jiaowu/urp_01.js
 *
 * 教务系统 URL 已通过网络搜索验证。
 */
object SupplementarySchools {

    val schools: List<School> = listOf(
        // --- 云南省 ---
        School(
            id = "WSXY",
            name = "文山学院",
            initial = "W",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "WSXY_01",
                    adapter_name = "文山学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://cas.wsu.edu.cn:4433/lyuapServer/login?service=https://home.wsu.edu.cn:4433/shiro-cas",
                    description = "文山学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "PEXY",
            name = "普洱学院",
            initial = "P",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "PEXY_01",
                    adapter_name = "普洱学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://jwxt.peuni.edu.cn/",
                    description = "普洱学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "BSXY",
            name = "保山学院",
            initial = "B",
            resource_folder = "urp_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "BSXY_01",
                    adapter_name = "保山学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "urp_01.js",
                    import_url = "http://jwgl.bsnc.cn/jsxsd/",
                    description = "保山学院教务系统导入适配（金智/URP）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "ZTXY",
            name = "昭通学院",
            initial = "Z",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "ZTXY_01",
                    adapter_name = "昭通学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "http://jwxt.ztu.edu.cn/xtgl/login_slogin.html",
                    description = "昭通学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "HHXY",
            name = "红河学院",
            initial = "H",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "HHXY_01",
                    adapter_name = "红河学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://jwglxt.uoh.edu.cn/jwglxt/xtgl/login_slogin.html",
                    description = "红河学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "DXKJ",
            name = "滇西科技师范学院",
            initial = "D",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "DXKJ_01",
                    adapter_name = "滇西科技师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "http://211.69.159.74/jwglxt/xtgl/login_slogin.html",
                    description = "滇西科技师范学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "CXSF",
            name = "楚雄师范学院",
            initial = "C",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "CXSF_01",
                    adapter_name = "楚雄师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://jwglxt.cxtc.edu.cn/",
                    description = "楚雄师范学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "YXSF",
            name = "玉溪师范学院",
            initial = "Y",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "YXSF_01",
                    adapter_name = "玉溪师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "http://jwxt1.yxnu.edu.cn",
                    description = "玉溪师范学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "KMTDZY",
            name = "昆明铁道职业技术学院",
            initial = "K",
            resource_folder = "urp_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "KMTDZY_01",
                    adapter_name = "昆明铁道职业技术学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "urp_01.js",
                    import_url = "http://jwcas.kmtdzy.cn:50001/jsxsd/",
                    description = "昆明铁道职业技术学院教务系统导入适配（金智/URP）",
                    maintainer = "community"
                )
            )
        ),

        // --- 贵州省 ---
        School(
            id = "KLYX",
            name = "凯里学院",
            initial = "K",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "KLYX_01",
                    adapter_name = "凯里学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://sys.kluniv.edu.cn:8004/jwglxt/xtgl/login_slogin.html",
                    description = "凯里学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "TRXY",
            name = "铜仁学院",
            initial = "T",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "TRXY_01",
                    adapter_name = "铜仁学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://www.gztrc.edu.cn:17231/",
                    description = "铜仁学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "ASXY",
            name = "安顺学院",
            initial = "A",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "ASXY_01",
                    adapter_name = "安顺学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "http://jwxt.asu.edu.cn/jwweb/home.aspx",
                    description = "安顺学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "LPSS",
            name = "六盘水师范学院",
            initial = "L",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "LPSS_01",
                    adapter_name = "六盘水师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "http://jwgl.lpssy.edu.cn/",
                    description = "六盘水师范学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "XYMZ",
            name = "兴义民族师范学院",
            initial = "X",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "XYMZ_01",
                    adapter_name = "兴义民族师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://jwgl.xynun.edu.cn/xtgl/login_slogin.html",
                    description = "兴义民族师范学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "QNMZ",
            name = "黔南民族师范学院",
            initial = "Q",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "QNMZ_01",
                    adapter_name = "黔南民族师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "http://jwc.sgmtu.edu.cn/jwweb/home.aspx",
                    description = "黔南民族师范学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),

        // --- 广西壮族自治区 ---
        School(
            id = "HCXY",
            name = "河池学院",
            initial = "H",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "HCXY_01",
                    adapter_name = "河池学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://jwxt.hcnu.edu.cn/",
                    description = "河池学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "BSYX",
            name = "百色学院",
            initial = "B",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "BSYX_01",
                    adapter_name = "百色学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "http://jwgl.bsuc.edu.cn/bsxyjw/",
                    description = "百色学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "HZXY",
            name = "贺州学院",
            initial = "H",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "HZXY_01",
                    adapter_name = "贺州学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "http://jwglxt.hzxy.edu.cn/jwglxt",
                    description = "贺州学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "WZXY",
            name = "梧州学院",
            initial = "W",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "WZXY_01",
                    adapter_name = "梧州学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://jwxt.gxuwz.edu.cn/jwglxt/xtgl/login_slogin.html",
                    description = "梧州学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),

        // --- 其他省份 ---
        School(
            id = "WYXY",
            name = "武夷学院",
            initial = "W",
            resource_folder = "urp_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "WYXY_01",
                    adapter_name = "武夷学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "urp_01.js",
                    import_url = "https://jwxt.wuyiu.edu.cn/jsxsd",
                    description = "武夷学院教务系统导入适配（金智/URP）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "LSXY",
            name = "丽水学院",
            initial = "L",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "LSXY_01",
                    adapter_name = "丽水学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://jwxt.lsu.edu.cn/",
                    description = "丽水学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "SYXY",
            name = "邵阳学院",
            initial = "S",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "SYXY_01",
                    adapter_name = "邵阳学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://jwxt.hnsyu.edu.cn/",
                    description = "邵阳学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "HHXY2",
            name = "怀化学院",
            initial = "H",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "HHXY2_01",
                    adapter_name = "怀化学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "http://jwmis.hhtc.edu.cn",
                    description = "怀化学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "YCXY",
            name = "宜春学院",
            initial = "Y",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "YCXY_01",
                    adapter_name = "宜春学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://jwxt.ycu.edu.cn/",
                    description = "宜春学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "JGSU",
            name = "井冈山大学",
            initial = "J",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "JGSU_01",
                    adapter_name = "井冈山大学教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://jw.jgsu.edu.cn/",
                    description = "井冈山大学教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "GZXY",
            name = "广州学院(原广州大学松田学院)",
            initial = "G",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "GZXY_01",
                    adapter_name = "广州学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://jw.gzist.edu.cn/jwglxt/xtgl/login_slogin.html",
                    description = "广州学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "HDXY",
            name = "邯郸学院",
            initial = "H",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "HDXY_01",
                    adapter_name = "邯郸学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://jwgl.hdc.edu.cn/xtgl/login_slogin.html",
                    description = "邯郸学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "XCXY",
            name = "许昌学院",
            initial = "X",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "XCXY_01",
                    adapter_name = "许昌学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "http://jwglxt.xcu.edu.cn/jwglxt",
                    description = "许昌学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "HYXY",
            name = "衡阳师范学院",
            initial = "H",
            resource_folder = "urp_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "HYXY_01",
                    adapter_name = "衡阳师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "urp_01.js",
                    import_url = "https://hysfjw.hynu.edu.cn/jsxsd/",
                    description = "衡阳师范学院教务系统导入适配（金智/URP）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "YYXY",
            name = "岳阳学院",
            initial = "Y",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "YYXY_01",
                    adapter_name = "岳阳学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "https://jwxt.yyu.edu.cn/",
                    description = "岳阳学院教务系统导入适配（正方教务）",
                    maintainer = "community"
                )
            )
        ),
        School(
            id = "NCXY",
            name = "内江师范学院",
            initial = "N",
            resource_folder = "zhengfang_jiaowu",
            adapters = listOf(
                Adapter(
                    adapter_id = "NCXY_01",
                    adapter_name = "内江师范学院教务系统",
                    category = AdapterCategory.BACHELOR_AND_ASSOCIATE,
                    asset_js_path = "zhengfang_01.js",
                    import_url = "http://210.41.183.152/xtgl/login_slogin.html",
                    description = "内江师范学院教务系统导入适配（正方教务，校内网）",
                    maintainer = "community"
                )
            )
        )
    )

    fun existingIds(warehouseSchools: List<School>): Set<String> =
        warehouseSchools.map { it.id }.toSet()

    fun getSupplementarySchools(existingIds: Set<String>): List<School> =
        schools.filter { it.id !in existingIds }
}
