package ge.nlatsabidze.retrofitexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ge.nlatsabidze.retrofitexample.databinding.ItemTodoBinding

class InfoAdapter(): RecyclerView.Adapter<InfoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemTodoBinding): RecyclerView.ViewHolder(binding.root)

    var info: List<Content> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            val todo = info[position]
            tvDescription.text = todo.descriptionKA
            tvTitle.text = todo.titleKA

            Glide.with(holder.itemView.context)
                .load(todo.cover)
                .into(ivImage);

            tvPublishdate.text = todo.publishDate
        }
    }

    override fun getItemCount() = info.size
}