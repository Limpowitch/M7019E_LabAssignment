//A collection of HTTP interface declarations
//Add additional API calls by declaring new GET/SET/etc functions -
// - mapped to its appropriate DTO

package com.example.m7019e_lab1.data.remote.api

import com.example.m7019e_lab1.data.remote.dto.MovieDetailsDto
import com.example.m7019e_lab1.data.remote.dto.MoviesResponseDto
import com.example.m7019e_lab1.data.remote.dto.ReviewsResponseDto
import com.example.m7019e_lab1.data.remote.dto.VideosResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApiService {
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("language") language: String = "en-US",
        @Query("page")     page: Int     = 1
    ): MoviesResponseDto

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String = "en-US",
        @Query("page")     page: Int     = 1
    ): MoviesResponseDto

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: Long,
        @Query("language") language: String = "en-US"
    ): MovieDetailsDto

    @GET("movie/{id}/reviews")
    suspend fun getMovieReviews(
        @Path("id")    id: Long,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): ReviewsResponseDto

    @GET("movie/{id}/videos")
    suspend fun getMovieVideos(
        @Path("id") id: Long,
        @Query("language") language: String = "en-US"
    ): VideosResponseDto
}



