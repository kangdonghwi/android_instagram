package kr.ac.mjc.dongstargram

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import  android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.widget.ImageView
import com.bumptech.glide.Glide

class PhotoAdapter(var context: Context,var postList:ArrayList<Post>) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_photo,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var post =postList[position]
        holder.bind(post)
    }

    inner class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        var imageIv:ImageView= itemView.findViewById(R.id.image_iv)

        fun bind(post:Post){
            Glide.with(imageIv).load(post.imageUrl).into(imageIv)
        }
    }
}