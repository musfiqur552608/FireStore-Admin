package com.example.firestoreapp2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firestoreapp2.databinding.UserItemBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Adapter(var context: Context, var list: ArrayList<User>):RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(var binding:UserItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return  ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.nameTxt.text = list.get(position).name
        holder.binding.passtxt.text = list.get(position).pass
        holder.binding.deleteBtn.setOnClickListener {
            val db = Firebase.firestore
            db.collection("users").document(list.get(position).id!!).delete().addOnSuccessListener {
                Toast.makeText(context,"Delete", Toast.LENGTH_SHORT).show()
                notifyDataSetChanged()
            }.addOnFailureListener({
                Toast.makeText(context,"Failed to delete", Toast.LENGTH_SHORT).show()
            })
        }
    }
}