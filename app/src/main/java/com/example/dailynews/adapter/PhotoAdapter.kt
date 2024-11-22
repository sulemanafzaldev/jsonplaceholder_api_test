package com.example.dailynews.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dailynews.databinding.ItemPhotoBinding
import com.example.dailynews.model.PhotoResponseItem
import com.example.dailynews.ui.DetailActivity

class PhotoAdapter(private val list_Photo: List<PhotoResponseItem>,private val context: Context) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    class PhotoViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: PhotoResponseItem) {
            binding.textTitle.text = photo.title
            binding.tvId.text = photo.id.toString()
            Glide.with(binding.root.context)
                .load(photo.thumbnailUrl)
                .into(binding.imageThumbnail)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = list_Photo[position]
        holder.bind(photo)

        holder.itemView.setOnClickListener {
            val intent = Intent(context , DetailActivity::class.java)

            intent.putExtra("PHOTO_ID", photo.id)
            intent.putExtra("PHOTO_TITLE", photo.title)
            intent.putExtra("PHOTO_URL", photo.url)
            intent.putExtra("PHOTO_THUMBNAIL", photo.thumbnailUrl)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = list_Photo.size

}