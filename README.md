# Babbel
### For more detail about the project see [this article](https://medium.com/@hassan.alizadeh529/the-clean-architecture-concept-5fcbcb1a2a78).

### I have implemented this project using:
- Kotlin Language
- Clean Architecture
- MVVM Pattern
- OOP Principles
- SOLID Principles
- RxJava 2
- Dagger 2
- Retrofit
- Room DB
- JUnit and Mockito
- Android Architecture Components, some JetPack libraries such as ViewModel, LiveData,  ... 
- Constraint Layout and Motion Layout, ...
- ...


#### How much time was invested (within the given limit)
The whole implementation process took around 16 hours or two working days.

#### How was the time distributed (concept, model layer, view(s), game mechanics) 
- Clean Architecture Implementation: 30%
- Configuration: 20%
- Model Layer: 20%
- Views: 10%
- Game Mechanics: 20%

#### Decisions made to solve certain aspects of the game 
- Saving state of the game: If it is first time, the button to start the game is “Start” otherwise if user played the game before It is “Countinue”
- Handling words’ count in each time the user play the game: Display just 10 words in each time. These words are selected from the words that the user answered them incorrectly or skipped them.
- Calculating the points: For each correct answer 1 point will be added to user’s points.

#### Decisions made because of restricted time 
Decided to:
 - Not to write UI Tests
 - Make game simple as mush as possible

#### What would be the first thing to improve or add if there had been more time 
I would like to:
- Add more unit tests
- Add Integration Tests
- Add more Unit test
- Add UI Tests
- Implement more attractive animations using MotionLayout
- Calculate and display the total points for user in all sections they used the app
- Add a mechanism to review the words which the user answered them correctly
