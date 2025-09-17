package com.example.assignment2;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * GameLogic handles all the core gameplay for Whack-a-com.example.assignment2.Mole.
 * It manages mole visibility, timing, score, and communicates with the UI.
 */
public class GameLogic {

    /** declare variables */
    private static final long MOLE_DISPLAY_TIME = 800;
    private static final long GAME_DURATION = 30000;
    private int currentScore;
    private long timeRemaining;
    private int currentMoleIndex = -1;
    private Handler moleHandler;
    private Runnable moleRunnable;
    private CountDownTimer gameTimer;
    private Random random;
    private ArrayList<Mole> moles;
    private TextView scoreTextView;
    private TextView timerTextView;
    private boolean isGameRunning;
    private Context context;

    /**
     * Constructor: prepares the game logic.
     *
     * @param context    the Android context
     * @param moleViews  list of ImageViews representing holes
     * @param scoreText  TextView for displaying score
     * @param timerText  TextView for displaying timer
     */
    public GameLogic(Context context,
                     ArrayList<ImageView> moleViews,
                     TextView scoreText,
                     TextView timerText) {

        this.context = context;
        this.scoreTextView = scoreText;
        this.timerTextView = timerText;

        this.currentScore = 0;
        this.timeRemaining = GAME_DURATION;
        this.isGameRunning = false;

        this.random = new Random();
        this.moleHandler = new Handler();

        // Convert each ImageView into a com.example.assignment2.Mole object
        this.moles = new ArrayList<>();
        for (int i = 0; i < moleViews.size(); i++) {
            this.moles.add(new Mole(i, moleViews.get(i)));
        }
    }

    /**
     * Starts the game: score resets, timer starts, mole loop begins.
     */
    public void startGame() {
        if (isGameRunning)
            return;

        currentScore = 0;
        updateScoreText();

        isGameRunning = true;
        startTimer();
        startMoleLoop();
    }

    /**
     * Initializes and starts the countdown timer.
     * Updates timer text every second.
     */
    public void startTimer() {
        gameTimer = new CountDownTimer(GAME_DURATION, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeRemaining = millisUntilFinished;
                int seconds = (int) (timeRemaining / 1000);
                timerTextView.setText("Time: " + seconds);
            }

            @Override
            public void onFinish() {
                timeRemaining = 0;
                timerTextView.setText("Time: 0");
                stopMoleLoop();
                isGameRunning = false;
            }
        }.start();
    }

    /**
     * Starts the loop that spawns and hides moles.
     */
    private void startMoleLoop() {
        moleRunnable = new Runnable() {
            @Override
            public void run() {
                if (!isGameRunning) return;
                showMole(random.nextInt(moles.size()));
                moleHandler.postDelayed(this, MOLE_DISPLAY_TIME);
            }
        };
        /** starts the loop*/
        moleHandler.post(moleRunnable);
    }

    /**
     * Stops the mole-spawning loop.
     */
    private void stopMoleLoop() {
        if (moleHandler != null && moleRunnable != null) {
            moleHandler.removeCallbacks(moleRunnable);
        }
    }

    /**
     * Shows a mole at a given index and hides the previous one.
     *
     * @param index index of the mole to show
     */
    private void showMole(int index) {
        hideMole();

        currentMoleIndex = index;
        Mole mole = moles.get(index);
        mole.setVisible(true);
    }

    /**
     * Hides the currently visible mole, if any.
     */
    private void hideMole() {
        if (currentMoleIndex >= 0 && currentMoleIndex < moles.size()) {
            moles.get(currentMoleIndex).setVisible(false);
        }
        currentMoleIndex = -1;
    }

    /**
     * Call this from GameActivity when a mole is tapped.
     *
     * @param index index of the tapped mole
     */
    public void hitMole(int index) {
        if (!isGameRunning) return;

        if (currentMoleIndex == index) {
            currentScore++;
            updateScoreText();
            hideMole();
        }
    }

    /**
     * Updates the score TextView.
     */
    private void updateScoreText() {
        scoreTextView.setText("Score: " + currentScore);
    }

    /**
     * @return true if the game is currently running
     */
    public boolean isGameRunning() {
        return isGameRunning;
    }

    /**
     * @return the final score
     */
    public int getCurrentScore() {
        return currentScore;
    }
}
