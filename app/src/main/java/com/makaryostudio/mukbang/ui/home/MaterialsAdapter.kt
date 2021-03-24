package com.makaryostudio.mukbang.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.makaryostudio.mukbang.databinding.ItemMaterialsBinding
import com.makaryostudio.mukbang.model.materials.Materials

class MaterialsAdapter(
    private val context: Context,
    private val list: ArrayList<Materials>
) : RecyclerView.Adapter<MaterialsAdapter.ViewHolder>() {

    class ViewHolder(private val itemMaterialsBinding: ItemMaterialsBinding) :
        RecyclerView.ViewHolder(itemMaterialsBinding.root) {
        fun bindView(materials: Materials) {
            itemMaterialsBinding.imageItemThumbnail.setImageResource(materials.thumbnail)
            itemMaterialsBinding.imageItemTitle.text = materials.title
            itemMaterialsBinding.imageItemBody.text =
                when (materials.completed) {
                    false -> "Belum Selesai"
                    true -> "Selesai"
                }

//            when (materials.completed) {
//                false -> itemMaterialsBinding.imageItemBody.text = "Belum selesai"
//                true -> itemMaterialsBinding.imageItemBody.text = "Selesai"
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemMaterialsBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listMaterials = list[position]
        holder.bindView(listMaterials)
    }

    override fun getItemCount(): Int = list.size
}