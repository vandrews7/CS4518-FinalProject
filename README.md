# CS4518-FinalProject
# Veronica Andrews (vjandrews@wpi.edu) and Maranda Allen (mmallen@wpi.edu)

Welcome to WYD? our organization application designed to help keep students on track!

For our final project we decided to create an organization app for students that would allow students to track assignments and group partners, due dates, and create a ToDo list.

To design the application we used an MVVM structure using ViewModels and Fragments. We also used the single activity strategy and switched between fragments rather than activities to navigate throught the application.
This design structure satisfies the first requirement in the functional design.

The first thing a user will see is the option to create an account or login. To do this we used relational databases using Room, which would ensure persistence as well.
This implementation satisfies the second requirement in the functional design -- a long term persistence strategy. The schema can be accessed from the device's file explorer in the directory data/data/com.example.cs4518_finalproject/databases.

Once the user creates their account or logs in, the user will see the home screen with the different navigation options.
The 'Take Photo' button on the home screen uses an implicit intent to open the default camera application on the device and allows the user to take a picture of a receipt or assignment information.
The use of the camera satisfies the third functional design requirement. The pictures are stored in the phones local file system (the path is data/data/com.example.cs4518_finalproject/files).
