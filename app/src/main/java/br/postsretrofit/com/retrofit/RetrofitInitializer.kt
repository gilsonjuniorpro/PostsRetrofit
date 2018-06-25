package br.postsretrofit.com.retrofit

import br.postsretrofit.com.service.ActionService
import br.postsretrofit.com.util.Dominios
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    val retrofit = Retrofit.Builder()
            .baseUrl(Dominios.URL_LISTAR_POSTS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun postsRetrofit(): ActionService = retrofit.create(ActionService::class.java)
}