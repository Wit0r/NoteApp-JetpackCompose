## Android Note App using MVVM, Room Database, Hilt, and Navigation Animation in Jetpack Compose

<div>
 <img src="https://github.com/Wit0r/NoteApp-JetpackCompose/blob/main/images/1.jpeg" width="140" />
 <img src="https://github.com/Wit0r/NoteApp-JetpackCompose/blob/main/images/2.jpeg" width="140" />
 <img src="https://github.com/Wit0r/NoteApp-JetpackCompose/blob/main/images/3.jpeg" width="140" />
 <img src="https://github.com/Wit0r/NoteApp-JetpackCompose/blob/main/images/4.jpeg" width="140" />
 <img src="https://github.com/Wit0r/NoteApp-JetpackCompose/blob/main/images/5.jpeg" width="140" />
 <img src="https://github.com/Wit0r/NoteApp-JetpackCompose/blob/main/images/6.jpeg" width="140" />
 <img src="https://github.com/Wit0r/NoteApp-JetpackCompose/blob/main/images/7.jpeg" width="140" />
</div>

<br/>

I developed a Android Note app that allows users to create, edit, and delete notes easily. I used several advanced technologies to ensure that the app is easy to use and that user notes are stored securely.

1. I used the [MVVM architecture](https://developer.android.com/jetpack/guide) to organize the app's code. This means that the business logic is separated from the user interface, making maintenance and testing easier. The ViewModel is the intermediate layer that communicates with the database and other data sources, while the View is the user interface that is updated based on changes in the ViewModel.

2. I used the [Room Database](https://developer.android.com/training/data-storage/room) to store user notes. Room is a Jetpack library that allows for efficient and easy creation and management of SQLite databases. With Room, I was able to define the database entities and tables in an object modeling language (ORM) instead of manually writing SQL code. This made app development much faster and easier.

3. Additionally, I used [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) to inject dependencies into the app in an easy and secure way. Hilt is a Jetpack library that provides dependency injection for Android, which means it helps manage object instances and their dependencies.

4. Finally, I used [Navigation Animation](https://developer.android.com/jetpack/compose/navigation) in Jetpack Compose to create smooth and pleasing animations for users while navigating through the app.


## Final Thoughts:

### Currently, the app supports two languages: Brazilian Portuguese and English. However, it does not have an option for Light Mode at the moment. In the future, I plan to implement more features such as the ability to choose a theme or change the font. I am committed to making this app as customizable as possible, so stay tuned for updates!

----------------------------------------------------------------------------
----------------------------------------------------------------------------
----------------------------------------------------------------------------

# Thank you!

Thank you for using this repository and I hope it has helped you in your project! If you have any further questions or feedback, feel free to reach out.
Enjoy the resources and keep creating amazing projects!

- [GitHub repository](https://github.com/Wit0r/NoteApp-JetpackCompose) 
- [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square)](https://opensource.org/licenses/MIT)
