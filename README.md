# RedditVM
Reddit application implementing ViewModel based on Android Architecture Components and Dagger 2

Introduction
------------
### Android Architecture Components and Dagger 2
This repository contains a Reddit application implementing Android Architecture Comoponents.

The application illustrates how to implement [Dependency Injection design pattern][10] with [Dagger 2][23] as well as [Android Architecture Components][20] with [ViewModel][21] and [LiveData][22].

[10]: https://en.wikipedia.org/wiki/Dependency_injection

Please refer to [Android Architecture Components][20] and [Dagger 2][23] for more detailed information.

### Reddit RESTful API
This application uses RESTful API of [Reddit][0] which is a social news aggregation web site in order to get top 20 news posts.

It receives news data formatted in JSON and converts it to Java Objects including news title, photo url, author's name, date, comment's count and so on.
#### API Used

```
https://www.reddit.com/top.json?after=""&limit=20
```

[0]: https://www.reddit.com/

### Android development skills
This repository is able to help understand how to use the following skills.
* How to implement more robust application using ViewModel and LiveData of Android Architecture Components
* How to apply Dependency Injection design pattern to Android application with Dagger 2 framework
* How to call RESTful API with Retrofit
* How to use OkHttp Logging Intercepter in order to debug HTTP request/response data  
* How to convert JSON to Java Objects with Moshi
* How to load images from a remote server with Glide
* How to reduce boilerplate codes with ButterKnife

Libraries Used
---------------
* [ViewModel][21] - Stores and manages UI-related data in a lifecycle conscious way
* [LiveData][22] - Observable data holder class which is lifecycle-aware of other app components such as activities, fragments, or services
* [Dagger 2][23] - Framework to implement Dependency injection pattern for Android and Java
* [Retrofit][1] - Type-safe HTTP client for Android and Java which makes it easier to consume RESTful API services.
* [OkHttp Logging Intercepter][2] - Logs HTTP request and response data with different logging levels in order to debug HTTP error 
* [Moshi][3] - JSON library for Android and Java which makes it easy to parse JSON into Java objects. Used with Retrofit Moshi converter
* [Glide][4] - A fast and efficient image loading library for Android focused on smooth scrolling which offers an easy to use
* [ButterKnife][5] - Binds field and method for Android views with annotation processing and it reduces boilerplate codes


[1]: http://square.github.io/retrofit/
[2]: https://github.com/square/okhttp/wiki/Interceptors
[3]: https://github.com/square/moshi
[4]: https://bumptech.github.io/glide/
[5]: http://jakewharton.github.io/butterknife/
[6]: https://developer.android.com/topic/libraries/architecture/adding-components

Reference
---------
* [Android Architecture Components][20]
* [Android ViewModel][21]
* [Android LiveData][22]
* [Dagger 2][23]

[20]: https://developer.android.com/topic/libraries/architecture/
[21]: https://developer.android.com/topic/libraries/architecture/viewmodel
[22]: https://developer.android.com/topic/libraries/architecture/livedata
[23]: https://google.github.io/dagger

License
-------

    Copyright Jaemoon Hwang <jaemoon.hwang@gmail.com>

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
