package com.twq.w7_day4_mvvm.view.home

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.view.profile.ProfileActivity


class UserHolder(v: View) : RecyclerView.ViewHolder(v) {
    var imageViewPhoto = v.findViewById<ImageView>(R.id.imageViewPhoto)
    var textViewUsername = v.findViewById<TextView>(R.id.textViewUsername)
    var textViewEmail = v.findViewById<TextView>(R.id.textViewEmail)

}

class userAdapter(var data: List<User>) : RecyclerView.Adapter<UserHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false)
        return UserHolder(v)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
       Picasso.get().load(data[position].photo).into(holder.imageViewPhoto)
        holder.textViewUsername.text = data[position].username
        holder.textViewEmail.text = data[position].email
        var context = holder.textViewUsername.context





        holder.itemView.setOnClickListener {
            var intent=Intent(context,ProfileActivity::class.java)
                .putExtra("User",data[position])
            context.startActivity(intent)
        }

/*

//              start  profile dialog
        holder.itemView.setOnClickListener {
            var bottomSheetDialog = BottomSheetDialog(holder.textViewUsername.context)
            var view = View.inflate(holder.textViewUsername.context, R.layout.profile_dialog, null)
            var textViewDialogUsername = view.findViewById<EditText>(R.id.textViewDialogUsername)
            var textViewDialogEmail = view.findViewById<TextView>(R.id.textViewDialogEmail)
            var imageViewPhoto = view.findViewById<EditText>(R.id.imageViewPhoto)
            textViewDialogUsername.setText(data[position].email)
            textViewDialogEmail.setText(data[position].email)
            imageViewPhoto.setText(data[position].photo)
            bottomSheetDialog.setCancelable(true)
            bottomSheetDialog.setContentView(view)
            bottomSheetDialog.show()
//             end  profile dialog
}
*/
    }


    override fun getItemCount(): Int {
        return data.size
    }


}

