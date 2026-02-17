Here is a clean, professional `README.md` version you can paste directly into your repository:

---

#  Study Session Tracker App

A Kotlin-based Android application developed in **Android Studio** featuring a pixel-art themed UI.
The application demonstrates **object serialization and deserialization using JSON** as a communication mechanism between Activities.

---

##  Project Objective

The goal of this project was to implement:

* A structured data model using a Kotlin `data class`
* Object → JSON serialization
* JSON persistence using `SharedPreferences`
* JSON → Object deserialization
* Data transfer between Activities
* Basic authentication logic
* A functional countdown study timer

This project emphasizes understanding how structured memory objects can be transformed into text-based representations and restored back into structured objects.

---

##  Core Concept

The application demonstrates the following transformation process:

```
Structured memory object  →  Structured text (JSON)
Structured text (JSON)    →  Structured memory object
```

This is achieved using the **Gson** library.


---

## 📂 Project Structure

```
User.kt                → Data model (data class)
FormActivity.kt        → User registration & serialization
Login.kt               → Credential validation (deserialization + comparison)
TimerDisplay.kt        → Countdown timer logic
```

---

##  Features

###  User Registration

* Input validation
* JSON serialization using Gson
* Persistent storage via SharedPreferences

###  Login System

* JSON retrieval
* Deserialization into `User` object
* Credential comparison

###  Study Timer

* User-defined countdown timer
* Real-time display updates
* Simple and functional timer logic using `CountDownTimer`

---

##  Technologies Used

* **Kotlin**
* **Android Studio**
* **Gson (JSON Serialization Library)**
* **SharedPreferences (Local Persistence)**
* **CountDownTimer (Built-in Android timer API)**

---

##  UI Design

* Pixel-art inspired interface
* Pastel color palette
* Custom fonts and themed backgrounds
* Clean vertical navigation flow

---

##  Learning Outcomes

This project demonstrates understanding of:

* Data modeling with Kotlin `data class`
* Serialization / Deserialization principles
* Activity lifecycle and navigation
* Local data persistence
* Null-safety handling
* Basic authentication flow
* Separation of concerns in Android architecture

---

##  Limitations

* Stores only one user (overwrites previous registration)
* Passwords are stored in plain text (for educational purposes only)
* Uses SharedPreferences instead of a database


##  Credits

**Task developed by:**
Alessa Melo

**Class & Guidelines:**
Gabriela Cajamarca

=
