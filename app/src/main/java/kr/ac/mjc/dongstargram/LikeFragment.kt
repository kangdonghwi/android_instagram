package kr.ac.mjc.dongstargram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.log

class LikeFragment : Fragment(){

    lateinit var logoutBtn : Button
    lateinit var auth : FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_like,container,false)

        logoutBtn = view.findViewById(R.id.logout_btn)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        auth= FirebaseAuth.getInstance()
        logoutBtn.setOnClickListener { logout() }
    }

    private fun logout() {
        auth.signOut()
        var intent = Intent(context , LoginActivity::class.java)
        startActivity(intent)
    }

}