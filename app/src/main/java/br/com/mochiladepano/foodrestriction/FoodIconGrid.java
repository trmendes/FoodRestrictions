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
/**
 */

package br.com.mochiladepano.foodrestriction;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class FoodIconGrid extends Fragment {

    private Context ctx;
    private FoodIconList foodIconList;

    public FoodIconGrid() {
        foodIconList = new FoodIconList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_restriction_grid,
                container, false);

        GridView gridview = (GridView) v.findViewById(R.id.gridViewRestrictions);

        ctx = container.getContext();

        if (ctx != null) {
            gridview.setAdapter(new FoodImageAdapter(ctx, foodIconList.getFoodRestrictionList(true)));

            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {
                    FoodIconItem foodIconItem = foodIconList.getFoodRestrictionList(false).get(position);

                    switch (foodIconItem.getRestrictionType()) {
                        case FoodIconList.FOOD_RESTRICTION_TYPE_ALLERGIC:
                            Snackbar.make(v, getResources().getString(R.string.message_allergic_to) + " " + getResources().getString(foodIconItem.getNameId()), Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            break;
                        case FoodIconList.FOOD_RESTRICTION_TYPE_DONT_EAT:
                            Snackbar.make(v, getResources().getString(R.string.message_dont_eat) + " " + getResources().getString(foodIconItem.getNameId()), Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            break;
                    }
                }
            });
        }

        return v;
    }
}
