package com.bignerdranch.android.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TableLayout
import android.widget.Toast
import androidx.appcompat.widget.ShareActionProvider
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var shareActionProvider: ShareActionProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val pagerAdapter = SectionPagerAdapter(supportFragmentManager)
        val pager = findViewById<ViewPager>(R.id.pager)
        pager.adapter = pagerAdapter

        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(pager)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu?.findItem(R.id.action_share)
        shareActionProvider = menuItem?.let { MenuItemCompat.getActionProvider(it) } as ShareActionProvider
        setShareActionIntent("Want to join me for pizza?")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_create_order -> {
                val intent = Intent(this, OrderActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.toolbar ->{ Toast.makeText(this, "qqqqqqqqqq", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private class SectionPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager){
        override fun getCount(): Int {
            return 4
        }

        override fun getItem(position: Int): Fragment {
            return when(position){
                0-> TopFragment()
                1-> PizzaFragment()
                2-> PastaFragment()
                else -> StoresFragment()
            }
        }

        override fun getPageTitle(position: Int): CharSequence {
            return when(position){
                0-> R.string.home_tab.toString()
                1-> R.string.pizza_tab.toString()

                2-> R.string.pasta_tab.toString()
                else-> R.string.store_tab.toString()
            }
        }

    }
    private fun setShareActionIntent( text: String) {
        val intent = Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }
}