# Rapptr_Android
Rapptr Android Programming Test

Thank you for considering me for the Rapptr Android Software Engineering Apprenticeship! To show my appreciation, I've modernized the project
you've sent me with the latest Kotlin based tools including Jetpack Compose and updated the architechture of the application in accordance with 
Google's recommended Android platform best practices! Of course the finished product still has the look and functionality of the storyboard
and starter code you sent me. However, it will improve upon the original code in that it will be: computationally cheaper to run (and thus
much less likely to crash or hang), easier to debug and scale as the project grows with less lines of more readable code, and more modern 
library support.

Among some of the upgrades you'll notice are:

1) The project has been converted from the Java language to Kotlin enabling the use of modern libraries and Google's most recently developed 
tools and design patterns.

2) The navigation architechture has been updated from the older system in which different screens of an app are displayed by the entry point Activity
starting other navigation node Activities with Intents. Instead, I have made use of the full power of Jetpack Compose. Now, we can simply have 
a single host Activity as a user point of entry that navigates screens by reading UI state with a Composable function instead of starting any 
other Activities and switching between them. 
