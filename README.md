# OMAP - Online Movie Archive Project
## Introduction
Do you want a place to see the top rated movies? Collaborate on that list to add your personal favorites?
+ See top rated international movies
+ Add your own personal favorite movie to the list

---
## Functional Requirements  
---  

#### Given
user has application opened 
#### When 
the user opens the app 
#### Then
the user views a feed of movies

---

#### Given 
the user opens the app. 
#### When 
the user clicks on a movie. 
#### Then
the user views additional information about the movie

---


#### Given
the user opens the app. 
#### When 
the User clicks on a movie. 
#### When 
the user sees genre is incorrect. 
#### Then 
the user edits the genre to the correct genre.

---

#### Given 
the user is in the app. 
#### When
the user clicks to add a movie. 
#### When 
the user enters the fields, but leaves movie name blank.
#### Then
an error is thrown showing that the movie name is not entered.

---

#### Given
the user opens the app. 
#### When 
the user sees an outdated movie, they delete it.
#### Then 
the movie is deleted.

---


#### Given 
Bill opens the app.Bill searches for his movie, no search results show up.
#### When 
Bill decides to add his movie.
#### When
Bill fills in “Joker” as the movies name. 
#### When
bill fills in “2019” as movie year.
#### When 
Bill fills in “Drama” as the movie genre. 
#### When
Bill adds the movie.
#### Then
the newly added movies shows up on the table.

---

## Scrum Roles

- **Product Owner/Scrum Master**: Anand Pandey
- **Front-End Developvers**: Bill Appiagyei, Pruthvi Patel
- **Back-End Developers**: Anand Pandey & Pranav Mahajan

---

## Storyboard
---
Scene 1 (User Opens OMAP and clicks on MOVIES)  

<img  width="100" height="100" src="https://raw.githubusercontent.com/MrPandey2k/OMAP/main/writeup_images/Picture1.jpg">  

Scene 2 (Displays Movie Genres with drop down menu)  

<img  width="100" height="100" src="https://raw.githubusercontent.com/MrPandey2k/OMAP/main/writeup_images/Picture2.jpg">  


Scene 3 (User clicks on drop down menu)  

<img  width="100" height="100" src="https://raw.githubusercontent.com/MrPandey2k/OMAP/main/writeup_images/Picture3.jpg">

Scene 4 (User clicks on SCI-FI)  
<img  width="100" height="100" src="https://raw.githubusercontent.com/MrPandey2k/OMAP/main/writeup_images/Picture4.jpg">  

---
### Scenario 1   
---
Scene 5 (User searches for movie but no results come up but an option to add their own movie is available)  
<img  width="100" height="100" src="https://raw.githubusercontent.com/MrPandey2k/OMAP/main/writeup_images/Picture5.jpg">  
  
Scene 6 (User adds movie)  
<img  width="100" height="100" src="https://raw.githubusercontent.com/MrPandey2k/OMAP/main/writeup_images/Picture6.jpg">  
  
Scene 7 (Movie is added to list)  
  
<img  width="100" height="100" src="https://raw.githubusercontent.com/MrPandey2k/OMAP/main/writeup_images/Picture7.jpg">  

---  

### Scenario 2 
  ---   
Scene 8 (Date of release on “Prometheus” is wrong so the user can correct the date)  
   
<img  width="100" height="100" src="https://raw.githubusercontent.com/MrPandey2k/OMAP/main/writeup_images/Picture8.jpg">
  
Scene 9 (User clicks on Prometheus )  
  
<img  width="100" height="100" src="https://raw.githubusercontent.com/MrPandey2k/OMAP/main/writeup_images/Picture9.jpg">  
  
  
Scene 10 (User corrects date and saves)  
  
<img  width="100" height="100" src="https://raw.githubusercontent.com/MrPandey2k/OMAP/main/writeup_images/Picture10.jpg">  
   

Scene 11 (Movie date is corrected in list)  
  
<img  width="100" height="100" src="https://raw.githubusercontent.com/MrPandey2k/OMAP/main/writeup_images/Picture11.jpg">  
  

---

## Class Diagram  
  
  
---
![class diagram](./writeup_images/class_diagram.jpeg)

Description:

- Com.movies.ui
    - Model - Handles the data manipulation of the view and communicate with controller
    - View - main screen of the project where the user can interact with the application, add edit and delete movies
    - Controller - core logic component of client side that contacts server-side with crud operations
- Com.movies.dto
    - Genre.java - Genre class with genre ID and genre type
    - Movies.java - Movie Class with genre, movieTitle, Year, Description, Rating
- Com.movies.dao
    - IMovieService - Interface to work with MovieService
    - MovieService - Service that handles CRUD operations from controller to actual server
    - IMovieDatabseContext - Interface to work with MovieContext
    - MovieContext - Does the actual CRUD operations and Sends data to the Actual database
- Database - actual cloud or local database with all stored info

---

## Project Board
   
Located in [Github Projects](https://github.com/users/MrPandey2k/projects/2/views/1)