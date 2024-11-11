import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitapi.Model.Users
import com.example.retrofitapi.databinding.ItemUserBinding

class UserAdapter(private val userList: List<Users>, private val onItemClick: (Users) -> Unit) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Users) {
            with(binding) {
                tvName.text = user.firstName
                tvEmail.text = user.email
                Glide.with(imgAvatar.context)
                    .load(user.avatar)
                    .into(imgAvatar)

                itemView.setOnClickListener {
                    onItemClick(user)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount() = userList.size
}
