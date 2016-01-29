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

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MessageLanguageSelector extends ListFragment {

    public static final String ARG_LANGUAGE = "arg_language";

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Bundle args = new Bundle();
        Intent intent = new Intent(getContext(), MessagesTab.class);

        switch (position) {
            case 0: //English
                args.putString(MessageLanguageSelector.ARG_LANGUAGE, "en");
                break;
            case 1: //Portuguese
                args.putString(MessageLanguageSelector.ARG_LANGUAGE, "pt");
                break;
        }

        intent.putExtras(args);
        startActivity(intent);
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.activity_message_lang_selector, container, false);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(v.getContext(),
                R.array.languages_messages_array, android.R.layout.simple_list_item_1);

        setListAdapter(arrayAdapter);

        return v;
    }

}
