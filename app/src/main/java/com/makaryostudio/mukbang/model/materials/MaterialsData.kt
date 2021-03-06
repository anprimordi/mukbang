package com.makaryostudio.mukbang.model.materials

import com.makaryostudio.mukbang.R

object MaterialsData {
    var listMaterials: ArrayList<Materials> = arrayListOf(
        Materials(
            R.drawable.ic_cube_24,
            "Kubus & Balok",
            "mat_cube.pdf"
        ),
        Materials(
            R.drawable.ic_prism_blue,
            "Prisma",
            "mat_prism_1.pdf"
        ),
        Materials(
            R.drawable.ic_pyramid_purple,
            "Limas",
            "mat_pyramid.pdf"
        )
    )
}