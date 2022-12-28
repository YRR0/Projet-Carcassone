package com.carcassone.game.components.tuiles;

import com.carcassone.game.components.tuiles.Paysage;

public class Ville extends Paysage {

    private boolean mur;

    public Ville(boolean mur) {
        this.mur = mur;
    }

    public boolean estMur() {
        return mur;
    }

    public String toString() {
        return mur?"mur":"ville";
    }
}
