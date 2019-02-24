package click.jaromil.bpgithub

import click.jaromil.bpgithub.model.Repo
import click.jaromil.bpgithub.api.repository.GitHubRepository
import click.jaromil.bpgithub.viewmodel.RepositoriesViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
class RepositoriesViewModelTest {
    private lateinit var viewModel: RepositoriesViewModel
    @Mock
    private lateinit var gitHubRepository: GitHubRepository
    @Mock
    private lateinit var responseListener: (List<Repo>) -> Unit
    @Mock
    private lateinit var errorListener: (Throwable) -> Unit

    
    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = Mockito.mock(RepositoriesViewModel::class.java)
    }
    
    @Test
    fun getGitHubRepos_no_page_25_multiply() {
        val page = 0
        val perPage = 24
        Mockito.doNothing().`when`(gitHubRepository).getPublicRepos(page, perPage, responseListener, errorListener)
        viewModel.getGitHubRepos(page)
//        Mockito.verify(gitHubRepository, Mockito.times(1)).getPublicRepos(page, perPage, responseListener, errorListener)
    }
}