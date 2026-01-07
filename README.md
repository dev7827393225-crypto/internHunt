# InternHunt

[![Kotlin](https://img.shields.io/badge/Kotlin-100%25-orange?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Android](https://img.shields.io/badge/Android-100%25-brightgreen?logo=android&logoColor=white)](https://developer.android.com/)
[![Firebase](https://img.shields.io/badge/Firebase-100%25-yellow?logo=firebase&logoColor=black)](https://firebase.google.com/)

**InternHunt** is an Android application that helps students and fresh graduates discover, track, and apply for internships efficiently. The app uses modern Android technologies like **Jetpack Compose**, **Firebase Authentication**, and **Room Database** to provide a smooth and intuitive experience.

---

## Features

- **User Authentication**
  - Sign up and login using **email & password** with Firebase Authentication.
  - Persistent login: Users remain logged in until they choose to log out.

- **Profile Management**
  - Manage personal information: Name, Mobile number, and Email.

- **Modern UI/UX**
  - Fully built with **Jetpack Compose** for a responsive and visually appealing interface.
  - Material3 design components for consistent styling.

- **Offline & Online Support**
  - Works with internet availability checks to prevent errors when offline.

- **Navigation**
  - Smooth navigation between login, signup, and home screens.

---

## Tech Stack

- **Kotlin** – Primary language
- **Jetpack Compose** – UI toolkit for building modern Android apps
- **Firebase Authentication** – Secure user authentication
- **Room Database** – Local storage for app data
- **Navigation Component** – Screen navigation
- **Material3 Components** – Modern UI styling

---

## Project Architecture

**MVVM (Model-View-ViewModel) Architecture**  

- **ViewModel:** Handles business logic and exposes state to the UI.  
- **Repository:** Mediates between Firebase/Room and ViewModel.  
- **Data Source:** Handles Firebase Authentication calls.  
- **UI (Compose Screens):** Displays information and collects user input.

---

## Screenshots

*(Add your screenshots here to make the repo visually appealing)*  

- Login Screen  
- Sign Up Screen  
- Home/Profile Screen  

---

## Installation

1. **Clone the repository**
```bash
git clone https://github.com/<your-username>/internhunt.git
