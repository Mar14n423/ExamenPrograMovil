package com.example.examenprogramovil.di

import com.example.examenprogramovil.features.dollar.data.database.AppDatabase
import com.example.examenprogramovil.features.dollar.data.repository.DollarRepository
import com.example.examenprogramovil.features.dollar.domain.repository.IDollarRepository
import com.example.examenprogramovil.features.dollar.domain.usecases.FetchDollarUseCase
import com.example.examenprogramovil.features.dollar.presentation.DollarViewModel
import com.example.examenprogramovil.features.github.data.api.GithubService
import com.example.examenprogramovil.features.github.data.datasourse.GithubRemoteDataSource
import com.example.examenprogramovil.features.github.data.repository.GithubRepository
import com.example.examenprogramovil.features.github.domain.repository.IgithubRepository
import com.example.examenprogramovil.features.github.domain.usercases.FindByNickNameUseCase
import com.example.examenprogramovil.features.github.presentation.GirhubViewModel
import com.example.examenprogramovil.features.login.data.repository.LoginRepository
import com.example.examenprogramovil.features.login.domain.repository.ILoginRepository
import com.example.examenprogramovil.features.login.domain.usercases.LoginUseCase
import com.example.examenprogramovil.features.login.presentation.LogInViewModel
import com.example.examenprogramovil.features.movies.data.api.MovieService
import com.example.examenprogramovil.features.movies.data.datasource.MovieLocalDataSource
import com.example.examenprogramovil.features.movies.data.datasource.MoviesRemoteDataSource
import com.example.examenprogramovil.features.movies.data.repository.MoviesRepository
import com.example.examenprogramovil.features.movies.domain.repository.IMovieRepository
import com.example.examenprogramovil.features.movies.domain.usercases.GetFavoritesUseCase
import com.example.examenprogramovil.features.movies.domain.usercases.GetPopularMoviesUseCase
import com.example.examenprogramovil.features.movies.domain.usercases.InserteMyFavoriteMovieUseCase
import com.example.examenprogramovil.features.movies.presentation.MoviesViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    single {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }


    single(named("github")) {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single(named("movies")) {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    single<GithubService> {
        get<Retrofit>(named("github")).create(GithubService::class.java)
    }
    single { GithubRemoteDataSource(get()) }
    single<IgithubRepository> { GithubRepository(get()) }
    factory { FindByNickNameUseCase(get()) }
    viewModel { GirhubViewModel(get()) }


    viewModel { LogInViewModel(get()) }
    factory { LoginUseCase(get()) }
    single<ILoginRepository> { LoginRepository() }

    single<MovieService> {
        get<Retrofit>(named("movies")).create(MovieService::class.java)
    }

    single { MoviesRemoteDataSource(get()) }
    single { get<AppDatabase>().movieDao() }
    single { MovieLocalDataSource(get()) }
    single<IMovieRepository> { MoviesRepository(get(), get()) }

    factory { GetPopularMoviesUseCase(get()) }
    factory { GetFavoritesUseCase(get()) }
    factory { InserteMyFavoriteMovieUseCase(get()) }

    viewModel { MoviesViewModel(get(), get(), get()) }


    single { AppDatabase.getDatabase(get()) }
    single { get<AppDatabase>().dollarDao() }
    single<IDollarRepository> { DollarRepository(get()) }
    factory { FetchDollarUseCase(get()) }
    viewModel { DollarViewModel(get()) }
}