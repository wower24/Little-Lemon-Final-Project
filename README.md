Little Lemon App
(Jetpack Compose, Ktor, Room)

FOR PEER REVIEW:

Wireframe:

<img width="548" height="950" alt="image" src="https://github.com/user-attachments/assets/dd08560f-c456-4027-85e8-20ca383c5b69" />

Onboarding Screen:

<img width="518" height="1056" alt="image" src="https://github.com/user-attachments/assets/60fa12bd-dbda-4873-831e-4072216d175a" />

Home Screen:

<img width="505" height="1059" alt="image" src="https://github.com/user-attachments/assets/8c51b8b9-c49b-4d44-ad7d-d51b8a30eb59" />

Profile Screen:

<img width="519" height="1059" alt="image" src="https://github.com/user-attachments/assets/c84b03e3-552e-4c6d-bf07-061030bbeed8" />


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
