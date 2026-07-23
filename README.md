# 🎯 Whack-a-Mole Game

An Android implementation of the classic **Whack-a-Mole** arcade game built using **Java** in **Android Studio**. Players earn points by tapping randomly appearing moles before they disappear. The game features a countdown timer, score tracking, and a leaderboard to save high scores.

---

## 📱 Features

- 🎮 Classic Whack-a-Mole gameplay
- ⏱️ 30-second countdown timer
- 🎯 Real-time score tracking
- 🕳️ Random mole appearances
- 🏆 Leaderboard to store player scores
- 👤 Player name entry after each game
- 📱 Clean and responsive Android UI

---

## 🛠️ Built With

- **Java**
- **Android Studio**
- **Android SDK**
- **Gradle**

---

## 📂 Project Structure

```
app/
├── activities/
│   ├── MainActivity
│   ├── GameActivity
│   ├── PlayerActivity
│   └── LeaderboardActivity
│
├── models/
│   ├── Mole
│   ├── Player
│   └── Leaderboard
│
└── logic/
    └── GameLogic
```

---

## 🎮 How to Play

1. Launch the application.
2. Tap **Play** from the main menu.
3. Moles will randomly appear in the grid.
4. Tap each mole before it disappears to earn points.
5. The game ends after **30 seconds**.
6. Enter your name to save your score.
7. View saved scores in the **Leaderboard**.

---

## 🚀 Getting Started

### Prerequisites

- Android Studio
- JDK 17 or later
- Android SDK

### Installation

1. Clone the repository

```bash
git clone https://github.com/brarAmrinder/Whack-a-mole-game.git
```

2. Open the project in Android Studio.

3. Allow Gradle to sync.

4. Build and run the application on an emulator or Android device.

---


## 🎯 Game Rules

- Every successful tap on a visible mole increases your score.
- Only one mole appears at a time.
- Missing a mole does not reduce your score.
- The objective is to achieve the highest score before time runs out.

---

## 📁 Main Classes

| Class | Description |
|--------|-------------|
| `MainActivity` | Home screen with navigation |
| `GameActivity` | Displays the gameplay interface |
| `GameLogic` | Handles timer, mole movement, and scoring |
| `Mole` | Represents individual mole objects |
| `PlayerActivity` | Allows users to enter their name |
| `LeaderboardActivity` | Displays saved high scores |
| `Leaderboard` | Manages leaderboard data |
| `Player` | Stores player information |

---

## 📈 Future Improvements

- Multiple difficulty levels
- Sound effects and background music
- Animations
- Different mole types
- Online leaderboard
- Pause/Resume functionality
- Achievements and rewards

---

## 👨‍💻 Author

**Amrinder Brar**

GitHub: https://github.com/brarAmrinder

---

## 📄 License

This project was developed for educational purposes.
