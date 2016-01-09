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
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

public class MessageVegetarian extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.activity_message_vegetarian, container, false);

        String language = getArguments().getString(MessageLanguageSelector.ARG_LANGUAGE);

        TextView tv = (TextView) v.findViewById(R.id.tvVegetarian);

        /* //TODO - Find a better way of doing it
         * I don't believe that this is the best approach to handle this problem but it is
         * the only way I found to do it so far. Do you have any better idea?
         * please help me here :D
         */

        /* Getting the current resource  and config info */
        Resources rsc =  v.getContext().getResources();
        Configuration config = rsc.getConfiguration();
        /* Saving the original locale before changing to the new one
         * just to show the texts
         */
        Locale orgLocale = config.locale;

        config.locale = new Locale(language);

        /* Setting the new locale */
        rsc.updateConfiguration(config, rsc.getDisplayMetrics());
        /* Updating the layout with the new selected language */
        tv.setText(rsc.getString(R.string.msg_veget));

        /* Return to last locale to keep the app as it was before */
        config.locale = orgLocale;
        rsc.updateConfiguration(config, rsc.getDisplayMetrics());

        return v;
    }

}