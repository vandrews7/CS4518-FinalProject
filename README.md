# CS4518-FinalProject
# Veronica Andrews (vjandrews@wpi.edu) and Maranda Allen (mmallen@wpi.edu)

Welcome to WYD? our organization application designed to help keep students on track! (WYD? stands for "What You Doin'?")

For our final project we decided to create an organization app for students that would allow students to track assignments and group partners, due dates, and create a ToDo list.

To design the application we used an MVVM structure using ViewModels and Fragments. We also used the single activity strategy and switched between fragments rather than activities to navigate throught the application.
This design structure satisfies the first requirement in the functional design.

The first thing a user will see is the option to create an account or login. To do this we used relational databases using Room, which would ensure persistence as well.
This implementation satisfies the second requirement in the functional design -- a long term persistence strategy. The schema can be accessed from the device's file explorer in the directory data/data/com.example.cs4518_finalproject/databases.

Once the user creates their account or logs in, the user will see the home screen with the different navigation options.
The 'Take Photo' button on the home screen uses an implicit intent to open the default camera application on the device and allows the user to take a picture of a receipt or assignment information.
The use of the camera satisfies the third functional design requirement. The pictures are stored in the phones local file system (the path is data/data/com.example.cs4518_finalproject/files).

One design achievement that we used was using the CalendarView widget for our calendar page. This satisfies one of the design achievements.
The second design achievement that we implemented was part of the fragment navigation, where when you go back a page it goes back to the previous fragment because it was added to the backstack. This design was intentional to make it easier to navigate the application. This satisfies the second design achievement.

One technical achievement that we implemented was being able to click on the different dates of the calendar in the calendar view.
Our final technical achievement is the Dialog we used for selecting the due date of an assignment. This satisfies the last technical achievement of the project.

One problem that we had was implementing the sharing feature. Our original goal was to be able to share the assignment details with group members for group projects. Not the actual assignment would be attached, just the title, due date, and other relevant information.
Because of the time constraints, we were unable to implement the feature, but it would have been completed using the User table and the Assignment table in our relational database.
Because of time constraints, we were also not able to implement a network component, which is the fourth functional requirement.