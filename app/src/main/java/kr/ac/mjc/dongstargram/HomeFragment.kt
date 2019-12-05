package kr.ac.mjc.dongstargram

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class HomeFragment : Fragment(){

    lateinit var feedRv : RecyclerView
    lateinit var feedAdapter:FeedAdapter

    lateinit var firestore:FirebaseFirestore

    var postList = ArrayList<Post>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_home,container,false)
        feedRv = view.findViewById(R.id.feed_Rv)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        feedAdapter= FeedAdapter(context!!,postList)
        firestore = FirebaseFirestore.getInstance()

        feedRv.adapter= feedAdapter
        feedRv.layoutManager=LinearLayoutManager(context)
        postList.clear()

        firestore.collection("Post").orderBy("date", Query.Direction.ASCENDING)
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if(querySnapshot!=null){
                    for(dc in querySnapshot.documentChanges){
                        var post = dc.document.toObject(Post::class.java)
                        postList.add(0,post)        //배열에 첫번째를 계속 보여주기때문에 역순으로 보임
                    }
                    feedAdapter.notifyDataSetChanged()
                }
            }
    }
}