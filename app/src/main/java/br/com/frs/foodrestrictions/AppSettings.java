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

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppSettings {

    private static final String SETTINGS_APP_HELP_DIALOG = "br.mochiladepano.settings.app.helpdialog";

    private static AppSettings settings;
    private final SharedPreferences.Editor edit;

    private boolean helpDialog;

    private AppSettings(Context ctx) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ctx);

        helpDialog = sharedPref.getBoolean(AppSettings.SETTINGS_APP_HELP_DIALOG, true);

        edit = sharedPref.edit();
        edit.apply();
    }

    public static AppSettings getSettingsApp(Context ctx) {
        if (settings == null) {
            settings = new AppSettings(ctx);
        }
        return settings;
    }

    public boolean isHelpDialog() {
        return helpDialog;
    }

    public void setHelpDialog(boolean helpDialog) {
        edit.putBoolean(SETTINGS_APP_HELP_DIALOG, helpDialog);
        edit.commit();
        this.helpDialog = helpDialog;
    }

}
