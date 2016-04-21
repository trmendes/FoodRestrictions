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

package br.com.frs.foodrestrictions;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

public class FoodIconConfig extends Fragment implements View.OnClickListener {

    private CheckBox cbDontEatCow;
    private CheckBox cbAllergicCow;

    private CheckBox cbDontEatChicken;
    private CheckBox cbAllergicChicken;

    private CheckBox cbDontEatPork;
    private CheckBox cbAllergicPork;

    private CheckBox cbDontEatFish;
    private CheckBox cbAllergicFish;

    private CheckBox cbDontEatCheese;
    private CheckBox cbAllergicCheese;

    private CheckBox cbDontEatMilk;
    private CheckBox cbAllergicMilk;

    private CheckBox cbDontEatPepper;
    private CheckBox cbAllergicPepper;

    private FoodIconSettings foodSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_restriction_settings,
                container, false);

        foodSettings = MainActivity.getFoodSettings();
        if (foodSettings != null) {

            cbDontEatCow = (CheckBox) v.findViewById(R.id.cbDontEatCow);
            cbDontEatCow.setOnClickListener(this);
            cbAllergicCow = (CheckBox) v.findViewById(R.id.cbAllergicCow);
            cbAllergicCow.setOnClickListener(this);

            cbDontEatChicken = (CheckBox) v.findViewById(R.id.cbDontEatChicken);
            cbDontEatChicken.setOnClickListener(this);
            cbAllergicChicken = (CheckBox) v.findViewById(R.id.cbAllergicChicken);
            cbAllergicChicken.setOnClickListener(this);

            cbDontEatPork = (CheckBox) v.findViewById(R.id.cbDontEatPork);
            cbDontEatPork.setOnClickListener(this);
            cbAllergicPork = (CheckBox) v.findViewById(R.id.cbAllergicPork);
            cbAllergicPork.setOnClickListener(this);

            cbDontEatFish = (CheckBox) v.findViewById(R.id.cbDontEatFish);
            cbDontEatFish.setOnClickListener(this);
            cbAllergicFish = (CheckBox) v.findViewById(R.id.cbAllergicFish);
            cbAllergicFish.setOnClickListener(this);

            cbDontEatCheese = (CheckBox) v.findViewById(R.id.cbDontEatCheese);
            cbDontEatCheese.setOnClickListener(this);
            cbAllergicCheese = (CheckBox) v.findViewById(R.id.cbAllergicCheese);
            cbAllergicCheese.setOnClickListener(this);

            cbDontEatMilk = (CheckBox) v.findViewById(R.id.cbDontEatMilk);
            cbDontEatMilk.setOnClickListener(this);
            cbAllergicMilk = (CheckBox) v.findViewById(R.id.cbAllergicMilk);
            cbAllergicMilk.setOnClickListener(this);

            cbDontEatPepper = (CheckBox) v.findViewById(R.id.cbDontEatPepper);
            cbDontEatPepper.setOnClickListener(this);
            cbAllergicPepper = (CheckBox) v.findViewById(R.id.cbAllergicPepper);
            cbAllergicPepper.setOnClickListener(this);

            cbDontEatCow.setChecked(foodSettings.isDontEatCow());
            cbDontEatCow.setOnClickListener(this);
            cbAllergicCow.setChecked(foodSettings.isAllergicCow());
            cbAllergicCow.setOnClickListener(this);

            cbDontEatChicken.setChecked(foodSettings.isDontEatChicken());
            cbDontEatChicken.setOnClickListener(this);
            cbAllergicChicken.setChecked(foodSettings.isAllergicChicken());
            cbAllergicChicken.setOnClickListener(this);

            cbDontEatPork.setChecked(foodSettings.isDontEatPork());
            cbDontEatPork.setOnClickListener(this);
            cbAllergicPork.setChecked(foodSettings.isAllergicPork());
            cbAllergicPork.setOnClickListener(this);

            cbDontEatFish.setChecked(foodSettings.isDontEatFish());
            cbDontEatFish.setOnClickListener(this);
            cbAllergicFish.setChecked(foodSettings.isAllergicFish());
            cbAllergicFish.setOnClickListener(this);

            cbDontEatCheese.setChecked(foodSettings.isDontEatCheese());
            cbDontEatCheese.setOnClickListener(this);
            cbAllergicCheese.setChecked(foodSettings.isAllergicCheese());
            cbAllergicCheese.setOnClickListener(this);

            cbDontEatMilk.setChecked(foodSettings.isDontEatMilk());
            cbDontEatMilk.setOnClickListener(this);
            cbAllergicMilk.setChecked(foodSettings.isAllergicMilk());
            cbAllergicMilk.setOnClickListener(this);

            cbDontEatPepper.setChecked(foodSettings.isDontEatPepper());
            cbDontEatPepper.setOnClickListener(this);
            cbAllergicPepper.setChecked(foodSettings.isAllergicPepper());
            cbAllergicPepper.setOnClickListener(this);

            View.OnClickListener imageOnClickListener =
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String name = "";
                            switch(v.getId()) {
                                case R.id.ivCow:
                                    name = getResources().getString(R.string.cow);
                                    break;
                                case R.id.ivChicken:
                                    name = getResources().getString(R.string.chicken);
                                    break;
                                case R.id.ivPork:
                                    name = getResources().getString(R.string.pork);
                                    break;
                                case R.id.ivFish:
                                    name = getResources().getString(R.string.fish);
                                    break;
                                case R.id.ivCheese:
                                    name = getResources().getString(R.string.cheese);
                                    break;
                                case R.id.ivMilk:
                                    name = getResources().getString(R.string.milk);
                                    break;
                                case R.id.ivPepper:
                                    name = getResources().getString(R.string.pepper);
                                    break;
                            }

                            Snackbar.make(v, name, Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();


                        }
                    };

            ImageView ivCow = (ImageView) v.findViewById(R.id.ivCow);
            ImageView ivChicken = (ImageView) v.findViewById(R.id.ivChicken);
            ImageView ivPork = (ImageView) v.findViewById(R.id.ivPork);
            ImageView ivFish = (ImageView) v.findViewById(R.id.ivFish);
            ImageView ivCheese = (ImageView) v.findViewById(R.id.ivCheese);
            ImageView ivMilk = (ImageView) v.findViewById(R.id.ivMilk);
            ImageView ivPepper = (ImageView) v.findViewById(R.id.ivPepper);

            ivCow.setOnClickListener(imageOnClickListener);
            ivChicken.setOnClickListener(imageOnClickListener);
            ivPork.setOnClickListener(imageOnClickListener);
            ivFish.setOnClickListener(imageOnClickListener);
            ivCheese.setOnClickListener(imageOnClickListener);
            ivMilk.setOnClickListener(imageOnClickListener);
            ivPepper.setOnClickListener(imageOnClickListener);

        }
        return v;
    }

    @Override
    public void onClick(View v) {
        boolean checked = ((CheckBox) v).isChecked();

        switch(v.getId()) {
            //Cow
            case R.id.cbDontEatCow:
                cbDontEatCow.setChecked(checked);
                foodSettings.setDontEatCow(checked);

                if ((checked) && (cbAllergicCow.isChecked())) {
                    cbAllergicCow.setChecked(false);
                    foodSettings.setAllergicCow(false);
                }
                break;
            case R.id.cbAllergicCow:
                cbAllergicCow.setChecked(checked);
                foodSettings.setAllergicCow(checked);

                if ((checked) && (cbDontEatCow.isChecked())) {
                    cbDontEatCow.setChecked(false);
                    foodSettings.setDontEatCow(false);
                }
                break;
            //Chicken
            case R.id.cbDontEatChicken:
                cbDontEatChicken.setChecked(checked);
                foodSettings.setDontEatChicken(checked);

                if ((checked) && (cbAllergicChicken.isChecked())) {
                    cbAllergicChicken.setChecked(false);
                    foodSettings.setAllergicChicken(false);
                }
               break;
            case R.id.cbAllergicChicken:
                cbAllergicChicken.setChecked(checked);
                foodSettings.setAllergicChicken(checked);

                if ((checked) && (cbDontEatChicken.isChecked())) {
                    cbDontEatChicken.setChecked(false);
                    foodSettings.setDontEatChicken(false);
                }
                break;
            //Pork
            case R.id.cbDontEatPork:
                cbDontEatPork.setChecked(checked);
                foodSettings.setDontEatPork(checked);

                if ((checked) && (cbAllergicPork.isChecked())) {
                    cbAllergicPork.setChecked(false);
                    foodSettings.setAllergicPork(false);
                }
                break;
            case R.id.cbAllergicPork:
                cbAllergicPork.setChecked(checked);
                foodSettings.setAllergicPork(checked);

                if ((checked) && (cbDontEatPork.isChecked())) {
                    cbDontEatPork.setChecked(false);
                    foodSettings.setDontEatPork(false);
                }
                break;
            //Fish
            case R.id.cbDontEatFish:
                cbDontEatFish.setChecked(checked);
                foodSettings.setDontEatFish(checked);

                if ((checked) && (cbAllergicFish.isChecked())) {
                    cbAllergicFish.setChecked(false);
                    foodSettings.setAllergicFish(false);
                }
                break;
            case R.id.cbAllergicFish:
                cbAllergicFish.setChecked(checked);
                foodSettings.setAllergicFish(checked);

                if ((checked) && (cbDontEatFish.isChecked())) {
                    cbDontEatFish.setChecked(false);
                    foodSettings.setDontEatFish(false);
                }
                break;
            //Cheese
            case R.id.cbDontEatCheese:
                cbDontEatCheese.setChecked(checked);
                foodSettings.setDontEatCheese(checked);

                if ((checked) && (cbAllergicCheese.isChecked())) {
                    cbAllergicCheese.setChecked(false);
                    foodSettings.setAllergicCheese(false);
                }
                break;
            case R.id.cbAllergicCheese:
                cbAllergicCheese.setChecked(checked);
                foodSettings.setAllergicCheese(checked);

                if ((checked) && (cbDontEatCheese.isChecked())) {
                    cbDontEatCheese.setChecked(false);
                    foodSettings.setDontEatCheese(false);
                }
                break;
            //Milk
            case R.id.cbDontEatMilk:
                cbDontEatMilk.setChecked(checked);
                foodSettings.setDontEatMilk(checked);

                if ((checked) && (cbAllergicMilk.isChecked())) {
                    cbAllergicMilk.setChecked(false);
                    foodSettings.setAllergicMilk(false);
                }

                break;
            case R.id.cbAllergicMilk:
                cbAllergicMilk.setChecked(checked);
                foodSettings.setAllergicMilk(checked);

                if ((checked) && (cbDontEatMilk.isChecked())) {
                    cbDontEatMilk.setChecked(false);
                    foodSettings.setDontEatMilk(false);
                }
                break;
            //Pepper
            case R.id.cbDontEatPepper:
                cbDontEatPepper.setChecked(checked);
                foodSettings.setDontEatPepper(checked);

                if ((checked) && (cbAllergicPepper.isChecked())) {
                    cbAllergicPepper.setChecked(false);
                    foodSettings.setAllergicPepper(false);
                }
                break;
            case R.id.cbAllergicPepper:
                cbAllergicPepper.setChecked(checked);
                foodSettings.setAllergicPepper(checked);

                if ((checked) && (cbDontEatPepper.isChecked())) {
                    cbDontEatPepper.setChecked(false);
                    foodSettings.setDontEatPepper(false);
                }
                break;

        }
    }

}
