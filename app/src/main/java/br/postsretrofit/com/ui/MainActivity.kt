package br.postsretrofit.com.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.postsretrofit.com.R
import br.postsretrofit.com.adapter.PostsAdapter
import br.postsretrofit.com.service.PostService
import gov.pr.celepar.investigacao.pojo.Post
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var postList = ArrayList<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread(Runnable {
            postList = PostService.listPostsRetrofit()!!

            if(postList != null && postList.size > 0){
                this@MainActivity.runOnUiThread({
                    var postsAdapter = PostsAdapter(this, (postList as ArrayList<Post>?)!!)
                    listPosts.adapter = postsAdapter
                })
            }else{
                Toast.makeText(this, "There are no posts", Toast.LENGTH_LONG).show()
            }
        }).start()
    }
}
