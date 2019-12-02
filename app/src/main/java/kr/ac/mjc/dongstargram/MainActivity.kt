package kr.ac.mjc.dongstargram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var viewPager : ViewPager
    lateinit var tab : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager)
        tab = findViewById(R.id.tab)

        var mainAdapter = MainAdapter(supportFragmentManager)           //대신관리할수있게
        viewPager.adapter=mainAdapter
        tab.setupWithViewPager(viewPager)       //tab이 바뀔때마다 뷰페이저가 바뀌게 함(뷰페이저와 탭이 연동되게 해줌)

        tab.getTabAt(0)?.setIcon(resources.getDrawable(R.drawable.baseline_home_black_48))      //아이콘이 안떠서 강제로 뜨게함
        tab.getTabAt(1)?.setIcon(resources.getDrawable(R.drawable.baseline_search_black_48))
        tab.getTabAt(2)?.setIcon(resources.getDrawable(R.drawable.baseline_add_circle_outline_black_48))
        tab.getTabAt(3)?.setIcon(resources.getDrawable(R.drawable.baseline_favorite_border_black_48))
        tab.getTabAt(4)?.setIcon(resources.getDrawable(R.drawable.baseline_person_outline_black_48))
    }

    fun moveTab(position:Int){
        viewPager.currentItem = position
    }
}
