package com.example.menutoolbardrawlayoutexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.transition.Slide
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var menu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        menu = nav_view.menu
        menu.findItem(R.id.nav_login).setVisible(false)

        nav_view.bringToFront()
        var toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {

        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onStart() {
        super.onStart()
        nav_view.setCheckedItem(R.id.nav_home)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_cloud -> {
                var intent = Intent(this, FirstActivity::class.java)
                startActivity(intent)
            }

            R.id.nav_char -> {
                var intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_profile -> {
                var intent = Intent(this, ThirdActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_logout -> {
                menu.findItem(R.id.nav_login).setVisible(true)
            }

            R.id.nav_login -> {
                menu.findItem(R.id.nav_login).setVisible(false)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}