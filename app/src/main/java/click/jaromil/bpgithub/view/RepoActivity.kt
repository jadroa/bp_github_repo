package click.jaromil.bpgithub.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import click.jaromil.bpgithub.R

class RepoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo)
    
        if (savedInstanceState != null) {
            return
        }
        
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, RepositoriesFragment.create())
            .commit()
    }
}
