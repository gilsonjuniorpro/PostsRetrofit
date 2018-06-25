package br.postsretrofit.com.service

import br.postsretrofit.com.retrofit.RetrofitInitializer
import gov.pr.celepar.investigacao.pojo.Post

object PostService{
    fun listPostsRetrofit(): ArrayList<Post> {
        val call = RetrofitInitializer().postsRetrofit().list()
        val response = call.execute()
        var list = ArrayList<Post>()
        if (response.isSuccessful()) {
            var retorno = response!!.body()
            var postList : List<Post>? = retorno!!.list

            postList!!.forEach { elemento -> list.add(elemento) }
        }
        return list;
    }
}