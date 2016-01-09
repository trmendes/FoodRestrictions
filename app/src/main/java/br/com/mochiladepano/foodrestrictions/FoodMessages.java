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

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class FoodMessages extends Fragment implements AdapterView.OnItemSelectedListener {

    private FoodIconList foodIconList;
    private List<FoodIconItem> restrictList;
    private LinearLayout llAllergic;
    private LinearLayout llDontEat;
    private TextView allergicText;
    private TextView dontEatText;

    public FoodMessages() {
        this.foodIconList = new FoodIconList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_restriction_message,
                container, false);

        restrictList = foodIconList.getFoodRestrictionList(true);

        llAllergic = (LinearLayout) v.findViewById(R.id.llAllergic);
        llDontEat = (LinearLayout) v.findViewById(R.id.llDontEat);

        allergicText = (TextView) v.findViewById(R.id.messages_allergic_text);
        dontEatText = (TextView) v.findViewById(R.id.messages_dont_eat_text);

        Spinner spinner = (Spinner) v.findViewById(R.id.spinner_language);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(v.getContext(),
                R.array.languages_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View v, int i, long l) {

        /* //TODO - Find a better way of doing it
         * I don't believe that this is the best approach to handle this problem but it is
         * the only way I found to do it so far. Do you have any better idea?
         * please help me here :D
         */

        /* Getting the current resource  and config info */
        Resources rsc =  v.getContext().getResources();
        Configuration config = new Configuration(rsc.getConfiguration());
        /* Saving the original locale before changing to the new one
         * just to show the texts
         */
        Locale orgLocale = config.locale;

        /* Changing the language to the one the user have selected based on the
         * Languages.xml file
         */
        switch (i) {
            /* English */
            case 0:
                config.locale = new Locale("en");
                break;
            /* Portuguese */
            case 1:
                config.locale = new Locale("pt");
                break;
        }

        /* Setting the new locale */
        rsc.updateConfiguration(config, rsc.getDisplayMetrics());
        refreshMessages(v);

        /* Updating the layout with the new selected language */

        /* Return to last locale to keep the app as it was before */
        config.locale = orgLocale;
        rsc.updateConfiguration(config, rsc.getDisplayMetrics());
    }

    private void refreshMessages(View v) {

        int nAllergic = 0;
        int nDontEat = 0;
        String victory = "";

        if (!MainActivity.getAppSettings().isSeriosMode()) {
            victory = "\\0/";
        }

        llAllergic.removeAllViews();
        llDontEat.removeAllViews();

        for (final FoodIconItem iconItem : restrictList) {
            final String foodName = getResources().getString(iconItem.getNameId());
            final String allergic_text = getResources().getString(R.string.allergic_to) + " " + foodName;
            final String dont_eat_text = getResources().getString(R.string.dont_eat) + " " + foodName;

            TextView tv = new TextView(v.getContext());
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            tv.setTypeface(null, Typeface.BOLD_ITALIC);
            tv.setText("* " + foodName);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (iconItem.getRestrictionType()) {
                        case FoodIconList.FOOD_RESTRICTION_TYPE_ALLERGIC:
                            Snackbar.make(v, allergic_text, Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            break;
                        case FoodIconList.FOOD_RESTRICTION_TYPE_DONT_EAT:
                            Snackbar.make(v, dont_eat_text, Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            break;
                    }
                }
            });


            if (iconItem.getRestrictionType() == FoodIconList.FOOD_RESTRICTION_TYPE_ALLERGIC) {
                llAllergic.addView(tv);
                ++nAllergic;
            } else {
                llDontEat.addView(tv);
                ++nDontEat;
            }

        }

        if (nAllergic == 0) {
            allergicText.setVisibility(View.GONE);

            TextView tv = new TextView(v.getContext());
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            tv.setTypeface(null, Typeface.BOLD_ITALIC);
            tv.setText("* " + getResources().getString(R.string.food_msg_not_allergic));
            llAllergic.addView(tv);
        } else {
            allergicText.setText(getResources().getString(R.string.message_allergic_to));
        }

        if (nDontEat == 0) {
                dontEatText.setVisibility(View.GONE);

            TextView tv = new TextView(v.getContext());
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            tv.setTypeface(null, Typeface.BOLD_ITALIC);
            tv.setText("* " + getResources().getString(R.string.food_msg_not_picker));
            llDontEat.addView(tv);
        } else {
            dontEatText.setText(getResources().getString(R.string.message_dont_eat));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
