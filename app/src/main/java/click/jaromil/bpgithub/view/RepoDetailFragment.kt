package click.jaromil.bpgithub.view

import android.arch.lifecycle.Observer
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import click.jaromil.bpgithub.R
import click.jaromil.bpgithub.view.adapter.ContributorsAdapter
import click.jaromil.bpgithub.databinding.FragmentRepoDetailsBinding
import click.jaromil.bpgithub.viewmodel.RepositoriesViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel
import timber.log.Timber

class RepoDetailFragment : Fragment() {
    private lateinit var binding: FragmentRepoDetailsBinding
    private val reposViewModel: RepositoriesViewModel by sharedViewModel()
    
    companion object {
        fun create(): RepoDetailFragment {
            return RepoDetailFragment()
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reposViewModel.error.observe(this, Observer<String> { error ->
            Timber.e(error)
        })
        setHasOptionsMenu(true)
    }
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.let {
            it.window.statusBarColor = Color.TRANSPARENT
        }
        binding = FragmentRepoDetailsBinding.inflate(inflater, container, false)
        binding.viewModel = reposViewModel
        return binding.root
    }
    
    override fun onDestroyView() {
        activity?.let {
            it.window.statusBarColor = it.getColor(R.color.status_bar)
        }
        super.onDestroyView()
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        reposViewModel.currentRepo?.let {
            binding.toolbar.title = it.value?.name
        }
        
        initRecycler()
        
        reposViewModel.currentRepo?.value?.fullName?.let {
            reposViewModel.getRepoContributors(it)
        }
    }
    
    private fun initRecycler() {
        val contributorsAdapter = ContributorsAdapter()
    
        with(binding) {
            (activity as AppCompatActivity).setSupportActionBar(toolbar)
            (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            contributorsRecycler.layoutManager = LinearLayoutManager(context)
            contributorsRecycler.adapter = contributorsAdapter
            swipeRefreshLayout.isEnabled = false
            swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(context!!, R.color.primary))
        }
    }
    
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> (activity as AppCompatActivity).supportFragmentManager.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }
}