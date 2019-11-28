package kr.ac.mjc.dongstargram


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainAdapter(fragmetManager : FragmentManager) : FragmentPagerAdapter(fragmetManager) {
    override fun getCount(): Int {
        return 5
    }

    override fun getItem(position: Int): Fragment {
        if(position == 0){
            return HomeFragment()
        }
        else if(position ==1 ){
            return SearchFragment()
        }
        else if(position ==2 ){
            return AddFragment()
        }
        else if(position ==3 ){
            return LikeFragment()
        }
        else {
            return ProfileFragment()
        }
    }
}