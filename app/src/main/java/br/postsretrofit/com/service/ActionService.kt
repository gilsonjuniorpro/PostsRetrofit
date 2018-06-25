package br.postsretrofit.com.service

import gov.pr.celepar.investigacao.pojo.Retorno
import retrofit2.Call
import retrofit2.http.GET

interface ActionService {
    @GET("list.php")
    fun list() : Call<Retorno>
}