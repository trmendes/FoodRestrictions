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

import java.util.ArrayList;
import java.util.List;

class FoodIconList {

    private static List<FoodIconItem> iconList;

    public static final int FOOD_RESTRICTION_TYPE_ALLERGIC = 0;
    public static final int FOOD_RESTRICTION_TYPE_DONT_EAT = 1;
    private static final int FOOD_TYPE_COW = 0;
    private static final int FOOD_TYPE_CHICKEN = 1;
    private static final int FOOD_TYPE_PORK = 2;
    private static final int FOOD_TYPE_FISH = 3;
    private static final int FOOD_TYPE_CHEESE = 4;
    private static final int FOOD_TYPE_MILK = 5;
    private static final int FOOD_TYPE_PEPPER = 6;

    public FoodIconList() {
        refreshIconList();
    }

    public List<FoodIconItem> getFoodRestrictionList(boolean refresh) {
        if (refresh) {
            refreshIconList();
        } else {
            if (iconList == null) {
                iconList = new ArrayList<>();
            }

        }

        return iconList;
    }

    private void refreshIconList() {

        if (iconList == null) {
            iconList = new ArrayList<>();
        }

        iconList.clear();
        FoodIconSettings foodSettings = MainActivity.getFoodSettings();

        if (foodSettings != null) {

            if (foodSettings.isAllergicCow()) {
                iconList.add(getFoodItem(FOOD_RESTRICTION_TYPE_ALLERGIC, FOOD_TYPE_COW));
            }
            if (foodSettings.isDontEatCow()) {
                iconList.add(getFoodItem(FOOD_RESTRICTION_TYPE_DONT_EAT, FOOD_TYPE_COW));
            }

            if (foodSettings.isAllergicChicken()) {
                iconList.add(getFoodItem(FOOD_RESTRICTION_TYPE_ALLERGIC, FOOD_TYPE_CHICKEN));
            }
            if (foodSettings.isDontEatChicken()) {
                iconList.add(getFoodItem(FOOD_RESTRICTION_TYPE_DONT_EAT, FOOD_TYPE_CHICKEN));
            }

            if (foodSettings.isAllergicPork()) {
                iconList.add(getFoodItem(FOOD_RESTRICTION_TYPE_ALLERGIC, FOOD_TYPE_PORK));
            }
            if (foodSettings.isDontEatPork()) {
                iconList.add(getFoodItem(FOOD_RESTRICTION_TYPE_DONT_EAT, FOOD_TYPE_PORK));
            }

            if (foodSettings.isAllergicFish()) {
                iconList.add(getFoodItem(FOOD_RESTRICTION_TYPE_ALLERGIC, FOOD_TYPE_FISH));
            }
            if (foodSettings.isDontEatFish()) {
                iconList.add(getFoodItem(FOOD_RESTRICTION_TYPE_DONT_EAT, FOOD_TYPE_FISH));
            }

            if (foodSettings.isAllergicCheese()) {
                iconList.add(getFoodItem(FOOD_RESTRICTION_TYPE_ALLERGIC, FOOD_TYPE_CHEESE));
            }
            if (foodSettings.isDontEatCheese()) {
                iconList.add(getFoodItem(FOOD_RESTRICTION_TYPE_DONT_EAT, FOOD_TYPE_CHEESE));
            }

            if (foodSettings.isAllergicMilk()) {
                iconList.add(getFoodItem(FOOD_RESTRICTION_TYPE_ALLERGIC, FOOD_TYPE_MILK));
            }
            if (foodSettings.isDontEatMilk()) {
                iconList.add(getFoodItem(FOOD_RESTRICTION_TYPE_DONT_EAT, FOOD_TYPE_MILK));
            }

            if (foodSettings.isAllergicPepper()) {
                iconList.add(getFoodItem(FOOD_RESTRICTION_TYPE_ALLERGIC, FOOD_TYPE_PEPPER));
            }
            if (foodSettings.isDontEatPepper()) {
                iconList.add(getFoodItem(FOOD_RESTRICTION_TYPE_DONT_EAT, FOOD_TYPE_PEPPER));
            }
        }

    }

    private FoodIconItem getFoodItem(int restrictionType, int foodType) {

        FoodIconItem foodItem = new FoodIconItem();

        foodItem.setRestrictionType(restrictionType);
        foodItem.setType(foodType);

        switch (restrictionType) {
            case FOOD_RESTRICTION_TYPE_ALLERGIC:
                switch (foodType) {
                    case FOOD_TYPE_COW:
                        foodItem.setNameId(R.string.cow);
                        foodItem.setIconId(R.drawable.ic_128_cow_allergic);
                        break;
                    case FOOD_TYPE_CHICKEN:
                        foodItem.setNameId(R.string.chicken);
                        foodItem.setIconId(R.drawable.ic_128_chicken_allergic);
                        break;
                    case FOOD_TYPE_PORK:
                        foodItem.setNameId(R.string.pork);
                        foodItem.setIconId(R.drawable.ic_128_pig_allergic);
                        break;
                    case FOOD_TYPE_FISH:
                        foodItem.setNameId(R.string.fish);
                        foodItem.setIconId(R.drawable.ic_128_fish_allergic);
                        break;
                    case FOOD_TYPE_CHEESE:
                        foodItem.setNameId(R.string.cheese);
                        foodItem.setIconId(R.drawable.ic_128_cheese_allergic);
                        break;
                    case FOOD_TYPE_MILK:
                        foodItem.setNameId(R.string.milk);
                        foodItem.setIconId(R.drawable.ic_128_milk_allergic);
                        break;
                    case FOOD_TYPE_PEPPER:
                        foodItem.setNameId(R.string.pepper);
                        foodItem.setIconId(R.drawable.ic_128_pepper_allergic);
                        break;
                }
                break;
            case FOOD_RESTRICTION_TYPE_DONT_EAT:
                switch (foodType) {
                    case FOOD_TYPE_COW:
                        foodItem.setNameId(R.string.cow);
                        foodItem.setIconId(R.drawable.ic_128_cow_dont_eat);
                        break;
                    case FOOD_TYPE_CHICKEN:
                        foodItem.setNameId(R.string.chicken);
                        foodItem.setIconId(R.drawable.ic_128_chicken_dont_eat);
                        break;
                    case FOOD_TYPE_PORK:
                        foodItem.setNameId(R.string.pork);
                        foodItem.setIconId(R.drawable.ic_128_pig_dont_eat);
                        break;
                    case FOOD_TYPE_FISH:
                        foodItem.setNameId(R.string.fish);
                        foodItem.setIconId(R.drawable.ic_128_fish_dont_eat);
                        break;
                    case FOOD_TYPE_CHEESE:
                        foodItem.setNameId(R.string.cheese);
                        foodItem.setIconId(R.drawable.ic_128_cheese_dont_eat);
                        break;
                    case FOOD_TYPE_MILK:
                        foodItem.setNameId(R.string.milk);
                        foodItem.setIconId(R.drawable.ic_128_milk_dont_eat);
                        break;
                    case FOOD_TYPE_PEPPER:
                        foodItem.setNameId(R.string.pepper);
                        foodItem.setIconId(R.drawable.ic_128_pepper_dont_eat);
                        break;
                }
                break;
        }

        return foodItem;
    }


}