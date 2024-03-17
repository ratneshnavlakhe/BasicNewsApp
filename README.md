`# BasicNewsApp

Welcome to BasicNewsApp, a news application built with MVVM architecture

## Major Highlights

- **MVVM architecture** for a clean and scalable codebase
- **Kotlin** and **Kotlin DSL**
- **Dagger Hilt** for efficient dependency injection.
- **Retrofit** for seamless networking
- **Coroutines** and **Flow** for asynchronous programming
- **StateFlow** for streamlined state management
- **Unit tests** and **UI tests** for robust code coverage
- **Navigation** for smooth transitions between screens
- **Glide** for efficient image loading

## Features Implemented

- Show top news articles
- Edit country via settings screen

## Dependency Use

- Glide for Image Loading: Efficiently loads and caches images
- Retrofit for Networking: A type-safe HTTP client for smooth network requests
- Dagger Hilt for Dependency Injection: Simplifies dependency injection


## How to Run the Project

- Clone the Repository:
```
git clone https://github.com/ratneshnavlakhe/BasicNewsApp.git
cd BasicNewsApp
```
- Visit newsapi.org and sign up for an API key, Copy the API key provided
- Create the local.properties file in the root directory, if not created by default by Android Studio
- Add your API_KEY
```
API_KEY=<Add your API Key>
```
- Build and run the BasicNewsApp.


## The Complete Project Folder Structure

```
|-- app
    |-- main
    |   |-- AndroidManifest.xml
    |   |-- java
    |   |   |-- com
    |   |       |-- example
    |   |           |-- hiltintegrationexample
    |   |               |-- HiltIntegrationApplication.kt
    |   |               |-- data
    |   |               |   |-- local
    |   |               |   |   |-- NewsLocalDataSourceImpl.kt
    |   |               |   |   |-- NewsLocalSource.kt
    |   |               |   |-- model
    |   |               |   |   |-- ArticleEntity.kt
    |   |               |   |   |-- NewsListResponse.kt
    |   |               |   |   |-- SourceEntity.kt
    |   |               |   |   |-- State.kt
    |   |               |   |-- network
    |   |               |   |   |-- ApiKeyInterceptor.kt
    |   |               |   |   |-- NewsApi.kt
    |   |               |   |-- repo
    |   |               |       |-- NewsRepositoryImpl.kt
    |   |               |       |-- mapper
    |   |               |           |-- EntityMapper.kt
    |   |               |-- di
    |   |               |   |-- ApplicationModule.kt
    |   |               |   |-- NewsRepoModule.kt
    |   |               |   |-- SharedPreferencesModule.kt
    |   |               |   |-- qualifiers.kt
    |   |               |-- domain
    |   |               |   |-- NewsRepo.kt
    |   |               |   |-- Resource.kt
    |   |               |   |-- model
    |   |               |       |-- Article.kt
    |   |               |       |-- Source.kt
    |   |               |-- ui
    |   |                   |-- MainActivity.kt
    |   |                   |-- newslist
    |   |                   |   |-- NewsListFragment.kt
    |   |                   |   |-- NewsListViewModel.kt
    |   |                   |   |-- adapter
    |   |                   |       |-- NewsListAdapter.kt
    |   |                   |-- settings
    |   |                       |-- SettingsFragment.kt
    |   |                       |-- viewmodel
    |   |                           |-- SettingsViewModel.kt
```

## If this project helps you, show love ❤️ by putting a ⭐ on this project ✌️

## Contribute to the project

Feel free to improve or add features to the project.
Create an issue or find the pending issue. All pull requests are welcome 😄
`