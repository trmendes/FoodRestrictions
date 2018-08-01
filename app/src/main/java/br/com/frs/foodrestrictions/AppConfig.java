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
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

public class AppConfig extends Fragment  implements View.OnClickListener  {

    private AppSettings appSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_app_settings,
                container, false);

        appSettings = MainActivity.getAppSettings();

        CheckBox cbShowDialog = v.findViewById(R.id.cb_settings_help_dialog);

        cbShowDialog.setChecked(appSettings.isHelpDialog());

        cbShowDialog.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.cb_settings_help_dialog:
                appSettings.setHelpDialog(checked);
                break;
        }
    }
}
