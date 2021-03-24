package com.makaryostudio.mukbang.model.materials

import com.makaryostudio.mukbang.R

object MaterialsData {
    val listMaterials: ArrayList<Materials> = arrayListOf(
        Materials(
            R.drawable.ic_cube_24,
            "Kubus",
            "mat_cube.pdf"
        ),
        Materials(
            R.drawable.ic_prism_blue,
            "Prisma",
            "mat_prism.pdf"
        ),
        Materials(
            R.drawable.ic_pyramid_purple,
            "Limas",
            "mat_pyramid.pdf"
        )
    )
}