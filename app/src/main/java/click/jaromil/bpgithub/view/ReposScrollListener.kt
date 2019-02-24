package click.jaromil.bpgithub.view

import android.support.v7.widget.RecyclerView
import click.jaromil.bpgithub.view.adapter.RepositoriesAdapter

class ReposScrollListener : RecyclerView.OnScrollListener() {
    
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        if (!recyclerView.canScrollVertically(1)) {
            getRepos(recyclerView)
        }
    }
    
    fun getRepos(recycler: RecyclerView) {
        (recycler.adapter as RepositoriesAdapter).getRepos()
    }
}