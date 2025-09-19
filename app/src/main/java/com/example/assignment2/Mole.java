package com.example.assignment2;

import android.widget.ImageView;

/**
 * The com.example.assignment2.Mole class represents a mole in the game.
 * Each mole has a position (index), an associated ImageView for UI,
 * and a visibility state (isVisible).
 */
public class Mole {

    /** Declare variables */
    private int index;
    private ImageView imageView;
    private boolean isVisible;

    /** Constructor */
    public Mole(int index, ImageView imageView) {
        this.index = index;
        this.imageView = imageView;
        // initially hidden
        this.isVisible = false;
    }

    /**
     * Get the mole's index (hole number)
     * @return the index of the mole
     */
    public int getIndex() {
        return index;
    }

    /**
     * Get the ImageView associated with this mole
     * @return the ImageView object
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * Check if the mole is currently visible
     * @return true if visible, false otherwise
     */
    public boolean isVisible() {
        return isVisible;
    }

    /**
     * Set the mole's visibility and update the ImageView
     * @param visible true to show mole, false to hide
     */
    public void setVisible(boolean visible) {
        isVisible = visible;
        if (visible) {
            imageView.setImageResource(R.drawable.img_with_mole);
        } else {
            imageView.setImageResource(R.drawable.img_without_mole);
        }
    }
}
