/*
 * Copyright (C) 2015-2016 The Food Restriction Project Team
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package br.com.mochiladepano.foodrestrictions;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class FoodIconSettings {

    private static FoodIconSettings settings;
    private SharedPreferences.Editor edit = null;

    private final String FOOD_SETTINGS_DONTEAT_COW = "br.mochiladepano.settings.food.donteat.cow";
    private final String FOOD_SETTINGS_ALLERGIC_COW = "br.mochiladepano.settings.food.allergic.cow";
    private boolean dontEatCow;
    private boolean allergicCow;

    private final String FOOD_SETTINGS_DONTEAT_CHICKEN = "br.mochiladepano.settings.food.donteat.chicken";
    private final String FOOD_SETTINGS_ALLERGIC_CHICKEN = "br.mochiladepano.settings.food.allergic.chicken";
    private boolean dontEatChicken;
    private boolean allergicChicken;

    private final String FOOD_SETTINGS_DONTEAT_PORK = "br.mochiladepano.settings.food.donteat.pork";
    private final String FOOD_SETTINGS_ALLERGIC_PORK = "br.mochiladepano.settings.food.allergic.pork";
    private boolean dontEatPork;
    private boolean allergicPork;

    private final String FOOD_SETTINGS_DONTEAT_FISH = "br.mochiladepano.settings.food.donteat.fish";
    private final String FOOD_SETTINGS_ALLERGIC_FISH = "br.mochiladepano.settings.food.allergic.fish";
    private boolean dontEatFish;
    private boolean allergicFish;

    private final String FOOD_SETTINGS_DONTEAT_CHEESE = "br.mochiladepano.settings.food.donteat.cheese";
    private final String FOOD_SETTINGS_ALLERGIC_CHEESE = "br.mochiladepano.settings.food.allergic.cheese";
    private boolean dontEatCheese;
    private boolean allergicCheese;

    private final String FOOD_SETTINGS_DONTEAT_MILK = "br.mochiladepano.settings.food.donteat.milk";
    private final String FOOD_SETTINGS_ALLERGIC_MILK = "br.mochiladepano.settings.food.allergic.milk";
    private boolean dontEatMilk;
    private boolean allergicMilk;

    private final String FOOD_SETTINGS_DONTEAT_PEPPER = "br.mochiladepano.settings.food.donteat.pepper";
    private final String FOOD_SETTINGS_ALLERGIC_PEPPER = "br.mochiladepano.settings.food.allergic.pepper";
    private boolean dontEatPepper;
    private boolean allergicPepper;

    private FoodIconSettings(Context ctx) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ctx);

        if (sharedPref != null) {
            this.dontEatCow = sharedPref.getBoolean(FOOD_SETTINGS_DONTEAT_COW, false);
            this.allergicCow = sharedPref.getBoolean(FOOD_SETTINGS_ALLERGIC_COW, false);

            this.dontEatChicken = sharedPref.getBoolean(FOOD_SETTINGS_DONTEAT_CHICKEN, false);
            this.allergicChicken = sharedPref.getBoolean(FOOD_SETTINGS_ALLERGIC_CHICKEN, false);

            this.dontEatPork = sharedPref.getBoolean(FOOD_SETTINGS_DONTEAT_PORK, false);
            this.allergicPork = sharedPref.getBoolean(FOOD_SETTINGS_ALLERGIC_PORK, false);

            this.dontEatFish = sharedPref.getBoolean(FOOD_SETTINGS_DONTEAT_FISH, false);
            this.allergicFish = sharedPref.getBoolean(FOOD_SETTINGS_ALLERGIC_FISH, false);

            this.dontEatCheese = sharedPref.getBoolean(FOOD_SETTINGS_DONTEAT_CHEESE, false);
            this.allergicCheese = sharedPref.getBoolean(FOOD_SETTINGS_ALLERGIC_CHEESE, false);

            this.dontEatMilk = sharedPref.getBoolean(FOOD_SETTINGS_DONTEAT_MILK, false);
            this.allergicMilk = sharedPref.getBoolean(FOOD_SETTINGS_ALLERGIC_MILK, false);

            this.dontEatPepper = sharedPref.getBoolean(FOOD_SETTINGS_DONTEAT_PEPPER, false);
            this.allergicPepper = sharedPref.getBoolean(FOOD_SETTINGS_ALLERGIC_PEPPER, false);
        }

        if (sharedPref != null) {
            edit = sharedPref.edit();
            if (edit != null) {
                edit.apply();
            }
        }
    }

    public static FoodIconSettings getFoodIconSettings(Context ctx) {
        if (settings == null) {
            settings = new FoodIconSettings(ctx);
        }
        return settings;
    }

    public boolean isAllergicCheese() {
        return allergicCheese;
    }

    public void setAllergicCheese(boolean allergicCheese) {
        edit.putBoolean(FOOD_SETTINGS_ALLERGIC_CHEESE, allergicCheese);
        edit.commit();
        this.allergicCheese = allergicCheese;
    }

    public boolean isAllergicChicken() {
        return allergicChicken;
    }

    public void setAllergicChicken(boolean allergicChicken) {
        edit.putBoolean(FOOD_SETTINGS_ALLERGIC_CHICKEN, allergicChicken);
        edit.commit();
        this.allergicChicken = allergicChicken;
    }

    public boolean isAllergicCow() {
        return allergicCow;
    }

    public void setAllergicCow(boolean allergicCow) {
        edit.putBoolean(FOOD_SETTINGS_ALLERGIC_COW, allergicCow);
        edit.commit();
        this.allergicCow = allergicCow;
    }

    public boolean isAllergicFish() {
        return allergicFish;
    }

    public void setAllergicFish(boolean allergicFish) {
        edit.putBoolean(FOOD_SETTINGS_ALLERGIC_FISH, allergicFish);
        edit.commit();
        this.allergicFish = allergicFish;
    }

    public boolean isAllergicMilk() {
        return allergicMilk;
    }

    public void setAllergicMilk(boolean allergicMilk) {
        edit.putBoolean(FOOD_SETTINGS_ALLERGIC_MILK, allergicMilk);
        edit.commit();
        this.allergicMilk = allergicMilk;
    }

    public boolean isAllergicPepper() {
        return allergicPepper;
    }

    public void setAllergicPepper(boolean allergicPepper) {
        edit.putBoolean(FOOD_SETTINGS_ALLERGIC_PEPPER, allergicPepper);
        edit.commit();
        this.allergicPepper = allergicPepper;
    }

    public boolean isAllergicPork() {
        return allergicPork;
    }

    public void setAllergicPork(boolean allergicPork) {
        edit.putBoolean(FOOD_SETTINGS_ALLERGIC_PORK, allergicPork);
        edit.commit();
        this.allergicPork = allergicPork;
    }

    public boolean isDontEatCheese() {
        return dontEatCheese;
    }

    public void setDontEatCheese(boolean dontEatCheese) {
        edit.putBoolean(FOOD_SETTINGS_DONTEAT_CHEESE, dontEatCheese);
        edit.commit();
        this.dontEatCheese = dontEatCheese;
    }

    public boolean isDontEatChicken() {
        return dontEatChicken;
    }

    public void setDontEatChicken(boolean dontEatChicken) {
        edit.putBoolean(FOOD_SETTINGS_DONTEAT_CHICKEN, dontEatChicken);
        edit.commit();
        this.dontEatChicken = dontEatChicken;
    }

    public boolean isDontEatCow() {
        return dontEatCow;
    }

    public void setDontEatCow(boolean dontEatCow) {
        edit.putBoolean(FOOD_SETTINGS_DONTEAT_COW, dontEatCow);
        edit.commit();
        this.dontEatCow = dontEatCow;
    }

    public boolean isDontEatFish() {
        return dontEatFish;
    }

    public void setDontEatFish(boolean dontEatFish) {
        edit.putBoolean(FOOD_SETTINGS_DONTEAT_FISH, dontEatFish);
        edit.commit();
        this.dontEatFish = dontEatFish;
    }

    public boolean isDontEatMilk() {
        return dontEatMilk;
    }

    public void setDontEatMilk(boolean dontEatMilk) {
        edit.putBoolean(FOOD_SETTINGS_DONTEAT_MILK, dontEatMilk);
        edit.commit();
        this.dontEatMilk = dontEatMilk;
    }

    public boolean isDontEatPepper() {
        return dontEatPepper;
    }

    public void setDontEatPepper(boolean dontEatPepper) {
        edit.putBoolean(FOOD_SETTINGS_DONTEAT_PEPPER, dontEatPepper);
        edit.commit();
        this.dontEatPepper = dontEatPepper;
    }

    public boolean isDontEatPork() {
        return dontEatPork;
    }

    public void setDontEatPork(boolean dontEatPork) {
        edit.putBoolean(FOOD_SETTINGS_DONTEAT_PORK, dontEatPork);
        edit.commit();
        this.dontEatPork = dontEatPork;
    }
}
