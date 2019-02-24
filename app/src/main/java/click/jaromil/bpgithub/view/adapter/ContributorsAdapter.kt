package click.jaromil.bpgithub.view.adapter

import click.jaromil.bpgithub.R
import click.jaromil.bpgithub.model.Contributor

class ContributorsAdapter : BaseAdapter<Contributor>() {
    private val contributors = mutableListOf<Contributor>()
    
    override fun getObjForPosition(position: Int): Contributor = contributors[position]
    
    override fun getLayoutIdForPosition(position: Int): Int = R.layout.item_contributor
    
    override fun onItemClick(obj: Contributor) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    override fun onEmptyData(visible: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    override fun setData(items: MutableList<Contributor>) {
        contributors.clear()
        contributors.addAll(items)
        notifyDataSetChanged()
    }
    
    override fun setOnItemClickListener(listener: (Contributor) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    override fun getItemCount(): Int = contributors.size
}