package click.jaromil.bpgithub.view.adapter

import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import click.jaromil.bpgithub.R
import click.jaromil.bpgithub.databinding.ItemRepositoryBinding
import click.jaromil.bpgithub.model.Repo

class RepositoriesAdapter(private var itemClickListener: ((Repo) -> Unit)? = null) : BaseAdapter<Repo>() {
    private val repositories = mutableListOf<Repo>()
    private var getReposListener: (() -> Unit)? = null
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Repo> {
        val holder = super.onCreateViewHolder(parent, viewType)
        (binding as ItemRepositoryBinding).adapter = this
        return holder
    }
    
    override fun getObjForPosition(position: Int): Repo = repositories[position]
    
    override fun getLayoutIdForPosition(position: Int): Int = R.layout.item_repository
    
    override fun onItemClick(obj: Repo) {
        itemClickListener?.let {
            it(obj)
        }
    }
    
    override fun onEmptyData(visible: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    override fun setData(items: MutableList<Repo>) {
        val diffResult = DiffUtil.calculateDiff(ReposDiffResolver(repositories, items))
        repositories.clear()
        repositories.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }
    
    override fun setOnItemClickListener(listener: (Repo) -> Unit) {
        itemClickListener = listener
    }
    
    override fun getItemCount(): Int = repositories.size
    
    fun setGetReposListener(listener: () -> Unit) {
        getReposListener = listener
    }
    
    fun getRepos() {
        getReposListener?.let {
            it()
        }
    }
    
    class ReposDiffResolver(private val oldItems: List<Repo>, private val newItems: List<Repo>) : DiffUtil.Callback() {
        
        override fun areItemsTheSame(posOld: Int, posNew: Int): Boolean = oldItems[posOld].id == newItems[posNew].id
        
        override fun getOldListSize(): Int = oldItems.size
        
        override fun getNewListSize(): Int = newItems.size
        
        override fun areContentsTheSame(posOld: Int, posNew: Int): Boolean = oldItems[posOld] == newItems[posNew]
    }
}