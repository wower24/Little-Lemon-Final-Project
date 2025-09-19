Little Lemon App
(Jetpack Compose, Ktor, Room)

The application is a final project fro Meta Android Development course.

It contains of 3 screens:

  Onboarding:
    Collects user's data (name, surname, email) 
    and saves the information about completing onboarding into "isLoggedIn" variable in SharedPreferences

  Home:
    Displays menu of the Little Lemon Restaurant fetched from Little Lemon API
    Allows the user to search for a dish using a search bar
    Allows the user to filter menu by catgories (Main, Desserts, Drinks)

  Profile:
    Displays user's data (name, surname, email)
    Allows the user to Log out (changes SharedPreferences variable "isLoggedIn" to false)

The menu fetched from API is saved into Room database.
