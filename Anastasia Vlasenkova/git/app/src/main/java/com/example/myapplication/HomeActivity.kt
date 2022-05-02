package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarHome)
        binding.navigationView.setNavigationItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.menuFragmentHomeProfile -> navigateToFragment(ProfileHomeFragment())
                R.id.menuFragmentHomeTasksList -> navigateToFragment(TasksListHomeFragment())
            }
            true
        }
        val toggle = ActionBarDrawerToggle(
            this,
            binding.profileHomeLayout,
            binding.toolbarHome,
            R.string.nav_open,
            R.string.nav_close
        )
        binding.profileHomeLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerHome, fragment)
            .commit()
        binding.profileHomeLayout.closeDrawer(GravityCompat.START)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.iconExit -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
