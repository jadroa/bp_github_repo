package click.jaromil.bpgithub.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import click.jaromil.bpgithub.R
import click.jaromil.bpgithub.view.adapter.RepositoriesAdapter
import click.jaromil.bpgithub.databinding.FragmentRepositoriesBinding
import click.jaromil.bpgithub.model.Repo
import click.jaromil.bpgithub.viewmodel.RepositoriesViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel
import timber.log.Timber

class RepositoriesFragment : Fragment() {
    private lateinit var binding: FragmentRepositoriesBinding
    private val reposViewModel: RepositoriesViewModel by sharedViewModel()
    
    companion object {
        fun create(): RepositoriesFragment {
            return RepositoriesFragment()
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reposViewModel.error.observe(this, Observer<String> { error ->
            Timber.e(error)
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRepositoriesBinding.inflate(inflater, container, false)
        binding.viewModel = reposViewModel
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecycler()
        
        if (reposViewModel.repoPage.value == 0)
            reposViewModel.getGitHubRepos(0)
    }
    
    private fun initRecycler() {
        val reposAdapter = RepositoriesAdapter { repo ->
            reposViewModel.currentRepo.value = repo
            showRepoDetails(repo)
        }
        with(binding) {
            (activity as AppCompatActivity).setSupportActionBar(toolbar)
            reposRecycler.layoutManager = LinearLayoutManager(context)
            reposAdapter.setGetReposListener {
                reposViewModel.repoPage.value?.let {
                    reposViewModel.getGitHubRepos(it)
                }
            }
            reposRecycler.adapter = reposAdapter
            reposRecycler.addOnScrollListener(ReposScrollListener())
            swipeRefreshLayout.isEnabled = false
            swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(context!!, R.color.primary))
        }
    }
    
    private fun showRepoDetails(repo: Repo) {
        activity?.let {
            val repoDetailFragment = RepoDetailFragment.create()
            it.supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, repoDetailFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}